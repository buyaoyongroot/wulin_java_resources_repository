package cn.itcast.java.proxy.exe3;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPool {
	public static void main(String[] args) throws Exception {
		//�������ӳ�
		Pool pool = new Pool();
		//ȡ�����ӳ��е����Ӹ���
		System.out.println("���Ӹ���Ϊ��" + pool.getSize());//10
		//ȡ��һ�����е�����
		Connection conn = pool.getConnection();
		//ȡ�����ӳ��е����Ӹ���
		System.out.println("���Ӹ���Ϊ��" + pool.getSize());//9
		//�ر����Ӷ��󣬱����ǽ����ӷŻ����ӳ�
		conn.close();
		System.out.println("���Ӹ���Ϊ��" + pool.getSize());//10
	}
}
