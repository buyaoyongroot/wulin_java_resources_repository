package test;

import java.net.MalformedURLException;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;

import com.xaccp.domain.Person;
import com.xaccp.service.Ihello;

public class TestService {
	public static void main(String[] args) {
		//���������Ԫ����
		Service ServiceModel = new ObjectServiceFactory().create(Ihello.class);
		//�����������
		XFire xfire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xfire);
		//�����ַ
		String serviceURL = "http://localhost:8080/service/services/hello";
		try {
			//�������ͨ������Ԫ���ݺͷ����ַȡ�÷���ʵ��
			Ihello helloService = (Ihello) factory.create(ServiceModel,serviceURL);
			String serviceResponse = helloService.sayHello("���");
			String you = helloService.sayThanks("wulin");
			Person person = helloService.getPerson("1", "wubo");
			Person p = new Person();
			p.setId("2");
			p.setName("hh");
			helloService.getPerson(p);
			System.out.println(you+","+serviceResponse);
			System.out.println("id:"+person.getId()+","+person.getName());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	
	}

}
