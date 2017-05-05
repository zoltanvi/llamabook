package llamabook.model.bean;

import java.sql.Date;

public class Csatlakozik {
	private String email;
	private int csoportID;
	private Date csatlakozas_datum;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCsoportID() {
		return csoportID;
	}

	public void setCsoportID(int csoportID) {
		this.csoportID = csoportID;
	}

	public Date getCsatlakozas_datum() {
		return csatlakozas_datum;
	}

	public void setCsatlakozas_datum(Date csatlakozas_datum) {
		this.csatlakozas_datum = csatlakozas_datum;
	}
}
