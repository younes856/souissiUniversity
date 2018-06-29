package com.SoussiUnivesity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SoussiUnivesity.entities.Compte;
import com.SoussiUnivesity.service.CompteService;

@Controller
public class CompteController {

	@Autowired
	private CompteService compteService ;
	
	@RequestMapping(value="addOrUpdateCompteRedirect" , method = RequestMethod.GET)
	public String addOrUpdateCompte(Model model ,@RequestParam(defaultValue="") String message ,Compte compte , @RequestParam(defaultValue="") String id)
	{
		model.addAttribute("message" , "".equals(message) ? "" : message ); 
		model.addAttribute("compte", "".equals(id) ? compte == null ? new Compte() : compte : compteService.getCompteById(id) );
		return "compte/addOrUpdateCompte";
	}
	
	@RequestMapping(value="addOrUpdateCompte", method=RequestMethod.POST)
	public ModelAndView addOrUpdateCompte (RedirectAttributes redirectAttributes , Compte compte )
	{
		Long id = compte.getId();
		ModelAndView modelAndView = null ;
		if(compteService.addOrUpdateCompte(compte))
		{
			
			modelAndView = new ModelAndView("redirect:/getComptes" , "message" , 
											id == null ? "Compte Ajouter Avec Succès" : 
												"Compte Modifier Avec Succès");
		}
		else
		{
			redirectAttributes.addFlashAttribute("compte", compte);
			modelAndView = new ModelAndView("redirect:/addOrUpdateCompteRedirect" , "message" , 
					compte.getNum() + " existe déjà ");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="getComptes" )
	public String getComptes (Model model,@RequestParam(defaultValue="") String message)
	{
		model.addAttribute("message", "".equals(message) ? "":message); 
		model.addAttribute("comptes", compteService.getComptes());
		return "compte/getComptes";
	}
	
	@RequestMapping(value="deleteCompte")
	public ModelAndView deleteCompte(String id)
	{
		compteService.deleteCompte(compteService.getCompteById(id));
		return new ModelAndView("redirect:/getComptes", "message" , "supréssion avec Succès") ;
	}
}

