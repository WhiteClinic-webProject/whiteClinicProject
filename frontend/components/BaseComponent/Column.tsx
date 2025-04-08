import { displayProps } from "../../types/baseType";

const Column = ({ children, className }: displayProps) => {
  return <div className={"flex flex-col " + className}>{children}</div>;
};

export default Column;
