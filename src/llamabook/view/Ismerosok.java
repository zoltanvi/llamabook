/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author ShockWave
 */
public class Ismerosok {
	 private javax.swing.JButton btnAjanlasKuldese;
    private javax.swing.JButton btnIsmerosnekJelolom;
    private javax.swing.JButton btnJelolesTorlese;
    private javax.swing.JButton btnTorles;
    private javax.swing.JButton btnVisszaigazolas;
    private javax.swing.JComboBox<String> comboBoxMialapjan;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblIsmerosAjanlasa;
    private javax.swing.JLabel lblIsmerosTorlese;
    private javax.swing.JLabel lblJelolesekKezelese;
    private javax.swing.JLabel lblNeki;
    private javax.swing.JList<String> listFelhasznaloJeloles;
    private javax.swing.JList<String> listIsmerosTorles;
    private javax.swing.JList<String> listJelolesekKezelese;
    private javax.swing.JList<String> listNeki;
    javax.swing.JPanel panel_ismerosok;
    private javax.swing.JLabel txtFelhasznaloJeloles;
	
	
	
	
	public Ismerosok(){
		panel_ismerosok = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFelhasznaloJeloles = new javax.swing.JList<>();
        txtFelhasznaloJeloles = new javax.swing.JLabel();
        btnIsmerosnekJelolom = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listJelolesekKezelese = new javax.swing.JList<>();
        lblJelolesekKezelese = new javax.swing.JLabel();
        btnVisszaigazolas = new javax.swing.JButton();
        btnJelolesTorlese = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        lblIsmerosAjanlasa = new javax.swing.JLabel();
        lblNeki = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listNeki = new javax.swing.JList<>();
        comboBoxMialapjan = new javax.swing.JComboBox<>();
        btnAjanlasKuldese = new javax.swing.JButton();
        lblIsmerosTorlese = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listIsmerosTorles = new javax.swing.JList<>();
        btnTorles = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

      
        panel_ismerosok.setBackground(java.awt.Color.white);

        listFelhasznaloJeloles.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        listFelhasznaloJeloles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listFelhasznaloJeloles);

        txtFelhasznaloJeloles.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFelhasznaloJeloles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtFelhasznaloJeloles.setText("Felhasznalok jelolese");

        btnIsmerosnekJelolom.setText("Ismerosnek jelolom");

        listJelolesekKezelese.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        listJelolesekKezelese.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listJelolesekKezelese);

        lblJelolesekKezelese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblJelolesekKezelese.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJelolesekKezelese.setText("Jelolesek kezelese");

        btnVisszaigazolas.setText("Visszaigazolas");

        btnJelolesTorlese.setText("Jeloles torlese");

        jList3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList3);

        lblIsmerosAjanlasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIsmerosAjanlasa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsmerosAjanlasa.setText("Ismeros ajanlasa");

        lblNeki.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNeki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNeki.setText("Neki");

        listNeki.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        listNeki.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listNeki);

        comboBoxMialapjan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kozos ismerosok alapjan", "Munkahely alapjan", "Iskola alapjan" }));

        btnAjanlasKuldese.setText("Ajanlas kuldese");

        lblIsmerosTorlese.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblIsmerosTorlese.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIsmerosTorlese.setText("Ismeros torlese");

        listIsmerosTorles.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        listIsmerosTorles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listIsmerosTorles);

        btnTorles.setText("Torlom");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panel_ismerosokLayout = new javax.swing.GroupLayout(panel_ismerosok);
        panel_ismerosok.setLayout(panel_ismerosokLayout);
        panel_ismerosokLayout.setHorizontalGroup(
            panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ismerosokLayout.createSequentialGroup()
                        .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_ismerosokLayout.createSequentialGroup()
                                .addComponent(btnVisszaigazolas)
                                .addGap(241, 241, 241)
                                .addComponent(btnJelolesTorlese))
                            .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblJelolesekKezelese, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_ismerosokLayout.createSequentialGroup()
                                    .addGap(153, 153, 153)
                                    .addComponent(btnIsmerosnekJelolom))))
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(panel_ismerosokLayout.createSequentialGroup()
                        .addComponent(txtFelhasznaloJeloles, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
                        .addComponent(btnTorles)
                        .addGap(213, 213, 213))
                    .addGroup(panel_ismerosokLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addComponent(lblIsmerosAjanlasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNeki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addGroup(panel_ismerosokLayout.createSequentialGroup()
                                .addComponent(comboBoxMialapjan, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAjanlasKuldese, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addComponent(lblIsmerosTorlese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))
                        .addContainerGap())))
        );
        panel_ismerosokLayout.setVerticalGroup(
            panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ismerosokLayout.createSequentialGroup()
                .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
                        .addGap(492, 492, 492)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIsmerosTorlese)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ismerosokLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFelhasznaloJeloles)
                            .addComponent(lblIsmerosAjanlasa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_ismerosokLayout.createSequentialGroup()
                                .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel_ismerosokLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnIsmerosnekJelolom)
                                        .addGap(17, 17, 17)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_ismerosokLayout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNeki)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4)))
                                .addGap(27, 27, 27)
                                .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblJelolesekKezelese)
                                    .addComponent(comboBoxMialapjan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAjanlasKuldese))
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ismerosokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVisszaigazolas)
                        .addComponent(btnTorles))
                    .addComponent(btnJelolesTorlese))
                .addContainerGap(41, Short.MAX_VALUE))
        );

		panel_ismerosok.setBackground(new Color(214, 217, 223));
        
	}
	
}
