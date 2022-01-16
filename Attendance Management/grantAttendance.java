// If the teacher wishes to provide attendance this window is opened
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class grantAttendance extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JComboBox c1; 
	JTextField t1,t2;
	JRadioButton b1,b2; // Radio Button to grant Attendance
	JButton b3;
	ButtonGroup bg; // grouping the button together
	JPanel p1,p2,p3,p4,p5;
	public grantAttendance()
	{
		setTitle("Attendace");
		setSize(500,300);
		setVisible(true);
		setLocation(550,300);
		buildComponents2();
		addComponent2();
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		DBhandler db=new DBhandler();
		if(ae.getSource()==b1) // Listener for Present status of the student 
		{
            String st="Present";
			String st1=t1.getText();
			String st2=t2.getText();
			String st3=db.getIDStud(st1); // Checking whether it is a valid ID or not
			if(st1.equals(st3))
			{
				db.setAttendance(st,st1,st2);
				JOptionPane.showMessageDialog(null,"Attendace Updated");
			}
			else
				JOptionPane.showMessageDialog(null,"No such ID Found !! Try again");
		}
		if(ae.getSource()==b2) // Listener for absent status of the student
		{
			String st="Absent";
			String st1=t1.getText();
			String st2=t2.getText();
			String st3=db.getIDStud(st1); // checking for vali ID
			if(st1.equals(st3))
			{
				db.setAttendance(st,st1,st2);
				JOptionPane.showMessageDialog(null,"Attendace Updated");
			}
			else
				JOptionPane.showMessageDialog(null,"No such ID Found !! Try again");
		}	
	}
	public void buildComponents2()
	{
		l1=new JLabel("Date");
		l2=new JLabel("ID");
		t1=new JTextField(5);
		t2=new JTextField(10);
		b1=new JRadioButton("Present");
		b2=new JRadioButton("Absent");
		b3=new JButton("Submit");
		bg=new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
	}
	public void addComponent2()
	{
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		p2.add(l2);
		p2.add(t1);
		p3.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		p3.add(l1);
		t2.setText("-- DD/MM/YY --");
		p3.add(t2);
		p4.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		p4.add(b1);
		p4.add(b2);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		p5.add(b3);
		p1.add(p2);
		p1.add(p3);
		p1.add(p4);
		//p1.add(p5);
		add(p1);
	}
}