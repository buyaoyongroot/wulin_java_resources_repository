package register.service;

import java.util.List;
import register.domain.Student;
import register.util.StudentArrays;

public interface RegisterService {
	
	//���ѧ��
	public void register(Student student);
	//��������ѧ��
	public StudentArrays findStudents();
	//��������
	public List<Student> conditionQuery(Student student);
	
	//����id����ѧ��
	public List<Student> findStudentsById(int id);
	
	//����id���и���
	public void updateStudentsById(Student student);
	
	//��ͬ������ѯ
	public StudentArrays differenceConditionQuery(Student student);
	
	//ͨ��Id����ɾ��
	public void deleteById(int id);
}
