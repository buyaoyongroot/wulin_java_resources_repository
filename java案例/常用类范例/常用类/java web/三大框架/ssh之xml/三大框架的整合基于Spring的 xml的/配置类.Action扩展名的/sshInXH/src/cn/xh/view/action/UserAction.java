package cn.xh.view.action;

import cn.xh.domain.User;
import cn.xh.service.intf.UserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String isAdd;
	private UserService userService;
	public String addUI() throws Exception {
		User user=new User();
		user.setId(5l);
		user.setName("ͬ��");
		user.setPassword("666666");
		userService.addUser(user);
		isAdd="��ӳɹ�";
		return "addUI";
	}

	///--------------
	
	public String getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	
	
}
