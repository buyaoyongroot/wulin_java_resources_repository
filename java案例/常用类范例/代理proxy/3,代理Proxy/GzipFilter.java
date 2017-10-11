package cn.itcast.java.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		MyResponse myResponse = new MyResponse(response);
		chain.doFilter(request,myResponse.getProxy());
		//ȡ�û����е�����
		byte[] buf = myResponse.getBuffer();
		System.out.println("ѹ��ǰ��" + buf.length);
		//������ѹ������
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		GZIPOutputStream gout = new GZIPOutputStream(bout);
		gout.write(buf);
		gout.flush();
		gout.close();
		//ȡ��ѹ���������
		buf = bout.toByteArray();
		System.out.println("ѹ����" + buf.length);
		//�����������ѹ���������
		response.setHeader("content-encoding","gzip");
		response.setHeader("content-length",buf.length+"");
		response.getOutputStream().write(buf);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}

//ʹ�ö�̬����ʽ�����������
class MyResponse{
	private HttpServletResponse response;
	//����
	private ByteArrayOutputStream bout = new ByteArrayOutputStream();
	public MyResponse(HttpServletResponse response){
		this.response = response;
	}
	//ȡ�û����е�����
	public byte[] getBuffer(){
		return bout.toByteArray();
	}
	public HttpServletResponse getProxy(){
		return (HttpServletResponse) Proxy.newProxyInstance(
				MyResponse.class.getClassLoader(), 
				response.getClass().getInterfaces(),
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						if("getOutputStream".equals(method.getName())){
							return new MyServletOutputStream(bout);	
						}else{
							return method.invoke(response,args);
						}
					}
				});
	}
}
//���л��湦�ܵ�ServletOutputStream
class MyServletOutputStream extends ServletOutputStream{
	private ByteArrayOutputStream bout;
	public MyServletOutputStream(ByteArrayOutputStream bout){
		this.bout = bout;
	}
	@Override
	public void write(int b) throws IOException {
	}
	//���ֽ�����д�뻺��
	public void write(byte[] buf) throws IOException {
		bout.write(buf);
		bout.flush();
	}
}






