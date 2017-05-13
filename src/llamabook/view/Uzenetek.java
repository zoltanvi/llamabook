/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import llamabook.controller.PropertiesController;

/**
 *
 * @author ShockWave
 */
public class Uzenetek {
	
	JPanel panel_uzenetek = new JPanel();
	
	public Uzenetek(){
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		PropertiesController props = new PropertiesController();
		panel_uzenetek.setLayout(new BorderLayout(0, 0));
		
		JPanel toppanel = new JPanel();
		panel_uzenetek.add(toppanel, BorderLayout.NORTH);
		toppanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton rdbtnBaratok = new JRadioButton(props.getProperty("uzism"));
		toppanel.add(rdbtnBaratok);
		String feltolt[] = {"Zoli", "Attila", "Akos", "Aztakurva", "JesszusMaria"};
		JComboBox<String> listFriends = new JComboBox<>(feltolt);
		listFriends.setBackground(Color.WHITE);
		toppanel.add(listFriends);
		
		
		JRadioButton rdbtnMindenki = new JRadioButton(props.getProperty("uzmind"));
		toppanel.add(rdbtnMindenki);
		String feltolt2[] = {"Ismeretlen", "Egy masik ismeretlen", "Egy ismeros", "Nem tudni", "Koko Jambo"};
		JComboBox<String> listAll = new JComboBox<>(feltolt2);
		listAll.setBackground(Color.WHITE);
		toppanel.add(listAll);
		JButton buttonSelect = new JButton(LabelsAndProperties.buttonselect);
		toppanel.add(buttonSelect);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnBaratok);
		bg.add(rdbtnMindenki);
		JPanel centerpanel = new JPanel();
		panel_uzenetek.add(centerpanel, BorderLayout.CENTER);
		centerpanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		centerpanel.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtUzenetszoveg = new JTextArea();
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
		
		buttonSelect.addActionListener((ActionEvent e) -> {
			if(e.getSource() == buttonSelect){
				if(rdbtnBaratok.isSelected()){
					txtUzenetszoveg.setText((String)(listFriends.getSelectedItem()) + " kijelolve");
				}
				else if(rdbtnMindenki.isSelected()){
					txtUzenetszoveg.setText((String)(listAll.getSelectedItem()) + " kijelolve");
				}
				else {
					txtUzenetszoveg.setText("Kerlek jelold ki valamelyiket! (ismerosök) (mindenki)");
				}
				
			}
		});
		
		buttonSubmit.addActionListener((ActionEvent e) -> {
			if(e.getSource() == buttonSubmit && txtElnemkuldott.getText().length() > 0 ){
					
		txtUzenetszoveg.setText(txtUzenetszoveg.getText() + "\n"
				+ "_______________________________________________\n" + txtElnemkuldott.getText());
		txtElnemkuldott.setText(null);
			}
			
		});
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
	}
}
