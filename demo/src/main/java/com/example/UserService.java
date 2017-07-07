package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class UserService {

	@Autowired
	private UserDao userDao;

	public void create(RegisteredUser registeredUser) {
		userDao.create(registeredUser);
	}
}