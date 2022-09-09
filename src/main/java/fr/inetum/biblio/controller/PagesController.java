package fr.inetum.biblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

	@RequestMapping("/")
	public String home() {
		return "pages/home";
	}
	@RequestMapping("/emprunts")
	public String emprunts() {
		return "pages/emprunts";
	}
	
	@RequestMapping("/abonnes")
	public String abonnes() {
		return "pages/abonnes";
	}
	
	@RequestMapping("/livres-dispo")
	public String livres() {
		return "pages/livres-dispo";
	}
	
	@RequestMapping("/recherche")
	public String recherche() {
		return "pages/recherche";
	}
	
}
