package fr.treeptik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import fr.treeptik.model.Utilisateur;
import fr.treeptik.model.Role;
import fr.treeptik.service.UtilisateurService;
import fr.treeptik.validator.UtilisateurValidator;

@Controller
@RequestMapping(value = "/utilisateur")
public class UtilisateurController {

	private final static Logger LOGGER = Logger
			.getLogger(UtilisateurController.class);

	@Autowired
	private UtilisateurValidator utilisateurValidator;

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/utilisateur.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		List<Role> roles = roleDAO.findAll();

		// nom de la vue , voir dispatcher-servlet qui donne le chemin
		ModelAndView modelAndView = new ModelAndView("utilisateur");
		// On ajoute un client vide
		modelAndView.addObject("utilisateur", new Utilisateur());
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	// quel client on va updater
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Utilisateur utilisateur = utilisateurService.findById(id);
		ModelAndView modelAndView = new ModelAndView("utilisateur", "utilisateur", utilisateur);
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listUtilisateur(HttpServletRequest request)
			throws ServiceException {
		String utilisateurNom = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		if (request.getSession().getAttribute("userSessionId") == null) {
			Utilisateur utilisateur = utilisateurService.findByName(utilisateurNom);
			request.getSession().setAttribute("userSessionId", utilisateur.getId());
		}
		return new ModelAndView("list-utilisateur", "utilisateurs",
				utilisateurService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		utilisateurService.remove(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView saveUtilisateur(@Valid Utilisateur utilisateur, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("utilisateur");

		utilisateurValidator.validate(utilisateur, result);

		if (result.hasErrors()) {
			for (ObjectError objectError : result.getAllErrors()) {
				LOGGER.info(objectError.getDefaultMessage());
			}
			utilisateur.setNom(null);
			utilisateur.setPassword(null);
//			client = new Client();

			List<Role> roles = roleDAO.findAll();
			modelAndView.addObject("utilisateur", utilisateur);
			modelAndView.addObject("roles", roles);
			return modelAndView;
		}
		utilisateur = utilisateurService.save(utilisateur);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}

}
