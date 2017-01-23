package hotel;

public class Extra {

	private String codice;
	private String descrizione;
	private Double prezzo;
	
	public Extra(String codice, String descrizione, Double prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public String getcodice() {
		return codice;
	}

	public Extra setcodice(String codice) {
		this.codice = codice;
		return this;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public Extra setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public Extra setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
		return this;
	}
	
	
	
}
