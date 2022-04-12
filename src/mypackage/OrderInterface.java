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
 * ��ѯ����
 */
public class OrderInterface 
{
	JFrame frame = new JFrame("��ѯ����");
	JLabel lb[]= new JLabel[10];
	ImageIcon icon = new ImageIcon("pictures\\С�ɻ�.jpg");
	Mypanel panel = new Mypanel(icon);
	static String city[] = {"����","���","�Ϻ�","����","�人","�½�","����","����",
								 "����","����","����","����","�˲�","�㶫","����"};
	JButton confirm,cancel;
	DateChooserJButton datechoose;			//����ѡ��ť
	JTextField txt[] = new JTextField[5];
	JComboBox combo[] = new JComboBox[5];
	public OrderInterface()
	{
		panel.setLayout(null);
		lb[1] = new JLabel("��Ʊ��ѯ");
		lb[2] = new JLabel("��������");
		lb[3] = new JLabel("�������");
		lb[4] = new JLabel("��������");
		lb[5] = new JLabel("����");
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
		confirm = new JButton("��ѯ");
		cancel = new JButton("����");
		datechoose = new DateChooserJButton("����ѡ������");
		for( int i = 1 ; i <= 5 ; i++ )		//panel ������
			panel.add(lb[i]);
		
		panel.add(combo[1]);	//����������
		panel.add(combo[2]);
		panel.add(combo[3]);	//����������
		panel.add(datechoose);
		
		panel.add(confirm);
		panel.add(cancel);
											//panel ������
		
		lb[1].setBounds(200, 10, 80, 60);
		lb[1].setFont( new Font("����",Font.BOLD,17));	//��Ʊ��ѯ
		lb[2].setBounds(50,50,80,60);
		lb[2].setFont( new Font("����",Font.BOLD,16));
		lb[3].setBounds(50, 90, 80, 60);
		lb[3].setFont( new Font("����",Font.BOLD,16) );
		lb[4].setBounds(50, 130, 80, 60);
		lb[4].setFont(new Font("����",Font.BOLD,16) );
		lb[5].setBounds(50, 170, 60, 60);
		lb[5].setFont(new Font("����",Font.BOLD,16) );
		combo[1].setBounds(150, 70, 80, 30);
		combo[2].setBounds(150, 110, 80, 30);
		combo[3].setBounds(150,190,40,20);
		datechoose.setBounds(150, 147, 130, 30);
		confirm.setBounds(160, 220, 80, 30);
		cancel.setBounds(250, 220, 80, 30);
		datechoose.setFont( new Font("����",Font.PLAIN,15) );
		confirm.setFont( new Font("����",Font.BOLD,15));
		cancel.setFont( new Font("����",Font.BOLD,15) );
		
		
		addEvent();		//����¼�
		frame.add(panel);
		frame.setSize(500,300);								//�������� 500  �� 300
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void addEvent()
	{
		confirmEvent();	//���ȷ����ť
	}
	public void confirmEvent()		//ȷ���ͷ��� ��ť
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
					new Tip("ѡ����в��Ϸ�!");
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
