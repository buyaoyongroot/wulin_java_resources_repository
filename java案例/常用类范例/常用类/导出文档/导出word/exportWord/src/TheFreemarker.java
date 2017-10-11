

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class TheFreemarker {
	private Configuration configuration = null;

	public TheFreemarker() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}

	public void createDoc() {
		// Ҫ����ģ���������ļ�
		Map dataMap = new HashMap();
		getData(dataMap);
		// ����ģ��װ�÷�����·��
		// �������ǵ�ģ���Ƿ���src.model������
		configuration.setClassForTemplateLoading(this.getClass(),
				"model");
		Template t = null;
		try {
			t = configuration.getTemplate("test2.xml");	// װ��test2.xmlģ��
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ����ĵ�·��������
		File outFile = new File("D:/������ͨ��.doc");
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(outFile),"utf-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			t.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ע��dataMap���ŵ�����KeyֵҪ��ģ���еĲ������Ӧ
	 * @param dataMap
	 */
	private void getData(Map dataMap) {
		dataMap.put("name", "С����С��");//���� xml��ı��Ϊ${name}
		dataMap.put("Tdate", "2011-12-02");//ʱ�� xml��ı��Ϊ${Tdate}
	dataMap.put("address", "����������");//ʱ�� xml��ı��Ϊ${address}
	dataMap.put("picture", getImageStr());
		List table2 = new ArrayList();
		for (int i = 0; i < 5; i++) {
			Table2 t = new Table2();
			t.setApplyno("BBBBBBBB-BB");
			t.setCustname("С��");
			t.setLoandate("2012-12-12");
			t.setRegion("999-999");
			table2.add(t);
		}
		dataMap.put("table2", table2);
	}
	
	private String getImageStr() {
        String imgFile = "d:/dress8.png";
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
