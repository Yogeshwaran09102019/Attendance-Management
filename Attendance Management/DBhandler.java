// DBMS Handler Operations
import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DBhandler
{
	Connection con;
	Statement st;
	public DBhandler()
	{
		try // Establishing connection between SQL and Java with JDBC Driver
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Admin","root","");
			System.out.println("Conn Success");
			st=con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public String getID(String rno) // Function the get ID from SQL
	{
		String x=null;
		try
		{
			String query="select * from staff where ID="+rno;
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
				x=rs.getString(1);
		}
		catch(Exception ex)
		{
			System.out.println("No such ID found");
		}
		return x;
	}	
	public String getPass(String pass) // Function to get pass from backend
	{
		String x=null;
		try
		{
			String query="select * from staff where pass="+pass;
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
				x=rs.getString(3);
		}
		catch(Exception ex)
		{
			System.out.println("No such ID found");
		}
		return x;
	}
	public String getIDStud(String rno) // getting student ID
	{
		String x=null;
		try
		{
			String query="select * from student where ID="+rno;
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
				x=rs.getString(1);
		}
		catch(Exception ex)
		{
			System.out.println("No such ID found");
		}
		return x;
	}
	public String getPassStud(String pass) // getting student pass
	{
		String x=null;
		try
		{
			String query="select * from student where pass="+pass;
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
				x=rs.getString(3);
		}
		catch(Exception ex)
		{
			System.out.println("No such ID found");
		}
		return x;
	}
	public int setAttendance(String a,String a1,String a3) // Providing Attendance for Student
	{
		int x=0,x1=0,x2=0;
		try
		{
			String query1="update student set date='"+a3+"'"+"where ID='"+a1+"'";
			x1=st.executeUpdate(query1);
			String query="update student set attendance='"+a+"'"+"where ID='"+a1+"'";
			x=st.executeUpdate(query);
			String query2="insert into Attendance_Management values('"+a1+"','"+a3+"','"+a+"')";
			x2=st.executeUpdate(query2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return x;
	}
	public int getCount(String s) // To keep count of student
	{
		int x=0;
		try
		{
			String query="select count(Date) from Attendance_Management where ID="+s;
			ResultSet rs=st.executeQuery(query);
			rs.next();
			x=rs.getInt(1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return x;
	}
	public ResultSet getAttendance(int x,String s) // get attendance result 
	{
		ResultSet rs=null;
		System.out.println(x);
		System.out.println(s);
		try
		{	
			String query="select Date,Attendance from Attendance_Management where ID='" + s +"'order by date DESC limit "+x+" ,1";
			rs=st.executeQuery(query);
			if(rs.next())
				return rs;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return rs;
	}
}	