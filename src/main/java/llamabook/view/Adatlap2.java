package llamabook.view;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import llamabook.controller.Controller;
import llamabook.controller.MultiLineCellRenderer;
import llamabook.controller.PropertiesController;
import llamabook.model.ModelDao;
import llamabook.model.bean.Csatlakozik;
import llamabook.model.bean.Jelol;
import llamabook.model.bean.Profil;
import java.awt.GridLayout;

public class Adatlap2 {

	JPanel panel_adatlap;
	JPanel header;
	
	
	private JComboBox<String> comboSelectProfil;
	private JTextField textSzuldatum;
	private JTextField textNem;
	private JTextField textIskola;
	private JTextField textMunkahely;
	private JTextField textIsmerosok;
	private JTextField textCsoport;
	private JTextField submitBejegyzes;
	private JLabel lblProfimage;
	private JButton btnModosit;
	
    private JScrollPane scrollBejegyzes;
    private JTable tablaBejegyzes;
    
	private Controller controller;
	private LlamabookGUI gui;
	private Profil profil;
	private Jelol jelol;
	private Csatlakozik csatlakozik;
	private PropertiesController props;
	
	private String vnev;
	private String knev;
	private String email;
	private String date;
	private int nem;
	private String munkahely;
	private String iskola;

	private int ismerosokszama;
	private int csoportagsag;
	private JPanel panel;
	private JTextField textVezeteknev;
	private JTextField textKeresztnev;
	
	public Vector<String> getProfiles() {
		Vector<String> nevek = new Vector<>();

		this.controller.getAllUser().forEach(e -> {
			nevek.add(e.getVezeteknev() + " " + e.getKeresztnev());
		});

		return nevek;
	}
	
	public Adatlap2(LlamabookGUI gui, Controller controller) {
		
		this.props = new PropertiesController();
		this.controller = controller;
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
		this.ismerosokszama = gui.getController().userFriendsnumber(jelol.getEmail());

		this.csatlakozik = new Csatlakozik();
		csatlakozik.setEmail(email);
		this.csoportagsag = gui.getController().userGroupNumber(csatlakozik.getEmail());

		
		
		
		
		
		panel_adatlap = new JPanel();
		panel_adatlap.setLayout(new BorderLayout(0, 0));
		
		header = new JPanel();
		//header.setBackground(Color.white);
		panel_adatlap.add(header, BorderLayout.NORTH);
		GridBagLayout gbl_header = new GridBagLayout();
		gbl_header.columnWidths = new int[]{0, 210, 155, 469, 0, 0};
		gbl_header.rowHeights = new int[]{0, 0, 280, 0};
		gbl_header.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_header.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		header.setLayout(gbl_header);
		header.setBorder(new EmptyBorder(30, 0, 0, 0));
		comboSelectProfil = new JComboBox<>();
		GridBagConstraints gbc_comboSelectProfil = new GridBagConstraints();
		gbc_comboSelectProfil.insets = new Insets(0, 0, 5, 5);
		gbc_comboSelectProfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSelectProfil.gridx = 3;
		gbc_comboSelectProfil.gridy = 1;
		header.add(comboSelectProfil, gbc_comboSelectProfil);
		//comboSelectProfil.setBorder(new EmptyBorder(30, 0, 0, 0));
		
		lblProfimage = new JLabel();
		//lblProfimage.setBorder(BorderFactory.createEtchedBorder());
		lblProfimage.setBorder(new EmptyBorder(0, 40, 30, 30));
		lblProfimage.setSize(new Dimension(210, 280));

		btnModosit = new JButton("Modosit");
		
		GridBagConstraints gbc_lblProfimage = new GridBagConstraints();
		gbc_lblProfimage.insets = new Insets(0, 0, 0, 5);
		gbc_lblProfimage.gridx = 1;
		gbc_lblProfimage.gridy = 2;
		header.add(lblProfimage, gbc_lblProfimage);
		
		JPanel selectionpanel = new JPanel();
		GridBagConstraints gbc_selectionpanel = new GridBagConstraints();
		gbc_selectionpanel.insets = new Insets(0, 0, 0, 5);
		gbc_selectionpanel.fill = GridBagConstraints.BOTH;
		gbc_selectionpanel.gridx = 3;
		gbc_selectionpanel.gridy = 2;
		header.add(selectionpanel, gbc_selectionpanel);
		GridBagLayout gbl_selectionpanel = new GridBagLayout();
		gbl_selectionpanel.columnWidths = new int[]{0, 0, 378, 0};
		gbl_selectionpanel.rowHeights = new int[]{32, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_selectionpanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_selectionpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		selectionpanel.setLayout(gbl_selectionpanel);
		
		JLabel lblNev = new JLabel("N\u00E9v");
		lblNev.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNev = new GridBagConstraints();
		gbc_lblNev.anchor = GridBagConstraints.WEST;
		gbc_lblNev.insets = new Insets(0, 0, 5, 5);
		gbc_lblNev.gridx = 1;
		gbc_lblNev.gridy = 0;
		selectionpanel.add(lblNev, gbc_lblNev);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		selectionpanel.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		textVezeteknev = new JTextField();
		panel.add(textVezeteknev);
		textVezeteknev.setColumns(10);
		
		textKeresztnev = new JTextField();
		panel.add(textKeresztnev);
		textKeresztnev.setColumns(10);
		
		JLabel lblSzuldatum = new JLabel("Sz\u00FClet\u00E9si d\u00E1tum");
		lblSzuldatum.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblSzuldatum = new GridBagConstraints();
		gbc_lblSzuldatum.anchor = GridBagConstraints.WEST;
		gbc_lblSzuldatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblSzuldatum.gridx = 1;
		gbc_lblSzuldatum.gridy = 1;
		selectionpanel.add(lblSzuldatum, gbc_lblSzuldatum);
		
		textSzuldatum = new JTextField();
		GridBagConstraints gbc_textSzuldatum = new GridBagConstraints();
		gbc_textSzuldatum.insets = new Insets(0, 0, 5, 0);
		gbc_textSzuldatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSzuldatum.gridx = 2;
		gbc_textSzuldatum.gridy = 1;
		selectionpanel.add(textSzuldatum, gbc_textSzuldatum);
		textSzuldatum.setColumns(10);
		
		JLabel lblNem = new JLabel("Nem");
		lblNem.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNem = new GridBagConstraints();
		gbc_lblNem.anchor = GridBagConstraints.WEST;
		gbc_lblNem.insets = new Insets(0, 0, 5, 5);
		gbc_lblNem.gridx = 1;
		gbc_lblNem.gridy = 2;
		selectionpanel.add(lblNem, gbc_lblNem);
		
		textNem = new JTextField();
		GridBagConstraints gbc_textNem = new GridBagConstraints();
		gbc_textNem.insets = new Insets(0, 0, 5, 0);
		gbc_textNem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNem.gridx = 2;
		gbc_textNem.gridy = 2;
		selectionpanel.add(textNem, gbc_textNem);
		textNem.setColumns(10);
		
		JLabel lblIskola = new JLabel("Iskola");
		lblIskola.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblIskola = new GridBagConstraints();
		gbc_lblIskola.anchor = GridBagConstraints.WEST;
		gbc_lblIskola.insets = new Insets(0, 0, 5, 5);
		gbc_lblIskola.gridx = 1;
		gbc_lblIskola.gridy = 3;
		selectionpanel.add(lblIskola, gbc_lblIskola);
		
		textIskola = new JTextField();
		GridBagConstraints gbc_textIskola = new GridBagConstraints();
		gbc_textIskola.insets = new Insets(0, 0, 5, 0);
		gbc_textIskola.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIskola.gridx = 2;
		gbc_textIskola.gridy = 3;
		selectionpanel.add(textIskola, gbc_textIskola);
		textIskola.setColumns(10);
		
		JLabel lblMunkahely = new JLabel("Munkahely");
		lblMunkahely.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblMunkahely = new GridBagConstraints();
		gbc_lblMunkahely.anchor = GridBagConstraints.WEST;
		gbc_lblMunkahely.insets = new Insets(0, 0, 5, 5);
		gbc_lblMunkahely.gridx = 1;
		gbc_lblMunkahely.gridy = 4;
		selectionpanel.add(lblMunkahely, gbc_lblMunkahely);
		
		textMunkahely = new JTextField();
		GridBagConstraints gbc_textMunkahely = new GridBagConstraints();
		gbc_textMunkahely.insets = new Insets(0, 0, 5, 0);
		gbc_textMunkahely.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMunkahely.gridx = 2;
		gbc_textMunkahely.gridy = 4;
		selectionpanel.add(textMunkahely, gbc_textMunkahely);
		textMunkahely.setColumns(10);
		
		JLabel lblCsoportTagsag = new JLabel("Ismerosok szama");
		lblCsoportTagsag.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCsoportTagsag = new GridBagConstraints();
		gbc_lblCsoportTagsag.anchor = GridBagConstraints.WEST;
		gbc_lblCsoportTagsag.insets = new Insets(0, 0, 5, 5);
		gbc_lblCsoportTagsag.gridx = 1;
		gbc_lblCsoportTagsag.gridy = 5;
		selectionpanel.add(lblCsoportTagsag, gbc_lblCsoportTagsag);
		
		textIsmerosok = new JTextField();
		textIsmerosok.setEditable(false);
		GridBagConstraints gbc_textIsmerosok = new GridBagConstraints();
		gbc_textIsmerosok.insets = new Insets(0, 0, 5, 0);
		gbc_textIsmerosok.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIsmerosok.gridx = 2;
		gbc_textIsmerosok.gridy = 5;
		selectionpanel.add(textIsmerosok, gbc_textIsmerosok);
		textIsmerosok.setColumns(10);
		
		JLabel lblCsoportTagsagok = new JLabel("Csoport tagsagok");
		lblCsoportTagsagok.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCsoportTagsagok = new GridBagConstraints();
		gbc_lblCsoportTagsagok.anchor = GridBagConstraints.WEST;
		gbc_lblCsoportTagsagok.insets = new Insets(0, 0, 5, 5);
		gbc_lblCsoportTagsagok.gridx = 1;
		gbc_lblCsoportTagsagok.gridy = 6;
		selectionpanel.add(lblCsoportTagsagok, gbc_lblCsoportTagsagok);
		
		textCsoport = new JTextField();
		textCsoport.setEditable(false);
		GridBagConstraints gbc_textCsoport = new GridBagConstraints();
		gbc_textCsoport.insets = new Insets(0, 0, 5, 0);
		gbc_textCsoport.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCsoport.gridx = 2;
		gbc_textCsoport.gridy = 6;
		selectionpanel.add(textCsoport, gbc_textCsoport);
		textCsoport.setColumns(10);
		textSzuldatum.setText(date);
		
		if (nem == 1) {
			textNem.setText("Férfi");
		} else {
			textNem.setText("Nő");
		}
		
		textMunkahely.setText(munkahely);
		textIskola.setText(iskola);
		textVezeteknev.setText(vnev);
		textKeresztnev.setText(knev);
		
		textIsmerosok.setText(Integer.toString(ismerosokszama));
		textCsoport.setText(Integer.toString(csoportagsag));
		
		comboSelectProfil.setModel(new DefaultComboBoxModel<>(getProfiles()));
		addMegnyitListener(btnModosit, getProfiles(), comboSelectProfil);
		
		
		
		GridBagConstraints gbc_btnModosit = new GridBagConstraints();
		gbc_btnModosit.gridx = 2;
		gbc_btnModosit.gridy = 7;
		selectionpanel.add(btnModosit, gbc_btnModosit);
		
		JPanel bejegyzesek = new JPanel();
		
		
		
		
		
		
		
		// TODO táblázatot ide létrehozni
		
		
		
		
		
		/*
		
		 // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		DefaultTableModel dm = new DefaultTableModel(){
			public Class getColumnClass(int columnIndex) {
			return String.class;
			}
                       @Override
                       public boolean isCellEditable(int row, int col){
                           return false;
                       }
		};
		
		/// Ezt a tablat kell majd feltolteni a bejegyzesekkel!
		  dm.setDataVector(new Object[][]
				{
					{"15", "Teszt Elek", "teszt szoveg 1"},
					{"0110", "Teszt Elek", "szoveg teszt 2"},
					{"85344", "Teszt Elek", "tobb soros\nmasodik sor\nharmadik sor"},
					{"1344", "Teszt Elek", "asd kek lol xd"}
					
				}, new Object[]
				{props.getProperty("tableID"), props.getProperty("tableName"), props.getProperty("tablePost")});

		tablaBejegyzes.getTableHeader().setReorderingAllowed(false);
		tablaBejegyzes.setModel(dm);


		tablaBejegyzes.setRowHeight(tablaBejegyzes.getRowHeight() * 5);
		tablaBejegyzes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaBejegyzes.getColumnModel().getColumn(1).setPreferredWidth(120);
		tablaBejegyzes.getColumnModel().getColumn(2).setPreferredWidth(400);
	
		tablaBejegyzes.setDefaultRenderer(String.class, new MultiLineCellRenderer());
				
		tablaBejegyzes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			if (tablaBejegyzes.getSelectedRow() > -1) {
				// kiírja az ID-t a kiválasztott sornak
				int asd = Integer.parseInt(tablaBejegyzes.getValueAt(tablaBejegyzes.getSelectedRow(), 0).toString()  );
				System.out.println(asd);
			}});
		
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
       scrollBejegyzes.setViewportView(tablaBejegyzes);
       
       
		*/
		
		
		
		
		
		panel_adatlap.add(bejegyzesek, BorderLayout.CENTER);
		
		JPanel bejegyzesiras = new JPanel();
		panel_adatlap.add(bejegyzesiras, BorderLayout.SOUTH);
		GridBagLayout gbl_bejegyzesiras = new GridBagLayout();
		gbl_bejegyzesiras.columnWidths = new int[]{54, 559, 0, 0, 0};
		gbl_bejegyzesiras.rowHeights = new int[]{0, 0};
		gbl_bejegyzesiras.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_bejegyzesiras.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bejegyzesiras.setLayout(gbl_bejegyzesiras);
		
		submitBejegyzes = new JTextField();
		GridBagConstraints gbc_submitBejegyzes = new GridBagConstraints();
		gbc_submitBejegyzes.insets = new Insets(0, 0, 0, 5);
		gbc_submitBejegyzes.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitBejegyzes.gridx = 1;
		gbc_submitBejegyzes.gridy = 0;
		bejegyzesiras.add(submitBejegyzes, gbc_submitBejegyzes);
		submitBejegyzes.setColumns(10);
		
		JButton btnKuld = new JButton("Kuld");
		GridBagConstraints gbc_btnKuld = new GridBagConstraints();
		gbc_btnKuld.insets = new Insets(0, 0, 0, 5);
		gbc_btnKuld.gridx = 2;
		gbc_btnKuld.gridy = 0;
		bejegyzesiras.add(btnKuld, gbc_btnKuld);
	
		
        lblProfimage.setIcon(this.controller.imgShow(email));	
		
	}

	private void addMegnyitListener(JButton jButton12, Vector<String> vector, JComboBox<String> combobox) {
		System.out.println("megnyomtad");
		
		jButton12.addActionListener(e -> {

			 System.out.println(combobox.getSelectedItem());

			this.controller.getAllUser().forEach(p -> {
				String nev = p.getVezeteknev() + " " + p.getKeresztnev();

				if (nev.equals(combobox.getSelectedItem())) {

					this.textSzuldatum.setText(p.getBirthdate());
					this.textMunkahely.setText(p.getMunkahely());
					this.textVezeteknev.setText(p.getVezeteknev());
					this.textKeresztnev.setText(p.getKeresztnev());
					this.textIskola.setText(p.getIskola());
					this.textNem.setText(p.getNem() == 1 ? "férfi" : "nő");
					this.textCsoport.setText(
							this.controller.userGroupNumber(p.getEmail()) + "");
					this.textIsmerosok.setText(
							this.controller.userFriendsnumber(p.getEmail())
									+ "");
					this.lblProfimage
							.setIcon(this.controller.imgShow(p.getEmail()));

				}
			});

		}

		);
		
		
	}

	
}
