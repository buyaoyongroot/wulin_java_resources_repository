package cn.scxh.ittx.ui.shared;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.util.ConstantUtils;

public class EditVariousComponent {
	private static EditVariousComponent editVariousComponent;
	public EditVariousComponent(){}
	public synchronized static EditVariousComponent getInstance(){
		if(editVariousComponent==null){
			editVariousComponent=new EditVariousComponent();
		}
		return editVariousComponent;
	}
	
	// topJPanel
	public void topJPanelContext(JPanel topJPanel, DifferenceObject object) {
		topJPanel.setLayout(null);
		DifferenceComponent dc = object.getDifferenceComponent();
		Date d = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String da = simpleDateFormat.format(d);
		String[] date = new String[] { da };

		dc.jLabelComponent(topJPanel, "��ʼ����:", 10, 30, 60, 20);
		dc.jComboBoxConponent(topJPanel, "��ʼ����:", date, 80, 30, 100, 20);

		dc.jLabelComponent(topJPanel, "��ֹ����:", 200, 30, 60, 20);
		dc.jComboBoxConponent(topJPanel, "��ֹ����:", date, 270, 30, 100, 20);

		String[] name = new String[] { "֤��/����", "�Ա�", "����״��", "ְҵ", "��ϵ��ַ",
				"�����������", "�������" };
		dc.jLabelComponent(topJPanel, "����λ��:", 390, 30, 60, 20);
		dc.jComboBoxConponent(topJPanel, "����λ��:", name, 460, 30, 100, 20);

		dc.jLabelComponent(topJPanel, "�ؼ���:", 580, 30, 60, 20);
		dc.jTextFieldComponent(topJPanel, "�ؼ���", 650, 30, 60, 20);

	}

	//tabbedPaneJPanel2ContectJPanel21
	public void tabbedPaneJPanel2ContectJPanel21(JPanel jPanel21,DifferenceObject object) {
		jPanel21.setLayout(null);
		
		DifferenceObject o=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(o);
		o.setDifferenceComponent(dc);
		object.getDifferenceObjectMap().put("jPanel21Object", o);
		o.getDifferenceObjectMap().put("object", object);
		o.setJpanel(jPanel21);
		
		
		EditVariousComponent.getInstance().tabbedPaneJPanel21Judge(jPanel21,o);
		tabbedPaneJPanel2ContectJPanel21Component(jPanel21, object);
		
	}
	
	//����JPanel21�Ķ����˵�
	public void tabbedPaneJPanel21Judge(JPanel jPanel21,DifferenceObject o){
		DifferenceComponent dc=o.getDifferenceComponent();
		if(o.getFlagList().isEmpty()){
			o.getFlagList().add(true);
		}
		dc.jButtonComponent(jPanel21, ConstantUtils._001, "_001", 4,
				0, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._002, "_002", 4,
				60, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._003, "_003", 4,
				120, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._004, "_004", 4,
				180, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._005, "_005", 4,
				240, 0, 60, 60);
		dc.jButtonComponent(jPanel21, ConstantUtils._006, "_006", 4,
				300, 0, 60, 60);
		SetValueOfUI setValue=new SetValueOfUI(o);
		setValue.setIsEnabledOfButton(true);
		
	}

	//JPanel2ContectJPanel21
	private void tabbedPaneJPanel2ContectJPanel21Component(JPanel jPanel21,
			DifferenceObject object) {
		DifferenceObject o=object.getDifferenceObjectMap().get("jPanel21Object");
		DifferenceComponent dc=o.getDifferenceComponent();
		dc.jLabelComponent(jPanel21, "ҽ��֤��:", 0,70,60,20);
		dc.jLabelComponent(jPanel21, "����:", 160,70,60,20);
		dc.jLabelComponent(jPanel21, "�Ա�:", 320,70,60,20);
		dc.jLabelComponent(jPanel21, "����:", 480,70,60,20);
		GetValueOfUI value=new GetValueOfUI(object);
		value.getTabbedSelectedValue();
		drawingJTableInJPanel21(jPanel21,object);
		
	}
	
	public void tabbedPaneJPanel1ContextComponent(JPanel tabbedPaneJPanel1,
			DifferenceObject object) {
		DifferenceComponent dc = object.getDifferenceComponent();
		String[] nameArray = new String[] { "��", "Ů" };
		String[] marriedArray = new String[] { "�ѻ�", "δ��" };
		String[] professionArray = new String[] { "ũ��", "ҽ��", "��ױʦ" };
		String[] bloodArray = new String[] { "A��", "B��", "O��", "AB��" };

		dc.jLabelComponent(tabbedPaneJPanel1, "ҽ��֤��:", 0, 80, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "ҽ��֤��:", 70, 80, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��������:", 200, 80, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "��������:", 270, 80, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��        ��:", 0, 120, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "��        ��:", nameArray, 70,
				120, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��        ��:", 200, 120, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "��        ��:", 270, 120, 100,
				20);

		dc.jLabelComponent(tabbedPaneJPanel1, "����״��:", 0, 160, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "����״��:", marriedArray, 70,
				160, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "ְ        ҵ:", 200, 160, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "ְ        ҵ:",
				professionArray, 270, 160, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��        ��:", 0, 200, 60, 20);
		dc.jLabelComponent(tabbedPaneJPanel1, "kg", 171, 200, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "��        ��:", 70, 200, 100,
				20);

		dc.jLabelComponent(tabbedPaneJPanel1, "Ѫ        ��:", 200, 200, 60, 20);
		dc.jComboBoxConponent(tabbedPaneJPanel1, "Ѫ        ��:", bloodArray,
				270, 200, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��ϵ�绰:", 0, 240, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "��ϵ�绰:", 70, 240, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "�Ǽ�����:", 200, 240, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "�Ǽ�����:", 270, 240, 100, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��ϵ��ַ:", 0, 280, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "��ϵ��ַ:", 70, 280, 300, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, " �� �� ʷ :", 0, 320, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, " �� �� ʷ :", 70, 320, 300, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "�������:", 0, 360, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "�������:", 70, 360, 300, 20);

		dc.jLabelComponent(tabbedPaneJPanel1, "��        ע:", 0, 400, 60, 20);
		dc.jTextFieldComponent(tabbedPaneJPanel1, "��        ע:", 70, 400, 300,
				20);
	}
	
	// tabbedPaneJPanel1
	public void tabbedPaneJPanel1Context(JPanel tabbedPaneJPanel1,
			DifferenceObject object) {

		tabbedPaneJPanel1.setLayout(null);

		

		EditVariousComponent.getInstance().tabbedPaneJPanel1Judge(tabbedPaneJPanel1,object);
		tabbedPaneJPanel1ContextComponent(tabbedPaneJPanel1, object);
	}
	
	// tabbedPaneJPanel1 �� judge
	public void tabbedPaneJPanel1Judge(JPanel tabbedPaneJPanel1,DifferenceObject object){
		DifferenceComponent dc = object.getDifferenceComponent();
		if(object.getFlagList().isEmpty()){
			object.getFlagList().add(true);
		}
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._001, "_001", 3,
					0, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._002, "_002", 3,
					60, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._003, "_003", 3,
					120, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._006, "_006", 3,
					300, 0, 60, 60);
	
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._004, "_004", 3,
					180, 0, 60, 60);
			dc.jButtonComponent(tabbedPaneJPanel1, ConstantUtils._005, "_005", 3,
					240, 0, 60, 60);
			SetValueOfUI setValue=new SetValueOfUI(object);
			setValue.setIsEnabledOfButton(true);
		
	}
	
	//drawingJTable
	private void drawingJTableInJPanel21(JPanel jPanel21,
			DifferenceObject object) {
		DifferenceObject o=object.getDifferenceObjectMap().get("jPanel21Object");
		DifferenceComponent dc=o.getDifferenceComponent();
		dc.jLabelComponent(jPanel21, "��������:", 640,70,60,20);
		dc.jTextFieldComponent(jPanel21, "��������", 710,70,100,20);
		dc.jLabelComponent(jPanel21, "��        ��:", 0,90,60,20);
		dc.jTextFieldComponent(jPanel21, "��         ��:", 70,90,740,20);
		dc.jLabelComponent(jPanel21, "��  ��  ʷ:", 0,120,60,20);
		dc.jTextFieldComponent(jPanel21, "��  ��  ʷ:", 2, 70,110,740,40);
		dc.jLabelComponent(jPanel21, "��  ��  ʷ:", 0,160,60,20);
		dc.jTextFieldComponent(jPanel21, "��  ��  ʷ:", 2, 70,150,740,40);
		dc.jLabelComponent(jPanel21, "��  ��  ʷ:", 0,200,60,20);
		dc.jTextFieldComponent(jPanel21, "��  ��  ʷ:", 2, 70,190,740,40);
		dc.jLabelComponent(jPanel21, "�����:", 0,250,60,20);
		dc.jTextFieldComponent(jPanel21, "�����:", 2, 70,230,740,60);
		dc.jLabelComponent(jPanel21, "ʵ����:", 0,300,60,20);
		dc.jTextFieldComponent(jPanel21, "ʵ����:", 2, 70,290,740,40);
		dc.jLabelComponent(jPanel21, "���:", 0,340,60,20);
		dc.jTextFieldComponent(jPanel21, "���:", 2, 70,330,740,40);
		dc.jLabelComponent(jPanel21, "�������:", 0,380,60,20);
		dc.jTextFieldComponent(jPanel21, "�������:", 2, 70,370,740,40);
		dc.jLabelComponent(jPanel21, "����˵��:", 0,420,60,20);
		dc.jTextFieldComponent(jPanel21, "����˵��:", 2, 70,410,740,40);
		
	}
	
	//ҩƷ���õĶ����˵�JPanel1�е����
	public DifferenceObject setTotJPanelComponent(JPanel topJPanel) {
		topJPanel.setLayout(null);
		DifferenceObject object5=new DifferenceObject();
		DifferenceComponent dc=new DifferenceComponent(object5);
		object5.setDifferenceComponent(dc);
		object5.setJpanel(topJPanel);
		dc.jButtonComponent(topJPanel,ConstantUtils.M1, "M1", 5, 0,0,60,60);
		dc.jButtonComponent(topJPanel,ConstantUtils.M2, "M2", 5, 60,0,60,60);
		dc.jButtonComponent(topJPanel,ConstantUtils.M3, "M3", 5, 120,0,60,60);
		return object5;
	}
	
	//�༭JPanel10�еĸ������
	public void editJPanel10Component(DifferenceObject object10) {
		DifferenceComponent dc=object10.getDifferenceComponent();
		JPanel jPanel10=object10.getJpanel();
		
		dc.jLabelComponent(jPanel10, "���ҹؼ���", 0,5,70,20);
		dc.jTextFieldComponent(jPanel10, "���ҹؼ���", 71,5,100,20);
		dc.jLabelComponent(jPanel10, "����Ϣ", 172,5,50,20);
		dc.jButtonComponent(jPanel10, "����", 10, 215,5,60,20);
		dc.jLabelComponent(jPanel10, "1.���ѡ����ҩ���Ҽ�[����¼�Ŀ¼]�����Ӹ�", 0,35,300,20);
		dc.jLabelComponent(jPanel10, "�����,��������ͬ��.", 10,55,300,20);
		dc.jLabelComponent(jPanel10, "2.���ѡ�������Ķ�Ӧ������Ҽ�[���ҩ��,����", 0,75,300,20);
		dc.jLabelComponent(jPanel10, "�÷�],���½����ྭ�鷽,����,�÷�.", 10,95,300,20);
		dc.jLabelComponent(jPanel10, "3.�������ֶ�չ������Ŀ¼��,�ٽ����ֶ�����", 0,115,300,20);
	}
	
	

}
