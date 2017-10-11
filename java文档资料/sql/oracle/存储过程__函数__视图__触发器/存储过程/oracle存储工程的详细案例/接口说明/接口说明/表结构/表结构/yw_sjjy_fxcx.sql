----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 15:59:38 --
----------------------------------------------------

set define off
spool yw_sjjy_fxcx.log

prompt
prompt Creating table YW_SJJY_FXCX
prompt ===========================
prompt
create table YW_SJJY_FXCX
(
  id      CHAR(32) not null,
  grbm    VARCHAR2(20) not null,
  cxbm    VARCHAR2(100) not null,
  sjzt    CHAR(1),
  cxsj    DATE default sysdate,
  clsj    DATE,
  dqbm    CHAR(6),
  jhlsh   CHAR(32),
  mbbm    NUMBER,
  cszt    CHAR(1),
  jhbm    VARCHAR2(10),
  tqzt    CHAR(1),
  tqsj    DATE,
  nplanid CHAR(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table YW_SJJY_FXCX
  is '���ݽ���������ͼƻ���';
comment on column YW_SJJY_FXCX.id
  is 'ά��ID';
comment on column YW_SJJY_FXCX.grbm
  is '���˱���';
comment on column YW_SJJY_FXCX.cxbm
  is '��ѯ���룬����Ǽƻ����ݣ�CXBMΪ0';
comment on column YW_SJJY_FXCX.sjzt
  is '����״̬��0������δ����1�����Ѵ���';
comment on column YW_SJJY_FXCX.cxsj
  is '�α��û���ѯʱ�䣬��ƻ����ݲ���ʱ��';
comment on column YW_SJJY_FXCX.clsj
  is '�����������������ݴ���ʱ��';
comment on column YW_SJJY_FXCX.dqbm
  is '��������';
comment on column YW_SJJY_FXCX.jhlsh
  is '���ݽ���������ˮ��';
comment on column YW_SJJY_FXCX.mbbm
  is 'ģ�����';
comment on column YW_SJJY_FXCX.cszt
  is '����״̬
4:׼����ȡ
0:δ����
1:������
2:����ɹ�
3:����ʧ��';
comment on column YW_SJJY_FXCX.jhbm
  is '�ƻ����룬����YW_DX_DXJH
���Ϊ�ƻ����ݣ���Ϊ�ƻ�����
����Ƿ����ѯ������Ϊ2
';


spool off
