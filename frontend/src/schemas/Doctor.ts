import { Dayjs } from "dayjs";

export interface Doctor {
  id: number;
  fullName: string;
  profession: string;
  description: string;
  dateOfBirth: Dayjs;
}
