package package1.service;

import java.awt.Frame;

import javax.swing.JButton;

public interface CountService {
	//�õ�chuangt
	public Frame getFrame();
	
	//�õ��ı���
	public void getJTextField(Frame frame);
	
	//�õ�һ����ť
	public JButton getJButton(String buttonString,int i,int j,int k,int l);
	
	//������ť
	public void handleButton(CountService countService,Frame frame);
	
	public void buttonListener(JButton jButton);
	
}
