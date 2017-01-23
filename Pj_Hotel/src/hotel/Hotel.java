package hotel;

import db.*;

public class Hotel {
	
	private Hotel instance = null;
	private String codice = null;
	private String nome = null;
	private String citta = null;
	private String indirizzo = null;
	private String cap = null;
	private String stelle = null;
	private String nomeproprietario = null;
	private String piva = null;
	private String emailproprietario = null;
	
	public Hotel (){
		DBHotel db = new DBHotel("jdbc:sqlite:C:\\Users\\corso1\\Desktop\\SQLiteStudio\\hotel");
	    
		codice = db.infoHotel().get(0);
		nome =  db.infoHotel().get(1);
		citta =  db.infoHotel().get(2);
		indirizzo =  db.infoHotel().get(3);
		cap =  db.infoHotel().get(4);
		stelle = (db.infoHotel().get(5));
		nomeproprietario =  db.infoHotel().get(6);
		piva =  db.infoHotel().get(7);
		emailproprietario =  db.infoHotel().get(8);
	}
	public synchronized Hotel getInstance()
	{
		if(instance==null) instance = new Hotel();
		return instance;
	}
	public String getCodice() {
		return codice;
	}
	public String getNome() {
		return nome;
	}
	public String getCitta() {
		return citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getCap() {
		return cap;
	}
	public String getStelle() {
		return stelle;
	}
	public String getNomeproprietario() {
		return nomeproprietario;
	}
	public String getPiva() {
		return piva;
	}
	public String getEmailproprietario() {
		return emailproprietario;
	}
	
	
}
