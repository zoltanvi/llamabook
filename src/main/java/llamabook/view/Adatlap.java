package llamabook.view;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

import llamabook.controller.Controller;
import llamabook.controller.PropertiesController;
import llamabook.model.bean.Csatlakozik;
import llamabook.model.bean.Jelol;
import llamabook.model.bean.Profil;

/**
 *
 * @author ShockWave
 */

public class Adatlap {

	private Controller controller;
	private LlamabookGUI gui;
	private Profil profil;
	private Jelol jelol;
	private Csatlakozik csatlakozik;

	private JPanel adatlap_belso;
	JPanel panel_adatlap;
	private JButton btnsubmit;
	private JComboBox<String> ismerosadatlap;
	private JButton jButton1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JLabel lblinivited;
	private JLabel lbliskola;
	private JLabel lblmeghivottak;
	private JLabel lblmunkahely;
	private JLabel lblname;
	private JLabel lblnem;
	private JLabel lblszuletesnap;
	private JLabel profimage;
	private JTextArea textBejegyzes;
	private JTextArea textPosztok;
	private JLabel txtdate;
	private JLabel txtjob;
	private JLabel txtname;
	private JLabel txtschool;
	private JLabel txtsex;
	PropertiesController props = new PropertiesController();

	private String vnev;
	private String knev;
	private String email;
	private String date;
	private int nem;
	private String munkahely;
	private String iskola;

	private int ismerosokszama;
	private int csoportagsag;

	public Adatlap(LlamabookGUI gui) {

		this.gui = gui;
		this.vnev = gui.ProfilVezeteknev();
		this.knev = gui.ProfilKeresztnev();
		this.email = gui.ProfilEmail();
		this.date = gui.ProfilDate();
		this.nem = gui.ProfilNem();
		this.iskola = gui.ProfilIskola();
		this.munkahely = gui.ProfilMunkahely();

		this.jelol = new Jelol();
		jelol.setEmail(email);
		this.ismerosokszama = gui.getController().userFriendsnumber(jelol);

		this.csatlakozik = new Csatlakozik();
		csatlakozik.setEmail(email);
		this.csoportagsag = gui.getController().userGroupNumber(csatlakozik);

		panel_adatlap = new JPanel();
		adatlap_belso = new JPanel();
		profimage = new JLabel();
		lblname = new JLabel();
		txtname = new JLabel();
		lblszuletesnap = new JLabel();
		txtdate = new JLabel();
		lblnem = new JLabel();
		txtsex = new JLabel();
		lblmunkahely = new JLabel();
		lbliskola = new JLabel();
		txtjob = new JLabel();
		txtschool = new JLabel();
		jScrollPane1 = new JScrollPane();
		textPosztok = new JTextArea();
		jScrollPane2 = new JScrollPane();
		textBejegyzes = new JTextArea();
		btnsubmit = new JButton();
		lblinivited = new JLabel();
		lblmeghivottak = new JLabel();
		ismerosadatlap = new JComboBox<>();
		jButton1 = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();

		adatlap_belso.setBackground(new java.awt.Color(255, 255, 255));

		profimage.setText("Kep_placeholder");
		profimage.setBorder(BorderFactory.createEtchedBorder());

		lblname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lblname.setText(props.getProperty("nev"));

		txtname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		txtname.setText(vnev + " " + knev);

		lblszuletesnap.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lblszuletesnap.setText(props.getProperty("bdate"));

		txtdate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		txtdate.setText(date);

		lblnem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lblnem.setText(props.getProperty("sex"));

		txtsex.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

		if (nem == 1) {
			txtsex.setText("Férfi");
		}
		if (nem == 0) {
			txtsex.setText("Nő");
		}

		lblmunkahely.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lblmunkahely.setText(props.getProperty("munkahely"));

		lbliskola.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lbliskola.setText(props.getProperty("iskola"));

		txtjob.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		txtjob.setText(munkahely);

		txtschool.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		txtschool.setText(iskola);

		textPosztok.setColumns(20);
		textPosztok.setRows(5);
		jScrollPane1.setViewportView(textPosztok);

		textBejegyzes.setColumns(20);
		textBejegyzes.setRows(5);
		jScrollPane2.setViewportView(textBejegyzes);

		btnsubmit.setText(props.getProperty("kuldes"));

		lblinivited.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lblinivited.setText(props.getProperty("csoportoksz"));

		lblmeghivottak.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		lblmeghivottak.setText(Integer.toString(csoportagsag));

		ismerosadatlap.setModel(new DefaultComboBoxModel<>(new String[] { "Zoli", "Attila", "Ă�kos", "Teszt" }));

		jButton1.setText(props.getProperty("megnyitas"));

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		jLabel1.setText(props.getProperty("ismerosok"));

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		jLabel2.setText(Integer.toString(ismerosokszama));

		GroupLayout adatlap_belsoLayout = new GroupLayout(adatlap_belso);
		adatlap_belso.setLayout(adatlap_belsoLayout);
		adatlap_belsoLayout
				.setHorizontalGroup(
						adatlap_belsoLayout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(adatlap_belsoLayout.createSequentialGroup().addContainerGap()
										.addGroup(adatlap_belsoLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1003,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(adatlap_belsoLayout.createSequentialGroup()
														.addComponent(profimage, GroupLayout.PREFERRED_SIZE, 210,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(adatlap_belsoLayout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(adatlap_belsoLayout.createSequentialGroup()
																		.addGap(18, 18, 18)
																		.addComponent(ismerosadatlap,
																				GroupLayout.PREFERRED_SIZE, 329,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18, 18, 18).addComponent(jButton1))
																.addGroup(adatlap_belsoLayout.createSequentialGroup()
																		.addGap(52, 52, 52)
																		.addGroup(adatlap_belsoLayout
																				.createParallelGroup(
																						GroupLayout.Alignment.LEADING)
																				.addGroup(adatlap_belsoLayout
																						.createSequentialGroup()
																						.addComponent(lblnem)
																						.addGap(18, 18, 18)
																						.addComponent(txtsex))
																				.addGroup(adatlap_belsoLayout
																						.createSequentialGroup()
																						.addComponent(lblmunkahely)
																						.addGap(18, 18, 18)
																						.addComponent(txtjob))
																				.addGroup(adatlap_belsoLayout
																						.createSequentialGroup()
																						.addComponent(lbliskola)
																						.addGap(18, 18, 18)
																						.addComponent(txtschool))
																				.addGroup(adatlap_belsoLayout
																						.createSequentialGroup()
																						.addGroup(adatlap_belsoLayout
																								.createParallelGroup(
																										GroupLayout.Alignment.LEADING)
																								.addGroup(
																										adatlap_belsoLayout
																												.createSequentialGroup()
																												.addComponent(
																														lblname)
																												.addGap(18,
																														18,
																														18)
																												.addComponent(
																														txtname))
																								.addGroup(
																										adatlap_belsoLayout
																												.createSequentialGroup()
																												.addComponent(
																														lblszuletesnap)
																												.addGap(18,
																														18,
																														18)
																												.addComponent(
																														txtdate)))
																						.addGap(216, 216, 216)
																						.addGroup(adatlap_belsoLayout
																								.createParallelGroup(
																										GroupLayout.Alignment.LEADING)
																								.addGroup(
																										adatlap_belsoLayout
																												.createSequentialGroup()
																												.addComponent(
																														jLabel1)
																												.addGap(18,
																														18,
																														18)
																												.addComponent(
																														jLabel2))
																								.addGroup(
																										adatlap_belsoLayout
																												.createSequentialGroup()
																												.addComponent(
																														lblinivited)
																												.addGap(18,
																														18,
																														18)
																												.addComponent(
																														lblmeghivottak))))))))
												.addGroup(adatlap_belsoLayout.createSequentialGroup()
														.addComponent(jScrollPane2)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btnsubmit, GroupLayout.PREFERRED_SIZE, 108,
																GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(24, Short.MAX_VALUE)));

		adatlap_belsoLayout
				.setVerticalGroup(adatlap_belsoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						adatlap_belsoLayout.createSequentialGroup().addContainerGap().addGroup(adatlap_belsoLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
										adatlap_belsoLayout.createSequentialGroup()
												.addGroup(adatlap_belsoLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(ismerosadatlap, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton1))
												.addGap(41, 41, 41)
												.addGroup(adatlap_belsoLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(lblname).addComponent(txtname).addComponent(
																lblinivited)
														.addComponent(lblmeghivottak))
												.addGap(18, 18, 18)
												.addGroup(adatlap_belsoLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(lblszuletesnap).addComponent(txtdate)
														.addComponent(jLabel1).addComponent(jLabel2))
												.addGap(18, 18, 18)
												.addGroup(adatlap_belsoLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(lblnem).addComponent(txtsex))
												.addGap(18, 18, 18)
												.addGroup(adatlap_belsoLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(lblmunkahely).addComponent(txtjob))
												.addGap(18, 18, 18)
												.addGroup(adatlap_belsoLayout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(lbliskola).addComponent(txtschool)))
								.addComponent(profimage, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
								.addGap(12, 12, 12)
								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(adatlap_belsoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
										.addGroup(adatlap_belsoLayout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE).addComponent(btnsubmit,
														GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));

		GroupLayout adatlap_panelLayout = new GroupLayout(panel_adatlap);
		panel_adatlap.setLayout(adatlap_panelLayout);
		adatlap_panelLayout
				.setHorizontalGroup(adatlap_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(adatlap_panelLayout
								.createSequentialGroup().addContainerGap().addComponent(adatlap_belso,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));
		adatlap_panelLayout
				.setVerticalGroup(adatlap_panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(adatlap_panelLayout
								.createSequentialGroup().addContainerGap().addComponent(adatlap_belso,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap()));

		adatlap_belso.setBackground(new Color(214, 217, 223));

		// profimage.setIcon(new
		// ImageIcon(getClass().getResource("/llamabook/resources/dalaillama.jpg")));
		try {
			profimage.setIcon(new ImageIcon(
					ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("dalailama.jpg"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
