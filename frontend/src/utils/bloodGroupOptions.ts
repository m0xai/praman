import { BloodGroup } from "../schemas/BloodGroup";

const bloodGroupKeys = Object.keys(BloodGroup).filter((key: string | number) =>
  isNaN(Number(key)) ? true : false
);

export const bloodGrpupOptions = bloodGroupKeys.map((key: string) => ({
  label: BloodGroup[key],
  value: key,
}));
