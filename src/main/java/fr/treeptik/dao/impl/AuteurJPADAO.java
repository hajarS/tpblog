package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.AuteurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Utilisateur;

@Repository
public class AuteurJPADAO extends GenericJPADAO<Auteur, Integer> implements
		AuteurDAO {

	// il faut appelé le constructeur de la classe sup
	public AuteurJPADAO() {
		super(Auteur.class);

	}

	@Override
	public Auteur findByCommentaire() {
		return em
				.createQuery(
						"Select a from Auteur a Join a.articles art join art.commentaires com "
						+ "group by art.auteur.id "
						+ "order by count(com.id) desc",
						Auteur.class).setMaxResults(1).getSingleResult();
		
	}

	@Override
	public Auteur findByName(String auteurNom) throws DAOException {
		try {
			return em
					.createQuery("select c from Auteur c WHERE c.nom LIKE ?1",
							Auteur.class).setParameter(1, auteurNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName Utilisateur", e);
		}
	}
	@Override
	public List<Auteur> findByEnligne() {
		
		 		return em
				.createQuery(
						"Select a from Auteur a Join a.articles art",
						Auteur.class).getResultList();
	}
	
	@Override
	public Long countByNameAndId(String auteurNom, Integer id) throws DAOException {
		try {
			return em
					.createQuery(
							"select count(c) from Auteur c WHERE c.nom LIKE ?1 and c.id<> ?2",
							Long.class).setParameter(1, auteurNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName auteur", e);
		}

	}
	
	@Override
	public Long countByName(String auteurNom) throws DAOException {
		try {
			return em
					.createQuery(
							"select count(c) from Auteur c WHERE c.nom LIKE ?1",
							Long.class).setParameter(1, auteurNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName auteur", e);
		}

	}

	@Override
	public Auteur findByNom(String auteurNom) throws DAOException {
		try {
			return em
					.createQuery("select c from Auteur c WHERE c.nom LIKE ?1",
							Auteur.class).setParameter(1, auteurNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName client", e);
		}
	}



}