package cn.itcast.java.annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo3 {
	//�÷�������Ҫȡ��@DbInfo�е�����ֵ��������ע��
	@DbInfo
	public static Connection getConnection() throws Exception{
		//ȡ�ø�����ֽ���
		Class clazz = Demo3.class;
		//ȡ�ø�������ΪgetConnection()�Ĺ�������
		//����һ��������
		//�������������������Ͷ�Ӧ���ֽ������û�еĻ�����null
		Method method = clazz.getMethod("getConnection",null);
		//ͨ���÷�����ȡ�÷����϶����ע��
		DbInfo dbInfo = method.getAnnotation(DbInfo.class);
		//�ֱ�ȡ�����ݿ����Ӳ���
		String driver = dbInfo.driver();
		String url = dbInfo.url();
		String username = dbInfo.usrename();
		String password = dbInfo.password();
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	public static void main(String[] args) throws Exception {
		Connection conn = getConnection();
		if(conn!=null){
			System.out.println("ȡ������");
			conn.close();
		}
	}
}
