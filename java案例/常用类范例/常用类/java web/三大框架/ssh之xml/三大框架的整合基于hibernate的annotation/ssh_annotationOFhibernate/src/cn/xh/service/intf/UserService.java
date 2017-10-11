package cn.xh.service.intf;

import java.util.List;

import cn.xh.domain.User;

public interface UserService {
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
