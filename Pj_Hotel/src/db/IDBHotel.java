package db;

import hotel.*;
import java.util.ArrayList;

public interface IDBHotel {

	Stanza caricaStanza(String codice);
	ArrayList<Stanza> caricaStanze();
	boolean salvaStanza(Stanza s);
	boolean salvaUtente(Utente u);
	Utente caricaUtente(String email);
	boolean login(String email,String password);
	
	boolean caricaExtra(Extra e);
	boolean salvaExtra (Extra e);

	Prenotazione caricaPrenotazione(String email);
	boolean caricaPrenotazioni(Stanza s, String dataArrivo, String dataPartenza);
	boolean salvaPrenotazione();
	boolean salvaPrenotazioni(Stanza s, String dataArrivo, String dataPartenza);
	
}
