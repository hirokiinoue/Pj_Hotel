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
	private final static int IDHOTEL = 1;
	private final static String SELECTALL_STANZA ="SELECT * FROM stanza";
	private final static String SELECT_STANZA ="SELECT * FROM stanza WHERE id = ?";
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
	private final static String SELECT_PRENOTAZIONE_CON_IDSTANZA = "SELECT * FROM prenotazioni WHERE idstanza = ?";
	private final static String SELECT_UTENTE_CON_EMAIL = "SELECT * FROM utenti WHERE email=?";
	private final static String SELECT_UTENTE_CON_ID = "SELECT * FROM utenti WHERE id=?";
	private final static String SELECT_UTENTE_PRENOTAZIONE = "select "
															+ "strftime('%y', dataarrivo) as a1"
															+ ", strftime('%m', dataarrivo) as m1"	
															+ ", strftime('%d', dataarrivo) as g1"
															+ ", strftime('%y', datapartenza) as a2"
															+ ", strftime('%m', datapartenza) as m2"
															+ ", strftime('%d', datapartenza) as g2"
															+ ", codstanza"
															+ ", note "
															+ "from "
															+ "prenotazioni where idcliente=?";
	private final static String INSERT_UTENTE = "INSERT INTO utente (email, password, nome, cognome, tipo) VALUES (?,?,?,?,?)";
	private final static String INSERT_STANZA = "INSERT INTO stanza (nome, costopernotte, fumatori, numeropersona, idhotel) VALUES (?,?,?,?,?)";

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
	public Stanza caricaStanza(int id) {
		Stanza ris = null;
		
		try
		{
			PreparedStatement p = db.prepareStatement(SELECT_STANZA);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			
			ris = new Stanza(
						rs.getInt("id")
						,rs.getString("nome")
						,rs.getDouble("costopernotte")
						,rs.getInt("fumatori")
						,rs.getInt("numeropersona")
					);
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
				lista.add(caricaStanza(rs.getInt("id")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public boolean salvaStanza(Stanza s) {
	
		boolean ris = false;

		try
		{
			PreparedStatement p = db.prepareStatement(INSERT_STANZA);
			p.setString(1, s.getNome());
			p.setDouble(2, s.getCostopernotte());
			p.setInt(3, s.getFumatori());
			p.setInt(4, s.getNumeropersona());
			p.setInt(5, IDHOTEL);
			p.executeUpdate();
			
			ris = true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
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
	public Utente caricaUtente(String UtenteEmail) {
		// TODO Auto-generated method stub
		Utente ris = null;
		
		try
		{
			PreparedStatement p = this.db.prepareStatement(SELECT_UTENTE_CON_EMAIL);
			p.setString(1, UtenteEmail);
			ResultSet rs = p.executeQuery();
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String tipo = rs.getString("tipo");
			String descrizione = rs.getString("descrizione");
			ris = new Utente(email,password,nome,cognome,tipo,descrizione);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ris;
	}

	public Utente caricaUtente(int UtenteId) {
		// TODO Auto-generated method stub
		Utente ris = null;
		
		try
		{
			PreparedStatement p = this.db.prepareStatement(SELECT_UTENTE_CON_ID);
			p.setInt(1, UtenteId);
			ResultSet rs = p.executeQuery();
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String tipo = rs.getString("tipo");
			String descrizione = rs.getString("descrizione");
			ris = new Utente(email,password,nome,cognome,tipo,descrizione);
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
					,caricaStanza(rs.getInt("idStanza"))
					, rs.getString("descrizione")
			);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return prenotazione;
	}

	@Override
	public ArrayList<Prenotazione> caricaPrenotazione(Stanza stanza) {

		ArrayList<Prenotazione> prenotazione = new ArrayList<Prenotazione>();
		
		try {
			PreparedStatement p = this.db.prepareStatement(SELECT_PRENOTAZIONE_CON_IDSTANZA);
			p.setInt(1, stanza.getId());
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Intervallo i = new Intervallo(rs.getDate("dataarrivo"),rs.getDate("datapartenza"));
				prenotazione.add( new Prenotazione(
						caricaUtente(rs.getInt("idUtente"))
						, i
						,caricaStanza(rs.getInt("idStanza"))
						, rs.getString("descrizione"))
				);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return prenotazione;
	}

	@Override
	public boolean salvaPrenotazione(Prenotazione prenotazione) {
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
