package cn.wulin.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.wulin.base.BaseDao;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> extends HibernateTemplate implements BaseDao<T>{
	private Class clazz;
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz  = (Class) type.getActualTypeArguments()[0];
	}

	public void deleteEntity(Long id) {
		T entity = (T) this.get(clazz, id);
		this.delete(entity);
	}
	
	public List<T> findAll() {
		return this.getSessionFactory().getCurrentSession().createQuery("FROM "+clazz.getSimpleName())
		.list();
	}
	
	public List<T> getByIds(Long[] ids){
		if(ids == null || ids.length == 0){
			return Collections.EMPTY_LIST;
		}
		return this.getMySession().createQuery("FROM "+clazz.getSimpleName() + " WHERE id IN(:ids)")
		.setParameterList("ids", ids)
		.list();
	}

	public T findEntity(Long id) {
		return (T) this.getSessionFactory().getCurrentSession().createQuery("FROM "+clazz.getSimpleName()+" WHERE id=:id")
		.setParameter("id", id)
		.uniqueResult();
	}

	public void saveEntity(T entity) {
		this.save(entity);
	}
	

	public void updateEntity(T entity) {
		this.update(entity);
	}

	/**
	*得到session
	*/
	public Session getMySession(){
		return this.getSessionFactory().getCurrentSession();
	}

}
