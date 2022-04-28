package Shape;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServerConnection extends Thread {
	private Socket client_socket;
	public String msgout="";
	public 	String msgin="";
	public DataInputStream din;
	public DataOutputStream dout;
	 ArrayList<Shape> shapes;
		int delay=1;
	public ServerConnection(Socket client_socket) {
		this.client_socket = client_socket;
	}
	
    public void run() {
		 try {
			this.din=new DataInputStream(client_socket.getInputStream());
			 this.dout=new  DataOutputStream(client_socket.getOutputStream());
				msgin=din.readUTF();
		        String str = "", str2 = "";
		        int counter = 0;
	        while (!str.equals("end"))
	        {
	        	String data="";
				for(Shape shape : shapes ) {
					data+=shape.getShapeInfo();
				}	
				msgout=data;
				dout.writeUTF(msgout);
				dout.flush();
				TimeUnit.MILLISECONDS.sleep(delay*10);
	        }

	        din.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    }

}