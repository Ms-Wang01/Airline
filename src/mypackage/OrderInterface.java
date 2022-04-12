package mypackage;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.swing.*;
/*
 * 查询界面
 */
public class OrderInterface 
{
	JFrame frame = new JFrame("查询界面");
	JLabel lb[]= new JLabel[10];
	ImageIcon icon = new ImageIcon("pictures\\小飞机.jpg");
	Mypanel panel = new Mypanel(icon);
	static String city[] = {"北京","天津","上海","重庆","武汉","新疆","宁夏","广西",
								 "吉林","徐州","襄阳","厦门","宜昌","广东","深圳"};
	JButton confirm,cancel;
	DateChooserJButton datechoose;			//日期选择按钮
	JTextField txt[] = new JTextField[5];
	JComboBox combo[] = new JComboBox[5];
	public OrderInterface()
	{
		panel.setLayout(null);
		lb[1] = new JLabel("机票查询");
		lb[2] = new JLabel("出发城市");
		lb[3] = new JLabel("到达城市");
		lb[4] = new JLabel("出发日期");
		lb[5] = new JLabel("人数");
		//JCheckBox cbox;
		combo[1] = new JComboBox<String>();
		combo[2] = new JComboBox<String>();
		combo[3] = new JComboBox<Integer>();
		for( int i = 0 ; i < city.length ; i++ )
		{
			//cbox = new JCheckBox(city[i]);
			combo[1].addItem(city[i]);
			combo[2].addItem(city[i]);
		}
		for( int i = 1 ; i <= 4 ; i++ )
			combo[3].addItem(i);
		confirm = new JButton("查询");
		cancel = new JButton("返回");
		datechoose = new DateChooserJButton("点我选择日期");
		for( int i = 1 ; i <= 5 ; i++ )		//panel 添加组件
			panel.add(lb[i]);
		
		panel.add(combo[1]);	//两个下拉框
		panel.add(combo[2]);
		panel.add(combo[3]);	//人数下拉框
		panel.add(datechoose);
		
		panel.add(confirm);
		panel.add(cancel);
											//panel 添加组件
		
		lb[1].setBounds(200, 10, 80, 60);
		lb[1].setFont( new Font("楷体",Font.BOLD,17));	//机票查询
		lb[2].setBounds(50,50,80,60);
		lb[2].setFont( new Font("楷体",Font.BOLD,16));
		lb[3].setBounds(50, 90, 80, 60);
		lb[3].setFont( new Font("楷体",Font.BOLD,16) );
		lb[4].setBounds(50, 130, 80, 60);
		lb[4].setFont(new Font("楷体",Font.BOLD,16) );
		lb[5].setBounds(50, 170, 60, 60);
		lb[5].setFont(new Font("楷体",Font.BOLD,16) );
		combo[1].setBounds(150, 70, 80, 30);
		combo[2].setBounds(150, 110, 80, 30);
		combo[3].setBounds(150,190,40,20);
		datechoose.setBounds(150, 147, 130, 30);
		confirm.setBounds(160, 220, 80, 30);
		cancel.setBounds(250, 220, 80, 30);
		datechoose.setFont( new Font("楷体",Font.PLAIN,15) );
		confirm.setFont( new Font("楷体",Font.BOLD,15));
		cancel.setFont( new Font("楷体",Font.BOLD,15) );
		
		
		addEvent();		//添加事件
		frame.add(panel);
		frame.setSize(500,300);								//整个界面 500  乘 300
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void addEvent()
	{
		confirmEvent();	//点击确定按钮
	}
	public void confirmEvent()		//确定和返回 按钮
	{
		confirm.addActionListener( new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
					//Statement st = new Connect().st;
				String u = (String)combo[1].getSelectedItem();
				String v = (String)combo[2].getSelectedItem();
				if( u.equals(v) )
				{
					new Tip("选择城市不合法!");
					return;
				}
				String date = datechoose.getText();
				//System.out.println(date);
				int number = (int)combo[3].getSelectedItem();
				new ConfirmInterface(u,v,date,number);
				frame.dispose();
			}
		});
		cancel.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
	}
	
	
}
