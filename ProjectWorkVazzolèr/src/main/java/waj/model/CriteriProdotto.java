package waj.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CriteriProdotto {
 
	@NotNull(message = "prezzo obbligatorio")
	private Double prezzo;
	@NotBlank(message = "tipo prodotto obbligatorio")
	private String tipoProdotto;
    
    public CriteriProdotto() {
		super();
	}

	public String getTipoProdotto() {
		return tipoProdotto;
	}

	public void setTipoProdotto(String tipoProdotto) {
		this.tipoProdotto = tipoProdotto;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
    
    
}
