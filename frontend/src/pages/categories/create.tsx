import { Create, useForm } from "@refinedev/antd";
import { DatePicker, Form, Input, Select } from "antd";
import { bloodGrpupOptions } from "../../utils/bloodGroupOptions";

export const CategoryCreate = () => {
  const { formProps, saveButtonProps } = useForm({});

  return (
    <Create saveButtonProps={saveButtonProps}>
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
    </Create>
  );
};
