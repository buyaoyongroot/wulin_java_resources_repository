package cn.scxh.ittx.ui.hospitalFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.MedicineServiceImpl;
import cn.scxh.ittx.service.intf.MedicineService;
import cn.scxh.ittx.ui.shared.DifferenceComponent;
import cn.scxh.ittx.ui.shared.GetValueOfUI;
import cn.scxh.ittx.ui.shared.SetValueOfUI;

public class MedicineAddOrUpdateFrame {
	private DifferenceObject object;
	public MedicineAddOrUpdateFrame(){}
	public MedicineAddOrUpdateFrame(DifferenceObject object){
		this.object=object;
	}

	//���õ����
	public void sharedComponent(DifferenceComponent dc,JPanel jPanel){
		dc.jLabelComponent(jPanel, "ҩƷ���:", 30,20,60,20);
		dc.jTextFieldComponent(jPanel, "ҩƷ���:", 100,20,150,20);
		dc.jLabelComponent(jPanel, "ҩƷ����:", 300,20,60,20);
		dc.jTextFieldComponent(jPanel, "ҩƷ����:", 370,20,150,20);
		
		dc.jLabelComponent(jPanel, "ҩƷ���:", 30,60,60,20);
		dc.jComboBoxConponent(jPanel, "ҩƷ���:", new GetValueOfUI().getMedicineClassification(),100,60,150,20);
		dc.jLabelComponent(jPanel, "ҩƷ���:", 300,60,60,20);
		dc.jTextFieldComponent(jPanel, "ҩƷ���:", 370,60,150,20);
		
		dc.jLabelComponent(jPanel, "������λ:", 30,100,60,20);
		dc.jComboBoxConponent(jPanel, "������λ:", new GetValueOfUI().getMedicineUnit(),100,100,150,20);
		dc.jLabelComponent(jPanel, "ҩƷ����:", 300,100,100,20);
		dc.jTextFieldComponent(jPanel, "ҩƷ����:", 370,100,150,20);
		
		dc.jLabelComponent(jPanel, "�ɱ��۸�:", 30,140,60,20);
		dc.jTextFieldComponent(jPanel, "�ɱ��۸�:", 100,140,150,20);
		dc.jLabelComponent(jPanel, "���α���:", 300,140,60,20);
		dc.jTextFieldComponent(jPanel, "���α���:", 370,140,150,20);
		
		dc.jLabelComponent(jPanel, "���ۼ۸�:", 30,180,60,20);
		dc.jTextFieldComponent(jPanel, "���ۼ۸�:", 100,180,150,20);
		dc.jLabelComponent(jPanel, "ҩƷ��ƴ:", 300,180,60,20);
		dc.jTextFieldComponent(jPanel, "ҩƷ��ƴ:", 370,180,150,20);
		
		dc.jLabelComponent(jPanel, "�������:", 30,220,60,20);
		dc.jTextFieldComponent(jPanel, "�������:", 100,220,150,20);
		dc.jLabelComponent(jPanel, "�������:", 300,220,60,20);
		dc.jTextFieldComponent(jPanel, "�������:", 370,220,150,20);
		
		dc.jLabelComponent(jPanel, "��׼�ĺ�:", 30,260,60,20);
		dc.jTextFieldComponent(jPanel, "��׼�ĺ�:", 100,260,420,20);
		
		dc.jLabelComponent(jPanel, "���ɳ���:", 30,300,60,20);
		dc.jTextFieldComponent(jPanel, "���ɳ���:", 100,300,420,20);
		
		dc.jLabelComponent(jPanel, "��Ҫ�ɷ�:", 30,350,60,20);
		dc.jTextFieldComponent(jPanel, "��Ҫ�ɷ�:", 100,340,420,40);
		
		dc.jLabelComponent(jPanel, "����Ч:", 30,400,60,20);
		dc.jTextFieldComponent(jPanel, "����Ч:", 100,390,420,40);
		
		dc.jLabelComponent(jPanel, "ʹ�÷���:", 30,450,60,20);
		dc.jTextFieldComponent(jPanel, "ʹ�÷���:", 100,440,420,40);
		
		dc.jLabelComponent(jPanel, "ע������:", 30,510,60,20);
		dc.jTextFieldComponent(jPanel, "ע������:", 100,490,420,60);
		
	}
	
	//���»����ӵĸ������
	public void medicineAddOrUpdateComponent(JFrame jFrame,JPanel jPanel8,DifferenceObject object5){
		DifferenceObject object8=new DifferenceObject();
		object5.getDifferenceObjectMap().put("object8",object8);
		object8.getDifferenceObjectMap().put("object5",object5);
		DifferenceComponent dc=new DifferenceComponent(object8);
		object8.setDifferenceComponent(dc);
		object8.setJpanel(jPanel8);
		object8.setJframe(jFrame);
		sharedComponent(dc,jPanel8);
		dc.jButtonComponent(jPanel8, "����", 5, 200,560,60,20);
		dc.jButtonComponent(jPanel8, "ȡ��", 5, 350,560,60,20);
		MedicineService ms=new MedicineServiceImpl();
		int id=0;
		try {
			id=ms.theLargestNumberOfMedicines(null).get(0).getId()+1;
			object8.getJtextFieldMap().get("ҩƷ���:").setText(String.valueOf(id));
			object8.getJtextFieldMap().get("ҩƷ���:").setEditable(false);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}
	
	//����һ�����µĴ���
	public void medicineUpdateFrame(DifferenceObject object5){
		JFrame jFrame=new JFrame();
		closeJFrame(jFrame);
		JPanel jPanel9=new JPanel();
		jFrame.setBounds(400,60,600,650);
		jPanel9.setLayout(null);
		jPanel9.setBounds(400,60,600,650);
		medicineUpdateComponent(jFrame,jPanel9,object5);
		
		jFrame.add(jPanel9);
		jFrame.setVisible(true);
	}
	
	private void medicineUpdateComponent(JFrame jFrame, JPanel jPanel9,
			DifferenceObject object5) {
		DifferenceObject object9=new DifferenceObject();
		object5.getDifferenceObjectMap().put("object9",object9);
		object9.getDifferenceObjectMap().put("object5",object5);
		DifferenceComponent dc=new DifferenceComponent(object9);
		object9.setDifferenceComponent(dc);
		object9.setJpanel(jPanel9);
		object9.setJframe(jFrame);
		sharedComponent(dc,jPanel9);
		
		SetValueOfUI setValue=new SetValueOfUI(object9);
		int id=setValue.isSelectedOfJPanel7();
		if(id!=0){
			setValue.setDataToJPanel9(id);
		}
		
		dc.jButtonComponent(jPanel9, "����", 6, 200,560,60,20);
		dc.jButtonComponent(jPanel9, "ȡ��", 6, 350,560,60,20);
	}
	//����һ�����ӻ���µĴ���
	public void medicineAddOrUpdateFrame(DifferenceObject object5){
		JFrame jFrame=new JFrame();
		closeJFrame(jFrame);
		JPanel jPanel8=new JPanel();
		jFrame.setBounds(400,60,600,650);
		jPanel8.setLayout(null);
		jPanel8.setBounds(400,60,600,650);
		medicineAddOrUpdateComponent(jFrame,jPanel8,object5);
		
		jFrame.add(jPanel8);
		jFrame.setVisible(true);
	}
	public void closeJFrame(final JFrame jFrame) {
		jFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});
	}
}




