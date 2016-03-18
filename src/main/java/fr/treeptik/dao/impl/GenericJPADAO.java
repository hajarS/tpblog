package fr.treeptik.dao.impl;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.treeptik.dao.GenericDAO;

public class GenericJPADAO<T, Pk> implements GenericDAO<T, Pk> {

	// pour que employeJPADAO l'utilise protected

	@PersistenceContext
	protected EntityManager em;

	public GenericJPADAO() {
		super();
	}

	public GenericJPADAO(EntityManager em, Class<T> type) {
		super();
		this.em = em;
		this.type = type;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	// on créer un objet classe
	private Class<T> type;

	public GenericJPADAO(Class<T> type) {
		this.type = type;
	}

	@Override
	public T save(T entite) {
		// code qui va marcher pour tout type d'entité qu'il faudra préciser en
		// dessous
	
					
		return em.merge(entite);
	}

	// @Transactional
	@Override
	public void removeById(Pk id) {
		// on considere que ttte les classes ont une colonne id
		em.createQuery("delete from " + type.getName() + " Where id=:id")
				.setParameter("id", id).executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T findBy(Pk id) {

		return em.find(type, id);
	}

	@Override
	public T updateById(Pk id) {
		return (T) em.merge(id);

	}

	@Override
	public List<T> findAll() {

		return em.createQuery("Select e from " + type.getSimpleName() + " e",
				type).getResultList();
	}

}
