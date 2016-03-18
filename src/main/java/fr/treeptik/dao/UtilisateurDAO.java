package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;

import fr.treeptik.model.Utilisateur;

public interface UtilisateurDAO {

	Utilisateur save(Utilisateur utilisateur) throws DAOException;

	List<Utilisateur> findAll() throws DAOException;

	void delete(Utilisateur utilisateur) throws DAOException;

	Utilisateur findOne(Integer id) throws DAOException;

	Utilisateur findByName(String utilisateurNom) throws DAOException;

	Long countByName(String utilisateurNom) throws DAOException;

	Long countByNameAndId(String utilisateurNom, Integer id) throws DAOException;

}
