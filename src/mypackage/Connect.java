package mypackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;
/*
 * ���ݿ�����
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

			    //System.out.println("�������ݿ�ɹ�");
			   	st = con.createStatement();

			}

		  catch(Exception e)

		  {

			   e.printStackTrace();

			   //System.out.print("����ʧ��");
			  JFrame frame = new JFrame("��ʾ");
			  JPanel panel = new JPanel();
			  JLabel label = new JLabel("���ݿ�����ʧ�ܣ�����1433�˿�");
			  label.setFont( new Font("����",Font.BOLD,13) );
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