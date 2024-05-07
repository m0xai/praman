import { Edit, useForm } from "@refinedev/antd";
import { DatePicker, Form, Input, Select, TimePicker } from "antd";
import dayjs from "dayjs";
import { useSelect } from "@refinedev/core";

export const AppointmentEdit = () => {
  const { formProps, saveButtonProps, formLoading } = useForm();
  const { options: doctorOptions } = useSelect({
    resource: "doctors",
    optionLabel: "fullName",
    optionValue: "id",
  });

  const { options: patientOptions } = useSelect({
    resource: "patients",
    optionLabel: "fullName",
    optionValue: "id",
  });

  return (
    <Edit saveButtonProps={saveButtonProps} isLoading={formLoading}>
      <Form {...formProps} layout="vertical">
        <Form.Item
          name={"patientId"}
          label={"Patient"}
          initialValue={formProps?.initialValues?.patient.id}
        >
          <Select options={patientOptions} />
        </Form.Item>
        <Form.Item
          name={"doctorId"}
          label={"Doctor"}
          initialValue={formProps?.initialValues?.doctor.id}
        >
          <Select options={doctorOptions} />
        </Form.Item>
        <Form.Item
          name={["date"]}
          label={"Date"}
          getValueProps={(value) => ({
            value: value ? dayjs(value) : "",
          })}
          getValueFromEvent={(v) => (v ? v.format("YYYY-MM-DD") : "")}
        >
          <DatePicker />
        </Form.Item>
        <Form.Item
          name={["time"]}
          label={"Time"}
          getValueProps={(v) => ({ value: v ? dayjs(v, "HH:mm:ss") : "" })}
          getValueFromEvent={(v) => (v ? v.format("HH:mm:ss") : "")}
        >
          <TimePicker format="HH:mm" />
        </Form.Item>
        <Form.Item name={"reason"} label={"Reason"}>
          <Input />
        </Form.Item>
      </Form>
    </Edit>
  );
};
