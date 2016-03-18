package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Utilisateur;

public interface AuteurService {

	Auteur createAuteur(Auteur auteur) throws ServiceException;

	void delete(Integer id) throws ServiceException;

	Auteur find(Integer id) throws ServiceException;

	List<Auteur> findAll() throws ServiceException;

	Auteur update(Integer id) throws ServiceException;

	Auteur findCommentaire() throws ServiceException;
	
	List<Auteur> findAuteurEnligne() throws ServiceException;
	
	Auteur findByName(String auteurNom) throws ServiceException;
	
}
