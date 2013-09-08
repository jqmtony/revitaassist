package org.visico.userdb.bo;

import org.visico.userdb.model.User;

public interface UserBo {
	void save(User user);
	void update(User user);
	void delete(User user);

	User findById(int id);
}
