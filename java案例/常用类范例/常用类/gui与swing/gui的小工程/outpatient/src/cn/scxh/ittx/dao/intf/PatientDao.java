package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.Patient;

public interface PatientDao {
	//��Ӳ���
	public void addPatient(Patient patient) throws SQLException;
	//ɾ������
	public void deletePatient(Patient patient) throws SQLException;
	//���²���
	public void updatePatient(Patient patient) throws SQLException;
	//��ͬ������ѯ����
	public List<Patient> differenceConditionQueryPatients(Patient patient) throws SQLException;
	//�õ����ı��
	public List<Patient> theLargestNumberOfPatients()throws SQLException;
}
