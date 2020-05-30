package pl.com.mojafirma.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.com.mojafirma.model.Osoba;
import pl.com.mojafirma.service.OsobaService;

@Controller
@RequestMapping(value="/osoba")
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
		osoba.setId(100);
		
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
	
	@RequestMapping(value = "/json/{id}", method = RequestMethod.GET)
	public @ResponseBody Osoba getOsobaJson(@PathVariable("id") Integer id) {
		return osobaService.getOsobaById(id);
	}
	
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public @ResponseBody List<Osoba> getOsobyJson() {
		return osobaService.getAllOsoby();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateOsoba(@PathVariable("id") Integer id, 
			@RequestBody Osoba osoba, HttpServletResponse response) {
		logger.info("PUT: Osoba = " + osoba);
		if(osobaService.editOsoba(id, osoba)) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteOsoba(@PathVariable("id") Integer id,
			HttpServletResponse response) {
		logger.info("DELETE: id = " + id);
		if(osobaService.removeOsoba(id)) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}
		
}
