import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;	
import java.sql.*;
class attendance extends JFrame implements ActionListener
{
	JLabel l,l1,l2; // Various Lables
	JTextField t1; // Text Field
	JPasswordField pwd; // Password Field
	JButton b1; // Button
	JPanel p1,p2,p3,p4,p5; // Panels to add Contents
	newFrame f; // Teacher Login 
	newStudFrame f1; // Student Login
	attendance() throws IOException
	{
		setResizable(true);
		setTitle("LOGIN"); // Title of Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension size=kit.getScreenSize();
		setSize(size.width,size.height);
		Image img = Toolkit.getDefaultToolkit().getImage("umd2.JPG");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) { 
            super.paintComponent(g); // Used to get the Background Image
            g.drawImage(img,0,0,null);
         }
      });
      pack();
	  buildComponent();
      addComponent(); 
	  b1.addActionListener(this); // Action Listener for Button
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1) // What happens if Button is pressed
		{
			DBhandler db=new DBhandler();
			String s1=t1.getText();
			String s2=pwd.getText();
			String s3=db.getID(s1);
			String s4=db.getPass(s2);
			String s5=db.getIDStud(s1);
			String s6=db.getPassStud(s2);
			try
			{
				if(s1.equals(s3) && s2.equals(s4)) // Checking whether ID,pass equals to Teacher ID,pass from backend 
				{
					f=new newFrame(); // If equal,teacher frame is opened
				}
				else if(s1.equals(s5) && s2.equals(s6)) // Checking whether ID,pass equals to Student ID,pass from backend 
				{
					f1=new newStudFrame(s5); // If equal, student frame is opened
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid ID or Password! Try Again!");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
	}
	public void buildComponent() // Function to build the components
	{
		l=new JLabel("UNIVERSITY OF MARYLAND",JLabel.RIGHT);
		l.setFont(new Font("Verdana",Font.PLAIN,50));
		l1=new JLabel("USER ID:",JLabel.LEFT);
		l1.setFont(new Font("Verdana",Font.PLAIN,30));
		t1=new JTextField(5);
		t1.setFont(new Font("Verdana",Font.PLAIN,30));
		l2=new JLabel("PASSWORD:",JLabel.LEFT);
		l2.setFont(new Font("Verdana",Font.PLAIN,30));
		pwd=new JPasswordField(10);
		pwd.setFont(new Font("Verdana",Font.PLAIN,30));
		b1=new JButton("ENTER");
		b1.setPreferredSize(new Dimension(100,50));
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
	}
	public void addComponent() // Function to add components to panel
	{
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		p2.add(l);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		p3.add(l1);
		p3.add(t1);
		p4.setLayout(new FlowLayout(FlowLayout.RIGHT,25,25));
		p4.add(l2);
		p4.add(pwd);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
		p5.add(b1);
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		p1.add(p5);
		add(p1);
	}
}

public class AttendanceProject 
{
	public static void main(String ...args) throws IOException
	{
		attendance a=new attendance(); 
	}
}		