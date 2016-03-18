package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;

import fr.treeptik.model.Utilisateur;

public interface UtilisateurService {

	Utilisateur findById(Integer id) throws ServiceException;

	Utilisateur save(Utilisateur utilisateur) throws ServiceException;

	void remove(Integer id) throws ServiceException;

	List<Utilisateur> findAll() throws ServiceException;

	Utilisateur findByName(String utilisateurNom) throws ServiceException;


	
	
}
