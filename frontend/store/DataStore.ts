import { create } from "zustand";

type Data = {
  id: number;
  name: string;
  email: string;
};

type DataStore = {
  datas: Data[];
  loading: boolean;
  error: string | null;

  fetchUsers: () => Promise<void>;
  createUser: (user: Omit<Data, "id">) => Promise<void>;
  updateUser: (user: Data) => Promise<void>;
  deleteUser: (id: number) => Promise<void>;
};

export const useUserStore = create<DataStore>((set, get) => ({
  datas: [],
  loading: false,
  error: null,

  // READ
  fetchUsers: async () => {
    set({ loading: true, error: null });
    try {
      const res = await fetch(`https://jsonplaceholder.typicode.com/users`);
      const data: Data[] = await res.json();
      set({ datas: data, loading: false });
    } catch (err: any) {
      set({ error: err.message, loading: false });
    }
  },

  // CREATE
  createUser: async (newUser) => {
    set({ loading: true });
    try {
      const res = await fetch(`https://jsonplaceholder.typicode.com/users`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(newUser),
      });
      const data: Data = await res.json();
      set({ datas: [...get().datas, data], loading: false });
    } catch (err: any) {
      set({ error: err.message, loading: false });
    }
  },

  // UPDATE
  updateUser: async (updatedUser) => {
    set({ loading: true });
    try {
      const res = await fetch(
        `https://jsonplaceholder.typicode.com/users/${updatedUser.id}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(updatedUser),
        }
      );
      const data: Data = await res.json();
      set({
        datas: get().datas.map((u) => (u.id === data.id ? data : u)),
        loading: false,
      });
    } catch (err: any) {
      set({ error: err.message, loading: false });
    }
  },

  // DELETE
  deleteUser: async (id) => {
    set({ loading: true });
    try {
      await fetch(`https://jsonplaceholder.typicode.com/users/${id}`, {
        method: "DELETE",
      });
      set({
        datas: get().datas.filter((u) => u.id !== id),
        loading: false,
      });
    } catch (err: any) {
      set({ error: err.message, loading: false });
    }
  },
}));
