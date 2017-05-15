package llamabook.model.bean;

public class Profil {

	private String email;
	private String vezeteknev;
	private String keresztnev;
	private int nem;
	private String birthdate;
	private String jelszo;
	private String munkahely;
	private String iskola;

	public Profil(String email, String vezeteknev, String keresztnev, int nem, String birthdate, String jelszo,
			String munkahely, String iskola) {
		this.email = email;
		this.vezeteknev = vezeteknev;
		this.keresztnev = keresztnev;
		this.nem = nem;
		this.birthdate = birthdate;
		this.jelszo = jelszo;
		this.munkahely = munkahely;
		this.iskola = iskola;
	}

	public Profil() {
	}

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

	public int getNem() {
		return nem;
	}

	public void setNem(int nem) {
		this.nem = nem;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
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

	@Override
	public String toString() {
		return "Profil [email=" + email + ", vezeteknev=" + vezeteknev + ", keresztnev=" + keresztnev + ", nem=" + nem
				+ ", birthdate=" + birthdate + ", jelszo=" + jelszo + ", munkahely=" + munkahely + ", iskola=" + iskola
				+ "]";
	}

}
