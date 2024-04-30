import { Dayjs } from "dayjs";
import { BloodGroup } from "./BloodGroup";

export interface Patient {
  fullName: string;
  dateOfBirth: Dayjs;
  phoneNumber: string;
  bloodGroup: BloodGroup;
}
