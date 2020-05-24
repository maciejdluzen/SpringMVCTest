package pl.com.mojafirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.com.mojafirma.model.Osoba;
import pl.com.mojafirma.service.OsobaService;

@Controller
public class OsobaController {
	
	@Autowired
	private OsobaService osobaService;
	
	@RequestMapping(value="/osoba", method=RequestMethod.GET)
	public String getOsoby(@ModelAttribute("osoba") Osoba osoba, Model model) {
		List<Osoba> osoby = osobaService.getAllOsoby();
		model.addAttribute("osoby", osoby);
		return "osoby";
	}
}
