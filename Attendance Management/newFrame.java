// if the entered ID and Pass corresponds to teacher ID and pass this window is opened
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class newFrame extends JFrame implements ActionListener
{
	JPanel p;
	JButton b1,b2;
	public newFrame() throws IOException
	{
		setVisible(true);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension size=kit.getScreenSize();
		setSize(size.width,size.height);
		setResizable(true);
		setTitle("Profile - Teacher");
		Image img = Toolkit.getDefaultToolkit().getImage("teacherimg.PNG");
		this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img,0,0,null); // Background image
         }
      });
      pack();
		buildComponents1();
		addComponents1();
		b1.addActionListener(this); // Button 1 for grantAttendance
		b2.addActionListener(this); // Button 2 for attendance_Result
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			grantAttendance a=new grantAttendance();
		}
		if(ae.getSource()==b2)
		{
			attendance_Result ar=new attendance_Result();
		}
	}
	public void buildComponents1() 
	{
		b1=new JButton("Grant Attendance");
		b1.setPreferredSize(new Dimension(300,100));
		b2=new JButton("View Record");
		b2.setPreferredSize(new Dimension(300,100));
		p=new JPanel();
	}
	public void addComponents1()
	{
		p.add(b1);
		p.add(b2);
		add(p);
	}
}