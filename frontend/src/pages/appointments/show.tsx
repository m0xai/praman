import { MarkdownField, NumberField, Show, TextField } from "@refinedev/antd";
import { useShow } from "@refinedev/core";
import { Typography } from "antd";

const { Title } = Typography;

export const AppointmentShow = () => {
  const { queryResult } = useShow({});
  const { data, isLoading } = queryResult;

  const record = data?.data;

  return (
    <Show isLoading={isLoading}>
      <Title level={5}>{"ID"}</Title>
      <NumberField value={record?.id ?? ""} />
      <Title level={5}>{"Full Name"}</Title>
      <TextField value={record?.fullName} />
      <Title level={5}>{"Description"}</Title>
      <MarkdownField value={record?.description} />
    </Show>
  );
};
