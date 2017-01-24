package db;
import hotel.*;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		//IDBHotel db = new DBHotel("jdbc:sqlite:C:\\Users\\corso1\\Desktop\\SQLiteStudio\\hotel");
		IDBHotel db = new DBHotel("jdbc:sqlite:C:\\sqlite\\albergo.db");
		
		Stanza stanza = new Stanza("201",60.00,1,2);
		System.out.println(db.salvaStanza(stanza));
		
		ArrayList<Stanza> lista = db.caricaStanze();		
		for (int i = 0; i<lista.size(); i++)
			System.out.println(lista.get(i).scheda());

	}

}
