package package1.package02;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class TestSplitPane
{
	
	Book[] books = new Book[3];
	/*Book[] books = new Book[]{
		new Book("Struts2Ȩ��ָ��" , new ImageIcon("ico/struts2.jpg") , 
			"ȫ�����Struts2�ĸ���\n��֪ʶ"),
		new Book("������J2EE��ҵӦ��ʵս" , new ImageIcon("ico/j2ee.jpg") ,
			"����Struts��Spring��\nHibernate���Ͽ�����֪ʶ"),
		new Book("����J2EE��Ajax����" , new ImageIcon("ico/ajax.jpg") , 
			"ȫ�����J2EEƽ̨��Ajax\n�����ĸ�����֪ʶ")
	};*/
	JFrame jf = new JFrame("����JSplitPane");
	
	//JList bookList = new JList(books);
	JLabel bookCover = new JLabel();
	JTextArea bookDesc = new JTextArea();

	public void init()
	{
		//jf.setLayout(null);
		jf.setBounds(0, 0, 1500, 750);
		//Ϊ�������������Ѵ�С
	/*	bookList.setPreferredSize(new Dimension(150, 300));
		bookCover.setPreferredSize(new Dimension(300, 150));
		bookDesc.setPreferredSize(new Dimension(300, 150));*/
		//Ϊ�����б�����¼�������
		/*bookList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent event)
			{  
				Book book = (Book)bookList.getSelectedValue();
				bookCover.setIcon(book.getIco());
				bookDesc.setText(book.getDesc());
			}
         });*/
		//����һ����ֱ�ķָ���壬
		//��bookCover�������棬��bookDesc�������� , ֧����������
	/*	JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true , 
			bookCover, new JScrollPane(bookDesc));*/
		JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,bookCover,new JScrollPane(bookDesc));
		//�򿪡�һ����չ��������
		//left.setOneTouchExpandable(true);
		left.setDividerSize(10); 
		//���ø÷ָ��������������������Ѵ�С���������� 
		//left.resetToPreferredSizes();
		//����һ��ˮƽ�ķָ����
		//��left���������ߣ���bookList��������ұ�
		//JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left, bookList);
		jf.add(left);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{  
		new TestSplitPane().init();
	}
}
class Book
{ 
	private String name;
	private Icon ico;
	private String desc;

	public Book(){}

	public Book(String name , Icon ico , String desc)
	{
		this.name = name;
		this.ico = ico;
		this.desc = desc;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	public void setIco(Icon ico)
	{
		this.ico = ico;
	}
	public Icon getIco()
	{
		 return this.ico;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
	}
	public String toString()
	{
		return name;
	}
}