package cn.scxh.ittx.service.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.MedicineClassify;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface MedicineClassifyService {

	//����ҩ�����
	public void addMedicineClassify(MedicineClassify classify) throws AddObjectException;
	//ɾ��ҩ�����
	public void deleteMedicineClassify(MedicineClassify classify) throws DeleteObjectException;
	//����ҩ�����
	public void updateMedicineClassify(MedicineClassify classify) throws UpdateObjectException;
	//��ͬ������ѯ
	public List<MedicineClassify> differenceConditionQueryMedicineClassify(MedicineClassify classify) throws QueryObjectException;
	//����id��ѯ���ֵ
	public List<MedicineClassify> theLargestNumberOfMedicineClassify(MedicineClassify classify) throws QueryObjectException;
	//�õ�����
	public List<MedicineClassify> getParent(MedicineClassify classify) throws QueryObjectException;
	//�õ�����
	public List<MedicineClassify> getChildren(MedicineClassify classify) throws QueryObjectException; 
	//�õ�����
	public List<MedicineClassify> getMedicineRoot(MedicineClassify classify) throws QueryObjectException; 
	//ͨ�����׵�id�뺢�ӵ����ֵĵõ����ӵ�id
	public List<MedicineClassify> getChildrenBynameAndId(MedicineClassify classify) throws QueryObjectException ;
}
