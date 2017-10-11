package register.ui;

import javax.swing.JFrame;

import register.domain.DifferenceObject;
import register.util.DifferenceComponent;
import register.util.GetValueOfUI;

public class RegisterJFrame extends JFrame{
	private DifferenceObject object;
	public RegisterJFrame(){
	}
	public RegisterJFrame(DifferenceObject object){
		this.object = object;
	}
	public void registerJFarme(){
		DifferenceComponent dc=new DifferenceComponent(object);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(500, 100, 500, 500);

		// ѧ�ŵ��ֶα�ǩ
		dc.jLabelComponent(this, "ѧ��:", 100, 80, 35, 20);
		dc.jTextFieldComponent(this, "ѧ��:", 140, 80, 80, 20);

		// �������ֶα�ǩ
		dc.jLabelComponent(this, "����:", 100, 120, 35, 20);
		dc.jTextFieldComponent(this, "����:", 140, 120, 80, 20);

		// ������ֶα�ǩ
		dc.jLabelComponent(this, "����:",100, 160, 35, 20);
		dc.jPasswordFieldComponent(this, "����:", 140, 160, 80, 20);

		// �Ա���ֶα�ǩ
		dc.jLabelComponent(this, "�Ա�:",100, 200, 35, 20);

		// Ů���ֶα�ǩ
		dc.jLabelComponent(this, "Ů",140, 200, 20, 20);
		dc.jRadioButtonComponent(this,"Ů",true, 155, 200, 20, 20);
		// �е��ֶα�ǩ
		dc.jLabelComponent(this,"��",180, 200, 20, 20);
		dc.jRadioButtonComponent(this, "��",false, 195, 200, 20, 20);
		
		// ���֤�ŵ��ֶα�ǩ
		dc.jLabelComponent(this, "ע������:", 80, 240, 70, 20);
		dc.jTextFieldComponent(this, "ע������:", 140, 240, 80, 20);

		// ע�����ڵ��ֶα�ǩ
		dc.jLabelComponent(this, "���֤��:", 80, 280, 70, 20);
		dc.jTextFieldComponent(this, "���֤��:", 140, 280, 80, 20);
		
		//���ð༶
		dc.jLabelComponent(this, "�����༶:",80, 320, 70, 20);
		GetValueOfUI value=new GetValueOfUI();
		String[] name=value.getClazzName();
		dc.jComboBoxConponent(this, name, 140, 320, 80, 20);
		//dc.jTextFieldComponent(this, "�����༶:", 140, 320, 80, 20);
		
		// �ύ��ť
		dc.jButtonComponent(this, "�ύ", 0,300, 380, 60, 20);
		this.setVisible(true);
	}
}
