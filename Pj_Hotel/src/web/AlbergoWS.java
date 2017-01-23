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
@WebServlet("/Pj_Hotel")
public class AlbergoWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Vista vista;
	private final static String PERCORSO = "jdbc:sqlite:C:\\sqlite\\hotel";
	private final static String MENUPAGENAME = "prenotazione.html";
       
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
		// TODO Auto-generated method stub
		System.out.println("----------- START doGet -----------");
		response.setContentType("application/json");
		//response.setContentType("text/html");
		response.setStatus(200);
    	String ris = vista.caricaCorpo("");
		//ris = vista.caricaCorpo("main.html");
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
