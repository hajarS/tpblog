package fr.treeptik.dao;


import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Categorie;

public interface CategorieDAO extends GenericDAO <Categorie, Integer>{

	public List<Categorie> findNbArticleCat();

	Long countByNameAndId(String categorieNom, Integer id) throws DAOException;

	Long countByName(String categorieNom) throws DAOException;

	Categorie findByName(String categorieNom) throws DAOException;
	
	public Categorie findByNom(String categorieNom) throws DAOException;
}
