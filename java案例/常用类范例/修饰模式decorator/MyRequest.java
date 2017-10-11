package cn.itcast.web.decorator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

//��HttpServletRequest�����װ/װ��
public class MyRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	//��д����ķ���
	public String getParameter(String name) {//���������
		String value = null;
		//ȡ�ÿͻ��˵�����ʽ[GET/POST]
		String method = request.getMethod();
		if("GET".equals(method)){
			try {
				value = request.getParameter(name);//����
				byte[] buf = value.getBytes("ISO8859-1");
				value = new String(buf,"UTF-8");//����
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("POST".equals(method)){
			try {
				request.setCharacterEncoding("UTF-8");
				value = request.getParameter(name);//����
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		value = filter(value);
		return value;
	}
	//ת�巽��
	public String filter(String message) {
        if (message == null)
            return (null);
        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
    }
}





