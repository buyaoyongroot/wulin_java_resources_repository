rem net start/stop ������ ;���ַ�ʽ������windows�ķ���
@echo off
net stop poseidon-api-provider 
net start poseidon-api-provider 
echo �������� poseidon-api-provider ��dubbo����,���Ժ�...

set "notwait=poseidon-api-provider"

:begin1
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :20980') do (
  if not %%i == 0 (
	set "notwait=%%i"
  ) 
)
if %notwait% == poseidon-api-provider goto begin1
ping -n 15 127.1>nul

echo poseidon-api-provider�ĵ�dubbo���������ɹ�pid=%notwait%
rem netstat -aon|findstr 20980 goto begin

net stop poseidon-web
net start poseidon-web
echo �������� poseidon-web ��web����,���Ժ�...
set "notwait=poseidon-web"

:begin2
ping -n 5 127.1>nul

for /f "tokens=5 delims= " %%i in ('netstat -a -n -o ^| findstr :8085') do (
  if not %%i == 0 (
	set "notwait=%%i"
  ) 
)

if %notwait% == poseidon-web goto begin2
ping -n 20 127.1>nul
echo poseidon-web�ĵ�web���������ɹ�pid=%notwait%
pause