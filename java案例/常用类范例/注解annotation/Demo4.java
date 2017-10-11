package cn.itcast.java.annotation;

import java.lang.reflect.Method;

public class Demo4 {
	public static void find(){
		System.out.println("���ڲ�ѯ�С�����");
	}
	@Role
	public static void execute(String username, String password) throws Exception{
		if(username==null && password==null){
			throw new Exception("��Ҫ����");
		}
		Class clazz = Demo4.class;
		Method method = clazz.getMethod("execute",String.class,String.class);
		Role role = method.getAnnotation(Role.class);
		if(role.username().equals(username) && role.password().equals(password)){
			find();
		}else{
			System.out.println("����Ȩ��ִ�и÷���");
		}
	}
	public static void main(String[] args) throws Exception {
		execute("jack","123456");
	}
}
