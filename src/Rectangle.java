package Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Rectangle  implements Shape{
	public String type="RECT";
	int id;
	public int width;
	public int height;
	//public Point br=new Point();
	public Point tl=new Point();
	public Point randomPoint=new Point(150,250);
	
	public int speed=1;
	
	public Rectangle() {

	}		
	public Rectangle(int id,Point tl,int width,int height) {
		this.id=id;
		this.tl=tl;
		this.width=width;
		this.height=height;
	//	this.br.x=Math.abs(tl.x+width);
		//this.br.y=Math.abs(tl.y+height);

		
		
	}


	@Override
	public String getShapeInfo() {
		
		return "RECT/"+id+"/"+width+"/"+height+"/"+tl.x+"/"+tl.y+"X";
	}
	@Override
	public void SetCoordinate(String info) {
		
	
		 String[] arrOfStr = info.split("/");

			this.tl.x=Integer.valueOf(arrOfStr[4]);	
			this.tl.y=Integer.valueOf(arrOfStr[5]);
		    this.id = Integer.valueOf(arrOfStr[1]);
		    this.width= Integer.valueOf(arrOfStr[2]);
		    this.height= Integer.valueOf(arrOfStr[3]);
		
	}

	public String GetType() {
		return type;
	}
	@Override
	public void update() {
		if(this.tl.y < randomPoint.y) {
			this.tl.y=this.tl.y+speed;	
			
		}
		if(this.tl.y > randomPoint.y) {
			this.tl.y=this.tl.y-speed;
		}
		if(this.tl.x < randomPoint.x) {
			this.tl.x=this.tl.x+speed;	
		}
		if(this.tl.x > randomPoint.x) {
			this.tl.x=this.tl.x-speed;
		}
		if(this.tl.y == randomPoint.y &&this.tl.x == randomPoint.x) {
			randomPoint=getRandomPoint();
			//System.out.println(this.tl.y);
			
			}
	//	this.tl.y=tl.y+speed;
		//this.tl.x=tl.x+speed;

	
	}
	@Override
	  public void paint(Graphics g) {
			
			 
			  g.setColor(Color.GREEN);
			  g.fillRect(tl.x,tl.y,width,height);
				
	  }
	@Override
	public Point getRandomPoint() {
		double randNumberx = Math.random();
		double dsx = randNumberx * 800;
        int randomIntx = (int)dsx;
		randomPoint.x=Math.abs(randomIntx);
		double randNumbery = Math.random();
		double dsy = randNumbery * 800;
        int randomInty = (int)dsy;
		randomPoint.y=Math.abs(randomInty);
		
		return randomPoint;
	}


		
}
