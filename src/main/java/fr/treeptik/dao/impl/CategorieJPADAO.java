package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;

import fr.treeptik.model.Categorie;

@Repository
public class CategorieJPADAO extends GenericJPADAO<Categorie, Integer>
		implements CategorieDAO {

	//On appel le constructeur de la classe supérieur
	public CategorieJPADAO() {
		super(Categorie.class);

	}
	

	@Override
	public Categorie findByNom(String categorieNom) throws DAOException {
		try {
			return em
					.createQuery("select c from Categorie c WHERE c.name LIKE ?1",
							Categorie.class).setParameter(1, categorieNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName Categorie", e);
		}
	}


	@Override
	public Categorie findByName(String categorieNom) throws DAOException {
		try {
			return em
					.createQuery("select c from Auteur c WHERE c.name LIKE ?1",
							Categorie.class).setParameter(1, categorieNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName categorie", e);
		}
	}

	public List<Categorie> findNbArticleCat() {
		return em
				.createQuery(
						"Select c from Categorie c Join c.articles group by c.name",
//						"Select count(a) from Article a group by categorie_id  ",
						Categorie.class).getResultList();
	}
	
	@Override
	public Long countByNameAndId(String categorieNom, Integer id) throws DAOException {
		try {
			return em
					.createQuery(
							"select count(c) from Categorie c WHERE c.name LIKE ?1 and c.id<> ?2",
							Long.class).setParameter(1, categorieNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName categorie", e);
		}

	}
	
	@Override
	public Long countByName(String categorieNom) throws DAOException {
		try {
			return em
					.createQuery(
							"select count(c) from Categorie c WHERE c.name LIKE ?1",
							Long.class).setParameter(1, categorieNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName categorie", e);
		}

	}
}