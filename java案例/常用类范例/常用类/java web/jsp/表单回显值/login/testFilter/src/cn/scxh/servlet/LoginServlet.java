package cn.scxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.scxh.model.Admin;

public class LoginServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		
		System.out.println("username--->" + username);
		System.out.println("pwd--->" + pwd);
		
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPwd(pwd);
		
		PrintWriter out = resp.getWriter();

		//����serviceȥ��֤���û��Ƿ�Ϸ�
		
		if("admin".equals(username) && "admin".equals(pwd)){
			//��֤�ɹ����򽫶���ŵ�session��
			req.getSession().setAttribute("admin", admin);
			//resp.sendRedirect("main.html");
			out.print("true");
			
		}else{
			//resp.sendRedirect("login.html");
			out.print("false");
		}
	}
}
