package llamabook.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import llamabook.controller.Controller;
import llamabook.controller.PropertiesController;
import llamabook.model.ModelDao;
import llamabook.model.bean.Profil;
import llamabook.model.bean.Uzen;


public class Uzenetek {

	JPanel panel_uzenetek = new JPanel();
	JTextArea txtUzenetszoveg;
	private Controller controller;
	private LlamabookGUI gui;
	private ModelDao dao;
	private Profil profil;
	JButton buttonSelect;
	JComboBox<String> listAll = new JComboBox<>();

	public Vector<String> getProfiles() {
		Vector<String> nevek = new Vector<>();

		this.controller.getAllUser().forEach(e -> {
			nevek.add(e.getVezeteknev() + " " + e.getKeresztnev());
		});

		return nevek;
	}


	public Uzenetek(LlamabookGUI gui, Controller controller, Profil profil){

		this.controller = controller;
		this.gui = gui;
		this.dao = this.controller.getDao();
		this.profil = profil;
		PropertiesController props = new PropertiesController();
		panel_uzenetek.setLayout(new BorderLayout(0, 0));

		JPanel toppanel = new JPanel();
		panel_uzenetek.add(toppanel, BorderLayout.NORTH);
		toppanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


		listAll.setBackground(Color.WHITE);
		toppanel.add(listAll);
		buttonSelect = new JButton(LabelsAndProperties.buttonselect);
		toppanel.add(buttonSelect);


		JPanel centerpanel = new JPanel();
		panel_uzenetek.add(centerpanel, BorderLayout.CENTER);
		centerpanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		centerpanel.add(scrollPane, BorderLayout.CENTER);

		txtUzenetszoveg = new JTextArea();
		txtUzenetszoveg.setLineWrap(true);
		scrollPane.setViewportView(txtUzenetszoveg);
		txtUzenetszoveg.setMargin(new Insets(10, 10, 10, 10));
		txtUzenetszoveg.setFont(new Font("Monospaced", Font.PLAIN, 18));

		JPanel bottompanel = new JPanel();
		panel_uzenetek.add(bottompanel, BorderLayout.SOUTH);
		bottompanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollingpanel = new JScrollPane();
		bottompanel.add(scrollingpanel, BorderLayout.CENTER);

		JTextArea txtElnemkuldott = new JTextArea();
		txtElnemkuldott.setLineWrap(true);
		txtElnemkuldott.setRows(5);
		scrollingpanel.setViewportView(txtElnemkuldott);

		JPanel buttonpanel = new JPanel();
		bottompanel.add(buttonpanel, BorderLayout.EAST);
		buttonpanel.setLayout(new BoxLayout(buttonpanel, BoxLayout.X_AXIS));

		JButton buttonSubmit = new JButton(LabelsAndProperties.uzenetbutton);
		buttonSubmit.setBackground(SystemColor.activeCaption);
		buttonpanel.add(buttonSubmit);


		addMegnyitListener(buttonSelect, getProfiles(), listAll);


		listAll.setModel(new DefaultComboBoxModel<>(getProfiles()));


		buttonSubmit.addActionListener((ActionEvent e) -> {
			if(e.getSource() == buttonSubmit && txtElnemkuldott.getText().length() > 0 ){


				this.controller.getAllUser().forEach(p -> {

					String nev = p.getVezeteknev() + " " + p.getKeresztnev();

					if (nev.equals(listAll.getSelectedItem())) {

						Uzen uzen = new Uzen();
						uzen.setEmail(this.profil.getEmail());
						System.out.println("Ő KÜLD: "+this.profil.getEmail());
						System.out.println("NEKI: " + p.getEmail());
						uzen.setKinek_email(p.getEmail());
						uzen.setUzenet(txtElnemkuldott.getText());
						System.out.println("Üzenet szövege: "+ txtElnemkuldott.getText());
						this.dao.sendMessage(uzen);
					}
				});




				txtElnemkuldott.setText(null);


			}

		});


	}


	private void addMegnyitListener(JButton jButton12, Vector<String> vector, JComboBox<String> combobox) {
		System.out.println("megnyomtad");

		jButton12.addActionListener(e -> {

			System.out.println(combobox.getSelectedItem());

			this.controller.getAllUser().forEach(p -> {
				String nev = p.getVezeteknev() + " " + p.getKeresztnev();


				if (nev.equals(combobox.getSelectedItem())) {

					Uzen uzen = new Uzen();
					uzen.setEmail(this.profil.getEmail());
					uzen.setKinek_email(p.getEmail());

					// TODO this.dao.uzenetprint(uzen);
					//	txtUzenetszoveg.setText(txtUzenetszoveg.getText() + "\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n" + this.dao.uzenetprint(uzen) + "\n");
					txtUzenetszoveg.setText(null);
					for (int i = 0; i < this.dao.uzenetprint(uzen).size(); i++) {
						txtUzenetszoveg.setText(txtUzenetszoveg.getText() + "\n <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< \n" + this.dao.uzenetprint(uzen).get(i) + "\n");
					}


				}
			});

		}

				);


	}
}
