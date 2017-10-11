package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.MedicineClassify;

public interface MedicineClassifyDao {

	//����ҩ�����
	public void addMedicineClassify(MedicineClassify classify) throws SQLException;
	//ɾ��ҩ�����
	public void deleteMedicineClassify(MedicineClassify classify) throws SQLException;
	//����ҩ�����
	public void updateMedicineClassify(MedicineClassify classify) throws SQLException;
	//��ͬ������ѯ
	public List<MedicineClassify> differenceConditionQueryMedicineClassify(MedicineClassify classify) throws SQLException;
	//����id��ѯ���ֵ
	public List<MedicineClassify> theLargestNumberOfMedicineClassify(MedicineClassify classify) throws SQLException;
	//�õ�����
	public List<MedicineClassify> getParent(MedicineClassify classify) throws SQLException;
	//�õ�����
	public List<MedicineClassify> getChildren(MedicineClassify classify) throws SQLException; 
	//�õ�����
	public List<MedicineClassify> getMedicineRoot(MedicineClassify classify) throws SQLException; 
	//ͨ�����׵�id�뺢�ӵ����ֵĵõ����ӵ�id
	public List<MedicineClassify> getChildrenBynameAndId(MedicineClassify classify) throws SQLException ;
}
