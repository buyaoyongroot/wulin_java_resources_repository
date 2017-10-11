package cn.scxh.testCookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("gb2312");
		resp.setCharacterEncoding("gb2312");
		String dname = req.getParameter("name");
		Cookie[] cookies = req.getCookies();
		double prices=0;
		int sum = 0;
		PrintWriter out = resp.getWriter();
		out.write("<html><head><title>���ﳵ</title></head><body><table border=1><tr><th>��Ʒ��</th><th>����(Ԫ)</th><th>����(��)</th><th>����</th></tr>");
		if(cookies != null && cookies.length>0){
			for (Cookie cookie : cookies) {
				if(dname.equals(cookie.getName())){
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}else{
					String name = cookie.getName();
					String value = cookie.getValue();
					String[] sv = value.split("-");
					Double price = Double.parseDouble(sv[0]);
					Integer count = Integer.parseInt(sv[1]);
					out.write("<tr><td>"+name+"</td><td>"+price+"</td><td>"+count+"</td><td><a href='deleteCookieServlet?name="+name+"'>ɾ��</a></td></tr>");
					prices += (price*count);
					sum += count;
				}
			}
		}
		out.write("<tr><td>�ܼ�</td><td>"+prices+"</td><td>"+sum+"</td></tr>");
		out.write("</table><a href='main.html'>���ؼ�������</a></body></html>");
	}
}
