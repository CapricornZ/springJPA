package cn.ibeans.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cn.ibeans.dao.UserDao;
import cn.ibeans.web.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findByName(String name) {		
		Query query = em.createQuery("from User where username=?");
		query.setParameter(1, name);
		List result = query.getResultList();
		return (User)result.get(0);
	}

	@Override
	public User findByLoginName(String loginName) {
		return null;
	}

	@Override
	public void saveOrUpdate(User user) {
		em.persist(user);
	}

}

