package cn.wulin.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Download extends ActionSupport {
	private String fileName;
	
	//��struts.xml��<param name="inputName">downloadFile</param>Ҫ��Ӧ����
	public InputStream getDownloadFile()throws Exception {
		fileName="dress2.png";
		//String path=ServletActionContext.getServletContext().getRealPath("/upload/");
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/dress2.png");
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
