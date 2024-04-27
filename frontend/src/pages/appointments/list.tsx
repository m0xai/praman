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
import { Patient } from "../../schemas/Patient";
import { Doctor } from "../../schemas/Doctor";

const { Text } = Typography;

export const AppointmentList = () => {
  const { tableProps } = useTable({
    syncWithLocation: true,
  });

  return (
    <List>
      <Table {...tableProps} rowKey="id">
        <Table.Column dataIndex="id" title={"ID"} />
        <Table.Column
          dataIndex="date"
          title={"Date"}
          render={(value: any) => {
            return <DateField value={value} />;
          }}
        />
        <Table.Column
          dataIndex="time"
          title={"Time"}
          render={(val) => {
            return <Text>{val.slice(0, 5)}</Text>;
          }}
        />
        <Table.Column
          dataIndex="doctor"
          title={"Doctor"}
          render={(value: Doctor) => {
            return <Text>{value.fullName}</Text>;
          }}
        />
        <Table.Column
          dataIndex="patient"
          title={"Patient"}
          render={(value: Patient) => {
            return <Text>{value.fullName}</Text>;
          }}
        />
        <Table.Column dataIndex="reason" title={"Reason"} />
        <Table.Column dataIndex="status" title={"Status"} />
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
