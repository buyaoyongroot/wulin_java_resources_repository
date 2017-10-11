package cn.scxh.ittx.service.intf;

import java.util.List;

import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface PatientService {
	//��Ӳ���
	public void addPatient(Patient patient)throws AddObjectException;
	//ɾ������
	public void deletePatient(Patient patient)throws DeleteObjectException;
	//���²���
	public void updatePatient(Patient patient)throws UpdateObjectException;
	//��ͬ������ѯ����
	public List<Patient> differenceConditionQueryPatients(Patient patient)  throws QueryObjectException;

	public SharedArrays queryPatients(Patient patient)throws QueryObjectException;
	//�õ����ı��
	public List<Patient> theLargestNumberOfPatients()throws QueryObjectException;
}
