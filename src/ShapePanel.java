package Shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.JPanel;

public class ShapePanel extends JPanel implements ActionListener {
	
	 ArrayList<Shape> shapes;
	Timer timer;
	boolean isServer;
	public ShapePanel( ArrayList<Shape> shapes,boolean isServer) {
		
		this.shapes=shapes;
		this.isServer=isServer;
		timer=new Timer(10,this);
		timer.start();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
			super.paintComponent(g);
		  for(Shape shape: this.shapes) {
				 shape.paint(g);
				
			 }
		 
		
	}
	
	    public void update() {
	    
	    	 for(Shape shape: this.shapes) {
				 shape.update();
			 }
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			repaint();
			if(isServer) {
				
				update();
			}
		}
	    
}

