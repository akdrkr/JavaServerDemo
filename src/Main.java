package Shape;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Main{

	public static void main(String[] args) {
		int ScreenWidth=900;
		int ScreenHeight=900;
		Gui gui;
		gui=new Gui("Shapes Example",ScreenWidth,ScreenHeight);
		gui.setVisible(true);


		
		
	}
	
}
