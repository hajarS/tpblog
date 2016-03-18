package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.dao.ArticleDAO;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Article;

@Component
public class ArticleValidator implements Validator {

	@Autowired
	private ArticleDAO articleDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Article.class);
	}

	@Override
	public void validate(Object article, Errors errors) {

		Article c = (Article) article;

		if (c.getTitre() == null) {
			errors.rejectValue("nom","hack","Le nom est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			try {
				Long countByNameAndId = articleDAO.countByNameAndId(c.getTitre(),
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
				Long countByNameAndId = articleDAO.countByName(c.getTitre());

				if (countByNameAndId != 0) {
					errors.rejectValue("nom", "hack","Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

}
