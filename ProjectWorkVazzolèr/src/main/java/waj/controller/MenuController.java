package waj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@GetMapping("/")
	public String inviaLogin() {
		return "login";
	}
	
	@GetMapping("/menuAdmin")
	public String inviaAdmin() {
		return "menuAdmin";
	}
	
	@GetMapping("/menuCliente")
	public String inviaCliente() {
		return "menuCliente";
	}
	
	
}
