package fr.treeptik.service.impl;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.AuteurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Utilisateur;
import fr.treeptik.service.AuteurService;

@Service
public class AuteurServiceImpl implements AuteurService {

	@Autowired
	private AuteurDAO auteurDAO;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Auteur createAuteur(Auteur auteur) throws ServiceException {
		try {

			return auteurDAO.save(auteur);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la création d'un Auteur",
					e);

		}

	}

	@Transactional(rollbackFor = ServiceException.class)
	public Auteur update(Integer id) throws ServiceException {
		try {
			return auteurDAO.updateById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la mise à jour d'un Auteur",
					e);

		}
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public void delete(Integer id) throws ServiceException {
		try {

			auteurDAO.removeById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la suppression à jour d'un Auteur",
					e);

		}
	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public Auteur find(Integer id) throws ServiceException {
		try {
			return auteurDAO.findBy(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"un problème est survenu lors de la recherche de la liste des auteurs",
					e);

		}

	}

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public List<Auteur> findAll() throws ServiceException {
		try {

			return auteurDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Un problème est survenu lors de la recherche de tout les auteurs",
					e);
		}
	}

	@Transactional(rollbackFor = ServiceException.class)
	public Auteur findCommentaire() throws ServiceException {
		try {
			return auteurDAO.findByCommentaire();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Un problème est survenu lors de la recherche le l'auteur avec l'article le plus commenté",
					e);
		}

	}

	@Override
	public List<Auteur> findAuteurEnligne() throws ServiceException {
		try {
			return auteurDAO.findByEnligne();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(
					"Un problème est survenu lors de la recherche de la liste par auteur du nb d'article en ligne",
					e);
		}

	}
	
	@Override
	public Auteur findByName(String auteurNom) throws ServiceException {
		try {
			return auteurDAO.findByName(auteurNom);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save utilisateur", e);
		}
	}

}
