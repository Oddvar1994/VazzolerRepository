package waj.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import waj.db.ProdottoRepository;
import waj.model.CriteriProdotto;
import waj.model.Prodotto;



@Controller
public class ProdottoController {
	
	public static final String PRODOTTO = "prodotto";
	public static final String PRODOTTI = "prodotti";
	public static final String CRITERI = "criteri";
	public static final String LISTINOPRODOTTI = "listinoProdotti";
	public static final String PRODOTTISELEZ = "prodottiSelez";
	
	@Autowired
	private ProdottoRepository prodottoRepo;
	
	
	//Admin:
		@GetMapping("/visualizzaProdotti")
		public String visualizzaProdotto(Model model) {
			Iterable<Prodotto> prodotti = prodottoRepo.findAll();
			model.addAttribute(PRODOTTI, prodotti);
			return PRODOTTI;
		}

		@GetMapping("/inserisciProdotto")
		public String inserisciProdotto(Model model) {
			model.addAttribute(PRODOTTO, new Prodotto());
			List<String> listTipiProdotto = Arrays.asList("alimentari", "tabacco","elettrodomestici", "bevande");
			model.addAttribute("listTipiProdotto", listTipiProdotto);
			return "inserisciProdotto";
		}
		
		@PostMapping("/inserisciProdotto")
		public String inserisciProdotto(@Valid @ModelAttribute (PRODOTTO) Prodotto prodotto, Errors errors, Model model) {
			if (errors.hasErrors()) {
				return "inserisciProdotto";
			} 
			prodottoRepo.save(prodotto); 
			model.addAttribute(PRODOTTO, prodotto);
			return "menuAdmin";
		}

		
		
	//Cliente:
		@GetMapping("/visualizzaListino")
		public String visualizzaListino(Model model) {
			Iterable<Prodotto> listinoProdotti = prodottoRepo.findAll();
			model.addAttribute(PRODOTTI, listinoProdotti);
			return LISTINOPRODOTTI;
		}
		
		@GetMapping("/selezionaProdotto")
		public String findProdottiByPrezzoAndTipoProdotto(Model model) {
			model.addAttribute(CRITERI, new CriteriProdotto());
			List<String> listTipiProdotto = Arrays.asList("alimentari", "tabacco","elettrodomestici", "bevande");
			model.addAttribute("listTipiProdotto", listTipiProdotto);
			return "criteriProdotto";
		}
		@PostMapping("/selezionaProdotto")
		public String findProdottiByPrezzoAndTipoProdotto(@ModelAttribute ("criteriProdotto") CriteriProdotto criteriProdotto, Model model) {
			Iterable<Prodotto> prodottiSelez = prodottoRepo.findProdottiByPrezzoAndTipoProdotto(criteriProdotto.getPrezzo(), criteriProdotto.getTipoProdotto());
			model.addAttribute(PRODOTTI, prodottiSelez);
		    return PRODOTTISELEZ;
		}
		
		
		
}
