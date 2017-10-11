package register.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import register.domain.DifferenceObject;
import register.util.DifferenceComponent;
import register.util.StudentModel;

public class UpdateData extends JFrame{
	
	//����һ�����´���
	public void updateWindow(JTable jTable,StudentModel studentModel,int id){
		DifferenceObject object=new DifferenceObject();
		object.setJframe(this);
		DifferenceComponent dc=new DifferenceComponent(object);
		this.setLayout(null);
		this.setTitle("���´���");
		
		object.setJtable(jTable);
		object.setStudentModel(studentModel);
		
		//id
		dc.jLabelComponent(this, "���:", 20, 30, 40, 20);
		dc.jTextFieldComponent(this,"���:", 60, 30, 100, 20);
		
		//name
		dc.jLabelComponent(this, "����:", 20, 60, 40, 20);
		dc.jTextFieldComponent(this,"����:", 60, 60, 100, 20);
		
		//gender
		dc.jLabelComponent(this, "�Ա�:", 20, 90, 40, 20);
		dc.jTextFieldComponent(this,"�Ա�:", 60, 90, 100, 20);
		
		//password
		dc.jLabelComponent(this, "����:", 20, 120, 40, 20);
		dc.jTextFieldComponent(this,"����:", 60, 120, 100, 20);
		
		//���֤��
		dc.jLabelComponent(this, "���֤��:", 0, 150, 60, 20);
		dc.jTextFieldComponent(this,"���֤��:", 60, 150, 100, 20);
		
		//����
		dc.jLabelComponent(this, "����:", 20, 180, 40, 20);
		dc.jTextFieldComponent(this, "����:", 60, 180, 100, 20);
		
		//�༶��
		dc.jLabelComponent(this, "�����༶:", 0, 210, 60, 20);
		dc.jTextFieldComponent(this, "�����༶:", 60, 210, 100, 20);
		
		//�༶���
		dc.jLabelComponent(this, "�༶���:", 0, 240, 60, 20);
		dc.jTextFieldComponent(this, "�༶���:", 60, 240, 100, 20);
		
		dc.jButtonComponent(this, "����", id,20, 300, 60, 20);
		
		this.setBounds(800,100,300,400);
		this.setVisible(true);
	}
}
