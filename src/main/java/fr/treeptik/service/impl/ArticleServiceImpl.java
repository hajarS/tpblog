package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.ArticleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Article;

import fr.treeptik.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Article createArticle(Article article) throws ServiceException {
		try {

			return articleDAO.save(article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la création d'un article",
					e);

		}

	}
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Article create(Article article) throws ServiceException {

		try {
			article = articleDAO.save(article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la création d'un Article", e);

		}
		return article;
	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Article findByName(String articleNom) throws ServiceException {
		try {
			return articleDAO.findByName(articleNom);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save article", e);
		}
	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public List<Article> findAll() throws ServiceException {
		try {

			return articleDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Un problème est survenu lors de la recherche de tout les articles",
					e);
		}
	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void delete(Integer id) throws ServiceException {
		try {

			articleDAO.removeById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la suppression à jour d'un article",
					e);

		}
	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Article find(Integer id) throws ServiceException {
		try {
			return articleDAO.findBy(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la recherche de la liste des Articles",
					e);

		}

	}


}
