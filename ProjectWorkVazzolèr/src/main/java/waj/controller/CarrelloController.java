package waj.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import waj.db.CarrelloRepository;
import waj.db.ProdottoRepository;
import waj.model.Carrello;
import waj.model.Prodotto;
import waj.model.Utente;
import way.dto.ProdottoCarrelloDto;

@Controller
public class CarrelloController {
	
	public static final String PRODOTTOCARRELLO = "prodottoCarrello";
	public static final String PRODOTTICARRELLO = "prodottiCarrello";
	
	@Autowired
	private CarrelloRepository carrelloRepo;
	@Autowired
	private ProdottoRepository prodottoRepo;
	
	
	
	
	@GetMapping("/visualizzaCarrello")
	public String visualizzaCarrello(Model model, HttpServletRequest request) {
		
		System.out.println("UTENTE: " + request.getSession().getAttribute("utente"));
		Utente utente = (Utente)request.getSession().getAttribute("utente");
		Integer codUtente = utente.getCodUtente();
		
		List<Carrello> prodottiCarrello = carrelloRepo.findByCodUtente(codUtente);
		
		model.addAttribute(PRODOTTICARRELLO, prodottiCarrello.stream().map(e-> getProdottiCarrello(e.getIdCarrello(), e.getCodProdotto(),
				e.getQuantita())).collect(Collectors.toList()));
		return PRODOTTICARRELLO;
	}
	
	public ProdottoCarrelloDto getProdottiCarrello(Integer idCarrello, Integer codProdotto, Integer quantita) {
		Prodotto prodotto = prodottoRepo.findById(codProdotto).orElse(new Prodotto());
		return new ProdottoCarrelloDto(idCarrello, prodotto.getCodProdotto(),
				prodotto.getNome(), prodotto.getTipoProdotto(), prodotto.getPrezzo(), quantita);
	}
	
	
	@GetMapping("/inserisciProdottoNelCarrello")
	public String inserisciProdottoNelCarrello(@RequestParam Integer codProdotto, Model model, HttpServletRequest request) {
		model.addAttribute(PRODOTTICARRELLO, new Prodotto());
		
		Utente utente = (Utente)request.getSession().getAttribute("utente");
		Integer codUtente = utente.getCodUtente();

		System.out.println("COD PRODOTTO: " + codProdotto);
		System.out.println("COD UTENTE: " + codUtente);
		
		Carrello carrelloDoppione = carrelloRepo.findByCodProdottoAndCodUtente(codProdotto, codUtente);

		if(carrelloDoppione==null) 
		{
			
			Carrello carrello = new Carrello();
			carrello.setCodProdotto(codProdotto);
			carrello.setCodUtente(codUtente);
			carrello.setQuantita(1);
			
			carrelloRepo.save(carrello);
			
		} 
		else
		{
			
			carrelloDoppione.setQuantita(carrelloDoppione.getQuantita()+1);
			carrelloRepo.save(carrelloDoppione);
			
		}
		
		return "redirect:visualizzaCarrello";
	}
	
	@PostMapping("/inserisciProdottoNelCarrello")
	public String inserisciProdottoNelCarrello(@ModelAttribute (PRODOTTICARRELLO) Carrello carrello, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "inserisciProdottoNelCarrello";
		} 
		carrelloRepo.save(carrello); 
		model.addAttribute(PRODOTTOCARRELLO, carrello);
		return PRODOTTICARRELLO; 
	}
	
	@GetMapping("/eliminaCarrello")
	public String eliminaCarrello(@RequestParam Integer idCarrello, HttpServletRequest request) {
		
		Carrello carrelloDaEliminare = carrelloRepo.findById(idCarrello).orElse(null);
		
		if(carrelloDaEliminare!=null) {
			carrelloRepo.delete(carrelloDaEliminare);
		}
		
		return "redirect:visualizzaCarrello"; 
	}

	

}
