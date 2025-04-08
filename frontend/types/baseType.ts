import React, { ReactNode } from "react";

export type BaseProps = {
  className?: string;
  text: string;
};

export type displayProps = {
  children: ReactNode;
  className?: string;
};
