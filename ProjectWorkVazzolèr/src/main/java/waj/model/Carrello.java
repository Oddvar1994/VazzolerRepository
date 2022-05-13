package waj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carrello")
public class Carrello {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_carrello")
	private Integer idCarrello;
	
	@Column(name = "cod_prodotto")
	private Integer codProdotto; 
	
	@Column(name = "quantita")
	private Integer quantita;
	
	@Column(name = "cod_utente")
	private Integer codUtente;

	public Carrello() {
		super();
	}

	public Integer getIdCarrello() {
		return idCarrello;
	}

	public void setIdCarrello(Integer idCarrello) {
		this.idCarrello = idCarrello;
	}

	public Integer getCodProdotto() {
		return codProdotto;
	}

	public void setCodProdotto(Integer codProdotto) {
		this.codProdotto = codProdotto;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	
	public Integer getCodUtente() {
		return codUtente;
	}

	public void setCodUtente(Integer codUtente) {
		this.codUtente = codUtente;
	}

	@Override
	public String toString() {
		return "Carrello=" + codProdotto + ", quantita=" + quantita + ", codUtente=" + codUtente;
	}
	
	

}
