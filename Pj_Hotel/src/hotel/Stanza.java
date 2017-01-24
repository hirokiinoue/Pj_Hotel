package hotel;

public class Stanza {

	private int id = 0;
	private String nome;
	private double costopernotte;
	private int fumatori;
	private int numeropersona;
	
	public Stanza(String nome, double costopernotte, int fumatori, int numeropersona) {
		this.nome = nome;
		this.costopernotte = costopernotte;
		this.fumatori = fumatori;
		this.numeropersona = numeropersona;
	}

	public Stanza(int id, String nome, double costopernotte, int fumatori, int numeropersona) {
		this.id = id;
		this.nome = nome;
		this.costopernotte = costopernotte;
		this.fumatori = fumatori;
		this.numeropersona = numeropersona;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getCostopernotte() {
		return costopernotte;
	}


	public void setCostopernotte(double costopernotte) {
		this.costopernotte = costopernotte;
	}


	public int getFumatori() {
		return fumatori;
	}


	public void setFumatori(int fumatori) {
		this.fumatori = fumatori;
	}


	public int getNumeropersona() {
		return numeropersona;
	}


	public void setNumeropersona(int numeropersona) {
		this.numeropersona = numeropersona;
	}
	
	

	public String scheda(){
		String Yes = "Si'";
		String No = "No";
		
		String ris = "La stanza " + this.nome +" per "+ this.numeropersona + " persone, viene " + this.costopernotte + " € a notte."
				+"\nFumatori: ";
		if(this.fumatori == 0)
			ris += No;
		else
			ris += Yes;
		
		return ris;
	}

}
