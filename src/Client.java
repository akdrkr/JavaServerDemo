package Shape;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Client extends Thread{

	public Socket sock;
	public DataInputStream din;
	public DataOutputStream dout;
	String msgin="";
	String msgout="connection success";
	int delay=1;
	 ArrayList<Shape> shapes;
	public Client(String host,int port) {
		try {
			sock=new Socket(host,port);
			System.out.println("Client Port No: "+port+" olusturuldu");
			
		} catch (Exception e) {
			System.out.println("Client olusturulamadi!");
		}
		
	}
	
	@Override
	public void run() {
		try {
			 this.din=new DataInputStream(sock.getInputStream());
			 this.dout=new  DataOutputStream(sock.getOutputStream());
			dout.writeUTF(msgout);
			while(!msgin.equals("end")) {
								
				msgin=din.readUTF();
				 String[] arrOfStr = msgin.split("X");
				 
				 if(shapes.size()>0) {	// shape arraylist dolu ile gelen kordinatlari set et		
				
				        	for (int i=0;i<arrOfStr.length;i++) {
				        		shapes.get(i).SetCoordinate(arrOfStr[i]);
				        		//System.out.println(arrOfStr[0]);
				        	}
				        
				        
				 }

				
				if(shapes.size()==0) {
					
					 for (String a : arrOfStr) {
						 ShapeFactory factory=new ShapeFactory();
						
						
						 this.shapes.add(factory.getShape(a.split("/")[0]));
				       
				       }
					 System.out.println("olusturuldu");
				}
				  //TimeUnit.MILLISECONDS.sleep(delay*10);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}




