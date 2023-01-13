import services from '@/services/demo';
import {
  ActionType,
  FooterToolbar,
  PageContainer,
  ProDescriptions,
  ProDescriptionsItemProps,
  ProTable,
} from '@ant-design/pro-components';
import { Button, Divider, Drawer, message, Popconfirm, Tag } from 'antd';
import React, { useRef, useState } from 'react';
import CreateForm from './components/CreateForm';
import UpdateForm, { FormValueType } from './components/UpdateForm';

const { addUser, queryUserList, deleteUser, modifyUser } =
  services.UserController;

const user_type = localStorage.getItem('user_type');
const user_id = localStorage.getItem('user_id');
const mentor = localStorage.getItem('mentor');
/**
 * 添加节点
 * @param fields
 */
const handleAdd = async (fields: API.UserInfo) => {
  const hide = message.loading('正在添加');
  try {
    // @ts-ignore
    await addUser({
      ...fields,
      user_id,
      user_type,
      mentor,
      paper_time: Date.parse(fields.paper_time),
      prize_time: Date.parse(fields.prize_time),
    });
    hide();
    message.success('添加成功');
    return true;
  } catch (error) {
    hide();
    message.error('添加失败请重试！');
    return false;
  }
};

/**
 * 更新节点
 * @param fields
 */
const handleUpdate = async (fields: FormValueType) => {
  const hide = message.loading('正在配置');
  try {
    await modifyUser(
      {
        userId: fields.id || '',
      },
      {
        name: fields.name || '',
        nickName: fields.nickName || '',
        email: fields.email || '',
      },
    );
    hide();

    message.success('配置成功');
    return true;
  } catch (error) {
    hide();
    message.error('配置失败请重试！');
    return false;
  }
};

/**
 *  删除节点
 * @param selectedRows
 */
const handleRemove = async (selectedRows: API.UserInfo[]) => {
  const hide = message.loading('正在删除');
  if (!selectedRows) return true;
  try {
    await deleteUser({
      userId: selectedRows.find((row) => row.id)?.id || '',
    });
    hide();
    message.success('删除成功，即将刷新');
    return true;
  } catch (error) {
    hide();
    message.error('删除失败，请重试');
    return false;
  }
};

const TableList: React.FC<unknown> = () => {
  const [createModalVisible, handleModalVisible] = useState<boolean>(false);
  const [updateModalVisible, handleUpdateModalVisible] =
    useState<boolean>(false);
  const [stepFormValues, setStepFormValues] = useState({});
  const actionRef = useRef<ActionType>();
  const [row, setRow] = useState<API.UserInfo>();
  const [selectedRowsState, setSelectedRows] = useState<API.UserInfo[]>([]);
  const [col, setCol] = useState();
  const otherColumns = [
    {
      title: '教科书',
      dataIndex: 'textbook',
      hideInTable: true,
    },
    {
      title: '标准',
      dataIndex: 'standard',
      hideInTable: true,
    },
    {
      title: '专利',
      dataIndex: 'patent',
      hideInTable: true,
    },
    {
      title: '报告',
      dataIndex: 'report',
      hideInTable: true,
    },
    {
      title: '发明证书',
      dataIndex: 'devCertificate',
      hideInTable: true,
    },
  ];
  const doctorOtherColumms = [
    {
      title: '标准',
      dataIndex: 'standard',
      hideInTable: true,
    },
    {
      title: '其他',
      dataIndex: 'others',
      hideInTable: true,
    },
  ];
  const prizeColumns = [
    {
      title: '奖项名称',
      dataIndex: 'name',
      hideInTable: true,
      formItemProps: {
        name: 'prize_name',
      },
    },
    {
      title: '奖项级别',
      dataIndex: 'prizeLevel',
      hideInTable: true,
      formItemProps: {
        name: 'prize_level',
      },
    },
    {
      title: '获奖等级',
      dataIndex: 'awardsRank',
      hideInTable: true,
      formItemProps: {
        name: 'awards_rank',
      },
    },
    {
      title: '排名',
      dataIndex: 'rank',
      hideInTable: true,
    },
    {
      title: '获奖时间',
      dataIndex: 'time',
      hideInTable: true,
      formItemProps: {
        name: 'prize_time',
      },
    },
    {
      title: '证明资源',
      dataIndex: 'resource',
      hideInTable: true,
      formItemProps: {
        name: 'prize_resource',
      },
    },
  ];
  const columns: ProDescriptionsItemProps<API.UserInfo>[] = [
    {
      title: 'ID',
      dataIndex: 'id',
      tip: 'ID是唯一的 key',
      hideInDescriptions: true,
      hideInForm: true,
    },
    {
      title: '初审状态',
      dataIndex: 'initialStatus',
      hideInDescriptions: true,
      hideInForm: true,
      render: (_, item) => {
        return (
          <Tag
            color={
              item?.initialStatus?.trim() === 'pending'
                ? 'blue'
                : item?.initialStatus?.trim() === 'access'
                ? 'success'
                : 'error'
            }
          >
            {item?.initialStatus?.trim() === 'pending'
              ? '等待'
              : item?.initialStatus?.trim() === 'access'
              ? '通过'
              : '失败'}
          </Tag>
        );
      },
    },
    {
      title: '终审状态',
      dataIndex: 'finalStatus',
      hideInDescriptions: true,
      hideInForm: true,
      render: (_, item) => {
        return (
          <Tag
            color={
              item?.finalStatus?.trim() === 'pending'
                ? 'blue'
                : item?.finalStatus?.trim() === 'access'
                ? 'success'
                : 'error'
            }
          >
            {item?.finalStatus?.trim() === 'pending'
              ? '等待'
              : item?.finalStatus?.trim() === 'access'
              ? '通过'
              : '失败'}
          </Tag>
        );
      },
    },
    {
      ...(localStorage.getItem('user_type') === 'mentor' ||
      localStorage.getItem('user_type') === 'admin'
        ? {
            title: '研究生类别',
            dataIndex: 'userType',
            hideInDescriptions: true,
            hideInForm: true,
          }
        : {
            hideInDescriptions: true,
            hideInForm: true,
          }),
    },
    {
      ...(localStorage.getItem('user_type') === 'mentor' ||
      localStorage.getItem('user_type') === 'admin'
        ? {
            title: '发起研究生',
            dataIndex: 'sponsor',
            hideInDescriptions: true,
            hideInForm: true,
          }
        : {
            hideInDescriptions: true,
            hideInForm: true,
          }),
    },
    {
      title: '论文',
      hideInDescriptions: true,
      hideInForm: true,
      render: (_, record) => {
        return (
          <a
            onClick={() => {
              // @ts-ignore
              setCol(columns);
              // @ts-ignore
              setRow(
                // @ts-ignore
                record?.masterAchievements?.paper ??
                  // @ts-ignore
                  record?.doctorAchievements?.paper,
              );
            }}
          >
            查看论文
          </a>
        );
      },
    },
    {
      ...(localStorage.getItem('user_type') !== 'master'
        ? {
            title: '奖励',
            hideInDescriptions: true,
            hideInForm: true,
            render: (_: any, record: any) => {
              return (
                <Button
                  onClick={() => {
                    // @ts-ignore
                    setCol(prizeColumns);
                    // @ts-ignore
                    setRow(record?.doctorAchievements?.prize);
                  }}
                  type="link"
                  disabled={!record?.doctorAchievements?.prize}
                >
                  查看奖励
                </Button>
              );
            },
          }
        : {
            hideInDescriptions: true,
            hideInForm: true,
          }),
    },
    {
      title: '论文名称',
      dataIndex: 'name',
      hideInTable: true,
      formItemProps: {
        name: 'paper_name',
      },
    },
    {
      title: '出版社',
      dataIndex: 'publication',
      hideInTable: true,
      formItemProps: {
        name: 'paper_publication',
      },
    },
    {
      title: '论文库',
      dataIndex: 'repo',
      hideInTable: true,
      formItemProps: {
        name: 'paper_repo',
      },
    },
    {
      title: '状态',
      dataIndex: 'status',
      hideInTable: true,
      formItemProps: {
        name: 'paper_status',
      },
    },
    {
      title: '索引类型',
      dataIndex: 'indexType',
      hideInTable: true,
      formItemProps: {
        name: 'paper_indexType',
      },
    },
    {
      title: '时间',
      dataIndex: 'time',
      hideInTable: true,
      formItemProps: {
        name: 'paper_time',
      },
    },
    {
      title: '论文资源',
      dataIndex: 'resource',
      hideInTable: true,
      formItemProps: {
        name: 'paper_resource',
      },
    },
    {
      title: '操作',
      dataIndex: 'option',
      valueType: 'option',
      render: (_, record) => (
        <>
          <a
            onClick={() => {
              // @ts-ignore
              setCol(
                // @ts-ignore
                record?.masterAchievements ? otherColumns : doctorOtherColumms,
              );
              setRow(record);
            }}
          >
            查看其他成果
          </a>
        </>
      ),
    },
    {
      ...(localStorage.getItem('user_type') === 'mentor' ||
      localStorage.getItem('user_type') === 'admin'
        ? {
            title: '审核',
            dataIndex: '_',
            valueType: 'option',
            render: (_, record) => (
              <>
                <Popconfirm
                  title="通过审核"
                  description="确认让成果通过审核?"
                  onConfirm={() => {
                    modifyUser({
                      node: user_type === 'admin' ? 1 : 0,
                      status: 'access',
                      id: record.id,
                    });
                    actionRef.current?.reload();
                  }}
                  disabled={
                    (user_type === 'admin' &&
                      (record?.initialStatus?.trim() !== 'access' ||
                        record?.finalStatus?.trim() !== 'pending')) ||
                    (user_type === 'mentor' &&
                      record?.initialStatus?.trim() !== 'pending')
                  }
                >
                  <Button
                    disabled={
                      (user_type === 'admin' &&
                        (record?.initialStatus?.trim() !== 'access' ||
                          record?.finalStatus?.trim() !== 'pending')) ||
                      (user_type === 'mentor' &&
                        record?.initialStatus?.trim() !== 'pending')
                    }
                    type="link"
                  >
                    {user_type === 'mentor' ? '通过初审' : '通过终审'}
                  </Button>
                </Popconfirm>

                <Popconfirm
                  title="不通过审核"
                  description="确认让成果不通过审核?"
                  onConfirm={() => {
                    modifyUser({
                      node: user_type === 'admin' ? 1 : 0,
                      status: 'failed',
                      id: record.id,
                    });
                    actionRef.current?.reload();
                  }}
                  disabled={
                    (user_type === 'admin' &&
                      (record?.initialStatus?.trim() !== 'access' ||
                        record?.finalStatus?.trim() !== 'pending')) ||
                    (user_type === 'mentor' &&
                      record?.initialStatus?.trim() !== 'pending')
                  }
                >
                  <Button
                    disabled={
                      (user_type === 'admin' &&
                        (record?.initialStatus?.trim() !== 'access' ||
                          record?.finalStatus?.trim() !== 'pending')) ||
                      (user_type === 'mentor' &&
                        record?.initialStatus?.trim() !== 'pending')
                    }
                    type="link"
                    danger
                  >
                    {user_type === 'mentor' ? '不通过初审' : '不通过终审'}
                  </Button>
                </Popconfirm>
              </>
            ),
          }
        : {
            hideInDescriptions: true,
            hideInForm: true,
          }),
    },
  ];

  return (
    <PageContainer
      header={{
        title: '研究生成果',
      }}
    >
      <ProTable
        headerTitle="研究生成果列表"
        actionRef={actionRef}
        rowKey="id"
        search={false}
        toolBarRender={() => [
          user_type !== 'mentor' && user_type !== 'admin' && (
            <Button
              key="1"
              type="primary"
              onClick={() => handleModalVisible(true)}
            >
              新建
            </Button>
          ),
        ]}
        request={async () => {
          const res = await queryUserList({
            user_id,
            user_type,
          });
          return {
            // @ts-ignore
            data: res.map((item) => {
              return {
                ...item?.masterAchievements,
                // @ts-ignore
                ...item?.doctorAchievements,
                ...item,
              };
            }) as any,
            success: true,
          };
        }}
        columns={columns}
      />
      {selectedRowsState?.length > 0 && (
        <FooterToolbar
          extra={
            <div>
              已选择{' '}
              <a style={{ fontWeight: 600 }}>{selectedRowsState.length}</a>{' '}
              项&nbsp;&nbsp;
            </div>
          }
        >
          <Button
            onClick={async () => {
              await handleRemove(selectedRowsState);
              setSelectedRows([]);
              actionRef.current?.reloadAndRest?.();
            }}
          >
            批量删除
          </Button>
          <Button type="primary">批量审批</Button>
        </FooterToolbar>
      )}
      <CreateForm
        onCancel={() => handleModalVisible(false)}
        modalVisible={createModalVisible}
      >
        <ProTable<API.UserInfo, API.UserInfo>
          onSubmit={async (value) => {
            const success = await handleAdd(value);
            if (success) {
              handleModalVisible(false);
              if (actionRef.current) {
                actionRef.current.reload();
              }
            }
          }}
          rowKey="id"
          type="form"
          columns={[
            ...columns,
            ...(user_type === 'doctor' ? prizeColumns : []),
            ...(user_type === 'doctor' ? doctorOtherColumms : otherColumns),
          ]}
        />
      </CreateForm>
      {stepFormValues && Object.keys(stepFormValues).length ? (
        <UpdateForm
          onSubmit={async (value) => {
            const success = await handleUpdate(value);
            if (success) {
              handleUpdateModalVisible(false);
              setStepFormValues({});
              if (actionRef.current) {
                actionRef.current.reload();
              }
            }
          }}
          onCancel={() => {
            handleUpdateModalVisible(false);
            setStepFormValues({});
          }}
          updateModalVisible={updateModalVisible}
          values={stepFormValues}
        />
      ) : null}

      <Drawer
        width={600}
        visible={!!row}
        onClose={() => {
          setRow(undefined);
        }}
        closable={false}
      >
        {row && (
          <ProDescriptions<API.UserInfo>
            column={1}
            title={'成果'}
            request={async () => ({
              data: row || {},
            })}
            // params={{
            //   id: row?.name,
            // }}
            columns={col}
          />
        )}
      </Drawer>
    </PageContainer>
  );
};

export default TableList;
