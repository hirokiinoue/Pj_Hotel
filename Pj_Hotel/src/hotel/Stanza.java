package hotel;

import java.util.ArrayList;

import db.Intervallo;

public class Stanza {

	private ArrayList<Extra> extra = null;
	private ArrayList<Prenotazione> prenotazioni = null;
	private String codice;
	private double costo;
	private boolean fumatori;
	private int npersone;
	
	public Stanza(ArrayList<Extra> extra, ArrayList<Prenotazione> prenotazioni,
			String codice, double costo, boolean fumatori, int npersone) {
		this.extra = extra;
		this.prenotazioni = prenotazioni;
		this.codice = codice;
		this.costo = costo;
		this.fumatori = fumatori;
		this.npersone = npersone;
	}

	public Stanza(String codice, double costo, boolean fumatori, int npersone) {
		this.extra = new ArrayList<Extra>();
		this.prenotazioni = new ArrayList<Prenotazione>();
		this.codice = codice;
		this.costo = costo;
		this.fumatori = fumatori;
		this.npersone = npersone;
	}

	
	public ArrayList<Extra> getExtra() {
		return extra;
	}

	public Stanza setExtra(ArrayList<Extra> extra) {
		this.extra = extra;
		return this;
	}

	public ArrayList<Prenotazione> getPrenotazione() {
		return prenotazioni;
	}

	public Stanza setPrenotazione(ArrayList<Prenotazione> prenotazione) {
		this.prenotazioni = prenotazione;
		return this;
	}
	
	public boolean nuovaPrenotazione(Intervallo intervallo, Utente utente)
	{
		boolean ris=false;
		for(Prenotazione p: prenotazioni)
			if(p.getIntervallo().collide(intervallo))
				ris=true;
		if(!ris)
			prenotazioni.add(new Prenotazione(utente,intervallo,this,""));
		
		
		return ris;
		
	}
	
	public String stampaPrenotazioni(){
		String ris = "";
		for(Prenotazione p: prenotazioni)
			ris += p.toString();
		
		return ris;
	}

	public String stampaPrenotazioni(Intervallo i){
		String ris = "";
		for(Prenotazione p: prenotazioni)
			if(i.interno(p.getIntervallo()))
				ris += p.toString();
		
		return ris;
	}

	public Stanza addExtra(Extra e){
		boolean trovato = false;
		for(Extra x:extra)
			if(x.getcodice().equals(e.getcodice()))
				trovato = true;
		if(!trovato)		
			this.extra.add(e);
		return this;
		
	}
	public String getCodice() {
		return codice;
	}

	public Stanza setCodice(String codice) {
		this.codice = codice;
		return this;
	}

	public double getCosto() {
		return costo;
	}

	public Stanza setCosto(double costo) {
		this.costo = costo;
		return this;
	}

	public boolean getFumatori() {
		return fumatori;
	}

	public Stanza setFumatori(boolean fumatori) {
		this.fumatori = fumatori;
		return this;
	}
	
	public int getNpersone() {
		return npersone;
	}

	public Stanza setNpersone(int npersone) {
		this.npersone = npersone;
		return this;
	}

	public String scheda(){
		double totale=costo;
		String ris = "La stanza " +codice +" per "+npersone+ " persone, viene " + costo + " € a notte."
				+"\nFumatori: "+fumatori;
		try
		{
			if (extra!=null)
				ris += "\nLa stanza è fornita dei seguenti extra:\n";
			for(Extra e:extra)
			{
				ris += e.getDescrizione() + " al costo di " + e.getPrezzo() + " €\n";
				totale+=e.getPrezzo();
			}
		}
		catch(Exception e)
		{
			ris += "\nLa tua stanza non è fornita di alcun extra";
		}
		
		ris += "\n\nTOTALE COSTO DELLA STANZA: " +totale +" €.";
		return ris;
	}
	
}
