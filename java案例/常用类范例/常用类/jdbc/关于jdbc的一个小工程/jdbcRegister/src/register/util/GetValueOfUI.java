package register.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import register.domain.Clazz;
import register.domain.DifferenceObject;
import register.domain.Student;
import register.service.ClazzService;
import register.service.RegisterService;
import register.service.impl.ClazzServiceImpl;
import register.service.impl.RegisterServiceImpl;

public class GetValueOfUI {
	private DifferenceObject object;
	public GetValueOfUI(){}
	public GetValueOfUI(DifferenceObject object){
		this.object=object;
	}
	
	//�õ�ע��ֵ
	public void getRegisterValue(){
		Student student=new Student();
		student.setId(Integer.decode(object.getJtextFieldMap().get("ѧ��:").getText()));
		student.setName(object.getJtextFieldMap().get("����:").getText());
		student.setPassword(String.valueOf(object.getJpasswordField().getPassword()));
		JRadioButton jRadioButtonFemale=object.getJradioButtonMap().get("Ů");
		JRadioButton jRadioButtonmale=object.getJradioButtonMap().get("��");
		if(jRadioButtonFemale.isSelected()){
			student.setGender(jRadioButtonFemale.getText());
		}if(jRadioButtonmale.isSelected()){
			student.setGender(jRadioButtonmale.getText());
		}
		try {
			student.setRegisterDate(DateFormat.getDateInstance().parse(object.getJtextFieldMap().get("ע������:").getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setIdentityNumber(object.getJtextFieldMap().get("���֤��:").getText());
		String str=(String)object.getJcomboBox().getSelectedItem();
		student.setClazzname(str);
		ClazzService cs=new ClazzServiceImpl();
		List<Clazz> clazzList=cs.queryClazzs();
		int i=0;
		for (Clazz clazz : clazzList) {
			if(str.equals(clazz.getName())){
				student.setSid(clazz.getId());
				break;
			}
			i++;
		}
		RegisterService rs=new RegisterServiceImpl();
		rs.register(student);
		object.getStudentModel().setSa(rs.findStudents());
		object.getJtable().updateUI();
	}
	
	//�õ�����ֵ
	public void getUpdateValue(int id){
		RegisterService rs=new RegisterServiceImpl();
		List<Student> studentList=rs.findStudentsById(id);
		Student student=studentList.get(0);
		JTextField jTextFieldId=object.getJtextFieldMap().get("���:");
		jTextFieldId.setText(""+student.getId());
		jTextFieldId.setEditable(false);
		JTextField jTextFieldName=object.getJtextFieldMap().get("����:");
		jTextFieldName.setText(student.getName());
		JTextField jTextFieldPassword=object.getJtextFieldMap().get("����:");
		jTextFieldPassword.setText(student.getPassword());
		JTextField jTextFieldGender=object.getJtextFieldMap().get("�Ա�:");
		jTextFieldGender.setText(student.getGender());
		JTextField jTextFieldIdentityNumber=object.getJtextFieldMap().get("���֤��:");
		jTextFieldIdentityNumber.setText(student.getIdentityNumber());
		JTextField jTextFieldRegisterDate=object.getJtextFieldMap().get("����:");
		jTextFieldRegisterDate.setText(DateFormat.getDateInstance().format(student.getRegisterDate()));
		object.getJtextFieldMap().get("�����༶:").setText(student.getClazzname());
		object.getJtextFieldMap().get("�༶���:").setText(String.valueOf(student.getSid()));
	}
	public void getSearchingValue() {
		Student student=new Student();
		RegisterService rs=new RegisterServiceImpl();
		if(!"".equals(object.getJtextFieldMap().get("���֤��:").getText())){
			student.setIdentityNumber(object.getJtextFieldMap().get("���֤��:").getText());
		}if(!"".equals(object.getJtextFieldMap().get("����:").getText())){
			student.setName(object.getJtextFieldMap().get("����:").getText());
		}if(!"".equals(String.valueOf(object.getJpasswordField().getPassword()))){
			student.setPassword(String.valueOf(object.getJpasswordField().getPassword()));
		}
		StudentArrays studentArrays=rs.differenceConditionQuery(student);
		object.getStudentModel().setSa(studentArrays);
		object.getJtable().updateUI();
	}
	public void getDeleteValue() {
		JTable jTable=object.getJtable();
		int[] rows=jTable.getSelectedRows();
		if(rows.length<=0){
			JOptionPane.showMessageDialog(null, "��ѡ��һ����¼!");
		}else{
			int flag=JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ����?", "ɾ��", 0, 0);
			if(flag==0){
				RegisterService rs=new RegisterServiceImpl();
				for(int i=0;i<rows.length;i++){
					Integer id=Integer.parseInt((String)jTable.getValueAt(rows[i], 0));
					rs.deleteById(id);
				}
				object.getStudentModel().setSa(rs.findStudents());
				object.getJtable().updateUI();
			}
		}
		
	}
	
	//ˢ�°༶
	public void getRefreshClazzValue() {
		StudentArrays studentArray=new ClazzServiceImpl().findClazzs();
		object.getStudentModel().setSa(studentArray);
		object.getJtable().updateUI();
	}
	
	public void getClazzValue() {
		Clazz clazz=new Clazz();
		clazz.setId(Integer.parseInt(object.getJtextFieldMap().get("���:").getText()));
		clazz.setName((object.getJtextFieldMap().get("����:").getText()));
		new ClazzServiceImpl().updateClazz(clazz);
		StudentArrays studentArray=new ClazzServiceImpl().findClazzs();
		object.getStudentModel().setSa(studentArray);
		object.getJtable().updateUI();
		object.getJframeMap().get("updateClazz").setVisible(false);
		
	}
	public void getAddClazzValue() {
		Clazz clazz=new Clazz();
		clazz.setId(Integer.parseInt(object.getJtextFieldMap().get("���:").getText()));
		clazz.setName(object.getJtextFieldMap().get("����:").getText());
		ClazzService cs=new ClazzServiceImpl();
		cs.addClazz(clazz);
		StudentArrays studentArray=cs.findClazzs();
		object.getStudentModel().setSa(studentArray);
		object.getJtable().updateUI();
	}
	public void getDeleteClazzValue() {
		JTable jTable=object.getJtable();
		int[] i=jTable.getSelectedRows();
		if(i.length==0){
			JOptionPane.showMessageDialog(null, "������ѡ��һ����¼ !");
		}else{
			int j =JOptionPane.showConfirmDialog(null,"ȷ��Ҫɾ����?",null,0,0);
			if(j==0){
				ClazzService cs=new ClazzServiceImpl();
				for(int k=0;k<i.length;k++){
					int id=Integer.parseInt((String)jTable.getValueAt(i[k], 0));
					cs.deleteClassById(id);
				}
				StudentArrays studentArray=cs.findClazzs();
				object.getStudentModel().setSa(studentArray);
				object.getJtable().updateUI();
			}
		}
		
	}
	public String[] getClazzName() {
		ClazzService cs=new ClazzServiceImpl();
		List<Clazz> clazzList=cs.queryClazzs();
		String[] name=new String[clazzList.size()];
		int i=0;
		for (Clazz clazz : clazzList) {
			name[i]=clazz.getName();
			i++;
		}
		return name;
	}
}





