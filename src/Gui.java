package Shape;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends JFrame  {
	JButton clientJButton ;
	JButton serverJButton ;
	JButton serverStartJButton ;
	JButton clientStartJButton ;
	
	JPanel panel;
    JTextField rectTextField ;
    JTextField circleTextField;
    JTextField triangleTextField;
    JTextField portNumberTextField;
    JTextField portTextField;
    JTextField hostTextField;
    public int port ;
    public String host;
	public Gui(String panelName,int width,int height) {
		super(panelName);
		this.setSize(width, height);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    openingPage();
	    
	    clientListener(this);
	    serverListener(this);
	}
	
	
	 private void openingPage(){
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 panel = new JPanel(new BorderLayout());
	        JPanel serverJPanel = new JPanel();
	        serverJPanel.setLayout(new FlowLayout());
	        JPanel clientJPanel = new JPanel();
	        clientJPanel.setLayout(new FlowLayout());
	         serverJButton = new JButton("Server");
	        serverJButton.setPreferredSize(new Dimension(200,100));
	        serverJButton.setFont(new Font("asd",Font.BOLD, 24));
	        serverJPanel.add(serverJButton);

	        
	         clientJButton = new JButton("Client");
	        clientJButton.setPreferredSize(new Dimension(200,100));
	        clientJButton.setFont(new Font("asd",Font.BOLD, 24));
	        clientJPanel.add(clientJButton);
	
	        panel.add(serverJPanel,BorderLayout.CENTER);
	        panel.add(clientJPanel, BorderLayout.NORTH);
	        this.add(panel);
	        this.setLocationRelativeTo(null);
	        this.setVisible(true);
	    }

	
	

	
	 public void DrawServerInfoPage(){
		 
	    
	      	this.panel.removeAll();
	   
	        panel.setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridy=0;
	        gbc.insets = new Insets(1, 1, 1, 1);
	        JLabel lblRect = new JLabel("Rect");
	        JLabel lblCircle = new JLabel("Circle");
	        JLabel lblTriangle = new JLabel("Triangle");
	        JLabel lblPort = new JLabel("port");
	         rectTextField = new JTextField(10);
	         circleTextField= new JTextField(10);
	         triangleTextField= new JTextField(10);
	         portNumberTextField = new JTextField(10);
	         
	      
	        gbc.gridx=0;
	        gbc.gridy=0;
	        panel.add(lblRect, gbc);
	        gbc.gridy=1;
	        panel.add(lblCircle, gbc);
	        gbc.gridy=2;
	        panel.add(lblTriangle, gbc);
	        gbc.gridy=3;
	        panel.add(lblPort, gbc);
	        
	        gbc.gridx=1;
	        gbc.gridy=0;
	        panel.add(rectTextField,gbc);
	        gbc.gridy+=1;
	        panel.add(circleTextField,gbc);
	        gbc.gridy+=1;
	        panel.add(triangleTextField,gbc);
	        gbc.gridy+=1;
	        panel.add(portNumberTextField,gbc);
	        gbc.gridx = 0;
	        gbc.gridy+=1;
	        gbc.gridx=1;
	        gbc.gridx=1;
	       
	        serverStartJButton = new JButton("Server Start");
	        serverStartJButton.setPreferredSize(new Dimension(190,40));
	        serverStartJButton.setFont(new Font("asd",Font.BOLD, 24));
	 
	        panel.add(serverStartJButton,gbc);
	        serverStartButtonAddActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					
					panel.removeAll();
					port=Integer.valueOf(portNumberTextField.getText());
					ShapeFactory factory=new ShapeFactory();
					try {
						
						ArrayList<Shape> shapes=new ArrayList<>();
						System.out.println(rectTextField.getText() + "  "  + circleTextField.getText() + "  "  + triangleTextField.getText());
						int i = 0;
						for(; i < Integer.valueOf(rectTextField.getText());i++) {
							shapes.add( factory.getShape("RECT"));
						}
						for(; i < Integer.valueOf(circleTextField.getText())+Integer.valueOf(rectTextField.getText());i++) {
							shapes.add(factory.getShape("CIRCLE"));
						}
						for(; i < Integer.valueOf(triangleTextField.getText())+Integer.valueOf(circleTextField.getText())+Integer.valueOf(rectTextField.getText());i++) {
							shapes.add(factory.getShape("TRIANGLE"));
						}
						ShapePanel panel = new ShapePanel(shapes,true);
						addShapesPanel(panel);

						Server server=new Server(port);
						server.shapes=shapes;
						server.start();
					
						
					} catch (Exception e2) {
						System.out.println("Please enter only integer value");
					}
					
				}
			});
	       
	        panel.updateUI();
    
	    }

	 public void DrawClientPage() {
		 
		 
		 this.panel.removeAll();
		   
	        panel.setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridy=0;
	        gbc.insets = new Insets(1, 1, 1, 1);
	        JLabel lblhost = new JLabel("HOST ");
	        JLabel lblPort = new JLabel("PORT ");
	         hostTextField = new JTextField(10);
	         portTextField= new JTextField(10);
	         gbc.gridx=0;
	         gbc.gridy=0;
	         panel.add(lblPort , gbc);
	         gbc.gridx=0;
	         gbc.gridy=1;
	         panel.add(lblhost , gbc);
	         gbc.gridx=1;
	         gbc.gridy=0;
	         panel.add(portTextField,gbc);
	         gbc.gridy+=1;
	         gbc.gridx=1;
	         panel.add(hostTextField,gbc);
	         gbc.gridy+=1;
	         gbc.gridx=1;
	         clientStartJButton = new JButton("Client Start");
	         clientStartJButton.setPreferredSize(new Dimension(190,40));
	         clientStartJButton.setFont(new Font("asd",Font.BOLD, 24));
	 
	        panel.add(clientStartJButton,gbc);
	        clientStartButtonAddActionListener(new ActionListener() {
	
	        	@Override
				public void actionPerformed(ActionEvent e) {
					
					panel.removeAll();
					ShapeFactory factory=new ShapeFactory();
					try {
						port = Integer.valueOf(portTextField.getText());
						host = hostTextField.getText();
					    ArrayList<Shape> shapes=new ArrayList<>();
						 ShapePanel panel2 = new ShapePanel(shapes,false);
						 Client client =new Client(host,port);
						 client.shapes=shapes;
						 client.start();
						 addShapesPanel(panel2);
					
						
					} catch (Exception e2) {
						System.out.println(e);
						System.out.println("Please enter only integer value");
					}
					
					
				}
			});
	       
	        panel.updateUI();
	      			         			        			       
	}

	
	
	public void addShapesPanel(JPanel panel) {
	
	
		 add(panel);
		 repaint();
		 panel.updateUI();
		
			
	}
	public void clientButtonAddActionListener(ActionListener listener) {
		clientJButton.addActionListener(listener);
	}
	public void serverButtonAddActionListener(ActionListener listener) {
		serverJButton.addActionListener(listener);
	}
	public void serverStartButtonAddActionListener(ActionListener listener) {
		serverStartJButton.addActionListener(listener);
	}
	public void clientStartButtonAddActionListener(ActionListener listener) {
		clientStartJButton.addActionListener(listener);
	}
	
	private static void clientListener(Gui gui) {
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
				gui.DrawClientPage();
		
				
			}
		};
		
		gui.clientButtonAddActionListener(listener);
	}
	

	private static void serverListener(Gui gui) {
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
		
		
				gui.DrawServerInfoPage();
			
		
	}
			
};
gui.serverButtonAddActionListener(listener);
	}
}

	
	


