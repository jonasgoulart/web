package br.com.web.dao;

import br.com.web.domain.User;

public class UserDAO extends DAO
{
	public User selectById(Long id)
	{
		User user = new User();
		user.setName("Jonas Goulart");
		user.setEmail("jgm.melo@gmail.com");
		user.setPhone("11 98260 8843");
		return user;
	}
}