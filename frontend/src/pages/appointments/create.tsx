import { Create, useForm } from "@refinedev/antd";
import { useSelect } from "@refinedev/core";
import { DatePicker, Form, Input, Select, TimePicker } from "antd";
import dayjs from "dayjs";

export const AppointmentCreate = () => {
  const { formProps, saveButtonProps } = useForm({});
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
    <Create saveButtonProps={saveButtonProps}>
      <Form {...formProps} layout="vertical">
        <Form.Item name={"patientId"} label={"Patient"}>
          <Select options={patientOptions} />
        </Form.Item>
        <Form.Item name={"doctorId"} label={"Doctor"}>
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
        <Form.Item
          name={"status"}
          label={"Status"}
          hidden
          initialValue={"PENDING"}
        />
      </Form>
    </Create>
  );
};
