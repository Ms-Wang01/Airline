package mypackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * 
 * �˶�����
 */
public class CancelInterface
{
	JFrame frame = new JFrame("ɾ����Ʊ");
	ImageIcon icon = new ImageIcon("pictures//��Ʊ�ɻ�.jpg");
	Mypanel panel = new Mypanel(icon);
	JLabel idlabel = new JLabel("���֤��:");
	JLabel namelabel = new JLabel("����");
	JTextField idtxt = new JTextField();
	JTextField nametxt = new JTextField();
	JButton confirm,cancel;
	JLabel uplabel = new JLabel("����д��Ϣ��ѯ���Ļ�Ʊ");
	public void init()
	{
		panel.setLayout(null);
		confirm = new JButton("ȷ��");
		cancel = new JButton("����");
		
		panel.add(idlabel);
		panel.add(namelabel);
		panel.add(idtxt);
		panel.add(nametxt);
		panel.add(confirm);
		panel.add(cancel);
		panel.add(uplabel);
		
		uplabel.setBounds(140, 40, 240, 40);
		uplabel.setFont( new Font("����",Font.BOLD,19));
		
		
		idlabel.setBounds(120, 100, 90, 30);
		idlabel.setFont( new Font("����",Font.BOLD,16) );
		idtxt.setBounds(220, 105, 150, 22);
		
		namelabel.setBounds(130, 150,60, 30);
		namelabel.setFont( new Font("����",Font.BOLD,16) );
		nametxt.setBounds(220, 155,150,22);
		
		confirm.setBounds(150, 250, 80, 30);
		cancel.setBounds(250, 250, 80, 30);
		
		frame.add(panel);
		frame.setSize(500, 350);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public CancelInterface()
	{
		this.init();
		addevent();
	}
	public void addevent()
	{
		confirm.addActionListener( new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String ID = idtxt.getText();
				Statement st = new Connect().st;
				try {
					
					ResultSet rs = st.executeQuery("select * from u where uid = '"+ID+"'");
					if( rs.next() )	//����������
					{
						new ShowPassengerInfo(idtxt.getText(),nametxt.getText() );
						frame.dispose();
					}
					else
					{
						new Tip("���޴��ˣ�������");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(idlabel.getText());
				
			}
		});
		cancel.addActionListener( new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
			}
		});
	}
	
}
