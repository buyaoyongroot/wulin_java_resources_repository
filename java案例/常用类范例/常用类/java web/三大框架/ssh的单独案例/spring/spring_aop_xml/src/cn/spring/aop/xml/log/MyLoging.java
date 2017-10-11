package cn.spring.aop.xml.log;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyLoging {
	
	public void addLoging(){
		System.out.println("����ӵ���־");
	}

	public void editLoging(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("���޸�֮ǰ����־");
		System.out.println(pjp.getArgs().length);
		pjp.proceed();
		System.out.println("���޸�֮�����־");
		
	}
}
