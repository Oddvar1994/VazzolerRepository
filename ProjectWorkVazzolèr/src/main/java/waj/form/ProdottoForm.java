package waj.form;


public class ProdottoForm {
	
	private Integer codProdotto;
    private String nome;
    private String tipoProdotto;
    private Double prezzo; 
    private Integer codUtente;
	
	public ProdottoForm() {
		
	}

	public ProdottoForm(Integer codProdotto, String nome, String tipoProdotto, Double prezzo, Integer codUtente) {
		super();
		this.codProdotto = codProdotto;
		this.nome = nome;
		this.tipoProdotto = tipoProdotto;
		this.prezzo = prezzo;
		this.codUtente = codUtente;
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

	public Integer getCodUtente() {
		return codUtente;
	}

	public void setCodUtente(Integer codUtente) {
		this.codUtente = codUtente;
	}

	
	
	
 
}