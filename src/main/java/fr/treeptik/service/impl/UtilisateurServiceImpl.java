package fr.treeptik.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.UtilisateurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Utilisateur;
import fr.treeptik.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Override
	public Utilisateur findById(Integer id) throws ServiceException {
		try {
			return utilisateurDAO.findOne(id);

		} catch (DAOException e) {
			throw new ServiceException("Erreur find utilisateur", e);
		}
	}

	@Transactional
	@Override
	public Utilisateur save(Utilisateur utilisateur) throws ServiceException {
		try {
			return utilisateurDAO.save(utilisateur);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save utilisateur", e);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws ServiceException {
		try {
			Utilisateur utilisateur = utilisateurDAO.findOne(id);
			utilisateurDAO.delete(utilisateur);
		} catch (DAOException e) {
			throw new ServiceException("Erreur delete utilisateur", e);

		}
	}

	@Override
	public List<Utilisateur> findAll() throws ServiceException {
		try {
			return utilisateurDAO.findAll();

		} catch (DAOException e) {
			throw new ServiceException("Erreur save utilisateur", e);
		}
	}

	@Override
	public Utilisateur findByName(String utilisateurNom) throws ServiceException {
		try {
			return utilisateurDAO.findByName(utilisateurNom);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save utilisateur", e);
		}
	}
}
