package cn.xh.dao.intf;

import java.util.List;

import cn.xh.domain.Upload;
import cn.xh.domain.User;

public interface UploadDao {
	/**
	 * �����ϴ�
	 * @param upload
	 */
	public void addUpload(Upload upload);
	
	
	
	/**
	 * ���Ҹ��û������ϴ�
	 * @return
	 */
	public List<Upload> findByUserUpload(User user);
	
	/**
	 * ����idɾ���ϴ�
	 * @param id
	 */
	public void remove(Long id);

	/**
	 * ����Id�����ϴ� 
	 * @param id
	 * @return
	 */
	public Upload getById(Long id);

}
