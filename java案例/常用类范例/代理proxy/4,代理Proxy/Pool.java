package cn.itcast.java.proxy.exe3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

//�Զ������ӳ�
public class Pool {
	private static LinkedList<Connection> linkedList = new LinkedList<Connection>();
	static{
		//�ڼ���Pool��ʱ������10�����ӣ������뵽���ӳ���
		for(int i=0;i<10;i++){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbs","root","root");
				linkedList.addLast(conn);
			} catch (Exception e) {
			}
		}
	}
	//ȡ�����ӳ������ӵĸ���
	public int getSize() {
		return linkedList.size();
	}
	/*ȡ��һ�����е����ӣ�ֻ�ܷ���Connection�Ķ�̬�������
	public Connection getConnection() {
		final Connection conn = linkedList.removeFirst();
		return (Connection) Proxy.newProxyInstance(
				Pool.class.getClassLoader(),
				conn.getClass().getInterfaces(), 
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						//������õ���close()����
						if("close".equals(method.getName())){
							//�����ӷŻ����ӳ�
							linkedList.addLast(conn);
							//����null
							return null;
						}else{
							return method.invoke(conn,args);
						}
					}
				});
	}
	*/
	public Connection getConnection() {
		Connection conn = linkedList.removeFirst();
		return conn;//������Connection
	}
}





