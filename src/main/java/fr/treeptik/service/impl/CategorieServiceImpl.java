package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Categorie;
import fr.treeptik.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDAO categorieDAO;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Categorie createCategorie(Categorie categorie) throws ServiceException {
		try {

			return categorieDAO.save(categorie);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la création d'un categorie",
					e);

		}

	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Categorie find(Integer id) throws ServiceException {
		try {
			return categorieDAO.findBy(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la recherche de la liste des Categories",
					e);

		}

	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public List<Categorie> findAll() throws ServiceException {
		try {

			return categorieDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Un problème est survenu lors de la recherche de tout les Categories",
					e);
		}
	}
	
	@Override
	public Categorie findByName(String categorieNom) throws ServiceException {
		try {
			return categorieDAO.findByName(categorieNom);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save categorie", e);
		}
	}
	
	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void delete(Integer id) throws ServiceException {
		try {

			categorieDAO.removeById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la suppression à jour d'un categorie",
					e);

		}
	}

	@Transactional
	public List<Categorie> findNbArticleParCategorie() {

		return categorieDAO.findNbArticleCat();
	}

}
