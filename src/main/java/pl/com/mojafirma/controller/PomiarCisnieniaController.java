package pl.com.mojafirma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(PomiarCisnieniaController.class);
	
	@RequestMapping(value = "/{osobaId}", method=RequestMethod.GET)
	public String getPomiaryOfOsoba(@PathVariable("osobaId") Integer id, Model model) {
		List<Pomiar_Cisnienia> pomiary = pomiar_CisnieniaService.gellAllPomiaryByOsobaId(id);
		
		Osoba osoba = osobaService.getOsobaById(id);		
		model.addAttribute("pomiary", pomiary);
		
		model.addAttribute("osoba", osoba);
		model.addAttribute("pomiar", new Pomiar_Cisnienia());
		return "pomiary";
	}
	
	@RequestMapping(value = "/{osobaId}", method=RequestMethod.POST)
	public String addPomiar(@ModelAttribute("pomiar") Pomiar_Cisnienia pomiar, @PathVariable("osobaId") Integer osobaId,
			BindingResult bindingResult, Model model) {
		pomiar.setId(100);
		pomiar.setOsoba(osobaService.getOsobaById(osobaId));
		
		logger.info("Zapis pomiaru: " + pomiar.toString());
		
		if(bindingResult.hasErrors()) {
			logger.info("Binding error " + bindingResult.toString());
			return "osoby";
		}
		
		if(!pomiar_CisnieniaService.addPomiar(pomiar)) {
			logger.info("Saving pomiar " + pomiar.toString());
			return "osoby";
		}
		return "redirect:/osoba/pomiary/{osobaId}";	
	}
}
