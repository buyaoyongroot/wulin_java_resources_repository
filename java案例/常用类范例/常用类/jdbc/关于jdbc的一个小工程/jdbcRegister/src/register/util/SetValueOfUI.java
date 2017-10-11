package register.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;

import register.domain.Clazz;
import register.domain.DifferenceObject;
import register.domain.Student;
import register.service.ClazzService;
import register.service.RegisterService;
import register.service.impl.ClazzServiceImpl;
import register.service.impl.RegisterServiceImpl;

public class SetValueOfUI {
	private DifferenceObject object;
	public SetValueOfUI(){}
	public SetValueOfUI(DifferenceObject object){
		this.object=object;
	}

	//���ø���ֵ
	public void setUpdateValue(){
		Student student=new Student();
		JTextField difference=object.getJtextFieldMap().get("���:");
		student.setId(Integer.parseInt(difference.getText()));
		difference=object.getJtextFieldMap().get("����:");
		student.setName(difference.getText());
		difference=object.getJtextFieldMap().get("�Ա�:");
		student.setGender(difference.getText());
		difference=object.getJtextFieldMap().get("����:");
		student.setPassword(difference.getText());
		difference=object.getJtextFieldMap().get("���֤��:");
		student.setIdentityNumber(difference.getText());
		difference=object.getJtextFieldMap().get("����:");
		try {
			DateFormat dateFormat=DateFormat.getDateInstance();
			Date date=dateFormat.parse(difference.getText());
			student.setRegisterDate(date);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		student.setClazzname(object.getJtextFieldMap().get("�����༶:").getText());
		student.setSid(Integer.parseInt(object.getJtextFieldMap().get("�༶���:").getText()));
		RegisterService rs=new RegisterServiceImpl();
		rs.updateStudentsById(student);
		object.getStudentModel().setSa(rs.findStudents());
		object.getJtable().updateUI();
	}
	public void setClazzValue(int id) {
		ClazzService cs=new ClazzServiceImpl();
		List<Clazz> clazzList=cs.queryClazzById(id);
		Clazz clazz=clazzList.get(0);
		object.getJtextFieldMap().get("���:").setText(String.valueOf(clazz.getId()));
		object.getJtextFieldMap().get("����:").setText(clazz.getName());
		
	}
}
