--���нӿ�
--------------------------------------------------------
--i_sp_sjjy_insert
--5.1 д�����ݽ�����
/*
�洢�����ƣ�i_sp_sjjy_insert��д�����ݽ�����
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ���������뷴���ѯ��Ϣ��  
*/
create or replace procedure i_sp_sjjy_insert(
ids in yw_sjjy.id%type,--id
grbms in yw_sjjy.grbm%type,--���˱���
dqbms in yw_sjjy.dqbm%type,--��������
mbbms in yw_sjjy.mbbm%type,--ģ�����
sjlrs in yw_sjjy.sjlr%type,--�������ݣ�xml��ʽ��
results out number,--ִ�н���������
messages out varchar2--ִ������������
)
is
sjlx varchar2(10);
npid raw(16);
begin
  if(ids is null)then
    --���idΪ�գ��²���һ��sys_guid����ͬ�������������һ�����������ݽ�������
    insert into yw_sjjy(id,grbm,dqbm,sjzt,sjlx,mbbm,sjlr,jhlsh,cszt,jhbm,inserttime,nplanid)values
  (sys_guid,grbms,dqbms,'0','1',mbbms,sjlrs,null,'0','0',sysdate,null);
  elsif(ids is not null)then
    begin
      --id��Ϊ��ʱ���������ѯ��������ȥ��ѯ��Ӧ��nplanid�ֶ���Ϣ
      select y.nplanid into npid from yw_sjjy_fxcx y where y.id=ids;
      --id��Ϊ��ʱ���������ѯ��������ȥjhbm�ֶ���Ϣ
      select y.jhbm into sjlx from yw_sjjy_fxcx y where y.id=ids;
      --�쳣����
    exception when no_data_found then
      npid:=null;
      sjlx:=null;
    end;
    --������Ϣ�����ݽ�������
    insert into yw_sjjy(id,grbm,dqbm,sjzt,sjlx,mbbm,sjlr,jhlsh,cszt,jhbm,inserttime,nplanid)values
  (ids,grbms,dqbms,'0',sjlx,mbbms,sjlrs,null,'0','0',sysdate,npid);
  end if;
  results:=1;
  messages:=null;
  commit;
  --�쳣����
  exception
    when others then
    rollback;
    results:=0;
    messages:=substr(sqlerrm,1,100);
end i_sp_sjjy_insert;
--------------------------------------------------------

--------------------------------------------------------
--����
declare
id char(32):='9bde802016794972b4d0772ccb9ca214';
grbm varchar2(20):='888888888';
dqbm char(6):='555555';
mbbm number:='0';
sjlr clob:='<test></test>';
results number;
messages varchar(100);
begin
  i_sp_sjjy_insert(id,grbm,dqbm,mbbm,sjlr,results,messages);
  dbms_output.put_line('results'||results);
  dbms_output.put_line('messages'||messages);
end;
select * from yw_sjjy y where y.id='9bde802016794972b4d0772ccb9ca214' for update;
--------------------------------------------------------
--������ʱ�����ڴ�Ų�ѯ�����ѯ�����������ѯ��id
create global temporary table temp_id
(
       id char(32)
);
--i_sp_sjjy_fxcx_select
--5.2��ѯ�����ѯ������
/*
�洢�����ƣ�i_sp_sjjy_fxcx_select����ѯ�����ѯ������
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ��������ѯ�����ѯ������  
*/
create or replace procedure i_sp_sjjy_fxcx_select(
lens number,--Ҫ��ѯ������
dqbms char,--��������
results out sys_refcursor--�����
)is
begin
  --���ؽ����
  open results for select y.id,y.grbm,y.cxbm,y.sjzt,y.cxsj,y.clsj,y.mbbm,y.cxbm from yw_sjjy_fxcx y where y.dqbm=dqbms and rownum<=lens and y.tqzt is null order by y.cxsj asc;
  --�ѷ��ؽ������id������ʱ��temp_id��
  insert into temp_id select id from yw_sjjy_fxcx y where y.dqbm=dqbms and rownum<=lens and y.tqzt is null order by y.cxsj asc;
  --������ʱ���е�id��Ϣ���·����ѯ�������е���ȡ״̬�ֶ�
  update yw_sjjy_fxcx y set y.tqzt='1',y.tqsj=sysdate where y.id in (select id from temp_id);
  commit;
end;
--------------------------------------------------------
--���²���Ҫ����sql plus�н���
var x refcursor;
exec i_sp_sjjy_fxcx_select(2,'510100',:x);
print :x;
--------------------------------------------------------
select * from yw_sjjy_fxcx y for update;
--------------------------------------------------------
--i_sp_sjjy_update
--5.3 ���·����ѯ������
/*
�洢�����ƣ�i_sp_sjjy_update�����·����ѯ������
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ���������·����ѯ������  
*/
create or replace procedure i_sp_sjjy_update(
ids in yw_sjjy_fxcx.id%type,--id
sjzts in yw_sjjy_fxcx.sjzt%type,--����״̬
clsjs in yw_sjjy_fxcx.clsj%type,--����ʱ��
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
begin
  if(ids is null) then
    results:=0;
    messages:='idΪ���޷�����';
  elsif(ids is not null)then
    --���·����ѯ������
    update yw_sjjy_fxcx y set y.sjzt=sjzts,y.clsj=clsjs where y.id=ids;
    results:=1;
    messages:=null;
    commit;
  end if;
  --�쳣����
  exception
  when others then
    rollback;
    results:=0;
    messages:=substr(trim(sqlerrm),1,100);
end i_sp_sjjy_update;
--------------------------------------------------------
select * from yw_sjjy_fxcx;
--����
declare id char(32):='7db6eca3ad4b4b008e1f8ecf72bf4784';
sjzt char(1):='0';
clsj date:=sysdate;
results number;
messages varchar2(100);
begin
  i_sp_sjjy_update(id,sjzt,clsj,results,messages);
  dbms_output.put_line(results);
  dbms_output.put_line(messages);
end;
-----------------------------------------------------------
--i_sp_grjc_insert
--5.4 �����α���Ա
/*
�洢�����ƣ�i_sp_grjc_insert���������˻�����Ϣ��
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ�������������˻�����Ϣ��  
*/
create or replace procedure i_sp_grjc_insert(
grbms in yw_dx_grjc.grbm%type,--���˱���
dwbms in yw_dx_grjc.dwbm%type,--��λ����
sfzhs in yw_dx_grjc.sfzh%type,--���֤��
xms in yw_dx_grjc.xm%type,--����
gwybzs in yw_dx_grjc.gwybz%type,--����Ա��־
xbs in yw_dx_grjc.xb%type,--�Ա�
dqbms in yw_dx_grjc.dqbm%type,--��������
dhhms in yw_dx_grjc.dhhm%type,--�绰����
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
validityPhone varchar2(10);
isExistPhone number;
isExistGrbm number;
begin
  --�жϵ绰�����Ƿ�Ϸ�
  --1���Ƿ�Ϸ��绰����
  --2���Ƿ��ظ�
  validityPhone:=chargyys(dhhms);
  select count(*) into isExistPhone from yw_dx_grjc y where y.dhhm=dhhms and y.ryzt='1';
  --�ж��Ƿ���ڲα���Ա
  select count(*) into isExistGrbm from yw_dx_grjc y where y.grbm=grbms and y.dqbm=dqbms;
  if(validityPhone=0)then
     results:=0;
     messages:='�绰���벻�Ϸ�';
  else
     if(isExistPhone<>0)then
          results:=0;
          messages:='�绰�����Ѵ���';
     else
          if(isExistGrbm<>0)then
            results:=0;
            messages:='�α��˸��˱����Ѵ���';
          else
            if(gwybzs not in('0','1','2','3','4'))then
              results:=0;
              messages:='��Ա��־���Ϸ�';
            else
              if(xbs not in('1','2'))then
                results:=0;
                messages:='�Ա𲻺Ϸ�';
              else
                if(xms is null or (trim(dqbms) is null))then
                   results:=0;
                   messages:='�����͵������붼����Ϊ��';
                else
                  begin
                   --�������˻�����Ϣ
                   insert into yw_dx_grjc values(dwbms,grbms,sfzhs,xms,'1',gwybzs,xbs,'',dqbms,dhhms,chargyys(dhhms));
                   --����������Ϣ����Ա�����ۼ�����
                   --insert into yw_dx_grjcmark values(grbms,dqbms,1);
                   results:=1;
                   messages:=null;
                   commit;
                   --�쳣����
                  exception
                   when others then
                    rollback;
                    results:=0;
                    messages:=substr(trim(sqlerrm),1,100);
                  end;
                end if;
              end if;
            end if;
          end if;
     end if;   
  end if;
end i_sp_grjc_insert;
-----------------------------------------------------------
--����
declare
grbm varchar2(20):='100000000';
dwbm varchar2(10):='100000';
sfzh varchar2(18):='';
xm varchar2(15):='������';
gwybz varchar2(5):='4';
xb varchar2(2):='1';
dqbm char(6):='510100';
dhhm varchar2(11):='18100000002';
results number;
messages varchar2(100);
begin
  i_sp_grjc_insert(grbm,dwbm,sfzh,xm,gwybz,xb,dqbm,dhhm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
select * from yw_dx_grjc y where y.grbm='100000000' for update;
-----------------------------------------------------------
--i_sp_grjc_update
--5.5 �޸Ĳα���Ա
/*
�洢�����ƣ�i_sp_grjc_update���޸ĸ��˻�������Ϣ��
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ�������޸ĸ��˻�������Ϣ��  
*/
create or replace procedure i_sp_grjc_update(
grbms in yw_dx_grjc.grbm%type,--���˱���
dwbms in yw_dx_grjc.dwbm%type,--��λ����
sfzhs in yw_dx_grjc.sfzh%type,--���֤��
xms in yw_dx_grjc.xm%type,--����
ryzts in yw_dx_grjc.ryzt%type,--��Ա״̬
gwybzs in yw_dx_grjc.gwybz%type,--����Ա��־
xbs in yw_dx_grjc.xb%type,--�Ա�
dqbms in yw_dx_grjc.dqbm%type,--��������
dhhms in yw_dx_grjc.dhhm%type,--�绰����
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
validityPhone varchar2(10);
isExistPhone number;
isExistGrbm number;
begin
  --�жϵ绰�����Ƿ�Ϸ�
  --1���Ƿ�Ϸ��绰����
  --2���Ƿ��ظ�
  validityPhone:=chargyys(dhhms);
  select count(*) into isExistPhone from yw_dx_grjc y where y.dhhm=dhhms and y.ryzt='1' and y.grbm<>grbms;
  --�ж��Ƿ���ڲα���Ա
  select count(*) into isExistGrbm from yw_dx_grjc y where y.grbm=grbms and y.dqbm=dqbms;
  if(validityPhone=0)then
     results:=0;
     messages:='�绰���벻�Ϸ�';
  else
     if(isExistPhone<>0)then
          results:=0;
          messages:='�绰�����Ѵ���';
     else
          if(isExistGrbm=0 or (trim(dqbms) is null))then
            results:=0;
            messages:='�α��˸��˱��벻���ڻ��ߵ�������Ϊ��';
          else
            if(gwybzs not in('0','1','2','3','4'))then
              results:=0;
              messages:='��Ա��־���Ϸ�';
            else
              if(xbs not in('1','2'))then
                results:=0;
                messages:='�Ա𲻺Ϸ�';
              else
                if(xms is null or (ryzts not in('0','1')) )then
                   results:=0;
                   messages:='��������Ϊ�ջ�����Ա״̬����';
                else
                  begin
                   --���¸��˻�����Ϣ��
                   update yw_dx_grjc y set y.dwbm=dwbms,y.sfzh=sfzhs,y.xm=xms,y.ryzt=ryzts,y.gwybz=gwybzs,y.xb=xbs,y.dhhm=dhhms,y.yys=chargyys(dhhms) where y.grbm=grbms and y.dqbm=dqbms;
                   --����������Ϣ����Ա�����ۼ�����
                   insert into yw_dx_grjcmark values(grbms,dqbms,2);
                   results:=1;
                   messages:=null;
                   commit;
                   --�쳣����
                  exception
                   when others then
                    rollback;
                    results:=0;
                    messages:=substr(trim(sqlerrm),1,100);
                  end;
                end if;
              end if;
            end if;
          end if;
     end if;   
  end if;
end i_sp_grjc_update;
-----------------------------------------------------------
--����
declare
grbm varchar2(20):='100000005';
dwbm varchar2(10):='100000';
sfzh varchar2(18):='612326198604284511';
xm varchar2(15):='������';
ryzt varchar2(5):='0';
gwybz varchar2(5):='4';
xb varchar2(2):='1';
dqbm char(6):='510100';
dhhm varchar2(11):='15002817702';
results number;
messages varchar2(100);
begin
  i_sp_grjc_update(grbm,dwbm,sfzh,xm,ryzt,gwybz,xb,dqbm,dhhm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
select * from yw_dx_grjc y where y.xm='������' for update;
select * from yw_dx_grjc y where y.grbm='100000005' for update;
-----------------------------------------------------------
--i_sp_grjc_delete
--5.6 ɾ���α���Ա
/*
�洢�����ƣ�i_sp_grjc_delete���޸Ļ�����Ա״̬��
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ�������޸Ļ�����Ա��Ϣ��  
*/
create or replace procedure i_sp_grjc_delete(
grbms in yw_dx_grjc.grbm%type,--���˱���
dqbms in yw_dx_grjc.dqbm%type,--��������
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
isDelete number;
begin
  --���ݸ��˱��룬�����������Ա״̬�ж��Ƿ������Ա��Ϣ
  select count(*) into isDelete from yw_dx_grjc y where y.grbm=grbms and y.dqbm=dqbms and y.ryzt='1';
  if(isDelete=0)then
     results:=0;
     messages:='��Ա���߼�ɾ��';
  else
    begin
      --�޸ĸ��˻���������Ա״̬��Ϣ
      update yw_dx_grjc y set y.ryzt='0' where y.grbm=grbms and y.dqbm=dqbms;
      --����������Ϣ����Ա�����ۼ�����
      insert into yw_dx_grjcmark values(grbms,dqbms,3);
      results:=1;
      messages:=null;
      commit;
      --�쳣����
    exception
      when others then
       rollback;
        results:=0;
        messages:=substr(trim(sqlerrm),1,100);
    end;
  end if;
end i_sp_grjc_delete;
----------------------------------------------------------
select * from yw_dx_grjc y where y.xm='������';
--����
declare grbm varchar2(20):='100000005';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_grjc_delete(grbm,dqbm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
----------------------------------------------------------
--i_sp_dwxx_insert
--5.7 ������λ
/*
�洢�����ƣ�i_sp_dwxx_insert��д�뵥λ��Ϣ��
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ���������뵥λ��Ϣ��  
*/
create or replace procedure i_sp_dwxx_insert(
dwbms in yw_dm_dwxx.dwbm%type,--��λ����
dwmcs in yw_dm_dwxx.dwmc%type,--��λ����
dqbms in yw_dm_dwxx.dqbm%type,--��������
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
isExist number;
begin
  --���ݵ�λ����͵��������ж��Ƿ���ڵ�λ��Ϣ
  select count(*) into isExist from yw_dm_dwxx y where y.dwbm=dwbms and y.dqbm=dqbms;
  if(isExist=1)then
     results:=0;
     messages:='�����Ѵ���';
  elsif(isExist=0)then
     --������λ��Ϣ
     insert into yw_dm_dwxx(dwbm,dwmc,dwyx,dqbm,grbm)values(dwbms,dwmcs,'1',dqbms,'');
     --����������λ��Ϣ���뵥λ�����ۼ���
     --insert into yw_dm_dwxxmark values(dwbms,dqbms,1);
     results:=1;
     messages:=null;
     commit;
  end if;
  --�쳣����
exception
  when others then
     rollback;
     results:=0;
     messages:=substr(trim(sqlerrm),1,100);
end i_sp_dwxx_insert;
----------------------------------------------------------
--����
declare dwbm varchar2(10):='90022222';
dwmc varchar2(80):='�쳣�����о���';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_dwxx_insert(dwbm,dwmc,dqbm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
select * from yw_dm_dwxx y where y.dwbm='90022222' and y.dqbm='510100' for update;
----------------------------------------------------------
--i_sp_dwxx_update
--5.8 �޸ĵ�λ
/*
�洢�����ƣ�i_sp_dwxx_update���޸ĵ�λ��Ϣ��
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ�������޸ĵ�λ��Ϣ��  
*/
create or replace procedure i_sp_dwxx_update(
dwbms in yw_dm_dwxx.dwbm%type,--��λ����
dwmcs in yw_dm_dwxx.dwmc%type,--��λ����
dqbms in yw_dm_dwxx.dqbm%type,--��������
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
isExist number;
begin
  --�Ե�λ����͵�������Ϊ������ѯ�Ƿ���ڵ�λ��Ϣ
  select count(*) into isExist from yw_dm_dwxx y where y.dwbm=dwbms and y.dqbm=dqbms;
  if(isExist=0)then
      results:=0;
      messages:='���ݲ�����';
      --(dwbm,dwmc,dwyx,dqbm,grbm
  elsif(isExist=1)then
      --���µ�λ��Ϣ
      update yw_dm_dwxx y set y.dwmc=dwmcs where y.dwbm=dwbms and y.dqbm=dqbms;
      --�������µ�λ��Ϣ���뵥λ�����ۼ���
    --  insert into yw_dm_dwxxmark values(dwbms,dqbms,2);
      results:=1;
      messages:=null;
      commit;
  end if;
  --�쳣����
exception
  when others then
    rollback;
    results:=0;
    messages:=substr(trim(sqlerrm),1,100);  
end i_sp_dwxx_update;
----------------------------------------------------------
--����
declare dwbm varchar2(10):='90022222';
dwmc varchar2(80):='�����������о���';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_dwxx_update(dwbm,dwmc,dqbm,results,messages);
  dbms_output.put_line('results:'||results);
  dbms_output.put_line('messages:'||messages);
end;
----------------------------------------------------------
--i_sp_dwxx_delete
--5.9 ɾ����λ
/*
�洢�����ƣ�i_sp_dwxx_delete��ɾ����λ��Ϣ��
��  ��  �ˣ�������
�� �� ���ڣ�2017-07-29
���� �� �������ⲿ������ϵͳ���ã��������籣ϵͳ�ȣ�������Ӧ������ɾ����λ��Ϣ��  
*/
create or replace procedure i_sp_dwxx_delete(
dwbms in yw_dm_dwxx.dwbm%type,--��λ����
dqbms in yw_dm_dwxx.dqbm%type,--��������
results out number,--ִ�н���������
messages out varchar2--ִ������������
)is
begin
  --���ݴ������ɾ����λ��Ϣ
  delete yw_dm_dwxx y where y.dwbm=dwbms and y.dqbm=dqbms;
  --����ɾ����λ��Ϣ���뵥λ�����ۼ���
  --insert into yw_dm_dwxxmark values(dwbms,dqbms,3);
  results:=1;
  messages:=null;
  commit;
  --�쳣����
exception
  when others then
    rollback;
    results:=0;
    messages:=substr(trim(sqlerrm),1,100);
end i_sp_dwxx_delete;
----------------------------------------------------------
--����
declare dwbm varchar2(10):='90022222';
dqbm char(6):='510100';
results number;
messages varchar2(100);
begin
  i_sp_dwxx_delete(dwbm,dqbm,results,messages);
end;
--
select * from yw_dm_dwxx y where y.dwbm='90022222' and y.dqbm='510100';
-----------------------------------------------------------
--��Ȩ
--1
grant execute on i_sp_sjjy_insert to interfaceuser;
grant select on yw_sjjy_fxcx to interfaceuser;
revoke select on yw_sjjy_fxcx from interfaceuser;
grant insert on yw_sjjy to interfaceuser;
revoke insert on yw_sjjy from interfaceuser;
--2
grant execute on i_sp_sjjy_fxcx_select to interfaceuser;
grant select on yw_sjjy_fxcx to interfaceuser;
revoke select on yw_sjjy_fxcx from interfaceuser;
grant insert on temp_id to interfaceuser;
revoke insert on temp_id from interfaceuser;
grant update on yw_sjjy_fxcx to interfaceuser;
revoke update on yw_sjjy_fxcx from interfaceuser;
--3
grant execute on i_sp_sjjy_update to interfaceuser;
grant update on yw_sjjy_fxcx to interfaceuser;
revoke update on yw_sjjy_fxcx from interfaceuser;
--4
grant execute on i_sp_grjc_insert to interfaceuser;
grant insert on yw_dx_grjc to interfaceuser;
revoke insert on yw_dx_grjc from interfaceuser;
grant insert on yw_dx_grjcmark to interfaceuser;
revoke insert on yw_dx_grjcmark from interfaceuser;
--5
grant execute on i_sp_grjc_update to interfaceuser;
grant select on yw_dx_grjc to interfaceuser;
revoke select on yw_dx_grjc from interfaceuser;
grant update on yw_dx_grjc to interfaceuser;
revoke update on yw_dx_grjc from interfaceuser;
grant insert on yw_dx_grjcmark to interfaceuser;
revoke insert on yw_dx_grjcmark from interfaceuser;
--6
grant execute on i_sp_grjc_delete to interfaceuser;
grant update on yw_dx_grjc to interfaceuser;
revoke update on yw_dx_grjc from interfaceuser;
grant insert on yw_dx_grjcmark to interfaceuser;
revoke insert on yw_dx_grjcmark from interfaceuser;
--7
grant execute on i_sp_dwxx_insert to interfaceuser;
grant select on yw_dm_dwxx to interfaceuser;
revoke select on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxx to interfaceuser;
revoke insert on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxxmark to interfaceuser;
revoke insert on yw_dm_dwxxmark from interfaceuser;
--8
grant execute on i_sp_dwxx_update to interfaceuser;
grant select on yw_dm_dwxx to interfaceuser;
revoke select on yw_dm_dwxx from interfaceuser;
grant update on yw_dm_dwxx to interfaceuser;
revoke update on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxxmark to interfaceuser;
revoke insert on yw_dm_dwxxmark from interfaceuser;
--9
grant execute on i_sp_dwxx_delete to interfaceuser;
grant delete on yw_dm_dwxx to interfaceuser;
revoke delete on yw_dm_dwxx from interfaceuser;
grant insert on yw_dm_dwxxmark to interfaceuser;
revoke insert on yw_dm_dwxxmark from interfaceuser;
