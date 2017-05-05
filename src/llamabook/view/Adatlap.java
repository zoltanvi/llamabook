package llamabook.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import llamabook.controller.PropertiesController;

/**
 *
 * @author ShockWave
 */

public class Adatlap {
	
     private javax.swing.JPanel adatlap_belso;
    javax.swing.JPanel panel_adatlap;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JComboBox<String> ismerosadatlap;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblinivited;
    private javax.swing.JLabel lbliskola;
    private javax.swing.JLabel lblmeghivottak;
    private javax.swing.JLabel lblmunkahely;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblnem;
    private javax.swing.JLabel lblszuletesnap;
    private javax.swing.JLabel profimage;
    private javax.swing.JTextArea textBejegyzes;
    private javax.swing.JTextArea textPosztok;
    private javax.swing.JLabel txtdate;
    private javax.swing.JLabel txtjob;
    private javax.swing.JLabel txtname;
    private javax.swing.JLabel txtschool;
    private javax.swing.JLabel txtsex;
	PropertiesController props = new PropertiesController();
	
	public Adatlap(){
		
		panel_adatlap = new javax.swing.JPanel();
        adatlap_belso = new javax.swing.JPanel();
        profimage = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JLabel();
        lblszuletesnap = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        lblnem = new javax.swing.JLabel();
        txtsex = new javax.swing.JLabel();
        lblmunkahely = new javax.swing.JLabel();
        lbliskola = new javax.swing.JLabel();
        txtjob = new javax.swing.JLabel();
        txtschool = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPosztok = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textBejegyzes = new javax.swing.JTextArea();
        btnsubmit = new javax.swing.JButton();
        lblinivited = new javax.swing.JLabel();
        lblmeghivottak = new javax.swing.JLabel();
        ismerosadatlap = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

      
        adatlap_belso.setBackground(new java.awt.Color(255, 255, 255));

        profimage.setText("Kep_placeholder");
        profimage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblname.setText(props.irjad("nev"));

        txtname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
      //  txtname.setText("Teszt Elek");	Lekerdezes!

        lblszuletesnap.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblszuletesnap.setText(props.irjad("bdate"));

        txtdate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        //txtdate.setText("17- DEC - 02");	Lekerdezes!

        lblnem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblnem.setText(props.irjad("sex"));

        txtsex.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        //txtsex.setText("fĂ©rfi"); 	Lekerdezes!

        lblmunkahely.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblmunkahely.setText(props.irjad("munkahely"));

        lbliskola.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbliskola.setText(props.irjad("iskola"));

        txtjob.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        //txtjob.setText("Evosoft");	Lekerdezes!

        txtschool.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        //txtschool.setText("Szegedi TudomĂˇnyegyetem");	Lekerdezes!

        textPosztok.setColumns(20);
        textPosztok.setRows(5);
        jScrollPane1.setViewportView(textPosztok);

        textBejegyzes.setColumns(20);
        textBejegyzes.setRows(5);
        jScrollPane2.setViewportView(textBejegyzes);

        btnsubmit.setText(props.irjad("kuldes"));

        lblinivited.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblinivited.setText(props.irjad("meghivottak"));

        lblmeghivottak.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        //lblmeghivottak.setText("55");	     Lekerdezes!

        ismerosadatlap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zoli", "Attila", "Ă�kos", "Teszt" }));

        jButton1.setText(props.irjad("megnyitas"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText(props.irjad("ismerosok"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        //jLabel2.setText("over 9000");		Lekerdezes!

        javax.swing.GroupLayout adatlap_belsoLayout = new javax.swing.GroupLayout(adatlap_belso);
        adatlap_belso.setLayout(adatlap_belsoLayout);
        adatlap_belsoLayout.setHorizontalGroup(
            adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                        .addComponent(profimage, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ismerosadatlap, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                        .addComponent(lblnem)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtsex))
                                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                        .addComponent(lblmunkahely)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtjob))
                                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                        .addComponent(lbliskola)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtschool))
                                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                                .addComponent(lblname)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtname))
                                            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                                .addComponent(lblszuletesnap)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtdate)))
                                        .addGap(216, 216, 216)
                                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2))
                                            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                                                .addComponent(lblinivited)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblmeghivottak))))))))
                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        adatlap_belsoLayout.setVerticalGroup(
            adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adatlap_belsoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ismerosadatlap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(41, 41, 41)
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname)
                            .addComponent(txtname)
                            .addComponent(lblinivited)
                            .addComponent(lblmeghivottak))
                        .addGap(18, 18, 18)
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblszuletesnap)
                            .addComponent(txtdate)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblnem)
                            .addComponent(txtsex))
                        .addGap(18, 18, 18)
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmunkahely)
                            .addComponent(txtjob))
                        .addGap(18, 18, 18)
                        .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbliskola)
                            .addComponent(txtschool)))
                    .addComponent(profimage, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adatlap_belsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addGroup(adatlap_belsoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout adatlap_panelLayout = new javax.swing.GroupLayout(panel_adatlap);
        panel_adatlap.setLayout(adatlap_panelLayout);
        adatlap_panelLayout.setHorizontalGroup(
            adatlap_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adatlap_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adatlap_belso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        adatlap_panelLayout.setVerticalGroup(
            adatlap_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adatlap_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adatlap_belso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

      adatlap_belso.setBackground(new Color(214, 217, 223));

     profimage.setIcon(new ImageIcon(getClass().getResource("/llamabook/resources/dalaillama.jpg")));
		
	}
	
}
