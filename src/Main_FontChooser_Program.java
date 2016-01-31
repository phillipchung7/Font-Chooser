import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.util.Hashtable;

public class Main_FontChooser_Program {
	
	JLabel font_type_label = new JLabel ("Font Type");
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String[] names = ge.getAvailableFontFamilyNames();
	JList nameslist = new JList(names);  
	JScrollPane names_listScroller = new JScrollPane(nameslist);
	JLabel font_size_label = new JLabel ("Font Size");
	JSlider font_slider = new JSlider(5, 35, 20);
    JCheckBox bold = new JCheckBox("Bold");
    JCheckBox italic = new JCheckBox("Italic");
		
	JPanel font_color_Pane = new JPanel();
	JColorChooser font_color_chooser = new JColorChooser();
	
	JPanel background_color_Pane = new JPanel();
	JColorChooser background_color_chooser = new JColorChooser();

	JPanel preview_Panel = new JPanel(new BorderLayout());
 
	String preview_text = "<html>"
			+ "The quick brown fox jumped over the lazy dog’s back.<br>"
			+ "Pack my box with five dozen liquor jugs.<br>"
			+ "Jackdaws love my big sphinx of quartz.<br>"
			+ "Mr. Jock, TV quiz PhD, bags few lynx.<br>"
			+ "abcdefghijklmnopqrstuvwxyz<br>"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ<br>"
			+ "01234567890<br>"
			+ "€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£\"»®§­¹²³ß×™¨¥<br>"
			+ "ÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ<br>"
			+ "àáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ<br>"
			+ "!\"#$%&\'()*+,-./:;<=>?@[\\^_z{|}~<br>"
			+ "uvw wW gq9 2z 5s il17|!j oO08 `'\" ;:,. m nn rn {[()]}u<br>"
			+ "</html>";
	JLabel preview_font = new JLabel (preview_text,JLabel.CENTER);

public Main_FontChooser_Program() {
		GUI(); 
	}

public void GUI() {
	
	JFrame frame = new JFrame();
		
		Box left1 = Box.createVerticalBox();
	    	left1.add(font_type_label);
	    	names_listScroller.setPreferredSize(new Dimension(390,0));
	    	nameslist.setCellRenderer(new FontCellRenderer());
	    	left1.add(Box.createVerticalStrut(5));
	    	left1.add(names_listScroller);
	    	left1.add(Box.createVerticalStrut(15));
		Box right1 = Box.createVerticalBox();
			right1.add(Box.createGlue());
			right1.add(font_size_label);
			right1.add(Box.createVerticalStrut(10));
			right1.add(font_slider);
				font_slider.setMajorTickSpacing(5);
				font_slider.setPaintTicks(true);
				Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
			    table.put (5, new JLabel("5"));
			    table.put (10, new JLabel("10"));
			    table.put (15, new JLabel("15"));
			    table.put (20, new JLabel("20"));
			    table.put (25, new JLabel("25"));
			    table.put (30, new JLabel("30"));
			    table.put (35, new JLabel("35"));
			    font_slider.setLabelTable (table);
			    font_slider.setPaintLabels(true);
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
	jtp.setFont(new java.awt.Font("Calibri", Font.BOLD,16));			
	jtp.addTab("Font Style", top1);
	jtp.addTab("Font Color", font_color_Pane);
		font_color_chooser.setPreviewPanel(font_color_Pane);
		font_color_Pane.add(font_color_chooser);
    jtp.addTab("Background Color", background_color_Pane);
    	background_color_chooser.setPreviewPanel(background_color_Pane);
    	background_color_Pane.add(background_color_chooser);

    frame.add(jtp); 
    frame.setVisible(true);
	frame.setSize(710,400); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.setResizable(false);
	frame.setTitle("Editor");
	
	JFrame preview = new JFrame();
	preview.setVisible(true); 
	preview.setSize(550,500); 
	preview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	preview.setTitle("Preview");
	
	preview.add(preview_Panel);
	preview_Panel.setBackground(Color.WHITE);
    preview_font.setFont(new Font("Default",Font.PLAIN,20));		
	preview_Panel.add(preview_font);


	
	nameslist.addListSelectionListener(new ListSelectionListener() {
	      public void valueChanged(ListSelectionEvent e) {
	    	  int size = font_slider.getValue();
	    	  String font_selected = nameslist.getSelectedValue().toString();
	    	  preview_font.setFont(new Font(font_selected,Font.PLAIN, size));
	      }
	    });
	
	
	font_slider.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent evt) {
	        JSlider font_slider = (JSlider) evt.getSource();
	        if (font_slider.getValueIsAdjusting()) {
	          float value = font_slider.getValue();
	          preview_font.setFont(preview_font.getFont().deriveFont(value));	        }
	        }
	    });
	
    ColorSelectionModel background_model = background_color_chooser.getSelectionModel();
    ChangeListener backgroundchangeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        Color newBackgroundcolor = background_color_chooser.getColor();
        preview_Panel.setBackground(newBackgroundcolor);
      }
    };
    background_model.addChangeListener(backgroundchangeListener);
    
    ColorSelectionModel font_model = font_color_chooser.getSelectionModel();
    ChangeListener fontchangeListener = new ChangeListener() {
      public void stateChanged(ChangeEvent changeEvent) {
        Color newfontcolor = font_color_chooser.getColor();
        preview_font.setForeground(newfontcolor);      }
    };
    font_model.addChangeListener(fontchangeListener);
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