package mypackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/*
 * 主菜单  也是程序入口
 * 
 */
public class Menu 
{
	JFrame frame = new JFrame("主菜单");
	JButton bt[] = new JButton[5];
	Mypanel panel;
	JLabel label = new JLabel("机票预订系统");
	JLabel name1 = new JLabel("代码编写: ***");	//在这里修改  你的名字
	JLabel name2 = new JLabel("界面设计: **");		//在这里修改成 你的名字
	ImageIcon bigicon,image1,image2,image3;
	private void init()
	{
		bigicon = new ImageIcon("pictures\\主界面飞机.jpg");
		panel = new Mypanel(bigicon);
		//		image1 = new ImageIcon("pictures\\小小飞机.jpg");
//		image2 = new ImageIcon("pictures\\退票按钮图片.jpg");
//		image3 = new ImageIcon("小小飞机");
		bt[1] = new JButton("机票预订");
		bt[2] = new JButton("退票");
		bt[3] = new JButton("退出系统");
		bt[4] = new JButton("添加数据");
		//bt[1].setIcon(image1);
		panel.setLayout(null);
		panel.add(bt[1]);
		panel.add(bt[2]);
		panel.add(bt[3]);
		panel.add(bt[4]);
		panel.add(name1);
		panel.add(name2);
		panel.add(label);
		label.setFont( new Font("楷体",Font.BOLD,38) );
		label.setForeground( Color.CYAN );
		name1.setForeground( Color.cyan);
		name2.setForeground(Color.cyan);
		bt[1].setBounds(40, 330, 120, 50);	//预订按钮
		bt[2].setBounds(190, 330, 120, 50);	//退票按钮
		bt[3].setBounds(340,330,120,50);
		bt[4].setBounds(490, 330, 120, 50);
		bt[1].setFont( new Font("楷体",Font.PLAIN,17) );
		bt[2].setFont( new Font("楷体",Font.PLAIN,17) );
		bt[3].setFont( new Font("楷体",Font.PLAIN,17) );
		bt[4].setFont( new Font("楷体",Font.PLAIN,17) );
		
		name1.setBounds(250, 70, 200, 40);
		name2.setBounds(250, 110, 200, 40);
		name1.setFont( new Font("楷体",Font.BOLD,20) );
		name2.setFont( new Font("楷体",Font.BOLD,20) );
		label.setBounds(200, 20,250, 60);				//机票预订系统 标签
		bt[1].addActionListener( new ActionListener()		//按下预订按钮 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new OrderInterface();		//跳转预订界面
				//frame.setVisible(false);  	//关闭之前的界面
			}
		} ); 
		bt[2].addActionListener( new ActionListener()	//退票按钮 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new CancelInterface();
				//frame.setVisible(false);
			}
		});
		bt[3].addActionListener( new ActionListener()		//退出系统按钮 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(1);
			}
		});
		
		bt[4].addActionListener( new ActionListener()	//加入数据按钮
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new AddData();
			}
		});
		
		frame.add(panel);
		frame.setSize(650,450);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public Menu()
	{
		this.init();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Menu();
	}

}
