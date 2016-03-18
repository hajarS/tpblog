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
import fr.treeptik.model.Auteur;
import fr.treeptik.model.Role;
import fr.treeptik.model.Utilisateur;
import fr.treeptik.service.AuteurService;
import fr.treeptik.validator.AuteurValidator;

@Controller
@RequestMapping(value = "/auteur")
public class AuteurController {
	private final static Logger LOGGER = Logger
			.getLogger(AuteurController.class);

	@Autowired
	private AuteurValidator auteurValidator;

	@Autowired
	private AuteurService auteurService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/auteur.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		List<Role> roles = roleDAO.findAll();

		ModelAndView modelAndView = new ModelAndView("auteur", "auteur",
				new Auteur());
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Auteur auteur = auteurService.find(id);
		ModelAndView modelAndView = new ModelAndView("auteur", "auteur", auteur);
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listAuteur(HttpServletRequest request)
			throws ServiceException, DAOException {
		String auteurNom = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		if (request.getSession().getAttribute("userSessionId") == null) {
			Auteur auteur = auteurService.findByName(auteurNom);
			request.getSession().setAttribute("userSessionId", auteur.getId());
		}
		return new ModelAndView("list-auteur", "auteurs",
				auteurService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		auteurService.delete(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView saveAuteur(Auteur auteur, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("auteur");

		auteurValidator.validate(auteur, result);

		if (result.hasErrors()) {
			for (ObjectError objectError : result.getAllErrors()) {
				LOGGER.info(objectError.getDefaultMessage());
			}

			auteur = new Auteur();

			List<Role> roles = roleDAO.findAll();
			modelAndView.addObject("auteur", auteur);
			modelAndView.addObject("roles", roles);
			return modelAndView;
		}
		auteur = auteurService.createAuteur(auteur);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}

}
