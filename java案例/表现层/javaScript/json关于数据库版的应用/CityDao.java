package cn.itcast.web.ajax.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import cn.itcast.web.ajax.domain.City;
import cn.itcast.web.ajax.util.JdbcUtil;

public class CityDao {
	//����ʡ�ݲ�ѯ��Ӧ�����г���
	public List<City> findCityByProvince(String province) throws SQLException{
		List<City> cityList = new ArrayList<City>();
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from city where province_name = ?";
		cityList = (List<City>) runner.query(sql,province,new BeanListHandler(City.class));
		return cityList;
	}
}







