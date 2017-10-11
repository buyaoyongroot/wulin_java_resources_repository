package spring2_5;

import java.util.Properties;

public class BeanFactory {
	
	private static Properties props;
	
	static{
		//ģ���ȡ�����ļ�
		props=new Properties();
		props.setProperty("UserDao", "spring2_5.UserDaoImpl");
		System.out.println("a");
	}
	/**
	 * �����������ɶ�Ӧʵ�����ʵ��
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T>T getBeanInstance(Class<T> clazz){
		String className=props.getProperty(clazz.getSimpleName());
		System.out.println("b");
		try {
		//	System.out.println("h="+(T) Class.forName(className).newInstance());
			return (T) Class.forName(className).newInstance();//ʹ�÷��������UserDaoImpl��Ĺ��췽��
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
