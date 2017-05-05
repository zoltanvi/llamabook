/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.view;


import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

/**
 *
 * @author ShockWave
 */
public class Csoportok {
	 private javax.swing.JButton btnAjanlom;
    private javax.swing.JButton btnBelepek;
    private javax.swing.JButton btnBelepekCsoportAjanlat;
    private javax.swing.JButton btnKilepek;
    private javax.swing.JButton btnLetrehozas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCsoportAjanlatok;
    private javax.swing.JLabel lblCsoportLetrehozasa;
    private javax.swing.JLabel lblCsoportLetszam;
    private javax.swing.JLabel lblCsoportjaim;
    private javax.swing.JLabel lblCsoportokListaja;
    private javax.swing.JLabel lblEztAjanlom;
    private javax.swing.JLabel lblLetszam;
    private javax.swing.JLabel lblNeki;
    private javax.swing.JList<String> listAjanlatok;
    private javax.swing.JList<String> listCsoportjaim;
    private javax.swing.JList<String> listCsoportokListaja;
    private javax.swing.JList<String> listEztAjanlom;
    private javax.swing.JList<String> listNeki;
    javax.swing.JPanel panel_csoportok;
    private javax.swing.JTextField txtCreateCsoport;
	public Csoportok(){
		
		panel_csoportok = new javax.swing.JPanel();
        lblCsoportokListaja = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCsoportokListaja = new javax.swing.JList<>();
        lblCsoportLetszam = new javax.swing.JLabel();
        lblLetszam = new javax.swing.JLabel();
        btnKilepek = new javax.swing.JButton();
        btnBelepek = new javax.swing.JButton();
        lblCsoportAjanlatok = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAjanlatok = new javax.swing.JList<>();
        btnBelepekCsoportAjanlat = new javax.swing.JButton();
        lblEztAjanlom = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEztAjanlom = new javax.swing.JList<>();
        lblNeki = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listNeki = new javax.swing.JList<>();
        btnAjanlom = new javax.swing.JButton();
        lblCsoportLetrehozasa = new javax.swing.JLabel();
        txtCreateCsoport = new javax.swing.JTextField();
        btnLetrehozas = new javax.swing.JButton();
        lblCsoportjaim = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listCsoportjaim = new javax.swing.JList<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        lblCsoportokListaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCsoportokListaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCsoportokListaja.setText("Csoportok listaja");

        listCsoportokListaja.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listCsoportokListaja);

        lblCsoportLetszam.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCsoportLetszam.setText("A csoport letszama:");

        lblLetszam.setForeground(new java.awt.Color(255, 102, 0));
        lblLetszam.setText("letszam");

        btnKilepek.setText("Kilepek");

        btnBelepek.setText("Belepek");

        lblCsoportAjanlatok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCsoportAjanlatok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCsoportAjanlatok.setText("Csoport ajanlatok");

        listAjanlatok.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };	// ide jön a lista...
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listAjanlatok);

        btnBelepekCsoportAjanlat.setText("Belepek");

        lblEztAjanlom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEztAjanlom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEztAjanlom.setText("Ezt a csoportot ajanlom");

        listEztAjanlom.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(listEztAjanlom);

        lblNeki.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNeki.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNeki.setText("Neki");

        listNeki.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };		// ide jön a lista 2 - teszt komment
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listNeki);

        btnAjanlom.setText("Ajanlom");

        lblCsoportLetrehozasa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCsoportLetrehozasa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCsoportLetrehozasa.setText("Csoport letrehozasa");

        btnLetrehozas.setText("Letrehozas");

        lblCsoportjaim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCsoportjaim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCsoportjaim.setText("Csoportjaim");

        listCsoportjaim.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listCsoportjaim);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panel_csoportokLayout = new javax.swing.GroupLayout(panel_csoportok);
        panel_csoportok.setLayout(panel_csoportokLayout);
        panel_csoportokLayout.setHorizontalGroup(
            panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_csoportokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_csoportokLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnBelepekCsoportAjanlat))
                    .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panel_csoportokLayout.createSequentialGroup()
                            .addComponent(lblCsoportLetszam, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblLetszam, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                            .addComponent(btnBelepek)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnKilepek)
                            .addGap(1, 1, 1))
                        .addComponent(jScrollPane1)
                        .addComponent(lblCsoportokListaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblCsoportAjanlatok, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_csoportokLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_csoportokLayout.createSequentialGroup()
                                .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEztAjanlom, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(lblNeki, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_csoportokLayout.createSequentialGroup()
                                        .addComponent(btnAjanlom)
                                        .addGap(197, 197, 197))
                                    .addComponent(lblCsoportLetrehozasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCreateCsoport)
                                    .addComponent(jScrollPane5))
                                .addContainerGap())
                            .addGroup(panel_csoportokLayout.createSequentialGroup()
                                .addComponent(lblCsoportjaim, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(panel_csoportokLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_csoportokLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_csoportokLayout.createSequentialGroup()
                                .addComponent(btnLetrehozas)
                                .addGap(201, 201, 201))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_csoportokLayout.createSequentialGroup()
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        panel_csoportokLayout.setVerticalGroup(
            panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_csoportokLayout.createSequentialGroup()
                .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_csoportokLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEztAjanlom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCsoportokListaja, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_csoportokLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNeki)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCsoportLetszam)
                                .addComponent(lblLetszam))
                            .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnKilepek)
                                .addComponent(btnBelepek)
                                .addComponent(btnAjanlom)))
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_csoportokLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(panel_csoportokLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_csoportokLayout.createSequentialGroup()
                                .addGroup(panel_csoportokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCsoportAjanlatok)
                                    .addComponent(lblCsoportLetrehozasa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBelepekCsoportAjanlat))
                            .addGroup(panel_csoportokLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txtCreateCsoport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLetrehozas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lblCsoportjaim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel_csoportokLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
		
	}
}
