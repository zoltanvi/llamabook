/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llamabook.view;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ShockWave
 */

public class Memes {
	
   
   JPanel panel_memes = new JPanel();
	private JLabel pepe = new JLabel();
	public Memes(){
		
	panel_memes.setLayout(new FlowLayout());
	
	panel_memes.add(pepe);
	pepe.setIcon(new ImageIcon(getClass().getResource("/llamabook/resources/unnamed.png")));
		
	}
	
}
