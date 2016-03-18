package fr.treeptik.dao;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;

public interface ArticleDAO extends GenericDAO <Article, Integer> {
		
	Long countByNameAndId(String auteurNom, Integer id) throws DAOException;

	Long countByName(String auteurNom) throws DAOException;

	Article findByName(String articleNom) throws DAOException;
}
