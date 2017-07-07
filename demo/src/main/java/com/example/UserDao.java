package com.example;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;


	public void create(RegisteredUser user) {
		entityManager.persist(user);
	}


	public void update(RegisteredUser user) {
		entityManager.merge(user);
	}


	public RegisteredUser getUserById(long id) {
		return entityManager.find(RegisteredUser.class, id);
	}


	public void delete(long id) {
		RegisteredUser user = getUserById(id);
		if (user != null) {
			entityManager.remove(user);
		}
	}
}