@echo off   
echo ================================================   
echo  Windows������mysql���ݿ���Զ����ݽű�  
echo  1. ʹ�õ�ǰ�������������ļ���  
echo  2. �Զ�ɾ��7��ǰ�ı��ݡ�  
echo ================================================  
::�ԡ�YYYYMMDD����ʽȡ����ǰʱ�䡣  
set BACKUPDATE=%date:~0,4%%date:~5,2%%date:~8,2%
::�����û����������Ҫ���ݵ����ݿ⡣  

set HOST=10.2.4.11
set USER=root
set PASSWORD=root
set DATABASE=platform
::��������Ŀ¼��  
if not exist "D:\mysql_backup\data"       mkdir D:\mysql_backup\data  

set DATADIR=D:\mysql_backup\data

mysqldump -h%HOST% -u%USER% -p%PASSWORD% --skip-lock-tables --default-character-set=utf8 %DATABASE% > %DATADIR%\mysql_%BACKUPDATE%.sql

::ɾ��7��ǰ�ı��ݡ�  
forfiles /p "%DATADIR%" /s /m *.* /d -7 /c "cmd /c del @path"

exit


