package org.visico.userdb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.visico.userdb.dao.UserDao;
import org.visico.userdb.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public void save(User user) {
		getHibernateTemplate().save(user);
	}

	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	public User findById(int id) {
		List list = getHibernateTemplate().find(
                "from USER where id=?", id
          );
		return (User)list.get(0);
	}

}
