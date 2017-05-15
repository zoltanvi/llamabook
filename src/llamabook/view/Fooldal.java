package llamabook.view;


import java.awt.Color;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import llamabook.controller.MultiLineCellRenderer;
import llamabook.controller.PropertiesController;
import llamabook.model.bean.Profil;
/**
 *
 * @author ShockWave
 */
public class Fooldal{
    private javax.swing.JButton btnbekuldbejegyzes;
    private javax.swing.JButton btnbekuldkomment;
    private javax.swing.JLabel lblbejegyzes;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblkomment;
    private javax.swing.JPanel panelBejegyzes;
    private javax.swing.JPanel panelKomment;
    javax.swing.JPanel panel_fooldal;
    private javax.swing.JScrollPane scrollBejegyzes;
    private javax.swing.JScrollPane scrollKomment;
    private javax.swing.JTable tablaBejegyzes;
    private javax.swing.JTable tablaKomment;
    private javax.swing.JTextField txtbejegyzes;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtkomment;
    private PropertiesController props;
	
	
	
	public Fooldal(Profil p) {
            this.props = new PropertiesController();
		
            panel_fooldal = new javax.swing.JPanel();
            panelBejegyzes = new javax.swing.JPanel();
            scrollBejegyzes = new javax.swing.JScrollPane();
            tablaBejegyzes = new javax.swing.JTable();
            panelKomment = new javax.swing.JPanel();
            scrollKomment = new javax.swing.JScrollPane();
            tablaKomment = new javax.swing.JTable();
            txtbejegyzes = new javax.swing.JTextField();
            btnbekuldbejegyzes = new javax.swing.JButton();
            txtid = new javax.swing.JTextField();
            txtkomment = new javax.swing.JTextField();
            btnbekuldkomment = new javax.swing.JButton();
            lblid = new javax.swing.JLabel();
            lblkomment = new javax.swing.JLabel();
            lblbejegyzes = new javax.swing.JLabel();

       
    
		panel_fooldal.setBackground(Color.WHITE);
        panelBejegyzes.setBackground(java.awt.Color.white);
        panelBejegyzes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, props.getProperty("bejegyzesek"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        panelBejegyzes.setPreferredSize(new java.awt.Dimension(530, 500));

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

        javax.swing.GroupLayout panelBejegyzesLayout = new javax.swing.GroupLayout(panelBejegyzes);
        panelBejegyzes.setLayout(panelBejegyzesLayout);
        panelBejegyzesLayout.setHorizontalGroup(
            panelBejegyzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBejegyzesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollBejegyzes, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBejegyzesLayout.setVerticalGroup(
            panelBejegyzesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBejegyzesLayout.createSequentialGroup()
                .addComponent(scrollBejegyzes, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelKomment.setBackground(java.awt.Color.white);
        panelKomment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, props.getProperty("kommentek"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        panelKomment.setPreferredSize(new java.awt.Dimension(530, 500));

        // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		DefaultTableModel asd = new DefaultTableModel(){
			public Class getColumnClass(int columnIndex) {
			return String.class;
			}
                        
                        @Override
                        public boolean isCellEditable(int row, int col){
                            return false;
                        }
                        
		};
	
		
		  asd.setDataVector(new Object[][]
				{
					{"Allahu Ackbar", "teszt szoveg 1"},
					{"Teszt Elek", "sdafasdfasdfas dafsdf"},
					{"Teszt Elek", "sdfa gasg"},
					{"Teszt Elek", "asd kek lol xd\n ez egy szar\ntöbbsoros szöveg"}
					
				}, new Object[]
				{props.getProperty("tableName"), props.getProperty("tableComment")});

		tablaKomment.getTableHeader().setReorderingAllowed(false);

		tablaKomment.setModel(asd);

		
		tablaKomment.setRowHeight(tablaKomment.getRowHeight() * 5);
		tablaKomment.getColumnModel().getColumn(0).setPreferredWidth(120);
		tablaKomment.getColumnModel().getColumn(1).setPreferredWidth(500);
	
		tablaKomment.setDefaultRenderer(String.class, new MultiLineCellRenderer());
				
		//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		
		
		
		
        scrollKomment.setViewportView(tablaKomment);

        javax.swing.GroupLayout panelKommentLayout = new javax.swing.GroupLayout(panelKomment);
        panelKomment.setLayout(panelKommentLayout);
        panelKommentLayout.setHorizontalGroup(
            panelKommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKommentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollKomment, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelKommentLayout.setVerticalGroup(
            panelKommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKommentLayout.createSequentialGroup()
                .addComponent(scrollKomment, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnbekuldbejegyzes.setText(props.getProperty("kuldes"));

        btnbekuldkomment.setText(props.getProperty("kuldes"));

        lblid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblid.setText(props.getProperty("id"));

        lblkomment.setText(props.getProperty("kszoveg"));

        lblbejegyzes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbejegyzes.setText(props.getProperty("bszoveg"));

        javax.swing.GroupLayout panel_fooldalLayout = new javax.swing.GroupLayout(panel_fooldal);
        panel_fooldal.setLayout(panel_fooldalLayout);
        panel_fooldalLayout.setHorizontalGroup(
            panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
            .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_fooldalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_fooldalLayout.createSequentialGroup()
                            .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelBejegyzes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblbejegyzes, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelKomment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel_fooldalLayout.createSequentialGroup()
                                    .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(203, 203, 203)
                                    .addComponent(lblkomment))))
                        .addGroup(panel_fooldalLayout.createSequentialGroup()
                            .addComponent(txtbejegyzes, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnbekuldbejegyzes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtkomment)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnbekuldkomment)))
                    .addContainerGap()))
        );
        panel_fooldalLayout.setVerticalGroup(
            panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_fooldalLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelBejegyzes, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                        .addComponent(panelKomment, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblid)
                        .addComponent(lblkomment)
                        .addComponent(lblbejegyzes))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panel_fooldalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbejegyzes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbekuldbejegyzes)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtkomment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbekuldkomment))
                    .addContainerGap()))
        );

		panel_fooldal.setBackground(new Color(214, 217, 223));
		panelBejegyzes.setBackground(new Color(214, 217, 223));
		panelKomment.setBackground(new Color(214, 217, 223));
		
	}              
}
