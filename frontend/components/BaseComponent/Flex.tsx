import { displayProps } from "../../types/baseType";

const Flex = ({ children, className }: displayProps) => {
  return <div className={"flex " + className}>{children}</div>;
};

export default Flex;
