package Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Circle  implements Shape{
	public String type="CIRCLE";
	int id;
	public int ratio;
	public Point randomPoint=new Point(300,50);
	public Point origin=new Point();
	public int speed=1;
	
	public Circle() {
	
	}
	public Circle(int id,Point org, int ratio) {
		this.id=id;
	this.ratio=ratio;
	this.origin=org;

	}

	@Override
	public String getShapeInfo() {
		
		
		return "CIRCLE/"+id+"/"+ ratio+"/"+this.origin.x +"/"+this.origin.y+"X";
	}
	@Override
	public void SetCoordinate(String info) {

		 String[] arrOfStr = info.split("/");

			this.origin.x=Integer.valueOf(arrOfStr[3]);	
			this.origin.y=Integer.valueOf(arrOfStr[4]);
			this.id=Integer.valueOf(arrOfStr[1]);
			this.ratio=Integer.valueOf(arrOfStr[2]);
		
	}

	@Override
		public String GetType() {
			return type;
		}
	
		@Override
		public void update() {
			
			//System.out.println("random" + randomPoint.x);
		
			if(this.origin.x < randomPoint.x) {
				this.origin.x=this.origin.x+1;
			}
			if(this.origin.x > randomPoint.x) {
				this.origin.x=this.origin.x-1;
			}
			if(this.origin.y < randomPoint.y) {
				this.origin.y=this.origin.y+1;
			}
			if(this.origin.y > randomPoint.y) {
				this.origin.y=this.origin.y-1;
			}
			if(this.origin.x == randomPoint.x && this.origin.y == randomPoint.y) {
				randomPoint=getRandomPoint();
				
				
				}
			}
			
			//this.origin.x=this.origin.x+speed;
			//this.origin.y=this.origin.y+speed;
		
		@Override
		  public void paint(Graphics g) {
				if (id==1 ||id==2) {
			  g.setColor(Color.green);
				}
				else if (id==5){
					g.setColor(Color.red);
						
				}
				else if (id==4){
					g.setColor(Color.ORANGE);
						
				}
				else
				{g.setColor(Color.pink);}
			  g.fillOval(origin.x,origin.y , ratio, ratio);
				  
			  

		  }
		@Override
		public Point getRandomPoint() {
			double randNumberx = Math.random();
			double dsx = randNumberx * 800;
	        int randomIntx = (int)dsx;
			randomPoint.x=randomIntx;
			double randNumbery = Math.random();
			double dsy = randNumbery * 800;
	        int randomInty = (int)dsy;
			randomPoint.y=randomInty;
			
			return randomPoint;
		}
		
}
