package register.util;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import register.domain.DifferenceObject;
import register.ui.ClazzUI;
import register.ui.RegisterJFrame;
import register.ui.UpdateClazzUI;

public class DifferenceListener {
	DifferenceObject object;
	public DifferenceListener(){}
	public DifferenceListener(DifferenceObject object){
		this.object=object;
	}
	
	//����ļ���
	public void sharedListener(JFrame jFrame, JButton jButton,final String name ,final int id) {
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if("�ύ".equals(name)){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getRegisterValue();
				}
				if("����".equals(name )&& id>0){
					SetValueOfUI setValue=new SetValueOfUI(object);
					setValue.setUpdateValue();
				}if("ˢ��".equals(name)){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getRefreshClazzValue();
				}if("����".equals(name )&& id==-2){
					int i=new UpdateClazzUI(object).updateClazzWindow();
					SetValueOfUI setValue=new SetValueOfUI(object);
					if(!(i==-1)){
						setValue.setClazzValue(i);
					}
				}if("����".equals(name )&& id==-3){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getClazzValue();
				}if("���".equals(name )&& id==-2){
					new UpdateClazzUI(object).addClazzWindow();
				}if("���".equals(name )&& id==-3){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getAddClazzValue();
				}if("ɾ��".equals(name )&& id==-2){
					GetValueOfUI value=new GetValueOfUI(object);
					value.getDeleteClazzValue();
				}
			}
		});
	}
	
	//����ļ����ع�
	public void sharedListener(Frame frame, JButton jButton,final String name ,final int id) {
		jButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if("����".equals(name)){					
					GetValueOfUI value=new GetValueOfUI(object);
					value.getSearchingValue();
				}
				if("ɾ��".equals(name)){					
					GetValueOfUI value=new GetValueOfUI(object);
					value.getDeleteValue();
				}
				if("ע��".equals(name)){					
					RegisterJFrame registerJFrame=new RegisterJFrame(object);
					registerJFrame.registerJFarme();
				}if("�༶".equals(name)){					
					new ClazzUI().clazzWindow();
				}
			}
		});
	}
}
