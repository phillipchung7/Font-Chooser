import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main_FontChooser_Program {
	
	JPanel font_Pane = new JPanel();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] names = ge.getAvailableFontFamilyNames();
		JList nameslist = new JList(names);  	          // creating JList object
		JScrollPane listScroller = new JScrollPane(nameslist);
		
	JPanel font_color_Pane = new JPanel();
		JColorChooser font_color_chooser = new JColorChooser();
	
	JPanel background_color_Pane = new JPanel();
		JColorChooser background_color_chooser = new JColorChooser();

	
	
public Main_FontChooser_Program() {
		
		frame(); // This creates a frame. The frame is the pop up window.
	}
	
public void frame() {
	
	JFrame frame = new JFrame();
	frame.setVisible(true); // The pop up window is now visible.
	frame.setSize(710,500); // The pop up window has these dimensions.
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The pop up window can be closed now by clicking close.
	
	JTabbedPane jtp = new JTabbedPane();

	jtp.addTab("Font Style", font_Pane);
		font_Pane.add(listScroller);

	jtp.addTab("Font Color", font_color_Pane);
		font_color_chooser.setPreviewPanel(font_color_Pane);
		font_color_Pane.add(font_color_chooser);

	
    jtp.addTab("Background Color", background_color_Pane);
    	background_color_chooser.setPreviewPanel(background_color_Pane);
    	background_color_Pane.add(background_color_chooser);

    
    
    frame.add(jtp); // Now we add the panel to the frame.

	
}
	

public static void main(String[] args)
	{
	new Main_FontChooser_Program();
	}
}