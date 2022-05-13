package way.dto;

public class ProdottoCarrelloDto {
	
	private Integer idCarrello;
	private Integer codProdotto; 
    private String nome;  
    private String tipoProdotto;
    private Double prezzo; 
    private Integer quantita;
    
	public ProdottoCarrelloDto(Integer idCarrello, Integer codProdotto, String nome, String tipoProdotto, Double prezzo, Integer quantita) {
		super();
		this.idCarrello = idCarrello; 
		this.codProdotto = codProdotto;
		this.nome = nome;
		this.tipoProdotto = tipoProdotto;
		this.prezzo = prezzo;
		this.quantita = quantita;
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

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
    
	
    
}
