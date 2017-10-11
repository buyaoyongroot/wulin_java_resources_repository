package cn.itcast.web.ajax.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.itcast.web.ajax.dao.CityDao;
import cn.itcast.web.ajax.domain.City;

public class CityServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String province = request.getParameter("province");
		byte[] buf = province.getBytes("ISO8859-1");
		province = new String(buf,"UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String jsonString = null;
		try {
			CityDao cityDao = new CityDao();
			List<City> cityList = cityDao.findCityByProvince(province);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"id","province_name"});
			JSONArray jsonArray = JSONArray.fromObject(cityList,jsonConfig);
			jsonString = jsonArray.toString();
			System.out.println("jsonString="+jsonString);
			pw.write(jsonString);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		
		/*
		List<City> cityList = new ArrayList<City>();
		if(province.equals("����ʡ")){
			cityList.add(new City(1,"����"));
			cityList.add(new City(2,"������"));
			cityList.add(new City(3,"��ԭ"));
			cityList.add(new City(4,"ͨ��"));
		}else if(province.equals("����ʡ")){
			cityList.add(new City(1,"����"));
			cityList.add(new City(2,"����"));
			cityList.add(new City(3,"��ɽ"));
			cityList.add(new City(4,"��˳"));
			cityList.add(new City(5,"����"));
		}else if(province.equals("ɽ��ʡ")){
			cityList.add(new City(1,"����"));
			cityList.add(new City(2,"�ൺ"));
			cityList.add(new City(3,"����"));
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"id"});
		JSONArray jsonArray = JSONArray.fromObject(cityList,jsonConfig);
		jsonString = jsonArray.toString();
		System.out.println("jsonString="+jsonString);
		pw.write(jsonString);
		*/
		
		/*
		if(province.equals("����ʡ")){
			jsonString="{'city':['����','������','��ԭ','ͨ��']}";	
		}else if(province.equals("����ʡ")){
			jsonString="{'city':['����','����','��ɽ','��˳','����']}";	
		}else if(province.equals("ɽ��ʡ")){
			jsonString="{'city':['����','�ൺ','����']}";	
		}
		pw.write(jsonString);
		*/
		
		
		/*
		pw.write("<root>");
		if(province.equals("����ʡ")){
			pw.write("<city>����[����ʡ]</city>");
			pw.write("<city>������[����ʡ]</city>");
			pw.write("<city>��ԭ[����ʡ]</city>");
			pw.write("<city>ͨ��[����ʡ]</city>");
		}else if(province.equals("����ʡ")){
			pw.write("<city>����[����ʡ]</city>");
			pw.write("<city>����[����ʡ]</city>");
			pw.write("<city>��ɽ[����ʡ]</city>");
			pw.write("<city>��˳[����ʡ]</city>");
			pw.write("<city>����[����ʡ]</city>");
		}else if(province.equals("ɽ��ʡ")){
			pw.write("<city>����[ɽ��ʡ]</city>");
			pw.write("<city>�ൺ[ɽ��ʡ]</city>");
			pw.write("<city>����[ɽ��ʡ]</city>");
		}
		pw.write("</root>");
		*/
		
		
	}
}
