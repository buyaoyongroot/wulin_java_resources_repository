package register.ui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import register.domain.Student;
import register.service.RegisterService;
import register.service.impl.RegisterServiceImpl;

public class RegisterUI {
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setLayout(null);
		frame.setSize(500, 500);
		// ע�ᰴť
		JButton jButton = new JButton();
		jButton.setText("ע��");
		jButton.setBounds(50, 50, 60, 20);
		jButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Frame frameRegister = new Frame();
				frameRegister.setLayout(null);
				frameRegister.setBounds(500, 100, 500, 500);

				// ѧ�ŵ��ֶα�ǩ
				JLabel jLabelId = new JLabel();
				jLabelId.setBounds(100, 80, 35, 20);
				jLabelId.setText("ѧ�� :");
				frameRegister.add(jLabelId);

				// ѧ�ŵ��ı���
				final JTextField jTextFieldId = new JTextField();
				jTextFieldId.setBounds(140, 80, 80, 20);
				frameRegister.add(jTextFieldId);

				// �������ֶα�ǩ
				JLabel jLabelName = new JLabel();
				jLabelName.setBounds(100, 120, 35, 20);
				jLabelName.setText("���� :");
				frameRegister.add(jLabelName);

				// �������ı���
				final JTextField jTextFieldName = new JTextField();
				jTextFieldName.setBounds(140, 120, 80, 20);
				frameRegister.add(jTextFieldName);

				// ������ֶα�ǩ
				JLabel jLabelPassword = new JLabel();
				jLabelPassword.setBounds(100, 160, 35, 20);
				jLabelPassword.setText("���� :");
				frameRegister.add(jLabelPassword);

				// ������ı���
				final JPasswordField jPasswordField = new JPasswordField();
				jPasswordField.setBounds(140, 160, 80, 20);
				frameRegister.add(jPasswordField);

				// �Ա���ֶα�ǩ
				JLabel jLabelGender = new JLabel();
				jLabelGender.setBounds(100, 200, 35, 20);
				jLabelGender.setText("�Ա�:");
				frameRegister.add(jLabelGender);

				// ����һ��ButtonGoup
				final ButtonGroup buttonGroup = new ButtonGroup();

				// Ů���ֶα�ǩ
				JLabel jLabelFemale = new JLabel();
				jLabelFemale.setBounds(140, 200, 20, 20);
				jLabelFemale.setText("Ů");
				frameRegister.add(jLabelFemale);

				// ����һ����ѡť
				final JRadioButton jRadioButtonFemale = new JRadioButton();
				jRadioButtonFemale.setText("Ů");
				jRadioButtonFemale.setBounds(155, 200, 20, 20);
				buttonGroup.add(jRadioButtonFemale);
				frameRegister.add(jRadioButtonFemale);

				// �е��ֶα�ǩ
				JLabel jLabelmale = new JLabel();
				jLabelmale.setBounds(180, 200, 20, 20);
				jLabelmale.setText("��");
				frameRegister.add(jLabelmale);

				// ����һ����ѡť
				final JRadioButton jRadioButtonmale = new JRadioButton();
				jRadioButtonmale.setText("��");
				jRadioButtonmale.setBounds(195, 200, 20, 20);
				buttonGroup.add(jRadioButtonmale);
				frameRegister.add(jRadioButtonmale);
				
				// ���֤�ŵ��ֶα�ǩ
				JLabel jLabelIdentityNumber = new JLabel();
				jLabelIdentityNumber.setBounds(80, 240, 70, 20);
				jLabelIdentityNumber.setText("���֤�� :");
				frameRegister.add(jLabelIdentityNumber);

				// ���֤�ŵ��ı���
				final JTextField jTextFieldIdentityNumber = new JTextField();
				jTextFieldIdentityNumber.setBounds(140, 240, 80, 20);
				frameRegister.add(jTextFieldIdentityNumber);

				// ע�����ڵ��ֶα�ǩ
				JLabel jLabelRegisterDate = new JLabel();
				jLabelRegisterDate.setBounds(80, 280, 70, 20);
				jLabelRegisterDate.setText("ע������ :");
				frameRegister.add(jLabelRegisterDate);

				// ע�����ڵ��ı���
				final JTextField jTextFieldRegisterDate = new JTextField();
				jTextFieldRegisterDate.setBounds(140, 280, 80, 20);
				frameRegister.add(jTextFieldRegisterDate);
				
				// �ύ��ť
				JButton jButtonSubmit = new JButton();
				jButtonSubmit.setText("�ύ");
				jButtonSubmit.setBounds(300, 300, 60, 20);
				jButtonSubmit.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						Student student=new Student();
						if(jRadioButtonFemale.isSelected()){
							student.setGender(jRadioButtonFemale.getText());
						}else if(jRadioButtonmale.isSelected()){
							student.setGender(jRadioButtonmale.getText());
						}
						DateFormat dateFormat=DateFormat.getDateInstance();
						java.util.Date date=null;
						try {
							date=dateFormat.parse(jTextFieldRegisterDate.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						student.setId(Integer.decode(jTextFieldId.getText()));
						student.setName(jTextFieldName.getText());
						student.setPassword(String.valueOf(jPasswordField.getPassword()));
						student.setIdentityNumber(jTextFieldIdentityNumber.getText());
						student.setRegisterDate(date);
						RegisterService rs=new RegisterServiceImpl();
						rs.register(student);
						String s=jTextFieldId.getText();
					}

				});

				frameRegister.add(jButtonSubmit);

				frameRegister.setVisible(true);

			}

		});
		frame.add(jButton);

		frame.setVisible(true);

	}

}
