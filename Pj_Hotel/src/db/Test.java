package db;
import hotel.*;

public class Test {

	public static void main(String[] args) {
		
		IDBHotel db = new DBHotel("jdbc:sqlite:C:\\Users\\corso1\\Desktop\\SQLiteStudio\\hotel");
		
		Hotel h = new Hotel().getInstance();
		
		System.out.println();

	}

}
