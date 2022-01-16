// If the ID and pass matches with the stud ID and pass this window is opened
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class newStudFrame extends JFrame implements ActionListener
{
	JPanel p;
	JButton b1;
	String s;
	public newStudFrame(String stID) throws IOException
	{
		setVisible(true);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension size=kit.getScreenSize();
		setSize(size.width,size.height);
		setResizable(true);
		setTitle("Profile - Student");
		s=stID;
		Image img = Toolkit.getDefaultToolkit().getImage("cc2stud.JPG");
		this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g); // Background Image
            g.drawImage(img,0,0,null);
         }
      });
      pack();
		buildComponents1();
		addComponents1();
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			viewRecord vr=new viewRecord(s); // Students can only view their record or status of attendance
		}
	}
	public void buildComponents1()
	{
		b1=new JButton("View Record");
		b1.setPreferredSize(new Dimension(300,100));
		p=new JPanel();
	}
	public void addComponents1()
	{
		p.add(b1);
		add(p);
	}
}