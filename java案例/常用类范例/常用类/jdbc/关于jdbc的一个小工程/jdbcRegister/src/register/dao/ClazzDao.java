package register.dao;

import java.util.List;

import register.domain.Clazz;

public interface ClazzDao {
	
	//���Ӱ༶
	public void addClazz(Clazz clazz);
	
	//���°༶
	public void updateClazz(Clazz clazz);
	
	//����id���в�ѯ
	public List<Clazz> queryClazzById(int id);
	
	//��ѯ���а༶
	public List<Clazz> queryClazzs();
	
	//����id����ɾ���༶
	public void deleteClassById(int id);
	
	

}
