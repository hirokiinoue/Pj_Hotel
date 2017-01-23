package db;
import java.sql.*;

public abstract class Db {

	private Connection db=null;
	
	public Db(String percorso)
	{
		
		try 
		{
		      Class.forName("org.sqlite.JDBC");
		      db = DriverManager.getConnection(percorso);
		}
		catch(Exception e)
		{
		   	  System.out.println("Erroreeee");
		   	  e.printStackTrace();
		   	  System.exit(-1);
		}
	
	}
	
	
	public ResultSet leggiDati(String sql) 
	{
		ResultSet rs = null;
		try
		{
			Statement smt = db.createStatement();
			rs = smt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("ERRORE");
			System.exit(-1);
		}
		return rs;
	}
	

	
	
}
