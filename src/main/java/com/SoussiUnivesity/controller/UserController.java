package com.SoussiUnivesity.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SoussiUnivesity.dao.UserDao;
import com.SoussiUnivesity.entities.User;
import com.SoussiUnivesity.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService ;
	
	@RequestMapping(value="addOrUpdateUserRedirect" , method=RequestMethod.GET)
	public String addOrUpdateUser(Model model , User user,@RequestParam(defaultValue="") String message,
									@RequestParam(defaultValue="") String id )
	{
		model.addAttribute("user", "".equals(id) ? user == null ? new User() : user : userService.getUserById(id));
		model.addAttribute("message", "".equals(message)?"":message);
		return "user/addOrUpdateUser";
	}
	
	@RequestMapping(value="addOrUpdateUser" , method=RequestMethod.POST)
	public ModelAndView addOrUpdateUser(User user , RedirectAttributes redirectAttributes)
	{
		Long id = user.getId();
		String message = ""; 
		ModelAndView modelAndView = null ;
		if(userService.addOrUpdateUser(user))
		{
			message = id == null  ? "Utilisateur Ajouter" : "Utilisateur Modifier";
			modelAndView = new ModelAndView("redirect:/getUsers","message" ,message );
		}	
		else
		{
			message= user.getLogin() +" existe déjà";
			redirectAttributes.addFlashAttribute("user", user);
			modelAndView = new ModelAndView("redirect:/addOrUpdateUserRedirect","message", message);
		}
			
		return modelAndView;
	}
	
	@RequestMapping(value="getUsers")
	public String getUers(Model model ,@RequestParam(defaultValue="") String message)
	{
		model.addAttribute("message", "".equals(message)?"":message);
		model.addAttribute("users", userService.getUsers());
		return "user/getUsers";
	}
	
	@RequestMapping(value="deleteUser")
	public ModelAndView deleteUser(RedirectAttributes redirectAttributes ,@RequestParam(defaultValue="") String id)
	{
		userService.deleteUser(userService.getUserById(id));
		return new ModelAndView("redirect:/getUsers","message","Suppression avec succès ");
	}
	
}
