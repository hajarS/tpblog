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
import fr.treeptik.model.Article;
import fr.treeptik.model.Role;
import fr.treeptik.model.Utilisateur;
import fr.treeptik.service.ArticleService;
import fr.treeptik.validator.ArticleValidator;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	private final static Logger LOGGER = Logger
			.getLogger(ArticleController.class);

	@Autowired
	private ArticleValidator articleValidator;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/article.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		List<Role> roles = roleDAO.findAll();

		ModelAndView modelAndView = new ModelAndView("article", "article",
				new Article());
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Article article = articleService.find(id);
		ModelAndView modelAndView = new ModelAndView("article", "article", article);
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listArticle(HttpServletRequest request)
			throws ServiceException, DAOException {
		String articleNom = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		if (request.getSession().getAttribute("userSessionId") == null) {
			Article article = articleService.findByName(articleNom);
			request.getSession().setAttribute("userSessionId", article.getId());
		}
		return new ModelAndView("list-article", "articles",
				articleService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		articleService.delete(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView saveArticle(Article article, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("article");

		articleValidator.validate(article, result);

		if (result.hasErrors()) {
			for (ObjectError objectError : result.getAllErrors()) {
				LOGGER.info(objectError.getDefaultMessage());
			}

			article = new Article();

			List<Role> roles = roleDAO.findAll();
			modelAndView.addObject("article", article);
			modelAndView.addObject("roles", roles);
			return modelAndView;
		}
		article = articleService.createArticle(article);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}

}
