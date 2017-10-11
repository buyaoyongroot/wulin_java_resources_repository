package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.User;

public interface UserDao {
	//����û�
	public void addUser(User user)throws SQLException;
	//����idɾ���û�
	public void deleteUserById(User user)throws SQLException;
	//����id�����û�
	public void updateuserById(User user)throws SQLException;
	//����id�����û�
	public List<User> queryUserById(User user)throws SQLException;
	//�������е��û�
	public List<User> queryUsers(User user)throws SQLException;
	//��������ѯ
	public List<User> variousConditionQueryUsers(User user) throws SQLException;
}
