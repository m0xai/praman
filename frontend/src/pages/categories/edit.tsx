import { Edit, useForm } from "@refinedev/antd";
import { DatePicker, Form, Input } from "antd";
import dayjs from "dayjs";

export const CategoryEdit = () => {
  const { formProps, saveButtonProps } = useForm({});

  return (
    <Edit saveButtonProps={saveButtonProps}>
      <Form {...formProps} layout="vertical">
        <Form.Item
          label={"Full Name"}
          name={["fullName"]}
          rules={[
            {
              required: true,
            },
          ]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          label={"Date of Birth"}
          name={["dateOfBirth"]}
          rules={[
            {
              required: true,
            },
          ]}
          getValueProps={(val) => ({ value: val ? dayjs(val) : "" })}
        >
          <DatePicker />
        </Form.Item>
      </Form>
    </Edit>
  );
};
