package hotel;

import java.sql.Date;
import java.util.ArrayList;

public class Intervallo {

	Date dataarrivo;
	Date datapartenza;
	
	public Intervallo(Date dataarrivo, Date datapartenza) {
		this.dataarrivo = dataarrivo;
		this.datapartenza = datapartenza;
	}
	
	public boolean CheckStanzaDisponibilita(Stanza stanza) {
		boolean rtnValue = false;
		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		
		
		
		return rtnValue;
	}
}
