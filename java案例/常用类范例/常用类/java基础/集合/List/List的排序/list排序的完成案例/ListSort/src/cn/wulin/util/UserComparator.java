package cn.wulin.util;

import java.util.Comparator;

import cn.wulin.domain.User;

/**
 * ����һ���û��Ƚ���,Ҫ�����û�������[age]��������
 * @author wulin
 *
 */
public class UserComparator implements Comparator<User>{

	public int compare(User o1, User o2) {
		Integer age1 = o1.getAge();
		Integer age2 = o2.getAge();
		if(age1 == null){
			age1 = Integer.MAX_VALUE;
		}
		if(age2 == null){
			age2 = Integer.MAX_VALUE;
		}
		//��Ϊ����Ƚϵ���age1,����������
		return age1.compareTo(age2);
	}
}
