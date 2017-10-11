package cn.itcast.java.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		MyRequest myRequest = new MyRequest(request);
		chain.doFilter(myRequest.getProxy(),response);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	}
}

//ʹ�ö�̬����ʽ�����������
class MyRequest{
	private HttpServletRequest request;
	public MyRequest(HttpServletRequest request){
		this.request = request;
	}
	public HttpServletRequest getProxy(){
		return (HttpServletRequest) Proxy.newProxyInstance(
				MyRequest.class.getClassLoader(), 
				request.getClass().getInterfaces(),
				new InvocationHandler(){
					public Object invoke(
							Object proxy, 
							Method method,
							Object[] args) throws Throwable {
						if("getParameter".equals(method.getName())){
							//ȡ�����������[POST��GET]
							String m = request.getMethod();
							//�����GET��������
							if("get".equalsIgnoreCase(m)){
								String value = request.getParameter((String)args[0]);//����
								byte[] buf = value.getBytes("ISO8859-1");
								value = new String(buf,"UTF-8");//����
								return value;	
							}else if("post".equalsIgnoreCase(m)){
								request.setCharacterEncoding("UTF-8");
								String value = request.getParameter((String)args[0]);//����
								return value;
							}
						}else{
							//����
							return method.invoke(request,args);
						}
						return null;
					}
				});
	}
}







