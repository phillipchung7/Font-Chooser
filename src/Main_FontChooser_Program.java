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
	SpinnerNumberModel model = new SpinnerNumberModel(12, 4, 24, 1);
    	JSpinner font_size = new JSpinner(model);	
    	JFormattedTextField cannnot_edit = ((JSpinner.DefaultEditor) font_size.getEditor()).getTextField();
    JCheckBox bold = new JCheckBox("Bold");
    JCheckBox italic = new JCheckBox("Italic");
		
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
	
	nameslist.setCellRenderer(new FontCellRenderer());
	
		Box left1 = Box.createVerticalBox();
	    	left1.add(font_type_label);
	    	names_listScroller.setPreferredSize(new Dimension(350,0));
	    	left1.add(Box.createVerticalStrut(5));
	    	left1.add(names_listScroller);
	    	left1.add(Box.createVerticalStrut(15));
		Box right1 = Box.createVerticalBox();
			right1.add(Box.createGlue());
			right1.add(font_size_label);
			right1.add(Box.createVerticalStrut(5));
			right1.add(font_size);
				cannnot_edit.setEditable(false);
			right1.add(Box.createGlue());
			right1.add(bold);
				bold.setFont(new java.awt.Font("Default", Font.BOLD,18));
			right1.add(Box.createVerticalStrut(30));
			right1.add(italic);
				italic.setFont(new java.awt.Font("Default", Font.ITALIC,18));
			right1.add(Box.createGlue());
		Box top1 = Box.createHorizontalBox();
			top1.add(Box.createHorizontalStrut(20));
			top1.add(left1);
			top1.add(Box.createGlue());
			top1.add(right1);
			top1.add(Box.createGlue());

	JTabbedPane jtp = new JTabbedPane();
	jtp.setFont(new java.awt.Font("Default", Font.ITALIC,16));			
	jtp.addTab("Font Style", top1);


	jtp.addTab("Font Color", font_color_Pane);
		font_color_chooser.setPreviewPanel(font_color_Pane);
		font_color_Pane.add(font_color_chooser);

	
    jtp.addTab("Background Color", background_color_Pane);
    	background_color_chooser.setPreviewPanel(background_color_Pane);
    	background_color_Pane.add(background_color_chooser);

    frame.add(jtp); // Now we add the panel to the frame.
    frame.setVisible(true); // The pop up window is now visible.
	frame.setSize(710,400); // The pop up window has these dimensions.
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //The pop up window can be closed now by clicking close.
	frame.setResizable(false);
	frame.setTitle("Editor");
}



class FontCellRenderer extends DefaultListCellRenderer {

    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {
        JLabel label = (JLabel)super.getListCellRendererComponent(
            list,value,index,isSelected,cellHasFocus);
        Font font = new Font((String)value, Font.PLAIN, 16);
        label.setFont(font);
        return label;
    }
}
	

public static void main(String[] args)
	{
	new Main_FontChooser_Program();
	}
}