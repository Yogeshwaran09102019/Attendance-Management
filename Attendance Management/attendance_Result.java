// Window from teacher side to get the attendance window of the student
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
public class attendance_Result extends JFrame implements ActionListener
{
	JTextField t;
	JButton b;
	JLabel l;
	JPanel p1,p2,p3; 
	public attendance_Result()
	{
		setTitle("Attendace");
		setSize(500,300);
		setVisible(true);
		setLocation(550,300);
		buildComponents();
		addComponents();
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		DBhandler db=new DBhandler();
		if(ae.getSource()==b)
		{
			String t1=t.getText();
			String s1=db.getIDStud(t1);
			if(t1.equals(s1)) // If ID is found , display the ID
			{
			viewRecord vr=new viewRecord(t1);
			}
			else
			JOptionPane.showMessageDialog(null,"Invalid ID! Try Again!");
		}
	}
	public void buildComponents()
	{
		t=new JTextField(8);
		b=new JButton("Submit");
		l=new JLabel("Enter the ID:");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
	}
	public void addComponents()
	{
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		p2.add(l);
		p2.add(t);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		p3.add(b);
		p1.add(p2);
		p1.add(p3);
		add(p1);
	}
	public String getID()
	{
		String s1=t.getText();
		return s1;
	}
}