package db;
import java.sql.Date;

public class EsempioDate {

	public static void main(String[] args) 
	{
		//Una classe interna... voi portatela fuori.
		//Un intervallo è una buona base per una prenotazione.
		
		Intervallo i = new Intervallo(new Date(2016,12,1), new Date(2016,12,31));
		Intervallo i2 = new Intervallo(new Date(2016,12,5), new Date(2017,12,31));
		
		
		System.out.println(i.interno(i2));
	
		
		
	}

}
