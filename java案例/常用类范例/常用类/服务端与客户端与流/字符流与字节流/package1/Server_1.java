package package1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server_1 {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket=new ServerSocket(6686);
		while(true){
			Socket socket=serverSocket.accept(); //socket�ǿͻ��˵���˼
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//���ֽ���ת��Ϊ�ַ�����Ҫ�м�ת����
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			int i=br.read();
			System.out.println(i);
			
//			String string=br.readLine();
//			bw.write(string);//��仰����˼�ǽ����������������ܵ���
			bw.close();
			br.close();
			
		}
	}
}


/*BuferedReader br=new BufferedReader(new InputStreamReader(client.getImputStream()));
 * BuferedReader br=new BufferedReader(new InputStreamReader(new InputstreamReader(System.in));
 * BufferedWriter bw =new BufferedWriter(new OUtputStreamWriter(client.getOutputStream())
 * String msg=br.readLine();
 * while()msg!=msg{
 * 	String keyMsg=br1.reaLine();
 * bw.write(keyMsg);
 * bw.newLine();
 * bw.flush();
 * 
 * }
 * */