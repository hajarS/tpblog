package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;
import fr.treeptik.model.Auteur;

public interface ArticleService {
	
	Article createArticle(Article article) throws ServiceException;

	Article create(Article article) throws ServiceException;
	
	Article findByName(String articleNom) throws ServiceException;
	
	List<Article> findAll() throws ServiceException;
	
	void delete(Integer id) throws ServiceException;
	
	Article find(Integer id) throws ServiceException;

	
}
