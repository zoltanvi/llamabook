package llamabook.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import llamabook.controller.PropertiesController;
import llamabook.model.bean.Csatlakozik;
import llamabook.model.bean.Group;
import llamabook.model.bean.Jelol;
import llamabook.model.bean.Kommentel;
import llamabook.model.bean.Poszt;
import llamabook.model.bean.Profil;
import llamabook.model.bean.Uzen;

public class ModelDao {
	// private Properties pro = new
	// Properties("jdbc:oracle:thin:@","localhost","4000","kabinet");
	private String DATABASE_FILE;
	private final PropertiesController props = new PropertiesController();
	private static Connection conn;

	public static void closeConnection() {
		try {
			conn.close();
			if (conn.isClosed()) {
				System.out.println("Sikeres db kapcsolat lezárás");
			}
		} catch (SQLException ex) {
			Logger.getLogger(ModelDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ModelDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException ex) {
			System.out.println("Nem talalhato driver!");
			System.exit(1);
		}

		try {

			String connectionStr = props.getProperty("thin") + props.getProperty("host") + ":"
					+ props.getProperty("port") + ":" + props.getProperty("sid");

			this.conn = DriverManager.getConnection(connectionStr, props.getProperty("AttilaUsername"),
					props.getProperty("AttilaPassword"));

			if (this.conn != null) {
				System.out.println("Sikeres kapcsolodas az adatbazishoz! :)");
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerult kapcsolodnom az adatbazishoz! :( ");
			System.exit(1);
		}
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// felhasznalo regisztralasa az adatbazisba 0
	public boolean userRegis(Profil user) {
		boolean successful = false;
		String regiszUser = "INSERT INTO PROFIL(email ,vezeteknev, keresztnev, nem, birthdate, jelszo, munkahely, iskola) VALUES (?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD'), ?, ?, ?)";
		try (PreparedStatement pst = this.conn.prepareStatement(regiszUser)) {

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getVezeteknev());
			pst.setString(3, user.getKeresztnev());
			pst.setInt(4, user.getNem());
			pst.setString(5, user.getBirthdate());
			pst.setString(6, user.getJelszo());
			pst.setString(7, user.getMunkahely());
			pst.setString(8, user.getIskola());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("A regisztráció sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	// user belep a profiljába 0
	public Profil userLoggingIn(Profil user) {
		String EnterUser = "SELECT * FROM PROFIL WHERE PROFIL.EMAIL = ? AND PROFIL.JELSZO = ?";

		try (PreparedStatement pst = this.conn.prepareStatement(EnterUser);) {

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getJelszo());
			ResultSet rs = pst.executeQuery();

			rs.next();

			Profil p = new Profil();
			p.setEmail(user.getEmail()); // ugyanez itt is a helyzet
			p.setVezeteknev(rs.getString(2));
			p.setKeresztnev(rs.getString(3));
			p.setNem(rs.getInt(4));
			p.setBirthdate(rs.getDate(5).toString());
			p.setJelszo(user.getJelszo()); 
			p.setMunkahely(rs.getString(7));
			p.setIskola(rs.getString(8));

			return p;

		} catch (SQLException e) {
			System.out.println("Belépés sikertelen volt! :(");
			e.printStackTrace();
			return null;
		}

	}

	// profil mennyi csoportba van benne 0
	public int userGroupNumber(String email) {
		int csoportokszama = 0;
		String profilGNumber = "SELECT count(email) FROM Csatlakozik WHERE email = ?";
		try (PreparedStatement pst = this.conn.prepareStatement(profilGNumber);) {

			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			rs.next();// 0. ról 1. re
			csoportokszama = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("Csoportok száma amiben benne van sikertelen volt! :(");

		}
		return csoportokszama;
	}

	//ismerősök száma
	public int userFriendsnumber(String email) {
		int ismerosok = 0;
		String profilFriendNumber = "SELECT Count(*) FROM Jelol WHERE isFriend = 1 AND email = ?";
		try (PreparedStatement pst = this.conn.prepareStatement(profilFriendNumber);) {

			pst.setString(1, email);//
			ResultSet rs = pst.executeQuery();

			rs.next();// 0. ról ami üres 1. sorra lépteti
			ismerosok = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("Ismerösök száma kiadás sikertelen volt! :(");
		}
		return ismerosok;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// felhasználó ismerősei kiíratása o
	public List<Profil> userFriends(Profil user) {
		String listismer = "select p.vezeteknev, p.keresztnev, p.email from jelol j inner join profil p on (j.email=p.email) or (j.KIT_EMAIL=p.email) and (p.email<>?) where j.email=? or j.kit_email=? and isfriend = 1"; 
		

		List<Profil> ismer_profil = new ArrayList();

		try (PreparedStatement pst = this.conn.prepareStatement(listismer);) {

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Profil t = new Profil();
				t.setVezeteknev(rs.getString("vezeteknev"));
				t.setKeresztnev(rs.getString("keresztnev"));
				t.setEmail(rs.getString("email"));
				ismer_profil.add(t);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni az ismerösöket! :( ");
			e.printStackTrace();
		}

		return ismer_profil;
	}

	// ismeros kereses 1. 2. paraméterrel
	public List<Profil> userSeek(Profil user) {
		String keresismeros = "SELECT Profil(*) FROM Profil WHERE Profil.vezeteknev = ? AND Profil.keresztnev = ? ";
		List<Profil> profil_lista = new ArrayList();

		try (PreparedStatement pst = this.conn.prepareStatement(keresismeros);) {
			pst.setString(1, user.getVezeteknev());
			pst.setString(2, user.getKeresztnev());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setEmail(rs.getString("email"));
				profil_lista.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni az ismerösöket! :( ");
			e.printStackTrace();
		}

		return profil_lista;
	}

	// ismeros kereses 1. paraméterrel (csak vezeteknev)
	public List<Profil> userseekFirst(Profil user) {
		String keresismeros1 = "SELECT Profil(*) FROM Profil WHERE Profil.vezeteknev = ?";
		List<Profil> profil_lista = new ArrayList();

		try (PreparedStatement pst = this.conn.prepareStatement(keresismeros1);) {
			pst.setString(1, user.getVezeteknev());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setEmail(rs.getString("email"));
				profil_lista.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni az ismerösöket! :( ");
			e.printStackTrace();
		}

		return profil_lista;
	}

	// ismeros kereses 2. paraméterrel (csak keresztnev)
	public List<Profil> userseekSecond(Profil user) {
		String keresismeros2 = "SELECT Profil(*) FROM Profil WHERE Profil.keresztnev = ?";
		List<Profil> profil_lista = new ArrayList();

		try (PreparedStatement pst = this.conn.prepareStatement(keresismeros2);) {
			pst.setString(1, user.getKeresztnev());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setEmail(rs.getString("email"));
				profil_lista.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni az ismerösöket! :( ");
			e.printStackTrace();
		}

		return profil_lista;
	}

	
	public List<Profil> whoisnotfriend(Profil user) {
		String whono = "select pr.vezeteknev, pr.keresztnev, pr.email from profil pr where pr.email not in (select j.kit_email from profil p inner join jelol j on j.email=p.email and p.email= ? ) and pr.email<>?";
		List<Profil> list = new ArrayList();
		try (PreparedStatement pst = this.conn.prepareStatement(whono);) {
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Profil p = new Profil();
				p.setVezeteknev(rs.getString(1));
				p.setKeresztnev(rs.getString(2));
				p.setEmail(rs.getString(3));

				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni az ismerösöket! :( ");
			e.printStackTrace();
		}

		return list;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// jeloles elküldése
	public boolean friendSign(Jelol jelol) {
		boolean successful = false;
		String Jeloles_LIST = "INSERT INTO Jelol (email ,kit_email, isFriend) VALUES (?, ?, 0)";
		try (PreparedStatement pst = this.conn.prepareStatement(Jeloles_LIST);) {

			pst.setString(1, jelol.getEmail());
			pst.setString(2, jelol.getKit_email());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Jelölés sikertelen vagy már megtörtént! :( ");
			e.printStackTrace();
		}
		return successful;
	}

	// listáza ki a függőbe lévő jelöléseket
	public List<Profil> listSigns(Profil user) {
		String Jeloles_LIST = "select * from jelol j inner join profil p on p.email = j.email where j.kit_email=? and j.ISFRIEND=0";
		List<Profil> users = new ArrayList();

		try (PreparedStatement pst = this.conn.prepareStatement(Jeloles_LIST);) {
			pst.setString(1, user.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setEmail(rs.getString("email"));
				users.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni a jelöléseket! :( ");
			e.printStackTrace();
		}
		return users;
	}

	// ismerem , elfogoadom 0 át 1 re állít
	public boolean signAccept(Jelol sign) {
		boolean successful = false;
		String signUpdate = " UPDATE Jelol SET Jelol.isFriend = 1 WHERE Jelol.email = ? AND Jelol.kit_email = ? ";
		try (PreparedStatement pst = this.conn.prepareStatement(signUpdate);) {

			pst.setString(1, sign.getEmail()); // sajátod
			pst.setString(2, sign.getKit_email()); // kit akarsz törölni

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("A csoport létrehozás sikertelen volt! :( ");
			e.printStackTrace();
		}
		return successful;
	}

	// ha nem ismerem , akkor törlöm
	public boolean signDelete(Jelol sign) {
		boolean successful = false;
		String signDelete = " DELETE FROM JELOL J WHERE J.EMAIL = ? AND J.KIT_EMAIL = ?";
		try (PreparedStatement pst = this.conn.prepareStatement(signDelete);) {
			pst.setString(1, sign.getEmail()); // sajatod
			pst.setString(2, sign.getKit_email()); // kit akarsz törölni

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("A csoport létrehozás sikertelen volt! :( ");
			e.printStackTrace();
		}
		return successful;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// csoport létrehozása
	public boolean createGroup(String nev) {
		boolean successful = false;
		String CREAT_GROUP = "INSERT INTO Group (nev) VALUES (?)";
		try (PreparedStatement pst = this.conn.prepareStatement(CREAT_GROUP);) {
			pst.setString(1, nev);

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("A csoport létrehozás sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	// csoport belépés
	public boolean joinGroup(Csatlakozik join) {
		boolean successful = false;
		String JOIN_GROUP = "INSERT INTO CSATLAKOZIK(csoportID, emial) VALUES ( ?, ?)";

		try (Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(JOIN_GROUP);) {

			pst.setInt(1, join.getCsoportID());
			pst.setString(2, join.getEmail());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("A csoporthoz való csatlakozás sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;

	}

	// összes csoport kilistázása
	public List<Group> listGroup() {
		String List_GROUP = "SELECT Csoport(*) FROM Csoport";
		List<Group> groups = new ArrayList();

		try (Connection conn = DriverManager.getConnection(DATABASE_FILE); Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(List_GROUP);

			while (rs.next()) {
				Group g = new Group();
				g.setCsoportID(rs.getInt("csoportID"));
				g.setCsoportNev(rs.getString("csoportNev"));
				groups.add(g);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni a jelöléseket! :( ");
			e.printStackTrace();
		}
		return groups;
	}

	// csoport tagok számának kiírása
	public List<Group> groupsmemberNumber(Group cs) {
		String CSoportletszam_count = "SELECT Count(*) FROM Csoport WHERE csoportNev = ? ";
		List<Group> group = new ArrayList();
		try (Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(CSoportletszam_count);) {

			pst.setString(1, cs.getCsoportnev());

			ResultSet rs = pst.executeQuery();

			rs.next();

		} catch (SQLException e) {
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return group;
	}

	public boolean LeaveGroup(){
		boolean sf = false;
		String query = "DELETE FROM ";

		return sf;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// üzenet küldés
	public void sendMessage(Uzen message) {
		String SEND_MES = "INSERT INTO Uzen2 VALUES (?, ?, ?) ";

		try (PreparedStatement pst = this.conn.prepareStatement(SEND_MES);) {
			pst.setString(1, message.getEmail());
			pst.setString(2, message.getKinek_email());
			pst.setString(3, message.getEmail() + " üzeni: " + message.getUzenet());
			//System.out.println("Küldő email:"+message.getEmail());
			//System.out.println("Fogadó email:"+message.getKinek_email());

			//System.out.println("Üzenet szövege::"+message.getUzenet());
			pst.executeQuery();

		} catch (SQLException e) {
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		
	}



	public boolean createPost(String ki, String kinek, String bejegyzes){
		boolean succ = false;
		String sql = "INSERT INTO POSZT VALUES((SELECT MAX(POSZTID)+1 FROM POSZT), TO_DATE(SYSDATE,'YYYY-MM-DD-HH24-MI-SS'), ?, ?, ?)";
		try(PreparedStatement pst = this.conn.prepareStatement(sql)){

			pst.setString(1, bejegyzes);
			pst.setString(2, ki);
			pst.setString(3, kinek);

			succ = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return succ;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	/*public boolean posztCreate(Poszt post) {
		boolean successful = false;
		String create_poszt = "INSERT INTO Poszt(email, datum, bejegyzes) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(create_poszt);) {

			pst.setString(1, post.getEmail());
			pst.setDate(2, post.getDatum());
			pst.setString(3, post.getBejegyzes());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	// Listázza a profil posztjait
	/*public List<Poszt> listPoszt(Profil p) {
		List<Poszt> Posts = new ArrayList();
		String List_Uzen = "select po.posztid, p.vezeteknev, p.keresztnev, po.BEJEGYZES from poszt po inner join profil p on po.KI_EMAIL=p.EMAIL and po.KINEK_EMAIL=?";
		try (PreparedStatement pst = this.conn.prepareStatement(List_Uzen);) {
			pst.setString(1, p.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Poszt po = new Poszt();
				po.setEmail(rs.getString("email"));
				po.setBejegyzes(rs.getString("bejegyzes"));
				po.setDatum(rs.getDate("datum"));
				Posts.add(po);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az üzeneteket! :( ");
			e.printStackTrace();
		}
		return Posts;
	}*/

	public List<Poszt> getPosts(Profil p){
		List<Poszt> posztok = new ArrayList<>();

		String sql = "select po.posztid, p.vezeteknev, p.keresztnev, po.BEJEGYZES from poszt po inner join profil p on po.KI_EMAIL=p.EMAIL and po.KINEK_EMAIL=?";
		try(PreparedStatement ps = this.conn.prepareStatement(sql)){
			ps.setString(1, p.getEmail());

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				posztok.add(new Poszt((rs.getString(2) + " " + rs.getString(3)), rs.getInt(1), rs.getString(4)));
			}


		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return posztok;
	}



	/*-----------------------------------------------------------------------------------------------------------------------*/

	// kommentel poszt alá
	public boolean createCommment(Kommentel comment) {
		boolean successful = false;
		String create_poszt = "INSERT INTO Kommentel(email, posztid, komment) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(create_poszt);) {

			pst.setString(1, comment.getEmail());
			pst.setInt(2, comment.getPosztID());
			pst.setString(3, comment.getKomment());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e) {
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	// kommentek listázása
	public List<Kommentel> listComment(Kommentel comment) {
		List<Kommentel> comments = new ArrayList();
		String commentlist = "WHERE email, komment FROM Kommentel WHERE posztID = ? ";

		try (Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(commentlist);) {

			pst.setString(1, comment.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Kommentel c = new Kommentel();
				c.setEmail(rs.getString("email"));
				c.setKomment(rs.getString("komment"));
				comments.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Kommentek listázása sikertelen volt! :( ");
			e.printStackTrace();
		}

		return comments;
	}
	/*-----------------------------------------------------------------------------------------------------------------------*/

	public List<Profil> szulinap_List(Profil user) {
		String List_szulinap = "SELECT Profil.vezeteknev, Profil.keresztnev, Profil.birthdate FROM Profil WHERE MONTH(Profile.birthdate) = 5";
		List<Profil> szulnaposok = new ArrayList();
		try (Connection conn = DriverManager.getConnection(DATABASE_FILE); Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(List_szulinap);

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setBirthdate(rs.getDate("birthdate").toString());
				szulnaposok.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni a szülinaposokat! ");
			e.printStackTrace();
		}
		return szulnaposok;
	}

	public List<Profil> ismerosMunka_list(Profil user) {
		String List_ismerosMunka = "SELECT Profil.vezeteknev, Profil.keresznev FROM Profil, Jelol FULL OUTER JOIN Jelol ON  Profil.email = Jelol.email WHERE Jelol.isFriend = 0 AND Profil.munkahely ...========= még kigondolom";
		List<Profil> ismMunka = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DATABASE_FILE); Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(List_ismerosMunka);

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setMunkahely(rs.getString("munkahely"));
				ismMunka.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az ajánlott ismerősöket munkahely alapján.");
			e.printStackTrace();
		}
		return ismMunka;

	}

	public List<Profil> ismerosSuli_list(Profil user) {
		String List_ismerosSuli = "SELECT Profil.vezeteknev, Profil.keresznev FROM Profil, Jelol FULL OUTER JOIN Jelol ON  Profil.email = Jelol.email WHERE Jelol.isFriend = 0 AND ========= ezt is kigondolom még ";
		List<Profil> ismSuli = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DATABASE_FILE); Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(List_ismerosSuli);

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setIskola(rs.getString("iskola"));
				ismSuli.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az ajánlott ismerősöket iskola alapján.");
			e.printStackTrace();
		}
		return ismSuli;

	}

	public List<Profil> ismerosSzulinap_list(Profil user) {
		String List_ismerosSzulinap = "SELECT Profil.vezeteknev, Profil.keresznev FROM Profil, Jelol FULL OUTER JOIN Jelol ON  Profil.email = Jelol.email WHERE Jelol.isFriend = 0 AND   ========= ezt is kigondolom még ";
		List<Profil> ismSzulnap = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DATABASE_FILE); Statement st = conn.createStatement();) {
			ResultSet rs = st.executeQuery(List_ismerosSzulinap);

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setBirthdate(rs.getDate("birthdate").toString());
				ismSzulnap.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az ajánlott ismerősöket iskola alapján.");
			e.printStackTrace();
		}
		return ismSzulnap;

	}

	// már reg email
	public boolean regYetUser(String email) {
		boolean successful = false;
		String REGYETUSER = "SELECT COUNT(*) FROM PROFIL WHERE PROFIL.EMAIL = ? ";
		try (PreparedStatement pst = this.conn.prepareStatement(REGYETUSER)) {

			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) == 0) {
				successful = pst.executeUpdate() == 1;
			}

		} catch (Exception e) {
			System.out.println("Email cím foglalt! :( ");
			e.printStackTrace();
		}
		return successful;
	}

	public List<Profil> allProfil() {
		String allprofil = "SELECT * FROM PROFIL P ";
		List<Profil> profilList = new ArrayList<>();
		try (PreparedStatement pst = this.conn.prepareStatement(allprofil)) {

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Profil p = new Profil();
				p.setEmail(rs.getString(1));
				p.setVezeteknev(rs.getString(2));
				p.setKeresztnev(rs.getString(3));
				p.setNem(rs.getInt(4));
				p.setBirthdate(rs.getDate(5).toString());
				p.setMunkahely(rs.getString(7));
				p.setIskola(rs.getString(8));
				profilList.add(p);
			}

		} catch (Exception e) {
			System.out.println("Nem tudom listázni :( ");
			e.printStackTrace();
		}

		return profilList;
	}

	// ismerős törlése
	public boolean friendDelete(String email1, String email2) {
		boolean sf = false;
		String fdq = "Delete From jelol where (email = ? and kit_email = ?) or (email = ? and kit_email = ?)";
		try (PreparedStatement pst = this.conn.prepareStatement(fdq)) {
			pst.setString(1, email1);
			pst.setString(2, email2);
			pst.setString(3, email2);
			pst.setString(4, email1);

			sf = pst.executeUpdate() == 1;

		} catch (Exception e) {
			System.out.println("Nem tudom listázni :( ");
			e.printStackTrace();
		}
		return sf;
	}

	public ImageIcon imgShow(String email) {
		ImageIcon proff = null;
		String kep_mutat = "SELECT IMAGE from kepek where email = ? and isprof = 1";
		try (PreparedStatement pst = this.conn.prepareStatement(kep_mutat);) {

			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Blob b = rs.getBlob(1);
				byte barr[] = b.getBytes(1, (int) b.length());

				BufferedImage image;
				try {
					image = ImageIO.read(new ByteArrayInputStream(barr));

					Image dimg = image.getScaledInstance(210, 280, Image.SCALE_SMOOTH);
					// profimage felbontás: 210*280
					proff = new ImageIcon(dimg);


				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("anonym profimage");

				try {
					return new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("anonym2.png")));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}


		} catch (SQLException e) {
			System.out.println("Nem sikerült lekérni a profilképet! :( ");
			e.printStackTrace();
		}
		return proff;

	}

	public List<String> sajatKepek(String email){
		String list_images = "select kepid from kepek where email = ?";
		List<String> imglist =  new ArrayList<>();

		try (PreparedStatement pst = this.conn.prepareStatement(list_images);) {
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			
			while (rs.next()) {
				 imglist.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az ajánlott ismerősöket iskola alapján.");
			e.printStackTrace();
		}

		return imglist;
	}
	
	
	public ImageIcon imageNezzem(int id) {
		ImageIcon proff = null;
		String kep_mutat = "SELECT IMAGE from kepek where kepid = ?";
		try (PreparedStatement pst = this.conn.prepareStatement(kep_mutat);) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Blob b = rs.getBlob(1);
				byte barr[] = b.getBytes(1, (int) b.length());

				BufferedImage image;
				try {
					image = ImageIO.read(new ByteArrayInputStream(barr));
					Image dimg = image.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
					proff = new ImageIcon(dimg);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült lekérni a képet! :( ");
			e.printStackTrace();
		}
		return proff;

	}
	
	
	public void kepfeltolt(String email, String where) throws IOException {
		ImageIcon keep = null;
		String kepbeszur = "insert into kepek (kepid, filesize, image, isprof, email, album)"
				+ " values(?,?,?,?,?,?)";
		try (PreparedStatement pst = this.conn.prepareStatement(kepbeszur);) {

			pst.setInt(1, 444);
			pst.setInt(2, 833);
			
			FileInputStream fin = new FileInputStream(where);
			pst.setBinaryStream(3, fin, fin.available());
			
			pst.setInt(4, 0);
			pst.setString(5, email);
			pst.setString(6, "default_album");
			
			pst.executeUpdate();
			

			} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public List<String> uzenetprint(Uzen message) {
		String uzenetszoveg;
		List<String> Uzenetek = new ArrayList();
		String List_Uzen = "SELECT Uzenet FROM Uzen2 WHERE ( email = ? AND kinek_email = ? ) OR ( email = ? AND kinek_email = ? )";
		try (PreparedStatement pst = this.conn.prepareStatement(List_Uzen);) {
			
			pst.setString(1, message.getEmail());
			pst.setString(2, message.getKinek_email());
			pst.setString(3, message.getKinek_email());
			pst.setString(4, message.getEmail());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
			//	Uzen m = new Uzen();
			//	m.setEmail(rs.getString("email"));
			//	m.setKinek_email(rs.getString("kinek_email"));
			//	m.setUzenet(rs.getString("uzenet"));
				uzenetszoveg = rs.getString("uzenet");
				Uzenetek.add(uzenetszoveg);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az üzeneteket! :( ");
			e.printStackTrace();
		}
		return Uzenetek;
	}
	
	
}
