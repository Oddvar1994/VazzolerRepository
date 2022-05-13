package waj.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import waj.db.UtenteRepository;
import waj.model.Utente;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;

	public String login(String username, String password, HttpServletRequest request, Model model) 
	{

		Utente utente = utenteRepo.findByUsernameAndPassword(username, password);

		if(utente == null)
		{
			System.out.print("Account inesistente");
			return "login";
		}
		 else 
	 	{
			 request.getSession().setAttribute("utente", utente);
			 System.out.print("account esistente");
			 if(utente.getRuolo().equalsIgnoreCase("admin")) 
			{
				return "menuAdmin";
			}
			 else 
			{
				model.addAttribute("utente", utente);
				System.out.println("UTENTE: " + request.getSession().getAttribute("utente"));
				return "menuCliente";
			}
	 	}
   }
	
	
	
	
	
	
	
	
}
