package mypackage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/*
 * ���˵�  Ҳ�ǳ������
 * 
 */
public class Menu 
{
	JFrame frame = new JFrame("���˵�");
	JButton bt[] = new JButton[5];
	Mypanel panel;
	JLabel label = new JLabel("��ƱԤ��ϵͳ");
	JLabel name1 = new JLabel("�����д: ***");	//�������޸�  �������
	JLabel name2 = new JLabel("�������: **");		//�������޸ĳ� �������
	ImageIcon bigicon,image1,image2,image3;
	private void init()
	{
		bigicon = new ImageIcon("pictures\\������ɻ�.jpg");
		panel = new Mypanel(bigicon);
		//		image1 = new ImageIcon("pictures\\СС�ɻ�.jpg");
//		image2 = new ImageIcon("pictures\\��Ʊ��ťͼƬ.jpg");
//		image3 = new ImageIcon("СС�ɻ�");
		bt[1] = new JButton("��ƱԤ��");
		bt[2] = new JButton("��Ʊ");
		bt[3] = new JButton("�˳�ϵͳ");
		bt[4] = new JButton("�������");
		//bt[1].setIcon(image1);
		panel.setLayout(null);
		panel.add(bt[1]);
		panel.add(bt[2]);
		panel.add(bt[3]);
		panel.add(bt[4]);
		panel.add(name1);
		panel.add(name2);
		panel.add(label);
		label.setFont( new Font("����",Font.BOLD,38) );
		label.setForeground( Color.CYAN );
		name1.setForeground( Color.cyan);
		name2.setForeground(Color.cyan);
		bt[1].setBounds(40, 330, 120, 50);	//Ԥ����ť
		bt[2].setBounds(190, 330, 120, 50);	//��Ʊ��ť
		bt[3].setBounds(340,330,120,50);
		bt[4].setBounds(490, 330, 120, 50);
		bt[1].setFont( new Font("����",Font.PLAIN,17) );
		bt[2].setFont( new Font("����",Font.PLAIN,17) );
		bt[3].setFont( new Font("����",Font.PLAIN,17) );
		bt[4].setFont( new Font("����",Font.PLAIN,17) );
		
		name1.setBounds(250, 70, 200, 40);
		name2.setBounds(250, 110, 200, 40);
		name1.setFont( new Font("����",Font.BOLD,20) );
		name2.setFont( new Font("����",Font.BOLD,20) );
		label.setBounds(200, 20,250, 60);				//��ƱԤ��ϵͳ ��ǩ
		bt[1].addActionListener( new ActionListener()		//����Ԥ����ť 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				new OrderInterface();		//��תԤ������
				//frame.setVisible(false);  	//�ر�֮ǰ�Ľ���
			}
		} ); 
		bt[2].addActionListener( new ActionListener()	//��Ʊ��ť 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new CancelInterface();
				//frame.setVisible(false);
			}
		});
		bt[3].addActionListener( new ActionListener()		//�˳�ϵͳ��ť 
		{	
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(1);
			}
		});
		
		bt[4].addActionListener( new ActionListener()	//�������ݰ�ť
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
