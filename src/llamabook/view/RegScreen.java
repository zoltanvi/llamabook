package llamabook.view;

import com.sun.jndi.toolkit.ctx.Continuation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import llamabook.controller.Controller;
import llamabook.controller.PropertiesController;
import llamabook.model.bean.Profil;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ShockWave
 */
public class RegScreen extends javax.swing.JFrame implements ActionListener{
        
        private LoginScreen gui ;
        private Controller controller = new Controller();
         
	/**
	 * Creates new form RegScreen
	 */
	public RegScreen(LoginScreen gui){
                
                this.gui = gui;
		initComponents(gui);
	}


	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents(LoginScreen gui) {

        jPanel1 = new javax.swing.JPanel();
        lblRegIcon = new javax.swing.JLabel();
        lblReg = new javax.swing.JLabel();
        txtVezeteknev = new javax.swing.JTextField();
        txtKeresztnev = new javax.swing.JTextField();
        lblVezeteknev = new javax.swing.JLabel();
        lblKeresztnev = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        radioFerfi = new javax.swing.JRadioButton();
        radioNo = new javax.swing.JRadioButton();
        lblNem = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        lblJelszo1 = new javax.swing.JLabel();
        txtJelszo1 = new javax.swing.JPasswordField();
        lblJelszo2 = new javax.swing.JLabel();
        txtJelszo2 = new javax.swing.JPasswordField();
        txtIskola = new javax.swing.JTextField();
        lblIskola = new javax.swing.JLabel();
        txtMunkahely = new javax.swing.JTextField();
        lblMunkahely = new javax.swing.JLabel();
        lblTajekoztato = new javax.swing.JLabel();
        btnReg = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(32, 107, 162));

        lblRegIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       

        lblReg.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblReg.setForeground(new java.awt.Color(255, 255, 255));
        lblReg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReg.setText(props.getProperty("regisztracio"));

        lblVezeteknev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblVezeteknev.setForeground(new java.awt.Color(255, 255, 255));
        lblVezeteknev.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVezeteknev.setText(props.getProperty("xxvezeteknev"));

        lblKeresztnev.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKeresztnev.setForeground(new java.awt.Color(255, 255, 255));
        lblKeresztnev.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblKeresztnev.setText(props.getProperty("xxkeresztnev"));

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText(props.getProperty("xxemail"));

        radioFerfi.setText(props.getProperty("xxmale"));

        radioNo.setText(props.getProperty("xxfemale"));

        lblNem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNem.setForeground(new java.awt.Color(255, 255, 255));
        lblNem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNem.setText(props.getProperty("xxnem"));

        lblDatum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblDatum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDatum.setText(props.getProperty("xxszuldatum"));

        lblJelszo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblJelszo1.setForeground(new java.awt.Color(255, 255, 255));
        lblJelszo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJelszo1.setText(props.getProperty("xxjelszo"));

        lblJelszo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblJelszo2.setForeground(new java.awt.Color(255, 255, 255));
        lblJelszo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblJelszo2.setText(props.getProperty("xxrejelszo"));

        lblIskola.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblIskola.setForeground(new java.awt.Color(255, 255, 255));
        lblIskola.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIskola.setText(props.getProperty("xxiskola"));

        lblMunkahely.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMunkahely.setForeground(new java.awt.Color(255, 255, 255));
        lblMunkahely.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMunkahely.setText(props.getProperty("xxmunkahely"));

        lblTajekoztato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTajekoztato.setForeground(new java.awt.Color(255, 255, 255));
        lblTajekoztato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTajekoztato.setText(props.getProperty("xxcsillaggal"));

        btnReg.setText(props.getProperty("regisztracio"));

        btnBack.setText(props.getProperty("vissza"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblJelszo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKeresztnev, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblVezeteknev, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJelszo2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtKeresztnev)
                            .addComponent(txtJelszo1)
                            .addComponent(txtJelszo2)
                            .addComponent(txtVezeteknev, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(lblIskola, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMunkahely, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMunkahely, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioFerfi)
                                .addGap(18, 18, 18)
                                .addComponent(radioNo)
                                .addGap(271, 271, 271))
                            .addComponent(txtIskola)
                            .addComponent(txtDatum)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTajekoztato, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblRegIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblReg)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVezeteknev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVezeteknev))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeresztnev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKeresztnev))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJelszo1)
                    .addComponent(txtJelszo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJelszo2)
                    .addComponent(txtJelszo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioFerfi)
                        .addComponent(radioNo))
                    .addComponent(lblNem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatum)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIskola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIskola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMunkahely, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMunkahely))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTajekoztato)
                    .addComponent(btnReg)
                    .addComponent(btnBack))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

		lblRegIcon.setIcon(new ImageIcon(getClass().getResource("/llamabook/resources/registicon.png")));
		setResizable(false);
		setVisible(true);
		setLocation(600, 100);
		txtDatum.setToolTipText("<html><font size=\"15\"><b>Pl: 96-SZEPT.-02 </b></font><br>Hónapok:<br>- JAN<br>- FEBR<br>- MÁRC<br>- ÁPR<br>- MÁJ<br>- JÚN<br>- JÚL<br>- AUG<br>- SZEPT<br>- OKT<br>- NOV<br>- DEC</html>");
		btnReg.addActionListener(this);
		btnBack.addActionListener(this);
        pack();
    }// </editor-fold>                        

	/**
	 * @param args the command line arguments
	 */

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIskola;
    private javax.swing.JLabel lblJelszo1;
    private javax.swing.JLabel lblJelszo2;
    private javax.swing.JLabel lblKeresztnev;
    private javax.swing.JLabel lblMunkahely;
    private javax.swing.JLabel lblNem;
    private javax.swing.JLabel lblReg;
    private javax.swing.JLabel lblRegIcon;
    private javax.swing.JLabel lblTajekoztato;
    private javax.swing.JLabel lblVezeteknev;
    private javax.swing.JRadioButton radioFerfi;
    private javax.swing.JRadioButton radioNo;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIskola;
    private javax.swing.JPasswordField txtJelszo1;
    private javax.swing.JPasswordField txtJelszo2;
    private javax.swing.JTextField txtKeresztnev;
    private javax.swing.JTextField txtMunkahely;
    private javax.swing.JTextField txtVezeteknev;
	private final PropertiesController props = new PropertiesController();

    // End of variables declaration                   

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnReg){
                    if(txtEmail.getText().isEmpty()){
                            JOptionPane.showMessageDialog(this, LabelsAndProperties.email_hiany_ERROR, "Hiba", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else{
                            boolean ellenorEmail = gui.getController().regYetUser(txtEmail.getText());
                            if(ellenorEmail == false){ 
                                JOptionPane.showMessageDialog(this, LabelsAndProperties.email_foglalt_ERROR, "Hiba", JOptionPane.ERROR_MESSAGE);
                                return;
                                 
                            }
                            
                        }
                    // txtJelszo1.getPassword() <- char[]
                    String jelszo1 = String.valueOf(txtJelszo1.getPassword());
                    String jelszo2 = String.valueOf(txtJelszo2.getPassword());
                    if(jelszo1.isEmpty() ||  jelszo2.isEmpty()){
                                    JOptionPane.showMessageDialog(this, LabelsAndProperties.jelszo_hiany_ERROR,"Hiba",JOptionPane.ERROR_MESSAGE);
                                    return;
                    } else {
                        if(txtJelszo1.getText().equals(txtJelszo2.getText())){
                        } else{
                            JOptionPane.showMessageDialog(
                                    this,
                                    LabelsAndProperties.jelszo_egyez_ERROR,"Hiba",
                                    JOptionPane.ERROR_MESSAGE);
                                    return;
                        
                        }
                    }
                    
                    if(txtVezeteknev.getText().isEmpty()){
                        JOptionPane.showMessageDialog(
                                    this,
                                    LabelsAndProperties.veznev_hiany_ERROR,"Hiba",
                                    JOptionPane.ERROR_MESSAGE);
                                    return; 
                    }
                    
                    if(txtKeresztnev.getText().isEmpty()){
                        JOptionPane.showMessageDialog(
                                    this,
                                    LabelsAndProperties.keresztnev_hiany_ERROR,"Hiba",
                                    JOptionPane.ERROR_MESSAGE);
                                    return; 
                    }
                    
                    if(txtDatum.getText().isEmpty()){
                        JOptionPane.showMessageDialog(
                                    this,
                                    LabelsAndProperties.szuletesid_hiany_ERROR,"Hiba",
                                    JOptionPane.ERROR_MESSAGE);
                                    return; 
                    } // itt még lekellene kezelni ha nem helyes  a formatum 
                    
                    if((radioFerfi.equals(0)) && radioNo.equals(0)){
                         JOptionPane.showInputDialog(
                                    this,
                                    LabelsAndProperties.nem_hiany_ERROR,"Hiba",
                                    JOptionPane.ERROR_MESSAGE);
                                    return; 
                    }   
 
                    Profil user = new Profil();
                        user.setVezeteknev(txtVezeteknev.getText());
                        user.setKeresztnev(txtKeresztnev.getText());
                        user.setEmail(txtEmail.getText());
                        user.setJelszo(txtJelszo1.getText());
                        if(radioFerfi.isSelected()){
                            user.setNem(1);    
                        } else {
                            user.setNem(0);
                        }
                    
 
                        
                        
                        user.setBirthdate(txtDatum.getText());
                        if(txtIskola.getText().isEmpty()){
                            user.setIskola("NONE");
                        }else{
                             user.setIskola(txtIskola.getText());
                        }
                        
                        if(txtMunkahely.getText().isEmpty()){
                            user.setMunkahely("NONE");
                        }else{
                            user.setMunkahely(txtMunkahely.getText());
                        }
                        
                        if(gui.getController().userRegis(user)){
                            setVisible(false);
                        }
                       
			RegisztracioSikerult reg = new RegisztracioSikerult(this, rootPaneCheckingEnabled);
			reg.setVisible(true);
			dispose();
		}
		if(e.getSource() == btnBack){
			LoginScreen login = new LoginScreen(controller);
			dispose();
		}
		
	}
}
