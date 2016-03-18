package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Categorie;

public interface CategorieService {

	Categorie createCategorie(Categorie categorie) throws DAOException, ServiceException;
	
	List<Categorie> findNbArticleParCategorie();
	
	Categorie find(Integer id) throws ServiceException;	
	
	List<Categorie> findAll() throws ServiceException;
	
	Categorie findByName(String categorieNom) throws ServiceException;
	
	void delete(Integer id) throws ServiceException;
	
}
