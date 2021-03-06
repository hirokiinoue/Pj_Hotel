package db;

import hotel.*;
import java.util.ArrayList;

public interface IDBHotel {

	Stanza caricaStanza(int id);
	ArrayList<Stanza> caricaStanze();
	boolean salvaStanza(Stanza s);
	boolean salvaUtente(Utente u);
	Utente caricaUtente(String email);
	boolean login(String email,String password);
	
	boolean caricaExtra(Extra e);
	boolean salvaExtra (Extra e);

	Prenotazione caricaPrenotazione(String email);
	ArrayList<Prenotazione> caricaPrenotazione(Stanza stanza);
	boolean caricaPrenotazioni(Stanza s, String dataArrivo, String dataPartenza);
	boolean salvaPrenotazione(Prenotazione prenotazione);
	boolean salvaPrenotazioni(Stanza s, String dataArrivo, String dataPartenza);
	
}
