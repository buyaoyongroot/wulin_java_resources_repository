package cn.xh.dao.intf;

import java.util.List;

import cn.xh.domain.User;

public interface UserDao {
	/**
	 * �����û�
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * �༭�û�
	 * @param user
	 */
	public void editUser(User user);
	
	/**
	 * ���������û�
	 * @return
	 */
	public List<User> findAllUser();
	
	/**
	 * ����idɾ���û�
	 * @param id
	 */
	public void remove(Long id);

	public User getById(Long id);

}
