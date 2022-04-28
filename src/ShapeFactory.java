package Shape;

public class ShapeFactory {

	int id =0;
	
	public Shape getShape(String type) {
		if(type.contains("SQUARE")) {
			return getSquare();
		}
		if(type.contains("RECT")) {
		
			return getRectangle();
		}
		if(type.contains("CIRCLE")) {
		
			return getCircle();
		} 
		if(type.contains("TRIANGLE")) {
			return getTriangle();
		}
		else 
		{
			return new  Rectangle(id,new Point(5,5),10,10);
		}
	}
		
		
		
	
	public Rectangle getSquare() {
		id++;
		return new Rectangle(id,new Point(5,5),10,10);
	}
	public Rectangle getRectangle() {
		id++;		
		return new Rectangle(id,new Point(500,500), 20+getSize(), 20+getSize());
	}
	public Circle getCircle() {
		id++;
		return new Circle(id,new Point(300,300), 20+getSize());
	}
	public Triangle getTriangle() {
		id++;
		return new Triangle(id,new Point(70,200),new Point(110,70),new Point(170,200));
	}
	public int getSize() {
		double randNumberx = Math.random();
		double dsx = randNumberx * 110;
        int randomSize = Math.abs((int)dsx);
		
		return randomSize;
	}
	
}
