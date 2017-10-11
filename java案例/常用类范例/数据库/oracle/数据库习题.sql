˵��:(1��һ��41�⣬����100�֣�36��20�֣�����ÿ��2�֣�ʱ��120����
      2�����µĲ���������scott�û���
   )
Ҫ��:����ֱ��д��ÿ�������(���밴�淶д)

--1����ӱ��в�ѯ������CLERK�������˵����������ʡ����źš����������Լ����ŵ�ַ����Ϣ

SELECT e.ename , e.sal ,e.deptno ,d.dname ,d.loc
FROM emp e ,dept d
WHERE e.deptno=d.deptno and e.job='CLERK'

--2����ѯ��EMP�����еĹ��ʴ��ڵ���2000�Ĺ�Ա���������ľ��������

SELECT e.ename ,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno AND e.sal>=2000


--3���ڱ�EMP�в�ѯ���й��ʸ���JONES�����й�Ա�����������͹���

SELECT ename,job,sal
FROM emp
WHERE sal>(SELECT sal
FROM emp 
WHERE ename='JONES')

--4���г�û�ж�Ӧ���ű���Ϣ�����й�Ա�������������Լ����ź�

SELECT e.ename,e.job,e.deptno
FROM emp e
WHERE not exists(SELECT 1
FROM dept d 
WHERE e.deptno=d.deptno)

--5�����ҹ�����1000��3000֮��Ĺ�Ա���ڲ��ŵ�������Ա��Ϣ
select * from emp 
where deptno in(

SELECT dictinct e.deptno 
WHERE e.sal>=1000 AND e.sal<=3000
)

������:

SELECT e.* 
FROM emp e
WHERE exists (SELECT 1 FROM (SELECT distinct deptno FROM emp 
                             WHERE sal between 1000 and 3000) a 
              WHERE e.deptno=a.deptno)

--6����ѯ���й�Ա��������SAL��COMM֮��

SELECT ename,nvl(sal,0)+nvl(comm,0)
FROM emp

--7����ѯ����81��7��1����ǰ����Ա�����������ʡ��������ŵ�����

SELECT e.ename,e.sal,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno(+) AND e.hiredate<to_date('1981/7/1','yyyy/MM/dd')

--8����ѯ��������81��1��1���Ժ�����Ա����

SELECT d.dname, count(e.ename)
FROM emp e ,dept d
WHERE e.deptno=d.deptno AND e.hiredate>to_date('1981/1/1','yyyy/MM/dd')
GROUP BY d.dname

--9����ѯ������CHICAGO�����ľ���MANAGER������ԱSALESMAN������������

SELECT e.ename,e.sal
FROM emp e,dept d
WHERE e.deptno=d.deptno AND d.loc='CHECAGO' AND e.job='MANAGER' OR e.job='SALESMAN'

������:������Ч�ʵ�

SELECT e.ename ,e.sal 
FROM emp e ,dept d
WHERE e.deptno=d.deptno and d.loc='CHICAGO'
AND e.job in('MANAGER','SELESMAN')

--10����ѯ��81������˾����Ա���������루SAL��COMM��

������:��ʦ

SELECT sum(sal+nvl(comm,0))
FROM emp 
WHERE to_char(hiredate,'yyyy')='1981'

--11����ѯ��˾�а�����·�ͳ�Ƹ��ص�¼��ְ������
SELECT to_char(e.hiredate,'yyyy-MM'),d.loc,count(e.empno)
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY to_char(e.hiredate,'yyyy-MM'),d.loc

--12����ѯ�г������ŵĲ������Ͳ��ž������� ---

SELECT *
FROM emp e,dept d
WHERE e.deptno=d.deptno AND job='MANAGER'


--13�� ��ѯ����ƽ��������ߵĲ������� 
SELECT na.name
FROM (SELECT d.dname name,avg(sal) average
     FROM emp e,dept d
     WHERE e.deptno=d.deptno
     GROUP BY d.dname) na,(
           SELECT max(average) maxAverage
           FROM (SELECT d.dname name,avg(sal) average
                FROM emp e,dept d
                WHERE e.deptno=d.deptno
                GROUP BY d.dname))ma
WHERE na.average=ma.maxAverage

������:
SELECT d.dname 
FROM dept d , (
              SELECT rownum ,t.*
              FROM (
                    SELECT deptno,avg(sal) 
                    FROM emp 
                    GROUP BY deptno
                    ORDER BY avg(sal) desc ) t
              WHERE rownum =1 ) a
WHERE d.deptno=a.deptno



--14����emp�в����Ա���Ϊ7369��Ա������Ϣ(��ʾ��Ա��ţ���Ա���ƣ����¹���������)

SELECT empno,ename,job,sal
FROM emp 
WHERE empno=7369

--15����emp���ҳ�����Ϊ1500��4000֮���Ա��

SELECT *
FROM emp
WHERE sal>=1500 AND sal<=4000

--16����emp���ҳ�����Ϊ1500��4000֮���Ա�������Ҵ��µ������۵Ĺ���

SELECT *
FROM emp
WHERE sal>=1500 AND sal<=4000 AND job='SALESMAN'

--17����emp���ҳ�����Ϊ1500��4000֮���Ա���������ʵĽ������У�������ͬ�İ���ְ���ڽ�������

SELECT *
FROM emp
WHERE sal>=1500 AND sal<=4000
ORDER BY sal desc,hiredate desc


--18����emp���ҳ�������ANALYST��CLERK����Ա

SELECT *
FROM emp
WHERE job='ANALYST' OR job='CLERK'

--19���г����С�CLERK�����������䲿������

SELECT e.ename ,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno AND job='CLERK'

--20����emp���ҳ���������J��ͷԱ������Ϣ���������ʵĽ�������
SELECT *
FROM emp
WHERE ename like 'J%'
ORDER BY sal desc


--21����emp���ҳ��ܹ���������1987/4/19��Ա����Ϣ

SELECT *
FROM emp
WHERE hiredate<to_date('1987/4/19','yyyy-MM-dd')

--22���г��ܹ�����������ֱ���ϼ�������Ա��

SELECT e.*
FROM emp e,emp m
WHERE e.mgr=m.empno AND e.hiredate<m.hiredate

--23����emp���ҳ���Ա���ϼ���7698��Ա����Ϣ���������ʵĽ�������
SELECT *
FROM emp e
WHERE e.mgr=7698
ORDER BY sal desc


--24���г�н��ȡ�SMITH���������Ա��

SELECT *
FROM emp e
WHERE e.sal>(SELECT sal
FROM emp 
WHERE ename='SMITH')

--25���г�н����ڹ�˾ƽ��н�������Ա��

SELECT *
FROM emp
WHERE sal>(SELECT avg(sal)
FROM emp
)

--26���г��롰SCOTT��������ͬ����������Ա��
SELECT *
FROM emp
WHERE job=(SELECT job
FROM emp
WHERE  ename='SCOTT') AND ename!='SCOTT'


--27���г��ڲ��š�SALES��������Ա�����������������ʽ�������

SELECT ename,sal
FROM emp
WHERE (SELECT deptno
FROM dept
WHERE dname='SALES')=deptno
ORDER BY sal desc

--28���г�н������ڲ���30���������е�Ա����н���Ա��������н��

SELECT ename,sal
FROM emp 
WHERE sal>(SELECT max(sal)
FROM emp
WHERE deptno=30)

--29���г�Ա���Ĺ��ţ�������ԭ���ʣ��¹���(�Դ���CLERK��+200���Դ���SALESMAN+300��������Ա���ʲ���)--

SELECT sal+200 cs
FROM emp 
WHERE job='CLERK'

SELECT sal+300 ss
FROM emp 
WHERE job='SALESMAN'

SELECT empno,ename,sal,newsal
FROM emp
WHERE 

--30���г�����Ա������������ֱ���ϼ�������

SELECT e.ename,m.ename
FROM emp e,emp m
WHERE e.mgr=m.empno

--31���г����н�����1500�ĸ��ֹ�����������������

SELECT job
FROM (SELECT *
     FROM emp
     ORDER BY sal desc)
GROUP BY job
HAVING min(sal)>1500



--32���г�ÿ�����Ź�����Ա��������ƽ�����ʣ�����ƽ����������

SELECT count(e.ename),avg(e.sal)
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY d.dname
ORDER BY avg(e.sal) desc

������:��ʦ
SELECT d.dname,nvl(a.c,0),nvl(a.b,0)
FROM dept d,(SELECT deptno,count(*) c,avg(sal) b
                    FROM emp
                    GROUP BY deptno ) a
WHERE d.deptno=a.deptno(+)
ORDER BY nvl(a.b,0) desc


--33���г�����Ա�����������������ƺ͹���

SELECT e.ename,d.dname,e.sal
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno

--34���г��������ƺ���Щ���ŵ�Ա����Ϣ��ͬʱ�г���Щû��Ա���Ĳ���

SELECT d.dname,e.ename
FROM emp e,dept d
WHERE e.deptno(+)=d.deptno

--35���г����ֹ�������͹���

SELECT min(e.sal)
FROM emp e,dept d
WHERE e.deptno=d.deptno
GROUP BY d.dname

--36������һ�Ŷ�����,�ֶ���(������ ����������״̬�������ˣ���ַ���۸���ϵ�绰)

CREATE TABLE t_dingdan(did number(20) primary key,
                        dstatus varchar(10),
                        dperson varchar(10),
                        daddress varchar(100),
                        dprice number(20),
                        dphone number(20)); 

--    ����һ�Ŷ�����ϸ���ֶ���(��� ��������Ʒ��ţ��۸񣬶������(���))

CREATE TABLE t_ddetailed(ddid number(20) primary key,
ddgoodsid varchar2(50),
ddprice number(20),
dingd_id number(20),
constraint dingd_id_FK foreign key(dingd_id) references t_dingdan(did) on delete cascade);

--     1)���򶩵���ʹ��������������������



--    (������:201403081201,����״̬��00,������:����,��ַ���ɶ����۸�250����ϵ�绰:13800138000)

INSERT INTO t_dingdan(did,dstatus,dperson,daddress,dprice,dphone) 
VALUES(201403081201,'00','����','�ɶ�',250,13800138000)


--    (������:201403081202,����״̬��02,������:����,��ַ�����ϣ��۸�35����ϵ�绰:10086)
INSERT INTO t_dingdan(did,dstatus,dperson,daddress,dprice,dphone) 
VALUES(201403081202,'02','����','����',35,10086)

--    (������:201403081203,����״̬��02,������:������,��ַ���䵱ɽ���۸�800����ϵ�绰:1008611)
INSERT INTO t_dingdan(did,dstatus,dperson,daddress,dprice,dphone) 
VALUES(201403081203,'02','������','�䵱ɽ',800,1008611)

--     2)���򶩵���ϸ���в�������5������
--     (��ţ�2014030801����Ʒ��ţ�001,�۸�200��������ţ�201403081203)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030801,'001',200,201403081203)


SELECT * FROM  t_ddetailed

--     (��ţ�2014030802����Ʒ��ţ�003,�۸�300��������ţ�201403081203)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030802,'003',300,201403081203)

--     (��ţ�2014030803����Ʒ��ţ�004,�۸�300��������ţ�201403081203)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030803,'004',300,201403081203)

--     (��ţ�2014030804����Ʒ��ţ�005,�۸�35��������ţ�201403081202)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030804,'005',35,201403081202)

--     (��ţ�2014030805����Ʒ��ţ�002,�۸�250��������ţ�201403081201)
INSERT INTO  t_ddetailed(ddid,ddgoodsid,ddprice,dingd_id)
VALUES(2014030805,'002',250,201403081201)

--   3)��ͳ�Ƴ�20140308����һ�������۶�

SELECT sum(ddprice)
FROM t_ddetailed


--   4)������������ĵ�ַΪ������

UPDATE t_dingdan SET daddress='������'
WHERE dperson='������'

SELECT * FROM t_dingdan
SELECT * FROM t_ddetailed
--   5)��ͳ��ÿ�ֶ���״̬�ļ۸��ܺ�
SELECT sum(ddprice)
FROM t_ddetailed
GROUP BY dingd_id


--   6)���ڶ�������ɾ���������Ϊ201403081203�Ķ���


DELETE FROM t_dingdan 
WHERE did=201403081203

--   7)����ն�����
TRUNCATE TABLE t_ddetailed

TRUNCATE TABLE t_dingdan

--37�����������ݿ��������Щ��Լ������Щ?������Ψһ��������
��:  �� ,��ͼ,����,����,ͬ���
    2.not null ,unique ,primary key,foreign key,check
    3.������ֵΨһ�Ҳ����п�ֵ,��Ψһ����ֵΨһ�������п�ֵ

--38������Ƶ�����ʽ����֮��Ĺ�ϵ������һ��������һ��t_order��ı��ݱ�
��:
    1���е��в����ٷ�,�������һ��ʽ�Ļ�����,���еķ������б�������������,������ڶ���ʽ�Ļ�����,
    �������б����໥����
    2.һ��һ,һ�Զ�����һ ,��Զ�
    3.CREATE TABLE t_order_bak
      AS
      SELECT * FROM t_order

--39�������ķ��麯������Щ?
��:
   1.sum() ,min(),max(),count(),avg()

--40�������ʾ��ṹ�����ȥ���ظ��У�sql�����࣬��ָ����������¶���ʲô���
��:desc ����
       2.SELECT distinct ���� FROM ����
       3.sql�����Ҫ��Ϊ �� ,ɾ ,�� ,�� ����
       �� :��Ҫ�� insert into ���� 
       ɾ :��Ҫ�� delete ,drop ,truncate ����
       �� :��Ҫ�� update ����
       �� :��Ҫ�� select ����

--41��delete,truncate,drop����
��:
  1.delete��ɾ����������,ͬʱ��������Իع�
  2.truncate����ձ�����,��������ṹ
  3.drop����ձ�����,ͬʱҲ���ñ���ɾ��

--
  
