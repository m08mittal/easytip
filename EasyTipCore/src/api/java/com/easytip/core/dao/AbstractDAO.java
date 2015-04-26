package com.easytip.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDAO {
	@PersistenceContext
	EntityManager entityManager;
}
