import java.awt.GraphicsEnvironment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DropDown_Fonts {
	
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] names = ge.getAvailableFontFamilyNames();
    
    JList nameslist = new JList(names);  	          // creating JList object
    JScrollPane listScroller = new JScrollPane(nameslist);
    JCheckBox bold = new JCheckBox("Bold");
    JCheckBox italic = new JCheckBox("Italic");
    JCheckBox underline = new JCheckBox("Underline");


    
	public DropDown_Fonts() {
		
		frame(); // This creates a frame. The frame is the pop up window.
	}
	
public void frame() {
	
	JFrame f = new JFrame();
	f.setVisible(true); // The pop up window is now visible.
	f.setSize(700,500); // The pop up window has these dimensions.
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The pop up window can be closed now by clicking close.


	
	JPanel p = new JPanel(new GridLayout(0,2)); //We must make a panel. The Gridlayout allows us to organize the features in two columns.
	JPanel s = new JPanel(new GridLayout(0,1)); //We must make a panel. The Gridlayout allows us to organize the features in two columns.
	p.add(listScroller); // On the panel, we add the different features (JLabel, JComboBox, JButton, etc.)
	p.add(s); // On the panel, we add the different features (JLabel, JComboBox, JButton, etc.)

	s.add(bold);
	s.add(italic);
	s.add(underline);



	f.add(p); // Now we add the panel to the frame.

	
	
}
	

public static void main(String[] args)
	{
	new DropDown_Fonts();
	}
}