package viste;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import hotel.Stanza;

public class Vista {

	public String menutop = "";
	private static final String percorsoRoot = "/Users/hirokiinoue/git/Pj_Hotel/Pj_Hotel/WebContent/viste/";
	
	public Vista(String percorsotop)
	{
		this.menutop = caricaParte(percorsotop);
	}
	
	public String caricaCorpo(String percorso)
	{
		System.out.println(this.menutop + this.caricaParte(percorso));
		return this.menutop + this.caricaParte(percorso);
	}
	
	public String caricaParte(String percorso)
	{
		String ris = "";
		try
		{
			Scanner s = new Scanner(new File(percorsoRoot + percorso));
			while(s.hasNext()) ris+= s.nextLine();
			s.close();
		} catch(Exception e)
		{
			
		}
		return ris;
	}
	
	public String formattaListaStanza(ArrayList<Stanza> lista)
	{
		String ris = "";
		String template;
		
		for (Stanza a:lista)
		{
			int i = 0;
			String s = "";
			template = caricaParte("albergo/stanza.html");
			template = template.replace("[nomeStanza]", a.getCodice());
			ris += template;
		}
		return ris;
	}
}
