package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.UtilisateurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Utilisateur;

@Repository
public class UtilisateurJPADAO implements UtilisateurDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Utilisateur save(Utilisateur utilisateur) throws DAOException {
		try {
			if (utilisateur.getId() != null) {
				entityManager.merge(utilisateur);
			} else {
				entityManager.persist(utilisateur);
			}
		} catch (PersistenceException e) {
			throw new DAOException("erreur save utilisateur", e);
		}
		return utilisateur;
	}

	@Override
	public Utilisateur findOne(Integer id) throws DAOException {
		Utilisateur utilisateur;
		try {
			utilisateur = entityManager.find(Utilisateur.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save utilisateur", e);
		}
		return utilisateur;
	}

	@Override
	public void delete(Utilisateur utilisateur) throws DAOException {
		try {
			entityManager.remove(utilisateur);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save utilisateur", e);
		}

	}

	@Override
	public List<Utilisateur> findAll() throws DAOException {
		try {
			return entityManager.createQuery("select c from Utilisateur c",
					Utilisateur.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur save Utilisateur", e);
		}

	}

	@Override
	public Utilisateur findByName(String utilisateurNom) throws DAOException {
		try {
			return entityManager
					.createQuery("select c from Utilisateur c WHERE c.nom LIKE ?1",
							Utilisateur.class).setParameter(1, utilisateurNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName Utilisateur", e);
		}
	}

	@Override
	public Long countByName(String utilisateurNom) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Utilisateur c WHERE c.nom LIKE ?1",
							Long.class).setParameter(1, utilisateurNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName utilisateur", e);
		}

	}
	
	@Override
	public Long countByNameAndId(String utilisateurNom, Integer id) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Utilisateur c WHERE c.nom LIKE ?1 and c.id<> ?2",
							Long.class).setParameter(1, utilisateurNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName utilisateur", e);
		}

	}
}
