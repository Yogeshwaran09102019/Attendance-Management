// This window is for viewing the students attendance Details
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class viewRecord extends JFrame 
{
	String s1;
	DefaultTableModel tableModel;
	JTable table; // To display the records in the table format JTable is used
	public viewRecord()
	{
		setResizable(true);
		setTitle("Student - Records");
		s1="";
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size=kit.getScreenSize();		
		setSize(size.width,size.height);
		setVisible(true);
		buildComponents();
		setTable(); // used to set the table 
		designScrollPane(); // Scroll pane for the JTable
	}
	public viewRecord(String s)
	{
		setResizable(true);
		setTitle("Student - Records");
		s1=s;
		System.out.println(s1);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension size=kit.getScreenSize();		
		setSize(size.width,size.height);
		setVisible(true);
		buildComponents();
		setTable();
		designScrollPane();
	}	
	public void buildComponents()
	{
		tableModel=new DefaultTableModel();
		table=new JTable(tableModel);
		table.setEnabled(false);
	}
	public void setTable()
	{
		int count=0,i;
		ResultSet temp;
		tableModel.addColumn("Date"); // adding columns in Table
		tableModel.addColumn("Attendance_Status"); // adding column in table
		try
		{
			DBhandler db=new DBhandler();
				count=db.getCount(s1);
				for(i=0;i<count;i++)
				{
					temp=db.getAttendance(i,s1);
					tableModel.insertRow(0,new Object[] {temp.getString(1),temp.getString(2)});
				}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void designScrollPane() // designing the Scroll Pane
	{
		JScrollPane pane=new JScrollPane(table);
		add(pane);
	}
}