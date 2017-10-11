package package1.package02;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class TestJTabbedPane
{
	JFrame jf = new JFrame("����Tabҳ��");
	//����һ��Tabҳ��ı�ǩ������ߣ����û��в��ֲ��Ե�JTabbedPane
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP , JTabbedPane.WRAP_TAB_LAYOUT);	
	
	Map<String , String> books = new LinkedHashMap<String , String>();

	public void init()
	{
		books.put("ROR���ݿ������ʵ��" , "ror.jpg");
		books.put("Struts2Ȩ��ָ��" , "struts2.jpg");
		for (String bookName : books.keySet())
		{
			tabbedPane.addTab(bookName,null);
		}
		jf.add(tabbedPane);
		tabbedPane.setPreferredSize(new Dimension(500 , 300));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);

	}
	
	public static void main(String[] args)
	{  
		new TestJTabbedPane().init();
	}
}



