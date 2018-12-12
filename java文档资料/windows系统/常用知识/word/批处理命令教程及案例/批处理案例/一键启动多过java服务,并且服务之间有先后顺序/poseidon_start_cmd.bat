@echo off
set "port=20980"
set "pid="
set "curr_dir=%~dp0"
set "app_dir=poseidon-api-provider\startup.bat"
set "full_app_dir=%curr_dir%%app_dir%"

rem ͨ���˿ںŲ���pid
for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem �ж�pid�����Ƿ�Ϊ��ֵ,��Ϊ����ɱ������
if defined pid (
    rem ͨ��taskkill ������ҵ���pid����ɱ��
	taskkill /pid %pid% -t -f
	echo �˿�:%port%��Ӧ�Ľ��� %pid% ��ɱ��...
)

echo ��������poseidon-api-provider��dubbo����,���Ժ�...
rem ����С���ķ�ʽ��������
start /min %full_app_dir%

rem ���ڵȺ� poseidon-api-provider��dubbo���� �����ɹ�
set "pid="
:begin1
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)
if not defined pid goto begin1
rem ������dubbo����Ķ˿ں�,�ȴ�15��,�Ա�֤dubbo�������������ɹ�
ping -n 15 127.1>nul
echo poseidon-api-provider�ĵ�dubbo���������ɹ�pid=%pid%

echo ========================================================================

set "port=8085"
set "pid="
set "app_dir=poseidon-web\startup.bat"
set "full_app_dir=%curr_dir%%app_dir%"

rem ͨ���˿ںŲ���pid
for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)
rem �ж�pid�����Ƿ�Ϊ��ֵ,��Ϊ����ɱ������
if defined pid (
	rem ͨ��taskkill ������ҵ���pid����ɱ��
	taskkill /pid %pid% -t -f
	echo �˿�:%port%��Ӧ�Ľ��� %pid% ��ɱ��...
)
echo �������� poseidon-web ��web����,���Ժ�...
rem ����С���ķ�ʽ��������
start /min %full_app_dir%

rem ���ڵȺ� poseidon-api-provider��dubbo���� �����ɹ�
set "pid="
:begin2
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)
if not defined pid goto begin2
rem ������web����Ķ˿ں�,�ȴ�20��,�Ա�֤web�������������ɹ�
ping -n 20 127.1>nul
echo poseidon-web�ĵ�web���������ɹ�pid=%pid%
pause





















