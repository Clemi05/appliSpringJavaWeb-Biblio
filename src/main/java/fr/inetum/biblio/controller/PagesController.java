package fr.inetum.biblio.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PagesController {

	@RequestMapping("/")
	public String home() {
		return "pages/home";
	}
	
	@RequestMapping("/profil")
	public String profil(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(nom != null && prenom != null && email != null && password != null) {
			return "profil";
		}
		return "pages/home";
	}
}
