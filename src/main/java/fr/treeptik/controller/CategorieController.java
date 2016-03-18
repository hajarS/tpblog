package fr.treeptik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;

import fr.treeptik.model.Categorie;
import fr.treeptik.model.Role;
import fr.treeptik.model.Utilisateur;

import fr.treeptik.service.CategorieService;

import fr.treeptik.validator.CategorieValidator;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {
	private final static Logger LOGGER = Logger
			.getLogger(CategorieController.class);

	@Autowired
	private CategorieValidator categorieValidator;

	@Autowired
	private CategorieService categorieService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/categorie.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		List<Role> roles = roleDAO.findAll();

		ModelAndView modelAndView = new ModelAndView("categorie", "categorie",
				new Categorie());
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Categorie categorie = categorieService.find(id);
		ModelAndView modelAndView = new ModelAndView("categorie", "categorie", categorie);
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listCategorie(HttpServletRequest request)
			throws ServiceException, DAOException {
		String categorieNom = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		if (request.getSession().getAttribute("userSessionId") == null) {
			Categorie categorie = categorieService.findByName(categorieNom);
			request.getSession().setAttribute("userSessionId", categorie.getId());
		}
		return new ModelAndView("list-categorie", "categories",
				categorieService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		categorieService.delete(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView saveCategorie(Categorie categorie, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("categorie");

		categorieValidator.validate(categorie, result);

		if (result.hasErrors()) {
			for (ObjectError objectError : result.getAllErrors()) {
				LOGGER.info(objectError.getDefaultMessage());
			}

			categorie = new Categorie();

			List<Role> roles = roleDAO.findAll();
			modelAndView.addObject("categorie", categorie);
			modelAndView.addObject("roles", roles);
			return modelAndView;
		}
		categorie = categorieService.createCategorie(categorie);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}

}
