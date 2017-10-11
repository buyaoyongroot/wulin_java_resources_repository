package cn.scxh.ittx.service.intf;

import java.util.List;

import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface MedicineService {

	//����ҩƷ
	public void addMedicine(Medicine medicine) throws AddObjectException;
	//ɾ��ҩƷ
	public void deleteMedicine(Medicine medicine) throws DeleteObjectException;
	//����ҩƷ
	public void updateMedicine(Medicine medicine) throws UpdateObjectException;
	//��ͬ������ѯҩƷ
	public List<Medicine> differenceConditionQueryMedicines(Medicine medicine) throws QueryObjectException;
	//��ѯ���ֵ
	public List<Medicine> theLargestNumberOfMedicines(Medicine medicine) throws QueryObjectException;
	//��ͬ��������һ������
	public SharedArrays queryMedicines(Medicine medicine)throws QueryObjectException;
	

}
