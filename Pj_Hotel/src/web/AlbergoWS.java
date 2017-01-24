package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import viste.Vista;
import db.IDBHotel;
import db.DBHotel;
import viste.Vista;

/**
 * Servlet implementation class AlbergoWS
 */
@WebServlet("/Pj_Hotel_v2")
public class AlbergoWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Vista vista;
	//private final static String PERCORSO = "jdbc:sqlite:/Users/hirokiinoue/sqlite/albergo.db";
	private final static String PERCORSO = "jdbc:sqlite:C:\\sqlite\\albergo.db";
	private final static String MENUPAGENAME = "menu.html";
       
	private IDBHotel db;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbergoWS() {
        super();
        this.db = new DBHotel(PERCORSO);
        vista = new Vista(MENUPAGENAME);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("----------- START doGet -----------");
		
		String ris = "";
		//response.setContentType("application/json");
		response.setContentType("text/html");
		response.setStatus(200);
		
		String comando = request.getParameter("comando");
		
		if(comando == null)
			comando = "";
		System.out.println(comando);
		switch(comando){
		case "prenotazione":
			ris = vista.caricaCorpo("albergo/Prenotazione_header.html");
	 		ris += vista.formattaListaStanza(db.caricaStanze());
			ris += vista.caricaParte("albergo/Prenotazione_footer.html");
			break;
		case "registrazione":
			ris = vista.formattaRegistrazione(request.getParameter("idStanza"), request.getParameter("nomeStanza"));
			break;
		case "controlloData":
			ris = vista.formattaConferma(request.getParameter("idStanza"), request.getParameter("nomeStanza"), request.getParameter("dataarrivo"), request.getParameter("datapartenza"));
			break;
		default:
			ris = vista.caricaCorpo("main.html");
		}
 		response.getWriter().append(ris);
		System.out.println("----------- E N D doGet -----------");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
