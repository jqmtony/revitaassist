package org.visico.userdb.dao;

import org.visico.userdb.model.User;

public interface UserDao {
	void save(User user);
	void update(User user);
	void delete(User user);

	User findById(int id);
}
