package package1.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyRegister {
	public static void main(String[] args) {
		JFrame frame=new JFrame("ע�����");
		frame.setLayout(null);//���ֹ�����
		
		frame.setLocation(333,200);
		frame.setSize(350,350);
		
		//�û���
		final JLabel  jLabel=new JLabel();
		jLabel.setText("�û�����");
		jLabel.setBounds(100,40,60,80);
		frame.add(jLabel);
		
		final JTextField jtf=new JTextField();
		jtf.setBounds(150,70,100,20);
		frame.add(jtf);
		
		//����
		JLabel jLabel2=new JLabel();
		jLabel2.setText("    ���룺");
		jLabel2.setBounds(100,70,60,80);
		frame.add(jLabel2);
		
		final JPasswordField jpf=new JPasswordField();
		jpf.setBounds(150,100,100,20);
		frame.add(jpf);
		
		//��ѡ��
		JLabel jLabel3=new JLabel();
		jLabel3.setText("    ���ã�");
		jLabel3.setBounds(100,100,60,80);
		frame.add(jLabel3);
		
		JLabel jLabel4=new JLabel();
		jLabel4.setText("����");
		jLabel4.setBounds(150,100,60,80);
		frame.add(jLabel4);
		
		final JCheckBox jcb=new JCheckBox();
		jcb.setBounds(175,130,20,20);
		frame.add(jcb);
		
		JLabel jLabel5=new JLabel();
		jLabel5.setText("����");
		jLabel5.setBounds(200,100,60,80);
		frame.add(jLabel5);
		
		JCheckBox jcb1=new JCheckBox();
		jcb1.setBounds(225,130,20,20);
		frame.add(jcb1);
		
		JLabel jLabel6=new JLabel();
		jLabel6.setText("����");
		jLabel6.setBounds(250,100,60,80);
		frame.add(jLabel6);
		
		JCheckBox jcb2=new JCheckBox();
		jcb2.setBounds(275,130,20,20);
		frame.add(jcb2);
		
		//�Ա�
		JLabel jLabel7=new JLabel();
		jLabel7.setText("    �Ա�");
		jLabel7.setBounds(100,160,100,20);
		frame.add(jLabel7);
		
		JLabel jLabel8=new JLabel();
		jLabel8.setText("��");
		jLabel8.setBounds(150,160,100,20);
		frame.add(jLabel8);
		
		JRadioButton jrb=new JRadioButton();
		jrb.setBounds(160,160,20,20);
		frame.add(jrb);
		
	    JLabel jLabel9=new JLabel();
		jLabel9.setText("Ů");
		jLabel9.setBounds(195,160,100,20);
		frame.add(jLabel9);
		
		final JRadioButton jrb1=new JRadioButton();
		jrb1.setBounds(205,160,20,20);
		frame.add(jrb1);
		
		//������
		JLabel jLabel10=new JLabel();
		jLabel10.setText("    ���У�");
		jLabel10.setBounds(100,190,100,20);
		frame.add(jLabel10);
		
		final JComboBox jcb_=new JComboBox(new String[]{"�ɶ�","����","����"});
		jcb_.setBounds(150,190,100,20);
		frame.add(jcb_);
		
		//�ύ
		JButton jb=new JButton("�ύ");
		jb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String string=jLabel.getText();
				
				String string1=jtf.getText();
				
				char[] charPassword=jpf.getPassword();
				
				//������������
				//AccessibleContext accessibleContext=jcb.getAccessibleContext();
				String stringJrb1=jrb1.getUIClassID();
				
				String stringJcb_=(String)jcb_.getSelectedItem();
				
				System.out.println(string);
				System.out.println(string1);
				System.out.println(charPassword);
				
				//������������
				//System.out.println(accessibleContext);
				System.out.println(stringJrb1);
				
				System.out.println(stringJcb_);
				
				
			}
			
		});
		jb.setBounds(160,220,60,20);
		frame.add(jb);
		
		//��ʾͼ��
		frame.setVisible(true);
	}
}
