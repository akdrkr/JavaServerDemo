package Shape;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Server extends Thread {
	public ServerSocket serverSocket = null;
	public Socket sock;
	public DataInputStream din;
	public DataOutputStream dout;
	public int port;
	public String msgout = "";
	public String msgin = "";
	ArrayList<Shape> shapes;

	public Server(int port) {
		this.port = port;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server Port No: " + port + " olusturuldu");

		} catch (Exception e) {
			System.out.println("Server olusturulamadi!");
		}
	}

	public void run() {
		try {

			System.out.println(this.port + " listening!");

			while (true) {
				Socket sock = serverSocket.accept();
				ServerConnection asd = new ServerConnection(sock);
				asd.shapes = shapes;
				asd.start();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
