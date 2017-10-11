package cn.template_2;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.a_helloworld.User;
import cn.template.HibernateUtils;

public class UserDao {

	public Object execute(HibernateCallback action) {
		Session session = HibernateUtils.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Object result = action.doInSession(session); // ����
			tx.commit();
			return result;
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void saveUser(final User user) {
		execute(new HibernateCallback() {
			public Object doInSession(Session session) {
				session.save(user);
				return null;
			}
		});
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void updateUser(final User user) {
		execute(new HibernateCallback() {
			public Object doInSession(Session session) {
				session.update(user);
				return null;
			}
		});
	}

	public User queryById(final Long id) {
		return (User) execute(new HibernateCallback() {
			public Object doInSession(Session session) {
				User user = (User) session.get(User.class, 1);
				return user;
			}
		});
	}
}
