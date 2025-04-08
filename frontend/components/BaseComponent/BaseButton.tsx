import { BaseProps } from "../../types/baseType";

const BaseButton = ({ text, className }: BaseProps) => {
  return <button className={className || ""}>{text}</button>;
};

export default BaseButton;
