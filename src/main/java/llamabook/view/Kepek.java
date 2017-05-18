package llamabook.view;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import llamabook.controller.Controller;
import llamabook.controller.PropertiesController;
import llamabook.model.ModelDao;
import llamabook.model.bean.Profil;


/**
 *
 * @author ShockWave
 */
public class Kepek {
	
	private Controller controller;
	private Profil profil;
	
	private ModelDao dao;
	
	 private javax.swing.JButton btngalerialetrehoz;
    private javax.swing.JButton btnismeroskepek;
    private javax.swing.JButton btnkivalasztgaleria;
    private javax.swing.JButton btnmutasdgaleriabelikepek;
    private javax.swing.JButton btnmutasdsajatismeroskepek;
    private javax.swing.JButton btnsajatkepek;
    private javax.swing.JButton btntalloz;
    private javax.swing.JComboBox<String> comboebbeagaleriaba;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JList<String> listgaleria;
    private javax.swing.JList<String> listgaleriabelikepek;
    private javax.swing.JList<String> listsajatismeros;
    javax.swing.JPanel panel_kepek;
    private javax.swing.JTextField txtfilesource;
    private javax.swing.JTextField txtgaleriacreate;
	private javax.swing.JButton btnfeltoltes;
	PropertiesController props = new PropertiesController();
	String filePath;
	
	public Kepek(Controller controller, Profil profil){
		this.controller = controller;
		this.profil = profil;
		this.dao = this.controller.getDao();
		
		panel_kepek = new javax.swing.JPanel();
        btnsajatkepek = new javax.swing.JButton();
        btnismeroskepek = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listsajatismeros = new javax.swing.JList<>();
        btnmutasdsajatismeroskepek = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listgaleria = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnkivalasztgaleria = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listgaleriabelikepek = new javax.swing.JList<>();
        btnmutasdgaleriabelikepek = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtfilesource = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btntalloz = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtgaleriacreate = new javax.swing.JTextField();
        btngalerialetrehoz = new javax.swing.JButton();
        comboebbeagaleriaba = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnfeltoltes = new javax.swing.JButton();

      
        panel_kepek.setBackground(new java.awt.Color(255, 255, 255));
        panel_kepek.setPreferredSize(new java.awt.Dimension(1110, 810));

        btnsajatkepek.setText(props.getProperty("sajatkep"));

        btnismeroskepek.setText(props.getProperty("ismeroskep"));

        listsajatismeros.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listsajatismeros);

        btnmutasdsajatismeroskepek.setText(props.getProperty("mutasd"));

        lbl_image.setBackground(new java.awt.Color(204, 204, 255));
        lbl_image.setText("jLabel1");
        lbl_image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_image.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        listgaleria.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listgaleria);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(props.getProperty("galeria"));

        btnkivalasztgaleria.setText(props.getProperty("kivalaszt"));

        listgaleriabelikepek.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listgaleriabelikepek);

        btnmutasdgaleriabelikepek.setText(props.getProperty("mutasd"));
        

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(props.getProperty("kivalasztottgaleria"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(props.getProperty("kepfeltoltes"));

        btntalloz.setText(props.getProperty("tallozas"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText(props.getProperty("makegalery"));

        btngalerialetrehoz.setText(props.getProperty("letrehoz"));

        comboebbeagaleriaba.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText(props.getProperty("ebbeagaleriaba"));

        btnfeltoltes.setText(props.getProperty("feltoltes"));

        javax.swing.GroupLayout panel_kepekLayout = new javax.swing.GroupLayout(panel_kepek);
        panel_kepek.setLayout(panel_kepekLayout);
        panel_kepekLayout.setHorizontalGroup(
            panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kepekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_kepekLayout.createSequentialGroup()
                        .addComponent(btnsajatkepek)
                        .addGap(18, 18, 18)
                        .addComponent(btnismeroskepek))
                    .addComponent(jScrollPane1)
                    .addComponent(btnmutasdsajatismeroskepek, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(btngalerialetrehoz, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtgaleriacreate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_kepekLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel_kepekLayout.createSequentialGroup()
                                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel_kepekLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(comboebbeagaleriaba, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel_kepekLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtfilesource, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btntalloz, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnfeltoltes, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(panel_kepekLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmutasdgaleriabelikepek, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnkivalasztgaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        panel_kepekLayout.setVerticalGroup(
            panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_kepekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsajatkepek)
                    .addComponent(btnismeroskepek)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_kepekLayout.createSequentialGroup()
                        .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_kepekLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnmutasdsajatismeroskepek)))
                        .addGap(24, 24, 24)
                        .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgaleriacreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfilesource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btntalloz)
                    .addGroup(panel_kepekLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(btnkivalasztgaleria)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_kepekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngalerialetrehoz)
                    .addComponent(comboebbeagaleriaba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnmutasdgaleriabelikepek)
                    .addComponent(btnfeltoltes))
                .addGap(146, 146, 146))
        );

     panel_kepek.setBackground(new Color(214, 217, 223));

     btnmutasdsajatismeroskepek.addActionListener(e -> {
    	 lbl_image.setIcon(this.controller.imageNezzem(Integer.parseInt(listsajatismeros.getSelectedValue())));	 
    	 
     });
     
     
     btntalloz.addActionListener(e -> {
    	  			
 				JFileChooser fc = new JFileChooser();
 				
 				fc.setCurrentDirectory(new File("C:/Users/ShockWave/Desktop/kepek"));
 				fc.setDialogTitle("Kep kivalasztasa");
 				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
 				fc.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
 				fc.showOpenDialog(fc);
 				System.out.println(fc.getSelectedFile().getAbsolutePath());
 				txtfilesource.setText(fc.getSelectedFile().getAbsolutePath());
 				filePath = fc.getSelectedFile().getAbsolutePath();

 		 
     });
     
     btnfeltoltes.addActionListener(e -> {
    	 	 System.out.println("csokifasz");
    	try {
			this.dao.kepfeltolt(this.profil.getEmail(), filePath);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("kurvanagy csokifasz");
			e1.printStackTrace();
		}
 		
     });
     
     
    PictureListModel plm = new PictureListModel(this.dao.sajatKepek(this.profil.getEmail()));
    
    btnsajatkepek.addActionListener(e -> {
    	listsajatismeros.setModel(plm);
    });
      
     
     
     
     
      
	}
}
