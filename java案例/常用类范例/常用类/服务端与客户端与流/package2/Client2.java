package package2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client2 {

	public static void main(String args[]) throws Exception{
		boolean flag = false;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeBoolean(flag);//�����������䵽�ֽ���������Ӧ��������
		
		byte[] buf = baos.toByteArray();//���ֽ���������Ӧ�������е������������������buf��
		
		//���Ӷ�Ӧ�������Ͷ˿ں�,��Ϊ����׼������,����������buf
		DatagramPacket dp = new DatagramPacket(buf, buf.length, 
											   new InetSocketAddress("127.0.0.1", 6666)
											   );
		DatagramSocket ds = new DatagramSocket(9999);//����һ�������Լ��Ŀͻ���
		ds.send(dp);//������ͻ��˷���
		ds.close();
		
	}
}
