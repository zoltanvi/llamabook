package llamabook.model.bean;

public class Poszt {

	private String nev;
	private int posztID;
	private String bejegyzes;
	public String getNev() {
		return nev;
	}
	public void setNev(String nev) {
		this.nev = nev;
	}
	public int getPosztID() {
		return posztID;
	}
	public void setPosztID(int posztID) {
		this.posztID = posztID;
	}
	public String getBejegyzes() {
		return bejegyzes;
	}
	public void setBejegyzes(String bejegyzes) {
		this.bejegyzes = bejegyzes;
	}
	public Poszt(String nev, int posztID, String bejegyzes) {
		this.nev = nev;
		this.posztID = posztID;
		this.bejegyzes = bejegyzes;
	}




}
