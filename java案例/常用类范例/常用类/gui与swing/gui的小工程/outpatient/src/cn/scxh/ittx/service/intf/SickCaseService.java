package cn.scxh.ittx.service.intf;

import java.util.List;

import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;

public interface SickCaseService {
	//���Ӳ���
	public void addSickCase(SickCase sickCase)throws AddObjectException;
	//ɾ������ 
	public void deleteSickCase(SickCase sickCase) throws DeleteObjectException;
	//���²���
	public void updateSickCase(SickCase sickCase) throws UpdateObjectException;
	//��ͬ������ѯ����
	public List<SickCase> differenceConditionQuerySickCase(SickCase sickCase) throws QueryObjectException;
	//�õ����������
	public List<SickCase> theLargestNumberOfSikeCase() throws QueryObjectException;
	
	//�������еĲ���
	public SharedArrays querySickCase(SickCase sickCase)throws QueryObjectException;
}
