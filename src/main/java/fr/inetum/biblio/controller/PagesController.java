package fr.inetum.biblio.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.inetum.biblio.model.Abonne;
import fr.inetum.biblio.model.AbonneRepository;

@Controller
public class PagesController {
	@Autowired
	private AbonneRepository abonneRepository;
	
	@PostMapping(path="/abonnes")
	public @ResponseBody String addNewAbonne (@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam Date dob, @RequestParam String password) {
		Abonne abonne = new Abonne();
		abonne.setNom(nom);
		abonne.setPrenom(prenom);
		abonne.setEmail(email);
		abonne.setDateNaissance(dob);
		abonneRepository.save(abonne);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Abonne> getAllAbonnes() {
	    // This returns a JSON or XML with the users
	    return abonneRepository.findAll();
	  }
	
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
