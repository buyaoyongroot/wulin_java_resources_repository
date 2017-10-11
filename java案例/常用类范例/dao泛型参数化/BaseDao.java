package cn.itcast.java.dao.dao3;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import cn.itcast.java.util.JdbcUtil;

public class BaseDao<T> {
	private Class clazz;
	private String tableName;
	public BaseDao(){
		//ȡ��BaseDao���ֽ������
		Class baseDaoClass = this.getClass();
		//ȡ��BaseDao�ķ�������
		Type type = (Type) baseDaoClass.getGenericSuperclass();
		//��Typeת��ParameterizedType����ȡ��BaseDao<Type>�Ĳ���������
		ParameterizedType pt = (ParameterizedType) type;
		//ȡ�ò����������е�ʵ���������ͣ���Type
		this.clazz = (Class) pt.getActualTypeArguments()[0];
		int index = this.clazz.getName().lastIndexOf(".");
		//����
		this.tableName = this.clazz.getName().substring(index+1).toLowerCase();
	}
	public T findTById(int id) throws SQLException {
		T t = null;
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from " + tableName + " where id = ?";
		t = (T) runner.query(sql, id, new BeanHandler(clazz));
		return t;
	}
}


