package llamabook.model.bean;


import java.sql.Date;


public class Poszt {
	
	private String email;
	private int PosztID;
	private Date datum;
	private String bejegyzes;

	public String getEmail() {
		return bejegyzes;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPosztID() {
		return PosztID;
	}

	public void setPosztID(int posztID) {
		PosztID = posztID;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getBejegyzes() {
		return bejegyzes;
	}

	public void setBejegyzes(String bejegyzes) {
		this.bejegyzes = bejegyzes;
	}




}
