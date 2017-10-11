package cn.scxh.ittx.service.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface UserService {
	//����û�
	public void addUser(User user)throws AddObjectException;
	//����idɾ���û�
	public void deleteUserById(User user) throws DeleteObjectException;
	//����id�����û�
	public void updateuserById(User user)throws UpdateObjectException;
	//����id�����û�
	public List<User> queryUserById(User user)throws QueryObjectException;
	//�������е��û�
	public List<User> queryUsers(User user)throws QueryObjectException;

	//��������ѯ
	public List<User> variousConditionQueryUsers(User user) throws QueryObjectException;
}
