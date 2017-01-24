package hotel;

import db.Intervallo;

public class Prenotazione {

	private Utente utente;
	private Intervallo intervallo;
	private Stanza stanza;
	private String note;
	
	public Prenotazione(Utente utente, Intervallo intervallo,
			Stanza stanza, String note) {
		super();
		this.utente = utente;
		this.intervallo = intervallo;
		this.stanza = stanza;
		this.note = note;
	}

	public Utente getUtente() {
		return utente;
	}

	public Prenotazione setUtente(Utente utente) {
		this.utente = utente;
		return this;
	}

	public Intervallo getIntervallo() {
		return intervallo;
	}

	public void setIntervallo(Intervallo intervallo) {
		this.intervallo = intervallo;
	}
	
	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}

	public String getNote() {
		return note;
	}

	public Prenotazione setNote(String note) {
		this.note = note;
		return this;
	}
	
	public String toString(){
		return "Utente: " + this.getUtente().getCognome() + "\n" +
				"data arrivo: " + getIntervallo().d1 +
				"\ndata ritorno: " + getIntervallo().d2 +
				"\nStanza: " + getStanza().scheda();
	}
	
}
