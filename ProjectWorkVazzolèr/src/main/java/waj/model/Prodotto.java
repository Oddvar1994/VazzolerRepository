package waj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodotti")
public class Prodotto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cod_prodotto")
	private Integer codProdotto; 
	
	@Column(name = "nome")
    private String nome;  
	
	@Column(name = "tipo_prodotto")
    private String tipoProdotto;
	
	@Column(name = "prezzo")
    private Double prezzo; 

	public Prodotto() {
		super();
	}

	public Integer getCodProdotto() {
		return codProdotto;
	}

	public void setCodProdotto(Integer codProdotto) {
		this.codProdotto = codProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Prodotto=" + codProdotto + ", nome=" + nome + ", tipoProdotto=" + tipoProdotto
				+ ", prezzo=" + prezzo;
	}

	 
	
	
	

}
