package pl.com.mojafirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.com.mojafirma.model.Osoba;
import pl.com.mojafirma.model.Pomiar_Cisnienia;
import pl.com.mojafirma.service.OsobaService;
import pl.com.mojafirma.service.Pomiar_CisnieniaService;

@Controller
@RequestMapping("/osoba/pomiary")
public class PomiarCisnieniaController {
	
	@Autowired
	private Pomiar_CisnieniaService pomiar_CisnieniaService;
	
	@Autowired
	private OsobaService osobaService;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public String getPomiaryOfOsoba(@PathVariable("id") Integer id, Model model) {
		List<Pomiar_Cisnienia> pomiary = pomiar_CisnieniaService.gellAllPomiaryByOsobaId(id);
		Osoba osoba = osobaService.getOsobaById(id);		
		model.addAttribute("pomiary", pomiary);
		model.addAttribute("osoba", osoba);
		return "pomiary";
	}
	
	public String addPomiar(@ModelAttribute("pomiar") Pomiar_Cisnienia pomiar, 
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			
		}
		
		
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	

}
