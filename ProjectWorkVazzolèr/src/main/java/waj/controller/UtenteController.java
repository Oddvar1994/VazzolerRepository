package waj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import waj.db.UtenteRepository;
import waj.model.Utente;
import waj.service.UtenteService;

@Controller
public class UtenteController {

	public static final String UTENTE = "utente";
	public static final String UTENTI = "utenti";
	
	@Autowired
	private UtenteRepository utenteRepo;
	
	@Autowired 
	private UtenteService utenteService;
	
	
	//Registrazione:
	@GetMapping("/registrazione")
	public String inserisciUtente(Model model) {
		model.addAttribute(UTENTE, new Utente());
		return "registrazione";
	}
	
	@PostMapping("/registrazione")
	public String inserisciUtente(@Valid @ModelAttribute (UTENTE) Utente utente, Errors errors, Model model) {
		
		utente.setRuolo("cliente");
//		if (errors.hasErrors()) {
//			return "registrazione";
//		}
		
		utenteRepo.save(utente);
		model.addAttribute(UTENTE, utente);
		return "login";
	}
	
	//Login:
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String submitLoginIn(@ModelAttribute("login") Utente utente, HttpServletRequest request, Model model) {
		return utenteService.login(utente.getUsername(), utente.getPassword(), request, model);
        } 
	
	
	
	
	
	
	
	
}
