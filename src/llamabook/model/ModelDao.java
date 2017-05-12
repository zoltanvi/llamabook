package llamabook.model;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import llamabook.controller.PropertiesController;
import llamabook.model.bean.Csatlakozik;
import llamabook.model.bean.Group;
import llamabook.model.bean.Jelol;
import llamabook.model.bean.Kommentel;
import llamabook.model.bean.Poszt;
import llamabook.model.bean.Profil;
import llamabook.model.bean.Uzen;



public class ModelDao {

	//private Properties pro =  new Properties("jdbc:oracle:thin:@","localhost","4000","kabinet");
	private String DATABASE_FILE;
        private final PropertiesController props = new PropertiesController();


	public ModelDao(){
            			Connection conn = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException ex) {
				System.out.println("Nem talalhato driver!");
				System.exit(1);
			}
			
			
			try {
				
				String connectionStr = props.irjad("thin") + props.irjad("host") +  ":" + props.irjad("port") + ":" + props.irjad("sid");
				
				conn = DriverManager.getConnection(connectionStr, props.irjad("AttilaUsername"), props.irjad("AttilaPassword"));
				
				
				if (conn != null) {
					System.out.println("Sikeres kapcsolodas az adatbazishoz! :)");
				}
				
			} catch (SQLException e) {
				System.out.println("Nem sikerult kapcsolodnom az adatbazishoz! :( ");
				System.exit(1);
			}
			
			
            
		

	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// felhasznalo regisztralasa az adatbazisba
	public boolean userRegis(Profil user){
		boolean successful = false;
		String REGISZT_USER = "INSERT INTO Profil (email ,vezeteknev, keresztnev, nem, birthdate, jelszo, munkahely, iskola) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(REGISZT_USER);
				){
                       
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getVezeteknev());
			pst.setString(3, user.getKeresztnev());
			pst.setString(4, user.getNem());
			pst.setDate(5, user.getBirthdate());
			pst.setString(6, user.getJelszo());
			pst.setString(7, user.getMunkahely());
			pst.setString(8, user.getIskola());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("A regisztráció sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	//user belep a profiljába
	public boolean userLoggingIn(Profil user){
		String ENT_USER = "SELECT COUNT(*) FROM Profil WHERE Profil.email = ? AND Profil.jelszo = ? ";
		boolean successful = false;

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(ENT_USER);){

			pst.setString(1, user.getEmail());
			pst.setString(2, user.getJelszo());
			ResultSet rs = pst.executeQuery();

			// Ctrl+D
			rs.next();

			if(rs.getInt(1) == 0){

			} else {
				successful = true;
			}
		} catch(SQLException e){
			System.out.println("Belépés sikertelen volt! :(");

		}

		return successful;
	}

	//profil name
	public boolean userName(Profil user){
		String profilName = "SELECT Profil.vezeteknev, Profil.keresztnev FROM Profil WHERE Profil.email = ? ";
		boolean successful = false;

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(profilName);){

			pst.setString(1, user.getEmail());
			
			ResultSet rs = pst.executeQuery();
			rs.next();
			successful = pst.executeUpdate() == 1;

		} catch(SQLException e){
			System.out.println("Név kiadás sikertelen volt! :(");

		}

		return successful;
	}

	//profil birthdate
	public boolean userBirthdate (Profil user){
		String profilBirthdate = "SELECT Profil.birthdate FROM Profil WHERE Profil.email = ? ";
		boolean successful = false;

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(profilBirthdate);){

			pst.setString(1, user.getEmail());
			ResultSet rs = pst.executeQuery();
			rs.next();
			successful = pst.executeUpdate() == 1;

		} catch(SQLException e){
			System.out.println("Születésidátum kiadás sikertelen volt! :(");

		}

		return successful;
	}
	// profil mennyi csoportba van benne
	public boolean userGroupNumber(Csatlakozik join){
		boolean successful = false;
		String profilGNumber = "SELECT count(email) FROM Csatlakozik WHERE email = ?";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(profilGNumber);){

			pst.setString(1, join.getEmail());// saját emailjet kell megadnia
			ResultSet rs = pst.executeQuery();
			rs.next();//0. ról 1. re
			successful = pst.executeUpdate() == 1;

		} catch(SQLException e){
			System.out.println("Csoportok száma amiben benne van sikertelen volt! :(");

		}
		return successful;
	}
	
	//profil munkahelye
	public boolean userJob(Profil user){
		boolean successful = false;
		String gfdhd = "SELECT Profil.munkahely FROM Profil WHERE Profil.email = ? "; //rename
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(gfdhd);){

			pst.setString(1, user.getEmail());// saját emailjet kell megadnia
			ResultSet rs = pst.executeQuery();
			rs.next();
			successful = pst.executeUpdate() == 1;

		} catch(SQLException e){
			System.out.println("Munkahely kiadás sikertelen volt! :(");

		}
		return successful;
	}
	
	//profil iskolaja
	public boolean userSchool(Profil user){
		boolean successful = false;
		String profilSchool = "SELECT Profil.iskola FROM Profil WHERE Profil.email = ? "; 
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(profilSchool);){

			pst.setString(1, user.getEmail());// saját emailjet kell megadnia
			ResultSet rs = pst.executeQuery();
				
			rs.next();
			successful = pst.executeUpdate() == 1;

		} catch(SQLException e){
			System.out.println("Iskola kiadás sikertelen volt! :(");
		}
		return successful;
	}
		
	// Elméletileg jó viszsa adka az ismerösök számát
	public boolean userFriendsnumber(Jelol sign){
		boolean successful = false;
		String profilFriendNumber = "SELECT Count(*) FROM Jelol WHERE isFirend = 1 AND email = ?";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(profilFriendNumber);){

			pst.setString(1, sign.getEmail());// 
			ResultSet rs = pst.executeQuery();
				
			rs.next();// 0. ról ami üres 1. sorra lépteti  
			successful = pst.executeUpdate() == 1;

		} catch(SQLException e){
			System.out.println("Ismerösök száma kiadás sikertelen volt! :(");
		}
		return successful;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/
	
	// felhasználó ismerősei kiíratása
	public List<Profil> userFriends(Profil user){
		String List_Ismer = "SELECT Profil.vezeteknev, Profil.keresztnev, Profil.email FROM Profil, Jelol WHERE Profil.email = ? AND Profil.email = Jelol.email  AND Jelol.isFriend = 1 ";
		List<Profil> ismer_profil = new ArrayList();

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(List_Ismer);){

			pst.setString(1, user.getEmail());
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
	public List<Profil> userSeek(Profil user){
		String Keres_Ismeros = "SELECT Profil(*) FROM Profil WHERE Profil.vezeteknev = ? AND Profil.keresztnev = ? ";
		List<Profil> profil_lista = new ArrayList();

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(Keres_Ismeros);
				){
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
	public List<Profil> userseekFirst(Profil user){
		String Keres_Ismeros = "SELECT Profil(*) FROM Profil WHERE Profil.vezeteknev = ?";
		List<Profil> profil_lista = new ArrayList();

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(Keres_Ismeros);
				){
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
	public List<Profil> userseekSecond(Profil user){
		String Keres_Ismeros = "SELECT Profil(*) FROM Profil WHERE Profil.keresztnev = ?";
		List<Profil> profil_lista = new ArrayList();

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(Keres_Ismeros);
				){
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

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// jeloles elküldése
	public boolean friendSign(Jelol jelol){
		boolean successful = false;
		String SEND_JELOL = "INSERT INTO Jelol (email ,kit_email, isFriend) VALUES (?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(SEND_JELOL);
				){

			pst.setString(1, jelol.getEmail());
			pst.setString(2, jelol.getKit_email());
			pst.setBoolean(3, jelol.isFriend());


			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("Jelölés sikertelen vagy már megtörtént! :( ");
			e.printStackTrace();
		}
		return successful;
	}

	//listáza ki a függőbe lévő jelöléseket
	public List<Jelol> listSigns(Jelol jelol){
		String Jeloles_LIST = "SELECT Jelol(*) FROM Jelol WHERE isFriend = 0";
		List<Jelol> jelolesek = new ArrayList();

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				Statement st = conn.createStatement();
				)
		{
			ResultSet rs = st.executeQuery(Jeloles_LIST);

			while (rs.next()) {
				Jelol j = new Jelol();
				j.setEmail(rs.getString("email"));
				j.setKit_email(rs.getString("kit_email"));
				j.setFriend(rs.getBoolean("isFriend"));
				jelolesek.add(j);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kiírni a jelöléseket! :( ");
			e.printStackTrace();
		}
		return jelolesek;
	}

	//ismerem , elfogoadom 0 át  1 re állít
	public boolean signAccept(Jelol sign){
		boolean successful = false ;
		String signUpdate = " UPDATE Jelol SET Jelol.isFriend = 1 WHERE Jelol.email = ? AND Jelol.kit_email = ? ";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(signUpdate);
				)
		{

			pst.setString(1, sign.getEmail()); // sajátod
			pst.setString(2, sign.getKit_email()); // kit akarsz törölni

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("A csoport létrehozás sikertelen volt! :( ");
			e.printStackTrace();
		}
		return successful;
	}
	
	//ha nem ismerem , akkor törlöm
	public boolean signDelete(Jelol sign){
		boolean successful = false ;
		String signDelete = " DELETE FROM Jelol WHERE Jelol.email = ? Jelol.kit_email = ? ";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(signDelete);
				)
		{
			pst.setString(1, sign.getEmail()); // sajatod
			pst.setString(2, sign.getKit_email()); // kit akarsz törölni

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("A csoport létrehozás sikertelen volt! :( ");
			e.printStackTrace();
		}
		return successful;
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------*/

	// csoport létrehozása
	public boolean createGroup(Group group){
		boolean successful  = false;
		String CREAT_GROUP = "INSERT INTO Group (nev) VALUES (?)";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(CREAT_GROUP);
				)
		{
			pst.setString(1, group.getCsoportnev());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("A csoport létrehozás sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	// csoport belépés
	public boolean joinGroup(Csatlakozik join){
		boolean successful = false;
		String JOIN_GROUP = "INSERT INTO CSATLAKOZIK(csoportID, emial) VALUES ( ?, ?)";

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(JOIN_GROUP);
				){
			
			pst.setInt(1, join.getCsoportID());
			pst.setString(2, join.getEmail());

		

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("A csoporthoz való csatlakozás sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;

	}

	// összes csoport kilistázása
	public List<Group> listGroup(){
		String List_GROUP = "SELECT Csoport(*) FROM Csoport";
		List<Group> groups = new ArrayList();

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				Statement st = conn.createStatement();
				)
		{
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
	public List<Group> groupsmemberNumber(Group cs){
		String CSoportletszam_count= "SELECT Count(*) FROM Csoport WHERE csoportNev = ? ";
		List<Group> group = new ArrayList();
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(CSoportletszam_count);
				){

			pst.setString(1, cs.getCsoportnev());

			ResultSet rs = pst.executeQuery();

			rs.next();
			
		} catch (SQLException e){
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return group;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// Üzcsi dobás
	public boolean sendMessage(Uzen message){
		boolean successful = false;
		String SEND_MES ="INSERT INTO Uzen(email, kinek_email, uzenet) VALUES(?, ?, ?) ";

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(SEND_MES);
				){
			pst.setString(1, message.getEmail());
			pst.setString(2, message.getKinek_email());
			pst.setString(3, message.getUzenet());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}

	//Üzcsi listázás
	public List<Uzen> listMessage(Uzen message){
		List<Uzen> Uzenetek = new ArrayList();
		String List_Uzen = "SELECT Uzen(*) FROM Uzen WHERE ( email = ? AND kinek_email = ? ) OR ( email = ? AND kinek_email = ? )";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(List_Uzen);
				)
		{
			pst.setString(1, message.getEmail());
			pst.setString(2, message.getKinek_email());
			pst.setString(3, message.getKinek_email());
			pst.setString(4, message.getEmail());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Uzen m = new Uzen();
				m.setEmail(rs.getString("email"));
				m.setKinek_email(rs.getString("kinek_email"));
				m.setUzenet(rs.getString("uzenet"));
				Uzenetek.add(m);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az üzeneteket! :( ");
			e.printStackTrace();
		}
		return Uzenetek;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// Poszt létrehozása
	public boolean posztCreate(Poszt post){
		boolean successful = false;
		String create_poszt = "INSERT INTO Poszt(email, datum, bejegyzes) VALUES (?, ?, ?)";

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(create_poszt);
				){

			pst.setString(1, post.getEmail());
			pst.setDate(2, post.getDatum());
			pst.setString(3, post.getBejegyzes());

			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}
	
	// Listázza a profil posztjait
	public List<Poszt> listPoszt(Poszt post){
		List<Poszt> Posts = new ArrayList();
		String List_Uzen = "SELECT Poszt(*) FROM Poszt WHERE Poszt.email = ? ORDER BY Poszt.datum ASC ";
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(List_Uzen);
				)
		{
			pst.setString(1, post.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Poszt p = new Poszt();
				p.setEmail(rs.getString("email"));
				p.setBejegyzes(rs.getString("bejegyzes"));
				p.setDatum(rs.getDate("datum"));
				Posts.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az üzeneteket! :( ");
			e.printStackTrace();
		}
		return Posts;
	}

	/*-----------------------------------------------------------------------------------------------------------------------*/

	// kommentel poszt allá
	public boolean createCommment(Kommentel comment){
		boolean successful = false;
		String create_poszt = "INSERT INTO Kommentel(email, posztid, komment) VALUES (?, ?, ?)";

		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(create_poszt);
				){

			pst.setString(1, comment.getEmail());
			pst.setInt(2, comment.getPosztID());
			pst.setString(3, comment.getKomment());


			successful = pst.executeUpdate() == 1;

		} catch (SQLException e){
			System.out.println("Új üzi küldés sikertelen volt! :( ");
			e.printStackTrace();
		}

		return successful;
	}
	
	 // kommentek listázása // gondolkozok 
	public List<Kommentel> listComment(Kommentel comment){
		List<Kommentel> comments = new ArrayList();
		String commentlist = "WHERE email, komment FROM Kommentel WHERE posztID = ? ";
		
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				PreparedStatement pst = conn.prepareStatement(commentlist);
				){

			pst.setString(1, comment.getEmail());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Kommentel c = new Kommentel();
				c.setEmail(rs.getString("email"));
				c.setKomment(rs.getString("komment"));
				comments.add(c);
			}
		} catch (SQLException e){
			System.out.println("Kommentek listázása sikertelen volt! :( ");
			e.printStackTrace();
		}
		
		return comments;
	}
	/*-----------------------------------------------------------------------------------------------------------------------*/

	
	
	public List<Profil> szulinap_List(Profil user){
		String List_szulinap = "SELECT Profil.vezeteknev, Profil.keresztnev, Profil.birthdate FROM Profil WHERE MONTH(Profile.birthdate) = 5";
		List<Profil> szulnaposok = new ArrayList();
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				Statement st = conn.createStatement();)
		{
			ResultSet rs = st.executeQuery(List_szulinap);

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setBirthdate(rs.getDate("birthdate"));
				szulnaposok.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni a szülinaposokat! ");
			e.printStackTrace();
		}
		return szulnaposok;
	}
	
	public List<Profil> ismerosMunka_list(Profil user){
		String List_ismerosMunka = "SELECT Profil.vezeteknev, Profil.keresznev FROM Profil, Jelol FULL OUTER JOIN Jelol ON  Profil.email = Jelol.email WHERE Jelol.isFriend = 0 AND Profil.munkahely ...========= még kigondolom";
		List<Profil> ismMunka = new ArrayList<Profil>();
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				Statement st = conn.createStatement();)
		{
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
        
        	public List<Profil> ismerosSuli_list(Profil user){
		String List_ismerosSuli = "SELECT Profil.vezeteknev, Profil.keresznev FROM Profil, Jelol FULL OUTER JOIN Jelol ON  Profil.email = Jelol.email WHERE Jelol.isFriend = 0 AND ========= ezt is kigondolom még ";
		List<Profil> ismSuli = new ArrayList<Profil>();
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				Statement st = conn.createStatement();)
		{
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

                public List<Profil> ismerosSzulinap_list(Profil user){
		String List_ismerosSzulinap = "SELECT Profil.vezeteknev, Profil.keresznev FROM Profil, Jelol FULL OUTER JOIN Jelol ON  Profil.email = Jelol.email WHERE Jelol.isFriend = 0 AND   ========= ezt is kigondolom még ";
		List<Profil> ismSzulnap = new ArrayList<Profil>();
		try(Connection conn = DriverManager.getConnection(DATABASE_FILE);
				Statement st = conn.createStatement();)
		{
			ResultSet rs = st.executeQuery(List_ismerosSzulinap);

			while (rs.next()) {
				Profil u = new Profil();
				u.setVezeteknev(rs.getString("vezeteknev"));
				u.setKeresztnev(rs.getString("keresztnev"));
				u.setBirthdate(rs.getDate("birthdate"));
				ismSzulnap.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Nem sikerült kilistázni az ajánlott ismerősöket iskola alapján.");
			e.printStackTrace();
		}
		return ismSzulnap;
                
                
                }       
}


