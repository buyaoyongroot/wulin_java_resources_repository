package package1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client_1 {
	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("localhost" ,6686);
		//dis.
		//�����ü�������ʱ���൱�����ֽ���
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
		 DataInputStream dis=new DataInputStream(socket.getInputStream());
		 for(int i=0;i<8;i++){
			 String string=br.readLine();
			 dos.writeUTF(string);//������������ܵ���ע�����ݺ�,�߳�Ӧ��ͣ�����
			 string=dis.readUTF();
			 System.out.println(string);
		 }
		 dos.close();
		 br.close();
	}
}

