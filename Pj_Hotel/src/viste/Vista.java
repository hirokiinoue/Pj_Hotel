package viste;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import hotel.Stanza;

public class Vista {

	public String menutop = "";
	private static final String percorsoRoot = "C:\\test\\Pj_Hotel\\WebContent\\viste\\";
	
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
			s = String.valueOf(i);
			switch(a.getClass().getSimpleName())
			{
			case "Ram":
				template = caricaParte("articoli/ram.html");
				template = template.replace("[nome]", a.getNome());
				template = template.replace("[prezzo]", String.valueOf(a.getPrezzo()));
				template = template.replace("[giga]", String.valueOf(((Ram) a).getGiga()));
				template = template.replace("[id]", String.valueOf(((Ram) a).getId()));
				
				ris += template;
				break;
			default:
				template = caricaParte("articoli/articolo.html");
				template = template.replace("[nome]", a.getNome());
				template = template.replace("[prezzo]", String.valueOf(a.getPrezzo()));
				template = template.replace("[id]", String.valueOf(a.getId()));
				ris += template;
			}
		}
		return ris;
	}
}
