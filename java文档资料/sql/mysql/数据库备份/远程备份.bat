@echo off
rem sw��ر���
::������Զ�̱��ݣ�����ʵ������޸��˺ź����룬ip��ַ��Զ���ļ������֡�
::���Ҫ��̨Զ�̱��ݣ��������´���һ�ݵ�������޸Ķ�Ӧ��Ϣ���ɡ�
rem Զ�̷��������û���
set remoteUsername=administrator
rem Զ�̷�����������
set remotePassword=bjhyrjb_001
rem Զ�̷�������·��
set remoteServer=\\192.168.0.2
rem Զ�̷����������ļ���
set remotePath=\swdbbak
rem �����ļ���·��
set localPath=E:\sworacleapk\sworacleapk-win64\���ݿⱸ��\swdbbak

@echo
@echo "���ݿ�Զ�̱�����......"
net use %remoteServer%\ipc$ "%remotePassword%" /user:%remoteUsername%
copy "%localPath%" %remoteServer%%remotePath%
@echo "���ݿ�Զ�̱������!"
