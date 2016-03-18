package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.dao.UtilisateurDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Utilisateur;

@Component
public class UtilisateurValidator implements Validator {

	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Utilisateur.class);
	}

	@Override
	public void validate(Object utilisateur, Errors errors) {

		Utilisateur c = (Utilisateur) utilisateur;

		if (c.getNom() == null) {
			errors.rejectValue("nom","hack","Le nom est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			try {
				Long countByNameAndId = utilisateurDAO.countByNameAndId(c.getNom(),
						id);

				if (countByNameAndId != 0) {
					errors.rejectValue("nom","hack", "Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Long countByNameAndId = utilisateurDAO.countByName(c.getNom());

				if (countByNameAndId != 0) {
					errors.rejectValue("nom", "hack","Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

}
