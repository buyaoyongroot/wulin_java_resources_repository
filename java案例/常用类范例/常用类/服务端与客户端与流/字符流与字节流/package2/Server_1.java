package package1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_1 {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket=new ServerSocket(6686);
		while(true){
			//�������ֽ��������ַ���,��û�а취�õ�String����;
			Socket socket=serverSocket.accept(); //socket�ǿͻ��˵���˼
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			int i=2;
			while(i<8){
				String string=dis.readUTF();
				System.out.println(string);//��һ��������,�߳̽�ͣ��������,��һ���������˺�,�߳̽������￪ʼִ��
				string=br.readLine();
				dos.writeUTF(string);
			}
			dis.close();
		}//�������ж����Ϊtrue����ѭ����,�̲߳���������ȥ,���Ը�"}"���治��д�κ����
	}
}
