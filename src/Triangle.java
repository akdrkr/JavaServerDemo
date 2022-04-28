package Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Triangle  implements Shape{
	public String type="TRIANGLE";
	int id;
	public Point p1=new Point();
	public Point p2=new Point();
	public Point p3=new Point();
	public Point randomPoint= new Point();
	
	public int speed=1;
	public Triangle() {
	
	}
	
	public Triangle(int id,Point p1,Point p2,Point p3) {
		this.id=id;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	
	}

	@Override
	public String getShapeInfo() {
		
return "TRIANGLE/"+id+"/"+this.p1.x+"/"+this.p1.y+"/"+this.p2.x+"/"+this.p2.y+"/"+this.p3.x+"/"+this.p3.y+"X";
		
	}

	@Override
	public void SetCoordinate(String info) {
		 String[] arrOfStr = info.split("/");
			p1.y=Integer.valueOf(arrOfStr[3]);	
			p2.y=Integer.valueOf(arrOfStr[5]);
			p3.y=Integer.valueOf(arrOfStr[7]);
		
		
			p1.x=Integer.valueOf(arrOfStr[2]);	
			p2.x=Integer.valueOf(arrOfStr[4]);
			p3.x=Integer.valueOf(arrOfStr[6]);
		
		
	}

	
	@Override
	public String GetType() {
		return type;
	}
	@Override
	public void update() {
		if(p1.y < randomPoint.y) {
			p1.y=p1.y+speed;	
			p2.y=p2.y+speed;
			p3.y=p3.y+speed;
		}
		if(p1.y > randomPoint.y) {
			p1.y=p1.y-speed;	
			p2.y=p2.y-speed;
			p3.y=p3.y-speed;
		}
		if(p1.x < randomPoint.x) {
			p1.x=p1.x+speed;	
			p2.x=p2.x+speed;
			p3.x=p3.x+speed;
		}
		if(p1.x > randomPoint.x) {
			p1.x=p1.x-speed;	
			p2.x=p2.x-speed;
			p3.x=p3.x-speed;
		}
		if(p1.y  == randomPoint.y &&p1.x == randomPoint.x) {
			randomPoint=getRandomPoint();
		}
		
		
	  }
	@Override
	  public void paint(Graphics g) {
		
				    int x[] = {p1.x,p2.x,p3.x};
				    int y[] = {p1.y,p2.y,p3.y};
				 
				    g.setColor(Color.BLUE);
				    g.drawPolygon(x, y, 3);//draws polygon outline
				    g.fillPolygon(x, y, 3);//paints a polygon
				    

	  }

	@Override
	public Point getRandomPoint() {
		double randNumberx = Math.random();
		double dsx = randNumberx * 700;
        int randomIntx = (int)dsx;
        randomPoint.x=Math.abs(randomIntx);
		double randNumbery = Math.random();
		double dsy = randNumbery * 700;
        int randomInty = (int)dsy;
        randomPoint.y=Math.abs(randomInty);
		
		return randomPoint;
	}
	  

				
		
}
