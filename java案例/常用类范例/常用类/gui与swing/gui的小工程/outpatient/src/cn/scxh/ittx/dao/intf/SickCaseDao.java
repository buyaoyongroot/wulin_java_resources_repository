package cn.scxh.ittx.dao.intf;

import java.sql.SQLException;
import java.util.List;

import cn.scxh.ittx.domain.SickCase;

public interface SickCaseDao {
	//���Ӳ���
	public void addSickCase(SickCase sickCase) throws SQLException;
	//ɾ������ 
	public void deleteSickCase(SickCase sickCase) throws SQLException;
	//���²���
	public void updateSickCase(SickCase sickCase) throws SQLException;
	//��ͬ������ѯ����
	public List<SickCase> differenceConditionQuerySickCase(SickCase sickCase) throws SQLException;
	//�õ����������
	public List<SickCase> theLargestNumberOfSikeCase() throws SQLException;

}
