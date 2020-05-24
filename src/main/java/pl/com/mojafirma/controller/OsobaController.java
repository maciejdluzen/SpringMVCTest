package pl.com.mojafirma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.com.mojafirma.model.Osoba;
import pl.com.mojafirma.service.OsobaService;

@Controller
@RequestMapping("/osoba")
public class OsobaController {
	
	@Autowired
	private OsobaService osobaService;
	
	private static final Logger logger = LoggerFactory.getLogger(OsobaController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String getOsoby(@ModelAttribute("osoba") Osoba osoba, Model model) {
		List<Osoba> osoby = osobaService.getAllOsoby();
		model.addAttribute("osoby", osoby);
		return "osoby";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addOsoba(@ModelAttribute("osoba") Osoba osoba, BindingResult bindingResult, Model model) {
		
		List<Osoba> osoby = osobaService.getAllOsoby();
		model.addAttribute("osoby", osoby);
		
		if(bindingResult.hasErrors()) {
			logger.info("Binding error: " + bindingResult.toString());
			return "osoby";
		}
		
		if(!osobaService.addOsoba(osoba)) {
			model.addAttribute("parkingError", 1);
			return "osoby";
		}
		return "redirect:osoba";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
