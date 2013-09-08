package org.visico.userdb.bo.impl;

import org.visico.userdb.bo.UserBo;
import org.visico.userdb.dao.UserDao;
import org.visico.userdb.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserBoImpl implements UserBo {

	@Autowired
	UserDao userDao;
	
	public void save(User user) {
		this.userDao.save(user);
		
	}

	public void update(User user) {
		this.userDao.update(user);
	}

	public void delete(User user) {
		this.userDao.delete(user);
	}

	public User findById(int id) {
		return this.userDao.findById(id);
	}
	

}
