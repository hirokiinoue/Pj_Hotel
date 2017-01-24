package hotel;

public class Utente {

	private int id;
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String tipo;
	private String descrizione;
		
	public Utente(String email, String password, String nome, String cognome,
			String tipo, String descrizione) {
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.tipo = tipo;
		this.descrizione = descrizione;
	}

	public Utente(int id, String email, String password, String nome, String cognome,
			String tipo, String descrizione) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.tipo = tipo;
		this.descrizione = descrizione;
	}

	public int getId() {
		return this.id;
	}

	public Utente setId(int id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Utente setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Utente setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Utente setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCognome() {
		return cognome;
	}

	public Utente setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	public String getTipo() {
		return tipo;
	}

	public Utente setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	@Override
	public String toString() {
		return "Utente [email=" + email + ", password=" + password + ", nome="
				+ nome + ", cognome=" + cognome + ", tipo=" + tipo + "]";
	}
	
	
	
}
