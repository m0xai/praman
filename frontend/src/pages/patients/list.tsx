import {
  DateField,
  DeleteButton,
  EditButton,
  List,
  ShowButton,
  useTable,
} from "@refinedev/antd";
import { BaseRecord } from "@refinedev/core";
import { Space, Table, Typography } from "antd";
import { BloodGroup } from "../../schemas/BloodGroup";

export const CategoryList = () => {
  const { Text } = Typography;

  const { tableProps } = useTable({
    syncWithLocation: true,
  });

  return (
    <List>
      <Table {...tableProps} rowKey="id">
        <Table.Column dataIndex="id" title={"ID"} />
        <Table.Column dataIndex="fullName" title={"Full Name"} />
        <Table.Column
          dataIndex="dateOfBirth"
          render={(v) => <DateField value={v} format="DD/MM/YYYY" />}
          title={"Date of Birth"}
        />
        <Table.Column dataIndex="phoneNumber" title={"Phone Number"} />
        <Table.Column
          align={"center"}
          dataIndex="bloodGroup"
          title={"Blood Group"}
          render={(value: string) => {
            return <Text>{BloodGroup[value]}</Text>;
          }}
        />
        <Table.Column
          align={"center"}
          title={"Actions"}
          dataIndex="actions"
          render={(_, record: BaseRecord) => (
            <Space>
              <EditButton hideText size="small" recordItemId={record.id} />
              <ShowButton hideText size="small" recordItemId={record.id} />
              <DeleteButton hideText size="small" recordItemId={record.id} />
            </Space>
          )}
        />
      </Table>
    </List>
  );
};
