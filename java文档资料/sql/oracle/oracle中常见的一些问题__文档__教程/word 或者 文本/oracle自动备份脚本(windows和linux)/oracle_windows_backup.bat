@echo off   
echo ================================================   
echo  Windows������Oracle���ݿ���Զ����ݽű�  
echo  1. ʹ�õ�ǰ�������������ļ���  
echo  2. �Զ�ɾ��7��ǰ�ı��ݡ�  
echo ================================================  
::�ԡ�YYYYMMDD����ʽȡ����ǰʱ�䡣  
set BACKUPDATE=%date:~0,4%%date:~5,2%%date:~8,2%
::�����û����������Ҫ���ݵ����ݿ⡣  

set USER=yzpt
set PASSWORD=yz_5127jljy_14
set DATABASE=orcl
::��������Ŀ¼��  
if not exist "d:\oracle_backup\data"       mkdir d:\oracle_backup\data  
if not exist "d:\oracle_backup\log"        mkdir d:\oracle_backup\log  

set DATADIR=d:\oracle_backup\data
set LOGDIR=d:\oracle_backup\log

exp %USER%/%PASSWORD%@%DATABASE% file=%DATADIR%\data_%BACKUPDATE%.dmp log=%LOGDIR%\log_%BACKUPDATE%.log

::ɾ��7��ǰ�ı��ݡ�  
forfiles /p "%DATADIR%" /s /m *.* /d -7 /c "cmd /c del @path"
forfiles /p "%LOGDIR%" /s /m *.* /d -7 /c "cmd /c del @path"

exit

