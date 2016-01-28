import javax.swing.*;
import java.awt.Event.*;


public class MenuuBar
{
	public static void main(String[] args){
		JFrame frame = new JFrame ("Menu");
		frame.setVisible(true);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu fonts = new JMenu("Fonts");
		menubar.add(fonts);
		JMenuItem fontfam = new JMenuItem("Family");
		fonts.add(fontfam);
		JMenuItem fontsty = new JMenuItem("Style");
		fonts.add(fontsty);
		
		JMenu fontcolors = new JMenu("Font Colors");
		menubar.add(fontcolors);
		JMenuItem red = new JMenuItem("Red");
		fontcolors.add(red);
		JMenuItem orange = new JMenuItem("Orange");
		fontcolors.add(orange);
		JMenuItem yellow = new JMenuItem("Yellow");
		fontcolors.add(yellow);
		JMenuItem green = new JMenuItem("Green");
		fontcolors.add(green);
		JMenuItem blue = new JMenuItem("Blue");
		fontcolors.add(blue);
		JMenuItem indigo = new JMenuItem("Indigo");
		fontcolors.add(indigo);
		JMenuItem violet = new JMenuItem("Violet");
		fontcolors.add(violet);
		
		JMenu backcolors = new JMenu("Background Colors");
		menubar.add(backcolors);
		JMenuItem red1 = new JMenuItem("Red");
		
		fontcolors.add(red1);
		JMenuItem orange1 = new JMenuItem("Orange");
		fontcolors.add(orange1);
		JMenuItem yellow1 = new JMenuItem("Yellow");
		fontcolors.add(yellow1);
		JMenuItem green1 = new JMenuItem("Green");
		fontcolors.add(green1);
		JMenuItem blue1 = new JMenuItem("Blue");
		fontcolors.add(blue1);
		JMenuItem indigo1 = new JMenuItem("Indigo");
		fontcolors.add(indigo1);
		JMenuItem violet1 = new JMenuItem("Violet");
		fontcolors.add(violet1);
		
		JMenu results = new JMenu("Results");
		menubar.add(results);
		
	}	
}
