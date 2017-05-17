package llamabook.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import llamabook.controller.Controller;
import llamabook.controller.MultiLineCellRenderer;
import llamabook.controller.PropertiesController;
import llamabook.model.ModelDao;
import llamabook.model.bean.Profil;

/**
 *
 * @author ShockWave
 */
public class Fooldal {
	private JButton btnbekuldbejegyzes;
	private JButton btnbekuldkomment;
	private JLabel lblbejegyzes;
	private JLabel lblid;
	private JLabel lblkomment;
	private JPanel panelBejegyzes;
	private JPanel panelKomment;
	JPanel panel_fooldal;
	private JScrollPane scrollBejegyzes;
	private JScrollPane scrollKomment;
	private JTable tablaBejegyzes;
	private JTable tablaKomment;
	private JTextField txtbejegyzes;
	private JTextField txtid;
	private JTextField txtkomment;
	private PropertiesController props;

	private Profil profil;
	private Controller controller;
	private ModelDao dao;

	public Fooldal(Profil p, Controller c) {
		this.profil = p;
		this.props = new PropertiesController();
		this.controller = c;
		this.dao = c.getDao();

		panel_fooldal = new JPanel();
		panelBejegyzes = new JPanel();
		scrollBejegyzes = new JScrollPane();
		tablaBejegyzes = new JTable();
		panelKomment = new JPanel();
		scrollKomment = new JScrollPane();
		tablaKomment = new JTable();
		txtbejegyzes = new JTextField();
		btnbekuldbejegyzes = new JButton();
		txtid = new JTextField();
		txtkomment = new JTextField();
		btnbekuldkomment = new JButton();
		lblid = new JLabel();
		lblkomment = new JLabel();
		lblbejegyzes = new JLabel();

		panel_fooldal.setBackground(Color.WHITE);
		panelBejegyzes.setBackground(java.awt.Color.white);
		panelBejegyzes.setBorder(BorderFactory.createTitledBorder(null, props.getProperty("bejegyzesek"),
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
		panelBejegyzes.setPreferredSize(new java.awt.Dimension(530, 500));

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		PostTableModel ptm = new PostTableModel(this.dao.getPosts(this.profil));

		tablaBejegyzes.getTableHeader().setReorderingAllowed(false);

		tablaBejegyzes.setModel(ptm);

		tablaBejegyzes.setRowHeight(tablaBejegyzes.getRowHeight() * 5);
		tablaBejegyzes.getColumnModel().getColumn(0).setPreferredWidth(50);
		tablaBejegyzes.getColumnModel().getColumn(1).setPreferredWidth(120);
		tablaBejegyzes.getColumnModel().getColumn(2).setPreferredWidth(400);

		tablaBejegyzes.setDefaultRenderer(String.class, new MultiLineCellRenderer());

		tablaBejegyzes.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
			if (tablaBejegyzes.getSelectedRow() > -1) {
				// kiírja az ID-t a kiválasztott sornak
				int asd = Integer.parseInt(tablaBejegyzes.getValueAt(tablaBejegyzes.getSelectedRow(), 0).toString());
				System.out.println(asd);
			}
		});

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		scrollBejegyzes.setViewportView(tablaBejegyzes);

		GroupLayout panelBejegyzesLayout = new GroupLayout(panelBejegyzes);
		panelBejegyzes.setLayout(panelBejegyzesLayout);
		panelBejegyzesLayout.setHorizontalGroup(panelBejegyzesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBejegyzesLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollBejegyzes, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
						.addContainerGap()));
		panelBejegyzesLayout.setVerticalGroup(panelBejegyzesLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelBejegyzesLayout.createSequentialGroup()
						.addComponent(scrollBejegyzes, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addContainerGap()));

		panelKomment.setBackground(java.awt.Color.white);
		panelKomment.setBorder(BorderFactory.createTitledBorder(null, props.getProperty("kommentek"),
				TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
		panelKomment.setPreferredSize(new java.awt.Dimension(530, 500));

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		DefaultTableModel asd = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int columnIndex) {
				return String.class;
			}

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

		};

		asd.setDataVector(new Object[][] { { "Allahu Ackbar", "teszt szoveg 1" },
			{ "Teszt Elek", "sdafasdfasdfas dafsdf" }, { "Teszt Elek", "sdfa gasg" },
			{ "Teszt Elek", "asd kek lol xd\n ez egy szar\ntöbbsoros szöveg" }

		}, new Object[] { props.getProperty("tableName"), props.getProperty("tableComment") });

		tablaKomment.getTableHeader().setReorderingAllowed(false);

		tablaKomment.setModel(asd);

		tablaKomment.setRowHeight(tablaKomment.getRowHeight() * 5);
		tablaKomment.getColumnModel().getColumn(0).setPreferredWidth(120);
		tablaKomment.getColumnModel().getColumn(1).setPreferredWidth(500);

		tablaKomment.setDefaultRenderer(String.class, new MultiLineCellRenderer());

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		scrollKomment.setViewportView(tablaKomment);

		GroupLayout panelKommentLayout = new GroupLayout(panelKomment);
		panelKomment.setLayout(panelKommentLayout);
		panelKommentLayout.setHorizontalGroup(panelKommentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelKommentLayout.createSequentialGroup().addContainerGap()
						.addComponent(scrollKomment, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
						.addContainerGap()));
		panelKommentLayout.setVerticalGroup(panelKommentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelKommentLayout.createSequentialGroup()
						.addComponent(scrollKomment, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addContainerGap()));

		btnbekuldbejegyzes.setText(props.getProperty("kuldes"));

		btnbekuldkomment.setText(props.getProperty("kuldes"));

		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setText(props.getProperty("id"));

		lblkomment.setText(props.getProperty("kszoveg"));

		lblbejegyzes.setHorizontalAlignment(SwingConstants.CENTER);
		lblbejegyzes.setText(props.getProperty("bszoveg"));

		GroupLayout panel_fooldalLayout = new GroupLayout(panel_fooldal);
		panel_fooldal.setLayout(panel_fooldalLayout);
		panel_fooldalLayout.setHorizontalGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 1110, Short.MAX_VALUE)
				.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						panel_fooldalLayout.createSequentialGroup().addContainerGap().addGroup(panel_fooldalLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panel_fooldalLayout.createSequentialGroup()
										.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(panelBejegyzes, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblbejegyzes, GroupLayout.PREFERRED_SIZE, 445,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(panelKomment,
														GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(panel_fooldalLayout.createSequentialGroup()
														.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 30,
																GroupLayout.PREFERRED_SIZE)
														.addGap(203, 203, 203).addComponent(lblkomment))))
								.addGroup(panel_fooldalLayout.createSequentialGroup()
										.addComponent(txtbejegyzes, GroupLayout.PREFERRED_SIZE, 445,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnbekuldbejegyzes)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtid, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtkomment)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnbekuldkomment)))
						.addContainerGap())));
		panel_fooldalLayout.setVerticalGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 810, Short.MAX_VALUE)
				.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panel_fooldalLayout.createSequentialGroup().addContainerGap()
								.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(panelBejegyzes, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
										.addComponent(panelKomment, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lblid).addComponent(lblkomment).addComponent(lblbejegyzes))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panel_fooldalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(txtbejegyzes, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnbekuldbejegyzes)
										.addComponent(txtid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtkomment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnbekuldkomment))
								.addContainerGap())));

		panel_fooldal.setBackground(new Color(214, 217, 223));
		panelBejegyzes.setBackground(new Color(214, 217, 223));
		panelKomment.setBackground(new Color(214, 217, 223));



		btnbekuldbejegyzes.addActionListener(e -> {
			if(this.dao.createPost(this.profil.getEmail(), this.profil.getEmail(), txtbejegyzes.getText())){
				ptm.setPosztok(this.dao.getPosts(this.profil));
				txtbejegyzes.setText("");
			}
		});


	}
}
