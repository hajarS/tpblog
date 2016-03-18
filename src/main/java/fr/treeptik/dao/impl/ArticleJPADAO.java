package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Auteur;

@Repository
public class ArticleJPADAO extends GenericJPADAO<Article, Integer> implements
		ArticleDAO {

	public ArticleJPADAO() {
		super(Article.class);

	}

	public List<Article> findById(String name) {
		return em.createQuery("Select t from Article t ", Article.class)
				.getResultList();
	}
	
	@Override
	public Article findByName(String articleNom) throws DAOException {
		try {
			return em
					.createQuery("select c from Article c WHERE c.titre LIKE ?1",
							Article.class).setParameter(1, articleNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName Article", e);
		}
	}

	@Override
	public Long countByNameAndId(String articleNom, Integer id) throws DAOException {
		try {
			return em
					.createQuery(
							"select count(c) from Article c WHERE c.titre LIKE ?1 and c.id<> ?2",
							Long.class).setParameter(1, articleNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName article", e);
		}

	}
	
	@Override
	public Long countByName(String articleNom) throws DAOException {
		try {
			return em
					.createQuery(
							"select count(c) from Article c WHERE c.titre LIKE ?1",
							Long.class).setParameter(1, articleNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName article", e);
		}

	}
}
