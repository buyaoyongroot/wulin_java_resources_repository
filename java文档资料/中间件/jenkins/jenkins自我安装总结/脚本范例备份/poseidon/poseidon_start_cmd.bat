@echo off
rem Ӧ�ó���Ŀ¼����
set "app_dir_name=poseidon-api-provider"

rem Ӧ�ó���Ŀ¼
set "app_dir=poseidon-api-provider\"

rem Ӧ�ó������������ļ�
set "start_file=startup.bat"

rem �����˿�
set "port=20980"

rem -------------------------------����ΪҪ�޸ĵı���---------------------

rem ��ǰ�����������ļ����ڵ�Ŀ¼
set "curr_dir=%~dp0"
set "pid="
set "full_app_dir=%curr_dir%%app_dir%%start_file%"

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

echo ��������%app_dir_name%�ķ���,���Ժ�...
rem ����С���ķ�ʽ��������
start /min %full_app_dir%

rem ���ڵȺ� app_dir_name �ķ��� �����ɹ�
set "pid="

rem ÿ���һ������,�ñ�ʶ����������Ҫ��1,,ǧ��������.....
:begin1
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem ÿ���һ������,�ñ�ʶ����������Ҫ��1,,ǧ��������.....
if not defined pid goto begin1
rem ������app_dir_name����Ķ˿ں�,�ȴ�15��,�Ա�֤app_dir_name�������������ɹ�
ping -n 15 127.1>nul
echo %app_dir_name%�ķ��������ɹ�pid=%pid%

echo ========================================================================

rem Ӧ�ó���Ŀ¼����
set "app_dir_name=poseidon-web"

rem Ӧ�ó���Ŀ¼
set "app_dir=poseidon-web\"

rem Ӧ�ó������������ļ�
set "start_file=startup.bat"

rem �����˿�
set "port=8085"

rem -------------------------------����ΪҪ�޸ĵı���---------------------

rem ��ǰ�����������ļ����ڵ�Ŀ¼
set "curr_dir=%~dp0"
set "pid="
set "full_app_dir=%curr_dir%%app_dir%%start_file%"

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

echo ��������%app_dir_name%�ķ���,���Ժ�...
rem ����С���ķ�ʽ��������
start /min %full_app_dir%

rem ���ڵȺ� app_dir_name �ķ��� �����ɹ�
set "pid="

rem ÿ���һ������,�ñ�ʶ����������Ҫ��1,ǧ��������.....
:begin2
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :%port%') do (
  if not %%i == 0 (
	set "pid=%%i"
  ) 
)

rem ÿ���һ������,�ñ�ʶ����������Ҫ��1,,ǧ��������.....
if not defined pid goto begin2

rem ������app_dir_name����Ķ˿ں�,�ȴ�15��,�Ա�֤app_dir_name�������������ɹ�
ping -n 15 127.1>nul
echo %app_dir_name%�ķ��������ɹ�pid=%pid%

rem ���������������ļ������
pause





















