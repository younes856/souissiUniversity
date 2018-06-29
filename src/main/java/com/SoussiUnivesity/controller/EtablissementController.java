package com.SoussiUnivesity.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SoussiUnivesity.entities.Etablissement;
import com.SoussiUnivesity.service.EtablissementService;
@Controller
public class EtablissementController implements Serializable {

	@Autowired
	private EtablissementService etablissementService ;
	
	@RequestMapping(value="addOrUpdateEtablissementRedirect")
	public String addOrUpdateEtablissement(Model model ,@RequestParam(defaultValue="") String id ,
			@RequestParam(defaultValue="") String message , Etablissement etablissement )
	{
		model.addAttribute("message", "".equals(message) ? "" : message);
		model.addAttribute("etablissement", "".equals(id) ? etablissement == null ? new Etablissement() : etablissement : etablissementService.getEtablissementById(id) );
		return "etablissement/addOrUpdateEtablissement";
	}
	
	@RequestMapping(value="addOrUpdateEtablissement", method=RequestMethod.POST)
	public ModelAndView addOrUpdateEtablissement(RedirectAttributes redirectAttributes , Etablissement etablissement)
	{
		Long id = etablissement.getId();
		ModelAndView modelAndView =null ;
		if(etablissementService.addOrUpdateEtablissement(etablissement))
		{
			modelAndView = new ModelAndView("redirect:/getEtablissements" , "message" ,
											id ==  null ? "Etablissment Ajouter avec Succes" : 
												"Etablissment Modifier avec Succes");
		}
		else
		{
			redirectAttributes.addFlashAttribute("etablissement", etablissement);
			modelAndView = new ModelAndView("redirect:/addOrUpdateEtablissementRedirect" , "message" ,
					id ==  null ? "Etablissment Ajouter avec Succes" : 
						"Etablissment Modifier avec Succes");
		}
		return modelAndView ;
	}
	
	@RequestMapping(value="getEtablissements")
	public String getEtablissements(Model model ,@RequestParam(defaultValue="") String message)
	{
		model.addAttribute("message", "".equals(message) ? "" : message);
		model.addAttribute("etablissements", etablissementService.getEtablissements());
		return "etablissement/getEtablissements";
	}
	
	@RequestMapping(value="deleteEtablissement")
	public ModelAndView deleteEtablissement(String id)
	{
		etablissementService.deleteEtablissement(etablissementService.getEtablissementById(id));
		return new ModelAndView("redirect:/getEtablissements" , "message" , "supréssion avec succès");
	}
	}
