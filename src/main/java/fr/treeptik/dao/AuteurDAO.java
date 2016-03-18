package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Utilisateur;

public interface AuteurDAO extends GenericDAO <Auteur, Integer> {
	
	public Auteur findByCommentaire();
	
	public List<Auteur> findByEnligne();

	Long countByNameAndId(String auteurNom, Integer id) throws DAOException;

	Long countByName(String auteurNom) throws DAOException;

	public Auteur findByNom(String auteurNom) throws DAOException;
	
	Auteur findByName(String utilisateurNom) throws DAOException;




}
