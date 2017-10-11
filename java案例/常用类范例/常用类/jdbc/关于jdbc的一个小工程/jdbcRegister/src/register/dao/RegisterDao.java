package register.dao;

import java.util.List;

import register.domain.Student;

public interface RegisterDao {
	
	//���ѧ��
	public void register(Student student);
	
	//��������student
	public List<Student> findStudents();
	
	//������ѯ
	public List<Student> conditionQuery(Student student);
	
	//����id���в���
	public List<Student> findStudentsById(int id);
	
	//����id���и���
	public void updateStudentsById(Student student);
	
	//��ͬ������ѯ
	public List<Student> differenceConditionQuery(Student student);
	
	//ͨ��Id����ɾ��
	public void deleteById(int id);

}
