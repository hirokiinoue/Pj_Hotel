package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hotel.*;

import java.sql.Date;

public class DBHotel implements IDBHotel{

	public Connection db;
	private final static String CODHOTEL = "BG001";
	private final static String SELECTALL_STANZA ="SELECT id as codice FROM stanze";
	private final static String SELECTSTANZA ="SELECT id as codice, costopernotte as costo, fumatori, numeropersona as npersona FROM stanze WHERE id = ?";
	private final static String SELECTEXTRA = "select "
											+ "extra.codice as codice"
											+ ", extra.descrizione as descrizione"
											+ ", extra.costo as costo "
											+ "from stanze, dotazione, extra "
											+ "where "
											+ "stanze.codice = dotazione.codstanza "
											+ "and "
											+ "dotazione.codextra = extra.codice "
											+ "and "
											+ "stanze.codice = ?";
	private final static String SELECT_PRENOTAZIONE = "SELECT * FROM prenotazioni WHERE id = ?";
	private final static String INSERT_UTENTE = "INSERT INTO (email, password, nome, cognome, tipo) VALUES (?,?,?,?,?)";
	private final static String INSERT_STANZA = "INSERT INTO (codice, costo, fumatori, npersone, codhotel) VALUES (?,?,?,?,?)";

	public DBHotel(String percorso) {
		db = null;
		try 
		{
			Class.forName("org.sqlite.JDBC");
			db = DriverManager.getConnection(percorso);
		} 
		catch(Exception e) 
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	@Override
	public Stanza caricaStanza(String codice) {
		Stanza ris = new Stanza(null,null,"",0,false,0);
		ArrayList <Extra> extra = new ArrayList<Extra>();
		try
		{
			PreparedStatement p = db.prepareStatement(SELECTSTANZA);
			p.setString(1, codice);
			ResultSet rs = p.executeQuery();
			
			ris
				.setCodice(rs.getString("codice"))
				.setCosto(rs.getDouble("costo"))
				.setFumatori(rs.getBoolean("fumatori"))
				.setNpersone(rs.getInt("npersone"));
			
			PreparedStatement e = db.prepareStatement(SELECTEXTRA);
			e.setString(1, codice);
			ResultSet rd = e.executeQuery();

			while(rd.next())
			{
				Extra a = new Extra(rd.getString("codice"),rd.getString("descrizione"),rd.getDouble("costo"));
				extra.add(a);

			}
			ris.setExtra(extra);
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		return ris;
	}
	
	public ArrayList<Stanza> caricaStanze() {
		ArrayList<Stanza> lista = new ArrayList<Stanza>();
		
		try {
			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery(SELECTALL_STANZA);
			
			while(rs.next()){
				lista.add(caricaStanza(rs.getString("codice")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	public ArrayList<Stanza> carcaStanze(){
		ArrayList<Stanza> listaStanza = new ArrayList<Stanza>();
		
		return listaStanza;
	}
	
	@Override
	public boolean salvaStanza(Stanza s) {
	
		boolean ris = false;

		try
		{
			PreparedStatement p = db.prepareStatement(INSERT_STANZA);
			p.setString(1, s.getCodice());
			p.setDouble(2, s.getCosto());
			p.setBoolean(3, s.getFumatori());
			p.setInt(4, s.getNpersone());
			p.setString(5, CODHOTEL);
			p.executeUpdate();
			
			ris = true;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return ris;
	}

	@Override
	public boolean salvaUtente(Utente u) {
		// TODO Auto-generated method stub
		boolean ris = false;

		try
		{
			PreparedStatement p = db.prepareStatement(INSERT_UTENTE);
			p.setString(1, u.getEmail());
			p.setString(2, u.getPassword());
			p.setString(3, u.getNome());
			p.setString(4, u.getCognome());
			p.setString(5, u.getTipo());
			p.executeUpdate();
			
			ris = true;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return ris;
	}

	@Override
	public Utente caricaUtente(String email) {
		// TODO Auto-generated method stub
		Utente ris = null;
		try
		{
			PreparedStatement p = this.db.prepareStatement("select * from utenti where email=?");
			p.setString(1, email);
			ResultSet rs = p.executeQuery();
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String password = rs.getString("password");
			String tipo = rs.getString("tipo");
			ris = new Utente(email,password,nome,cognome,tipo);
			
			p = this.db.prepareStatement("select strftime('%y', dataarrivo) as a1, strftime('%m', dataarrivo) as m1, strftime('%d', dataarrivo) as g1, strftime('%y', datapartenza) as a2, strftime('%m', datapartenza) as m2, strftime('%d', datapartenza) as g2, codstanza, note  from prenotazioni where email=?");
			p.setString(1, email);
			rs = p.executeQuery();
			
			while(rs.next())
			{
				ris.prenotazioni.add
				(
					new Prenotazione
					(
						ris,
						new Intervallo
						(
							new Date(rs.getInt("a1"), rs.getInt("m1")-1, rs.getInt("g1")),
							new Date(rs.getInt("a2"), rs.getInt("m2")-1, rs.getInt("g2"))
						),
						caricaStanza(rs.getString("codstanza")),
						rs.getString("note")
					)	
						
				);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean caricaExtra(Extra e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean salvaExtra(Extra e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Prenotazione caricaPrenotazione(String codicePrenotazione) {

		Prenotazione prenotazione = null;
		
		try {
			PreparedStatement p = this.db.prepareStatement(SELECT_PRENOTAZIONE);
			p.setString(1, codicePrenotazione);
			ResultSet rs = p.executeQuery();
			Intervallo i = new Intervallo(rs.getDate("dataarrivo"),rs.getDate("datapartenza"));
			prenotazione = new Prenotazione(
					caricaUtente(rs.getString("email"))
					, i
					,caricaStanza(rs.getString("codstanza"))
					, rs.getString("descrizione")
			);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return prenotazione;
	}

	@Override
	public boolean salvaPrenotazione() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean caricaPrenotazioni(Stanza s, String dataArrivo,
			String dataPartenza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean salvaPrenotazioni(Stanza s, String dataArrivo,
			String dataPartenza) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> infoHotel(){
		ArrayList<String> ris = new ArrayList<String>();
		
		try
		{
			PreparedStatement p = db.prepareStatement("select * from hotel");
			ResultSet rs = p.executeQuery();

			ris.add(rs.getString("codice"));
			ris.add(rs.getString("nome"));
			ris.add(rs.getString("citta"));
			ris.add(rs.getString("indirizzo"));
			ris.add(rs.getString("cap"));
			ris.add(rs.getString("stelle"));
			ris.add(rs.getString("nomeproprietario"));
			ris.add(rs.getString("piva"));
			ris.add(rs.getString("emailproprietario"));
		}
		catch (Exception e)
		{
			e.getMessage();
		}
		
		return ris;
	}
}
