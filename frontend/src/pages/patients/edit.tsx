import { Edit, useForm } from "@refinedev/antd";
import { DatePicker, Form, Input, Select } from "antd";
import dayjs from "dayjs";
import { bloodGrpupOptions } from "../../utils/bloodGroupOptions";

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
        <Form.Item
          label={"Phone Number"}
          name={["phoneNumber"]}
          rules={[{ required: true }]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          label={"Blood Group"}
          name={["bloodGroup"]}
          rules={[{ required: true }]}
        >
          <Select options={bloodGrpupOptions} />
        </Form.Item>
      </Form>
    </Edit>
  );
};
