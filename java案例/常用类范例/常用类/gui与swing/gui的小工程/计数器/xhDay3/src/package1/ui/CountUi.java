package package1.ui;

import java.awt.Frame;

import javax.swing.JButton;

import package1.service.CountService;
import package1.service.Impl.CountServiceImpl;

public class CountUi {
	static CountService countService=new CountServiceImpl();
	
	public static void main(String[] args) {
		//�õ�һ������
		Frame frame=countService.getFrame();
		//�õ�һ���ı���
		countService.getJTextField(frame);
		//�õ�������ť
		countService.handleButton(countService,frame);
		
		
		frame.setVisible(true);
	}

}
