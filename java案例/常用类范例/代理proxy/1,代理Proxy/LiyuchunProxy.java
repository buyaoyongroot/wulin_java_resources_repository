package cn.itcast.java.proxy.exe2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//������
public class LiyuchunProxy{ 
	
	//����˭��ͨ�����췽����ֵ
	private Liyuchun liyuchun = new Liyuchun();
	
	//��̬�����������
	public Star getProxy(){
		return (Star) Proxy.newProxyInstance(
				LiyuchunProxy.class.getClassLoader(), 
				liyuchun.getClass().getInterfaces(), 
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						String money = (String) args[0];
						if("sing".equals(method.getName())){
							if("3".equals(money)){
								//���ô����sing()����
								return method.invoke(liyuchun,args);//���ﷵ��ֵ����������public void sing(String money){}
								//�ķ���ֵ,�������û�з���ֵ,���Բ������κ�ֵ.����÷�����public String sing(String money
								//��return method.invoke(liyuchun,args);��仰�ķ���ֵ����String����
							}else{
								System.out.println("����������");	
							}
						}else if("dance".equals(method.getName())){
							if("5".equals(money)){
								return method.invoke(liyuchun,args);
							}else{
								System.out.println("����������");	
							}
						}else if("eat".equals(method.getName())){
							System.out.println("����������£�������");
						}
						return null;
					}
				});
	}
}
//����һ��loader��ʾ��̬������������ĸ����������ɵ�
//��������interfaces��ʾ��̬���������Ŀ����󣨴��磩��һ���ķ���
//����������ʾ��̬�����������ط�������ÿ�ε���Ŀ����󶼻�ִ�и�invoke()����(�ѵ�)


//invoke()����������������������
//����һ����̬�����Ĵ��������
//��������method��ʾ����
//��������args��ʾ��������
