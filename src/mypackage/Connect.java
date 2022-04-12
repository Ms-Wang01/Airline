package mypackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;
/*
 * 数据库连接
 */
public class Connect
{

	public Connection con;
	public Statement st;

	public Connect()
	{
		  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";

		  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=AirlineSystem2";

		  String userName="sa";

		  String userPwd="w4zhjiqi";

		  try

		  {

			   Class.forName(driverName);

			   con = DriverManager.getConnection(dbURL,userName,userPwd);

			    //System.out.println("连接数据库成功");
			   	st = con.createStatement();

			}

		  catch(Exception e)

		  {

			   e.printStackTrace();

			   //System.out.print("连接失败");
			  JFrame frame = new JFrame("提示");
			  JPanel panel = new JPanel();
			  JLabel label = new JLabel("数据库连接失败，请检查1433端口");
			  label.setFont( new Font("楷体",Font.BOLD,13) );
			  panel.add(label);
			  frame.add(panel);

			  frame.setVisible(true);
			  frame.setSize(300, 300);
			  frame.setLocationRelativeTo(null);

		  }
	}
	//public static void main(String[] args)
	//{
		//Connect c = new Connect();
	//}
}