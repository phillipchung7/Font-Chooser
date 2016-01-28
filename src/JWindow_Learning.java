import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import javax.swing.*;  
/* 
   <applet code = "JTabbedPaneDemo" width=400 height=100> 
   </applet> 
 */  
public class JWindow_Learning extends JApplet  
{  


	public void init()  
    {  
        JTabbedPane jtp=new JTabbedPane();  
        jtp.addTab("Fonts",new Font());  
        jtp.addTab("Text Color",new TextColor());  
        jtp.addTab("Background Color",new BackgroundColor());  
        getContentPane().add(jtp);  
    }  
}  
class Font extends JPanel  
{  
    public Font()  
    {  
    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] names = ge.getAvailableFontFamilyNames();
        
        JList nameslist = new JList(names);  	          // creating JList object
        JScrollPane listScroller = new JScrollPane(nameslist);
        add(listScroller);
        
        JPanel fontstyles = new JPanel(new GridLayout(3,0));
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italic");
        JCheckBox underline = new JCheckBox("Underline");
        
        fontstyles.add(bold);
        fontstyles.add(italic);
        fontstyles.add(underline);

        add(fontstyles);
        
    }  
}  
class TextColor extends JPanel  
{  
    public TextColor()  
    {  
    	JColorChooser colorChooser1 = new JColorChooser();
    	add(colorChooser1);
    }  
}  
class BackgroundColor extends JPanel  
{  
    public BackgroundColor()  
    {  
    	JColorChooser colorChooser2 = new JColorChooser();
    	add(colorChooser2); 
    }  
} 

