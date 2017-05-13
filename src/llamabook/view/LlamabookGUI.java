package llamabook.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import llamabook.controller.Controller;
import llamabook.controller.PropertiesController;
import llamabook.model.ModelDao;
import llamabook.model.bean.Profil;
/**
 *
 * @author ShockWave
 * 
 */

public class LlamabookGUI extends JFrame implements ActionListener{
    
    private Controller controller;
    private Profil profil;

        
    private PropertiesController props = new PropertiesController();
    private final Color hover = new Color(92, 148, 189);
    private final Color theme = new Color(32, 107, 162);
    private final Color szurke = new Color(197, 198, 199);
	
	// main GUI-nak az inicializálása
    private final JPanel panel_full = new JPanel();
    private final JPanel panel_menu = new JPanel();
    private final JPanel panel_main = new JPanel();
    private final JPanel panel_bal = new JPanel();
    private final JPanel panel_bal_also = new JPanel();
    private final JPanel panel_cardcontainer = new JPanel();
    private final JPanel panel_menu_bal = new JPanel();
    private final JPanel panel_menu_jobb = new JPanel();
   
	// fix, mindig a bejelentkezett felhasználó adataival töltjük fel!
	private final JTextPane adatok = new JTextPane();
	
	//menü gombok
    private final JButton button_logout = new JButton(props.irjad("logout"));
    private final JButton button_uzenetek = new JButton(props.irjad("messages"));
    private final JButton button_adatlap = new JButton(props.irjad("profil"));
    private final JButton button_csoportok = new JButton(props.irjad("groups"));
    private final JButton button_kepek = new JButton(props.irjad("images"));
    private final JButton button_ismerosok = new JButton(props.irjad("friends"));
    private final JButton button_fooldal = new JButton(props.irjad("index"));

	// menü ikonja (llamabook felirat)
    private final JLabel menutitle = new JLabel(); 
    private final JLabel lblbejelentkezve = new JLabel(props.irjad("loggedIn"));
    
    private String knev;
    private String vnev;
    private String email;
    private String date;
    private String iskola;
    private String munkahely;
    private int nem;
    
    private JLabel lblmint;
    

    public void addShutdownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ModelDao.closeConnection();
        }));
    }

	// konstruktor
    public LlamabookGUI(Controller controller, Profil profil) {
        this.controller = controller;
        this.profil = profil;
        
        this.vnev = profil.getVezeteknev();
        this.knev  = profil.getKeresztnev();
        this.email = profil.getEmail();
        this.date = profil.getBirthdate();
        this.nem = profil.getNem();
        this.iskola = profil.getIskola();
        this.munkahely = profil.getMunkahely();
        
        this.lblmint = new JLabel(this.vnev + " " + this.knev);
        this.addShutdownHook();
	initComponents();
    }
    
    
  
    private void initComponents(){
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(new Dimension(1140, 900));
			setTitle(props.irjad("ablakcim"));
			add(panel_full);
			
			panel_full.setBackground(Color.white);
			panel_full.setLayout(new BorderLayout());
			panel_full.add(panel_menu, BorderLayout.NORTH);
			panel_full.add(panel_main, BorderLayout.CENTER);
			
			panel_menu.setPreferredSize(new Dimension(1000, 40));
			panel_menu.setBackground(theme); // fasza kék
			panel_menu.setLayout(new BorderLayout());
			panel_menu.add(panel_menu_bal, BorderLayout.WEST);
			panel_menu.add(panel_menu_jobb, BorderLayout.EAST);
			
			panel_menu_bal.setBackground(theme); 
			panel_menu_bal.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			panel_menu_bal.add(menutitle);
			panel_menu_bal.add(lblbejelentkezve);
			panel_menu_bal.add(lblmint);
			
			 lblbejelentkezve.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
			 lblbejelentkezve.setForeground(Color.WHITE);
			 lblmint.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
			 lblmint.setForeground(Color.yellow);
			  
			panel_menu_jobb.setBackground(theme);
			panel_menu_jobb.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			panel_menu_jobb.add(button_fooldal);
			panel_menu_jobb.add(button_adatlap);
			panel_menu_jobb.add(button_kepek);
			panel_menu_jobb.add(button_ismerosok);
			panel_menu_jobb.add(button_csoportok);
			panel_menu_jobb.add(button_uzenetek);
			panel_menu_jobb.add(button_logout);
			
			panel_main.setBackground(Color.WHITE);
			panel_main.setLayout(new BorderLayout());
			panel_main.add(panel_cardcontainer, BorderLayout.CENTER);
			
			button_fooldal.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			button_adatlap.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			button_csoportok.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			button_ismerosok.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			button_kepek.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			button_logout.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			button_uzenetek.setMargin(new Insets(5, WIDTH, 5, HEIGHT));
			

			button_logout.addActionListener(this);
			button_uzenetek.addActionListener(this);
			button_ismerosok.addActionListener(this);
			button_csoportok.addActionListener(this);
			button_kepek.addActionListener(this);
			button_adatlap.addActionListener(this);
			button_fooldal.addActionListener(this);
			
			//////////////////////////////// HEY BOSS, I HAVE A CANCER PLES \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
			// karesz is azt kapott ennek a kódnak a láttán
			menutitle.setIcon(new ImageIcon(getClass().getResource("/llamabook/resources/icon.png")));
			
			
			panel_cardcontainer.setLayout(new BorderLayout());
			panel_cardcontainer.setBackground(Color.black);
			
			// Példányosítom a főoldalt, úgyis az a kezdő oldal ami betölt. Aztán a menü hatására a többi is létrejöhet.
			Fooldal fooldal = new Fooldal();
			panel_cardcontainer.add(fooldal.panel_fooldal, BorderLayout.CENTER);
			     setVisible(true);

	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_adatlap){
			Adatlap adatlap = new Adatlap(this);
			System.out.println("adatlap MENÜ");
			panel_cardcontainer.removeAll();
			panel_cardcontainer.add(adatlap.panel_adatlap, BorderLayout.CENTER);
			panel_cardcontainer.repaint();
			panel_cardcontainer.revalidate();
				
		}
		if(e.getSource() == button_kepek){
			Kepek kepek = new Kepek();
			System.out.println("képek MENÜ");
			panel_cardcontainer.removeAll();
			panel_cardcontainer.add(kepek.panel_kepek, BorderLayout.CENTER);
			panel_cardcontainer.repaint();
			panel_cardcontainer.revalidate();
		}
		if(e.getSource() == button_ismerosok){
			Ismerosok ismerosok = new Ismerosok();
			System.out.println("ismerősök MENÜ");
			panel_cardcontainer.removeAll();
			panel_cardcontainer.add(ismerosok.panel_ismerosok, BorderLayout.CENTER);
			panel_cardcontainer.repaint();
			panel_cardcontainer.revalidate();
		}
		if(e.getSource() == button_csoportok){
			Csoportok csoportok = new Csoportok();
			System.out.println("csoportok MENÜ");
			panel_cardcontainer.removeAll();
			panel_cardcontainer.add(csoportok.panel_csoportok, BorderLayout.CENTER);
			panel_cardcontainer.repaint();
			panel_cardcontainer.revalidate();
		}
		if(e.getSource() == button_uzenetek){
			Uzenetek uzenetek = new Uzenetek();
			System.out.println("üzenetek MENÜ");
			panel_cardcontainer.removeAll();
			panel_cardcontainer.add(uzenetek.panel_uzenetek, BorderLayout.CENTER);
			panel_cardcontainer.repaint();
			panel_cardcontainer.revalidate();
		}
		if(e.getSource() == button_fooldal){
			Fooldal fooldal = new Fooldal();
			System.out.println("főoldal MENÜ");
			panel_cardcontainer.removeAll();
			panel_cardcontainer.add(fooldal.panel_fooldal, BorderLayout.CENTER);
			panel_cardcontainer.repaint();
			panel_cardcontainer.revalidate();
		}
		if(e.getSource() == button_logout){
			System.out.println("Kijelentkezés...");
			System.exit(0);
			dispose();
			
		}
		
		
		
	}
        
        public String ProfilVezeteknev(){
            return this.vnev;
        }
        public String ProfilKeresztnev(){
            return this.knev;
        }
        public String ProfilEmail(){
            return this.email;
        }
        
        public String ProfilDate(){
            return this.date;
        }
        
        public int ProfilNem(){
            return this.nem;
        }
        
        public String ProfilIskola(){
            return this.iskola;
        }
        
        public String ProfilMunkahely(){
            return this.munkahely;
        }
        
        public Controller getController(){
            return this.controller;
        }
       

}