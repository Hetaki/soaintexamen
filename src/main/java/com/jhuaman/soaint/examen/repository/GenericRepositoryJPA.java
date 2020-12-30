package com.jhuaman.soaint.examen.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class GenericRepositoryJPA<T> implements GenericRepository<T> {

	protected EntityManager entityManager;
	private Class<T> type;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericRepositoryJPA() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("examen");
		this.setEntityManager(emf.createEntityManager());
	}

	public T create(T t) {
		entityManager.getTransaction().begin();
		t = entityManager.merge(t);
		entityManager.flush();
		entityManager.getTransaction().commit();
		return t;
	}

	public void delete(final Object objeto) {
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(objeto));
		entityManager.flush();
		entityManager.getTransaction().commit();
	}

	public T find(final long id) {
		return (T) entityManager.find(type, id);
	}

	public T update(final T t) {
		entityManager.getTransaction().begin();
		entityManager.merge(t);
		entityManager.flush();
		entityManager.getTransaction().commit();
		return t;
	}

	public List<T> findAll() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
		Root<T> root = criteriaQuery.from(type);
		criteriaQuery.select(root);
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}