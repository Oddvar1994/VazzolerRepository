package waj.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="utenti")
public class Utente {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cod_utente")
    private Integer codUtente;
	
	@NotBlank(message="nome obbligatorio")
    @Size(min=3, max=20, message="minimo 3/massimo 20 caratteri")
	@Column(name = "nome")
	private String nome;
	 
	@NotBlank(message="cognome obbligatorio")
    @Size(min=3, max=20, message="minimo 3/massimo 20 caratteri")
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "ruolo")
	private String ruolo;
	
	@NotBlank(message="email obbligatoria")
    @Pattern(regexp = "(.+?)@(.+?)", message="email non valida")
    @Column(name = "email")
    private String email;
	
	@NotBlank(message="username obbligatorio")
    @Size(min=3, max=20, message="minimo 3/massimo 20 caratteri")
    @Column(name = "username")
    private String username;
	
	@NotBlank(message="password obbligatoria")
    @Column(name="pwd")
    private String password;
	 
	@NotNull(message="data di nascita obbligatoria")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_nascita")
	private LocalDate dataNascita;
	
	
	public Utente() {
		super();
	}


	public Integer getCodUtente() {
		return codUtente;
	}


	public void setCodUtente(Integer codUtente) {
		this.codUtente = codUtente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getRuolo() {
		return ruolo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}


	@Override
	public String toString() {
		return "Utente=" + codUtente + ", nome=" + nome + ", cognome=" + cognome + ", ruolo=" + ruolo
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", dataNascita="
				+ dataNascita;
	}

}
	
	
	
	


