package package2;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Test1 {
	public static void main(String[] args) {
		Frame frame=new Frame("ע�����");
		frame.setLayout(null);//���ֹ�����
		
		frame.setLocation(333,200);
		frame.setSize(350,400);
		
		//�û���
		JLabel jLabel=new JLabel();
		jLabel.setText("�û�����");
		jLabel.setBounds(100,40,60,80);
		frame.add(jLabel);
		
		JTextField jtf=new JTextField();
		jtf.setBounds(150,70,100,20);
		frame.add(jtf);
		
		//����
		JLabel jLabel2=new JLabel();
		jLabel2.setText("    ���룺");
		jLabel2.setBounds(100,70,60,80);
		frame.add(jLabel2);
		
		JPasswordField jpf=new JPasswordField();
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
		
		JCheckBox jcb=new JCheckBox();
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
		
		ButtonGroup bg=new ButtonGroup();//�����Ա��Ψһѡ��
		JRadioButton jrb=new JRadioButton();
		jrb.setBounds(160,160,20,20);
		
		
		
		JLabel jLabel9=new JLabel();
		jLabel9.setText("Ů");
		jLabel9.setBounds(195,160,100,20);
		frame.add(jLabel9);
		
		JRadioButton jrb1=new JRadioButton();
		jrb1.setBounds(205,160,20,20);
		bg.add(jrb);
		bg.add(jrb1);
		frame.add(jrb);
		frame.add(jrb1);
		
		//bg.add());
		
		//������
		JLabel jLabel10=new JLabel();
		jLabel10.setText("    ���У�");
		jLabel10.setBounds(100,190,100,20);
		frame.add(jLabel10);
		
		JComboBox jcb_=new JComboBox(new String[]{"�ɶ�","����","����"});
		jcb_.setBounds(150,190,100,20);
		frame.add(jcb_);
		
		//�ύ
		JButton jb=new JButton("�ύ");
		jb.setBounds(160,220,60,20);
		frame.add(jb);
		
		List<Student> studentList=new ArrayList<Student>();
		String[] string1=new String[]{"���","����","�Ա�","����"};
		
		
		for (int i = 0; i <10; i++) {
			Student student=new Student();
			student.setAge(i+20);
			student.setGender("��");
			student.setName("haha"+i);
			student.setId(i);
			studentList.add(student);
		}
		String[][] string2=new String[studentList.size()][string1.length];
		
		for (int i = 0; i <10; i++) {
			Student student1=studentList.get(i);
			string2[i][0]=""+student1.getId();
			string2[i][1]=student1.getName();
			string2[i][2]=student1.getGender();
			string2[i][3]=student1.getAge()+"";
		}
		
		
		
	/*	
		string2[0][0]="1";
		string2[0][1]="hah";
		string2[0][2]="ji";
		string2[0][3]="12";
		
		
		string2[1][0]="1";
		string2[1][1]="ss";
		string2[1][2]="dd";
		string2[1][3]="25";*/
		JTable jTable=new JTable(string2,string1);
		
		JScrollPane jscrollPane=new JScrollPane(jTable);
		jscrollPane.setBounds(25,250,300,100);
		
		frame.add(jscrollPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//��ʾͼ��
		frame.setVisible(true);
	}
}
