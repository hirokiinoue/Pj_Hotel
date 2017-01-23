package db;

import java.sql.Date;

public class Intervallo {

	public Date d1;
	public Date d2;
	
	public Intervallo(Date d1, Date d2)
	{
		this.d1 = d1;
		this.d2 = d2;
		
	}
	
	public boolean interno(Date d)
	{
		return
				(d1.before(d) || d1.equals(d))
				&&
				(d2.after(d) || d2.equals(d));
	}
	
	public boolean interno(Intervallo i)
	{
		return
				this.interno(i.d1)
				&&
				this.interno(i.d2);
	}
	
	public boolean collide(Intervallo i)
	{
		return this.interno(i.d1) || this.interno(i.d2) || i.interno(this);
	}
	
}
