package llamabook.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import llamabook.controller.Controller;
import llamabook.controller.PropertiesController;
import llamabook.model.bean.Profil;

/**
 *
 * @author ShockWave
 */
public class LoginScreen extends javax.swing.JFrame implements ActionListener {

	private Controller controller = new Controller();
	PropertiesController props = new PropertiesController();

	public LoginScreen(Controller controller) {
		this.controller = controller;
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		setLocation(600, 100);

		setVisible(true);
		jPanel1 = new javax.swing.JPanel();
		lblloginicon = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		txtemail = new javax.swing.JTextField();
		btnlogin = new javax.swing.JButton();
		txtpassword = new javax.swing.JPasswordField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		btnregistration = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(32, 107, 162));

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText(props.getProperty("login"));

		btnlogin.setText(props.getProperty("login"));

		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText(props.getProperty("email"));

		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText(props.getProperty("jelszo"));

		btnregistration.setText(props.getProperty("regisztracio"));

		jLabel4.setForeground(new java.awt.Color(204, 255, 153));
		jLabel4.setText(props.getProperty("nincsfiok"));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
		.setHorizontalGroup(
				jPanel1Layout
				.createParallelGroup(
						javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblloginicon, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 338,
										Short.MAX_VALUE)
								.addComponent(txtemail))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
												false)
										.addComponent(txtpassword).addComponent(jLabel3,
												javax.swing.GroupLayout.DEFAULT_SIZE, 167,
												Short.MAX_VALUE))
								.addGap(18, 18, 18).addComponent(btnlogin)
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jLabel4)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(btnregistration)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(lblloginicon, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(57, 57, 57)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jLabel3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnlogin).addComponent(txtpassword,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnregistration).addComponent(jLabel4))
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		txtemail.requestFocus();
		try {
			lblloginicon.setIcon(new ImageIcon(ImageIO.read(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("loginiconimage2_1.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnlogin.addActionListener(this);
		btnregistration.addActionListener(this);
		txtpassword.addActionListener(this);
		txtemail.addActionListener(this);
		setResizable(false);
		pack();
	}// </editor-fold>

	// Variables declaration - do not modify - okay man
	private javax.swing.JButton btnlogin;
	private javax.swing.JButton btnregistration;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField txtpassword;
	private javax.swing.JTextField txtemail;
	private javax.swing.JLabel lblloginicon;
	// End of variables declaration

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnlogin || e.getSource() == txtpassword || e.getSource() == txtemail) {
			// valtoz
			String email = txtemail.getText();
			String password = String.valueOf(txtpassword.getPassword());
			if (email.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, LabelsAndProperties.bejelent_hiany_ERROR, "Hiba",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			Profil user = new Profil();
			user.setEmail(email);
			user.setJelszo(password);
			Profil fullUser = this.controller.getDao().userLoggingIn(user);
			if (null != fullUser) {
				System.out.println("Sikeres belépés! :)");
				new LlamabookGUI(this.controller, fullUser);
				this.setVisible(false);
			} else {

				JOptionPane.showMessageDialog(this, "Nem található ilyen felhasználó az adatbázisban!", "Hiba!",
						JOptionPane.ERROR_MESSAGE);
			}

		}
		if (e.getSource() == btnregistration) {
			RegScreen regisztracio = new RegScreen(this);
			System.out.println("Regisztracio...");
			dispose();
		}
	}

	public Controller getController() {
		return controller;
	}
}
