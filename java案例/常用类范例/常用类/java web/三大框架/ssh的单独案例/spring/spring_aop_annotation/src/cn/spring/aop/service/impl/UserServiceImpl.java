package cn.spring.aop.service.impl;

import cn.spring.aop.service.UserService;

public class UserServiceImpl implements UserService{

	public void addUser() {
		System.out.println("��������û�");
	}

	public void editUser() {
		System.out.println("�����޸��û�");
	}

}
