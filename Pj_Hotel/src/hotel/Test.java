package hotel;

import java.sql.Date;

import db.Intervallo;
import db.DBHotel;
import db.IDBHotel;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IDBHotel db = new DBHotel("jdbc:sqlite:C:\\sqlite\\hotel");
		Stanza s = new Stanza("s1", 20, true, 2);
		Utente g = db.caricaUtente("morte@666.com");
		
		System.out.println(db.caricaStanza("s1").scheda());
		
		System.out.println(db.caricaUtente("morte@666.com").toString());
	}

}
