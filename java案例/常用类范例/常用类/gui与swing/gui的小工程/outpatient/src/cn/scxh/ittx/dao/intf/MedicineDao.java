package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.Medicine;

public interface MedicineDao {
	//����ҩƷ
	public void addMedicine(Medicine medicine) throws SQLException;
	//ɾ��ҩƷ
	public void deleteMedicine(Medicine medicine) throws SQLException;
	//����ҩƷ
	public void updateMedicine(Medicine medicine) throws SQLException;
	//��ͬ������ѯҩƷ
	public List<Medicine> differenceConditionQueryMedicines(Medicine medicine) throws SQLException;
	//��ѯ���ֵ
	public List<Medicine> theLargestNumberOfMedicines(Medicine medicine) throws SQLException;
	//��ѯҩ�����
	public List<Medicine> queryMedicineClassification()throws SQLException;
}
