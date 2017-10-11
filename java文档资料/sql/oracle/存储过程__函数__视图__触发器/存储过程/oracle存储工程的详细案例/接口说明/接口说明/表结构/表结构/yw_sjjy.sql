----------------------------------------------------
-- Export file for user MZH001                    --
-- Created by Administrator on 2014-8-6, 15:58:55 --
----------------------------------------------------

set define off
spool yw_sjjy.log

prompt
prompt Creating table YW_SJJY
prompt ======================
prompt
create table YW_SJJY
(
  id         CHAR(32) not null,
  grbm       VARCHAR2(20) not null,
  dqbm       CHAR(6) not null,
  sjzt       CHAR(1),
  sjlx       VARCHAR2(10),
  mbbm       NUMBER,
  sjlr       CLOB not null,
  jhlsh      CHAR(32),
  cszt       CHAR(1),
  jhbm       VARCHAR2(10),
  inserttime DATE default sysdate,
  nplanid    CHAR(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 160M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table YW_SJJY
  is '���ݽ���������';
comment on column YW_SJJY.id
  is 'ά��ID';
comment on column YW_SJJY.grbm
  is '���˱���';
comment on column YW_SJJY.dqbm
  is '��������';
comment on column YW_SJJY.sjzt
  is '����״̬��0������δ����1�����Ѵ���';
comment on column YW_SJJY.sjlx
  is '��������(1:�������ݣ�2�������ѯ������)';
comment on column YW_SJJY.mbbm
  is 'ģ����룬��ģ���YW_DX_MB����';
comment on column YW_SJJY.sjlr
  is '���ݣ�XMLƴ�ӵ�����';
comment on column YW_SJJY.jhlsh
  is '���ݽ���������ˮ�ţ�GUID';
comment on column YW_SJJY.cszt
  is '����״̬
4:׼����ȡ
0:δ����
1:������
2:����ɹ�
3:����ʧ��';
comment on column YW_SJJY.jhbm
  is '�ƻ����룬����żƻ���YW_DX_DXJH����';
create index IDX_YW_SJJY on YW_SJJY (ID)
  tablespace MZH
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index IDX_YW_SJJY_NPLANID on YW_SJJY (NPLANID)
  tablespace MZH
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
