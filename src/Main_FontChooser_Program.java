import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class Main_FontChooser_Program {
	
	JLabel font_type_label = new JLabel ("Font Type");
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] names = ge.getAvailableFontFamilyNames();
	JList nameslist = new JList(names);  	          
	JScrollPane names_listScroller = new JScrollPane(nameslist);
	JLabel font_size_label = new JLabel ("Font Size");
	String[] fontsize = {"6", "8", "10", "12", "14", "16", "18", "20","22", "24", "26", "28", "30", "32", "34"};
	JList fontsizelist = new JList(fontsize);  
	JScrollPane fontsize_listScroller = new JScrollPane(fontsizelist);	
	JCheckBox bold = new JCheckBox("Bold");
    JCheckBox italic = new JCheckBox("Italic");
    JCheckBox underline = new JCheckBox("Underline");
		
	JPanel font_color_Pane = new JPanel();
		JColorChooser font_color_chooser = new JColorChooser();
	
	JPanel background_color_Pane = new JPanel();
		JColorChooser background_color_chooser = new JColorChooser();

	JPanel previewPanel = new JPanel();

	
public Main_FontChooser_Program() {
		frame(); // This creates a frame. The frame is the pop up window.
	}
	
public void frame() {
	
	JFrame frame = new JFrame();
	frame.setVisible(true); // The pop up window is now visible.
	frame.setSize(710,400); // The pop up window has these dimensions.
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The pop up window can be closed now by clicking close.
	frame.setResizable(false);
	frame.setTitle("Editor");
			
		Box left1 = Box.createVerticalBox();
	    	left1.add(font_type_label);
	    	nameslist.setVisibleRowCount(17);
	    	left1.add(names_listScroller);
	    	left1.setMaximumSize(new Dimension(0,300));
		Box center1 = Box.createVerticalBox();
			center1.add(font_size_label);
			center1.add(fontsize_listScroller);
			center1.setMaximumSize(new Dimension(0,300));
		Box right1 = Box.createVerticalBox();
			right1.add(bold);
			right1.add(Box.createVerticalStrut(30));
			right1.add(italic);
			right1.add(Box.createVerticalStrut(30));
			right1.add(underline);
		Box top1 = Box.createHorizontalBox();
			top1.add(Box.createGlue());
			top1.add(left1);
			top1.add(Box.createGlue());
			top1.add(center1);
			top1.add(Box.createGlue());
			top1.add(right1);
			top1.add(Box.createGlue());

		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Font Style", top1);


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