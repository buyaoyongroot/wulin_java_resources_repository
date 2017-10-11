package cn.scxh.ittx.ui.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.UserServiceImpl;
import cn.scxh.ittx.service.intf.UserService;

public class FormLoginValidate {
	Map<String,String> validateError=new HashMap<String,String>();
	
	public Map<String,String> userLoginValidate(User user){
		if(userNameValidate(user)&passwordValidate(user)){
			return null;
		}
		return validateError;
	}
	//�û�����֤
	public boolean userNameValidate(User user){
		boolean flag=false;
		if(user.getName()!=null&&!user.getName().equals("")){
			UserService userService=new UserServiceImpl();
				try {
					List<User> userList=userService.variousConditionQueryUsers(user);
					if(userList.isEmpty()){
						validateError.put("userNameError","�� ! ����û��������벻��ȷ" );
					}else{
						flag=true;
					}
					
				} catch (QueryObjectException e) {
					validateError.put("userNameError","�� ! ����û�������ȷ" );
				}
			
		}else{
			validateError.put("userNameError","�� ! �û�������Ϊ��" );
		}
		return flag;
	}
	
	//������֤
	public boolean passwordValidate(User user){
		boolean flag=false;
		if(user.getPassword()!=null&&!user.getPassword().equals("")){
			UserService userService=new UserServiceImpl();
				try {
					List<User> userList=userService.variousConditionQueryUsers(user);
					if(!userList.isEmpty()){
						if(!userList.get(0).getPassword().equals(user.getPassword())){
							System.out.println(userList.get(0).getPassword());
							validateError.put("passwordError","�� ! ����û��������벻��ȷ" );
						}
					}
					flag=true;
				} catch (QueryObjectException e) {
					validateError.put("passwordError","�� ! ����û��������벻��ȷ" );
				}
		}else{
			validateError.put("passwordError","�� ! �����벻��Ϊ��" );
		}
		return flag;
	}
}






