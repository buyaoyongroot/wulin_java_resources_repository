package package2;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server_2 {
	public static void main(String[] args) throws Exception {
		//׼��һ�������ֽ���������
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);//���ڷ��͵�
		DatagramSocket ds = new DatagramSocket(6666);//���ڽ���
		while(true){
			ds.receive(dp);//�������մӿͻ��˷��͹����Ķ���
			//����һ���ֽ�������,���ܵ�,ͬʱ����һ����СΪbuf�Ļ����ֽ���������,ͬʱ���ֽ��������뻺���ֽ�������������
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			//����DataInputStream����һ��������,�ڲ����ϱȽϷ���,������Ҫ��װһ���ֽ�������
			DataInputStream dis = new DataInputStream(bais);
			//dis.readBoolean() �Ӷ�Ӧ��dos.writeBoolean(flag);��,���ܵ��ж�ȡ����
			System.out.println(dis.readBoolean());
		}
	}
}
