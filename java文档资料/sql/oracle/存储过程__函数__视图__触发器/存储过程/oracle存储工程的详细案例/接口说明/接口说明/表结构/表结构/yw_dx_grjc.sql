----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 15:59:57 --
----------------------------------------------------

set define off
spool yw_dx_grjc.log

prompt
prompt Creating table YW_DX_GRJC
prompt =========================
prompt
create table YW_DX_GRJC
(
  dwbm  VARCHAR2(10),
  grbm  VARCHAR2(20) not null,
  sfzh  VARCHAR2(18),
  xm    VARCHAR2(15),
  ryzt  VARCHAR2(5),
  gwybz VARCHAR2(5),
  xb    VARCHAR2(2),
  bz    VARCHAR2(500),
  dqbm  CHAR(6),
  dhhm  VARCHAR2(50),
  yys   VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 24M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table YW_DX_GRJC
  is '���˻�����Ϣ��';
comment on column YW_DX_GRJC.dwbm
  is '��λ����';
comment on column YW_DX_GRJC.grbm
  is '���������˱���';
comment on column YW_DX_GRJC.sfzh
  is '���֤';
comment on column YW_DX_GRJC.xm
  is '����';
comment on column YW_DX_GRJC.ryzt
  is '��Ա״̬(��־�Ƿ������߼�ɾ��)';
comment on column YW_DX_GRJC.gwybz
  is '����Ա��־��1������Ա��0���ǹ���Ա��';
comment on column YW_DX_GRJC.xb
  is '�Ա�1���У�2��Ů��';
comment on column YW_DX_GRJC.bz
  is '��ע';
comment on column YW_DX_GRJC.dqbm
  is '�������룬����YW_DQ';
comment on column YW_DX_GRJC.dhhm
  is '�绰����';
comment on column YW_DX_GRJC.yys
  is '��Ӫ��';
alter table YW_DX_GRJC
  add constraint PK_YW_GRJC primary key (GRBM)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 8M
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
