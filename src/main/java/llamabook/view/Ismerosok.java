package llamabook.view;


import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import llamabook.controller.PropertiesController;
import llamabook.model.ModelDao;
import llamabook.model.bean.DeletableProfs;
import llamabook.model.bean.DeleteListModel;
import llamabook.model.bean.Jelol;
import llamabook.model.bean.Profil;
/**
 *
 * @author ShockWave
 */
public class Ismerosok {

	private LlamabookGUI gui;
	private Profil profil;
	private Jelol jelol;

	private JButton btnAjanlasKuldese;
	private JButton btnIsmerosnekJelolom;
	private JButton btnJelolesTorlese;
	private JButton btnTorles;
	private JButton btnVisszaigazolas;
	private JComboBox<String> comboBoxMialapjan;
	private JList<String> jList3;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JScrollPane jScrollPane4;
	private JScrollPane jScrollPane5;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	private JSeparator jSeparator3;
	private JLabel lblIsmerosAjanlasa;
	private JLabel lblIsmerosTorlese;
	private JLabel lblJelolesekKezelese;
	private JLabel lblNeki;
	private JList<String> listFelhasznaloJeloles;
	private JList<String> listIsmerosTorles;
	private JList<String> listJelolesekKezelese;
	private JList<String> listNeki;
	public JPanel panel_ismerosok;
	private JLabel txtFelhasznaloJeloles;
	private PropertiesController props ;
	private ModelDao dao;


	public Ismerosok(Profil profil, LlamabookGUI gui){
		this.gui = gui;
		this.props = new PropertiesController();
		this.dao = this.gui.getController().getDao();
		this.profil = profil;
		this.jelol = new Jelol();

		this.panel_ismerosok = new JPanel();
		this.jScrollPane1 = new JScrollPane();
		this.listFelhasznaloJeloles = new JList<>();
		this.txtFelhasznaloJeloles = new JLabel();
		this.btnIsmerosnekJelolom = new JButton();
		this.jScrollPane2 = new JScrollPane();
		this.listJelolesekKezelese = new JList<>();
		this.lblJelolesekKezelese = new JLabel();
		this.btnVisszaigazolas = new JButton();
		this.btnJelolesTorlese = new JButton();
		this.jSeparator1 = new JSeparator();
		this.jScrollPane3 = new JScrollPane();
		this.jList3 = new JList<>();
		this.lblIsmerosAjanlasa = new JLabel();
		this.lblNeki = new JLabel();
		this.jScrollPane4 = new JScrollPane();
		this.listNeki = new JList<>();
		this.comboBoxMialapjan = new JComboBox<>();
		this.btnAjanlasKuldese = new JButton();
		this.lblIsmerosTorlese = new JLabel();
		this.jScrollPane5 = new JScrollPane();
		this.listIsmerosTorles = new JList<>();
		this.btnTorles = new JButton();
		this.jSeparator2 = new JSeparator();
		this.jSeparator3 = new JSeparator();


		this.panel_ismerosok.setBackground(Color.white);

		this.listFelhasznaloJeloles.setBackground(UIManager.getDefaults().getColor("Button.background"));
		this.listFelhasznaloJeloles.setModel(new AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			@Override
			public int getSize() { return strings.length; }
			@Override
			public String getElementAt(int i) { return strings[i]; }


		});
		jScrollPane1.setViewportView(listFelhasznaloJeloles);

		txtFelhasznaloJeloles.setFont(new Font("Tahoma", 0, 18)); // NOI18N
		txtFelhasznaloJeloles.setHorizontalAlignment(SwingConstants.CENTER);
		txtFelhasznaloJeloles.setText(props.getProperty("feljel"));

		btnIsmerosnekJelolom.setText(props.getProperty("btnjelol"));

		listJelolesekKezelese.setBackground(UIManager.getDefaults().getColor("Button.background"));
		jScrollPane2.setViewportView(listJelolesekKezelese);

		DeletableProfs dp1 = new DeletableProfs();

		dao.listSigns(profil).forEach(ba1 -> {
			dp1.add(ba1.getEmail(), ba1.getVezeteknev()+" "+ba1.getKeresztnev());
		});

		List<String> nevek1 = new ArrayList<>();

		for(Map.Entry<String, String> entry1 : dp1.getDeleteableProfs().entrySet()){
			nevek1.add(entry1.getValue());
		}

		AtomicInteger c1 = new AtomicInteger(0);


		ListModel lm1 = new AbstractListModel<String>(){
			@Override
			public int getSize() {
				return dp1.getDeleteableProfs().size();
			}

			@Override
			public String getElementAt(int i) {
				return nevek1.get(i);
			}

		};

		listJelolesekKezelese.setModel(lm1);
		// felkeltölteni hozzá adatb h tryolni lehetsen







		lblJelolesekKezelese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lblJelolesekKezelese.setHorizontalAlignment(SwingConstants.CENTER);
		lblJelolesekKezelese.setText(props.getProperty("jelkez"));

		btnVisszaigazolas.setText(props.getProperty("btnvisszaig"));

		btnJelolesTorlese.setText(props.getProperty("btnjeltor"));

		jList3.setBackground(UIManager.getDefaults().getColor("Button.background"));
		jList3.setModel(new AbstractListModel<String>() {

			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };


			@Override
			public int getSize() { return strings.length; }
			@Override
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane3.setViewportView(jList3);

		lblIsmerosAjanlasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lblIsmerosAjanlasa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsmerosAjanlasa.setText(props.getProperty("ismaj"));


		lblNeki.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lblNeki.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeki.setText(props.getProperty("neki"));





		listNeki.setBackground(UIManager.getDefaults().getColor("Button.background"));
		listNeki.setModel(new AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
			@Override
			public int getSize() { return strings.length; }
			@Override
			public String getElementAt(int i) { return strings[i]; }
		});
		jScrollPane4.setViewportView(listNeki);

		comboBoxMialapjan.setModel(new DefaultComboBoxModel<>(new String[] { "Kozos ismerosok alapjan", "Munkahely alapjan", "Iskola alapjan" }));

		btnAjanlasKuldese.setText(props.getProperty("btnajanlaskuld"));

		lblIsmerosTorlese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		lblIsmerosTorlese.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsmerosTorlese.setText(props.getProperty("ismtor"));


		DeleteListModel dlm = new DeleteListModel(this.dao.userFriends(this.profil));

		listIsmerosTorles.setModel(dlm);

		listIsmerosTorles.setBackground(UIManager.getDefaults().getColor("Button.background"));

		jScrollPane5.setViewportView(listIsmerosTorles);

		btnTorles.setText(props.getProperty("btntorlom"));

		btnTorles.addActionListener(e -> {     // már jó!!!! :)
			if(this.dao.friendDelete(this.profil.getEmail(), dlm.getEmailByName(listIsmerosTorles.getSelectedValue()))){
				dlm.refresh(this.dao.userFriends(this.profil));
			}
		});

		jSeparator3.setOrientation(SwingConstants.VERTICAL);

		GroupLayout panel_ismerosokLayout = new GroupLayout(panel_ismerosok);
		panel_ismerosok.setLayout(panel_ismerosokLayout);
		panel_ismerosokLayout.setHorizontalGroup(
				panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panel_ismerosokLayout.createSequentialGroup()
										.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(panel_ismerosokLayout.createSequentialGroup()
														.addComponent(btnVisszaigazolas)
														.addGap(241, 241, 241)
														.addComponent(btnJelolesTorlese))
												.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
														.addComponent(lblJelolesekKezelese, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
														.addComponent(jScrollPane2, GroupLayout.Alignment.LEADING)
														.addComponent(jSeparator1, GroupLayout.Alignment.LEADING)
														.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING)
														.addGroup(GroupLayout.Alignment.LEADING, panel_ismerosokLayout.createSequentialGroup()
																.addGap(153, 153, 153)
																.addComponent(btnIsmerosnekJelolom))))
										.addGap(55, 55, 55)
										.addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(27, 27, 27))
								.addGroup(panel_ismerosokLayout.createSequentialGroup()
										.addComponent(txtFelhasznaloJeloles, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
										.addComponent(btnTorles)
										.addGap(213, 213, 213))
								.addGroup(panel_ismerosokLayout.createSequentialGroup()
										.addGap(35, 35, 35)
										.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(jSeparator2, GroupLayout.Alignment.TRAILING)
												.addComponent(jScrollPane3)
												.addComponent(lblIsmerosAjanlasa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNeki, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jScrollPane4)
												.addGroup(panel_ismerosokLayout.createSequentialGroup()
														.addComponent(comboBoxMialapjan, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(btnAjanlasKuldese, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
												.addComponent(lblIsmerosTorlese, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jScrollPane5))
										.addContainerGap())))
				);
		panel_ismerosokLayout.setVerticalGroup(
				panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panel_ismerosokLayout.createSequentialGroup()
						.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
										.addGap(492, 492, 492)
										.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblIsmerosTorlese)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
								.addGroup(GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
										.addGap(17, 17, 17)
										.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(txtFelhasznaloJeloles)
												.addComponent(lblIsmerosAjanlasa))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addGroup(panel_ismerosokLayout.createSequentialGroup()
														.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addGroup(panel_ismerosokLayout.createSequentialGroup()
																		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(btnIsmerosnekJelolom)
																		.addGap(17, 17, 17)
																		.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
																.addGroup(panel_ismerosokLayout.createSequentialGroup()
																		.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(lblNeki)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(jScrollPane4)))
														.addGap(27, 27, 27)
														.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(lblJelolesekKezelese)
																.addComponent(comboBoxMialapjan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(btnAjanlasKuldese))
														.addGap(8, 8, 8)
														.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
												.addComponent(jSeparator3))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panel_ismerosokLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btnVisszaigazolas)
										.addComponent(btnTorles))
								.addComponent(btnJelolesTorlese))
						.addContainerGap(41, Short.MAX_VALUE))
				);

		panel_ismerosok.setBackground(new Color(214, 217, 223));

	}

}
