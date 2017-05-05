package llamabook.model.bean;


import java.sql.Date;


public class Profil {

	private String email;
	private String vezeteknev;
	private String keresztnev;
	private String nem;
	private Date birthdate;
	private String jelszo;
	private String munkahely;
	private String iskola;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVezeteknev() {
		return vezeteknev;
	}

	public void setVezeteknev(String vezeteknev) {
		this.vezeteknev = vezeteknev;
	}

	public String getKeresztnev() {
		return keresztnev;
	}

	public void setKeresztnev(String keresztnev) {
		this.keresztnev = keresztnev;
	}

	public String getNem() {
		return nem;
	}

	public void setNem(String nem) {
		this.nem = nem;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getJelszo() {
		return jelszo;
	}

	public void setJelszo(String jelszo) {
		this.jelszo = jelszo;
	}

	public String getMunkahely() {
		return munkahely;
	}

	public void setMunkahely(String munkahely) {
		this.munkahely = munkahely;
	}

	public String getIskola() {
		return iskola;
	}

	public void setIskola(String iskola) {
		this.iskola = iskola;
	}




}
