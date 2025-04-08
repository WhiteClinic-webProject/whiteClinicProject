import { BaseProps } from "../../types/baseType";

const BaseText = ({ text, className }: BaseProps) => {
  return <div className={className || ""}>{text}</div>;
};

export default BaseText;
