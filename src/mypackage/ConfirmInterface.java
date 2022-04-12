
/*
 *  ���ܣ���ʾ������Ϣ
 *	�����۸񣬵ص����Ϣ
 *
 */

package mypackage;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

import javax.print.attribute.DateTimeSyntax;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


public class ConfirmInterface
{
	JFrame frame = new JFrame("������Ϣ");
	JPanel panel = new JPanel();
	JPanel downpanel = new JPanel();
	ResultSet rs;	//����  ����ʱ�� ����ʱ��  ���չ�˾  �۸�
	Vector rowdata1,rowdata2,columnnames;	//�������ɱ���Vector
	JScrollPane pricescroll,datescroll;
	JTable pricetable,datetable;
	JButton pricebutton,datebutton;
	String u,v,startairport,endairport;	//�����أ�Ŀ�ĵأ�����������Ŀ�Ļ���
	Statement st[] = new Statement[4];
	static int number;
	Vector<Result> temp1,temp2;		//�����ѯ�Ľ��	��������ʽ
	CardLayout card = new CardLayout();
	String getyear( String date )
	{
		int ans = 0;
		for( int i = 0 ; i < 4 ; i++ )
			ans = ans*10+(date.charAt(i)-'0' );
		return String.valueOf(ans);
	}
	String getmonth( String date )
	{
		return String.valueOf( (date.charAt(5)-'0')*10+(date.charAt(6)-'0') );
	}
	String getday( String date )
	{
		return String.valueOf( (date.charAt(8)-'0')*10+(date.charAt(9)-'0') );
	}
	
	public void showtable( )
	{
		
		try
		{
			columnnames = new Vector();
			rowdata1 = new Vector();
			rowdata2 = new Vector();
			columnnames.add("������Ϣ");	//������Ϸ���
			//System.out.println("here");
			panel.setLayout( card );
			String companyname;
			String time1,time2;
			String total;
			float price,discount;
			temp1 = new Vector<Result>();
			temp2 = new Vector<Result>();
			int id;
//			while( rs.next() )	//��֮ǰSQL��ѯ������Ū�� Vector��
//			{
//
//				time1 = rs.getTime(1).toString().trim()+" ����";
//				time2 = rs.getTime(2).toString().trim()+" ����";
//				companyname = rs.getString(3);
//				price = rs.getFloat(4);
//				id = rs.getInt(5);
//				Result tt = new Result(companyname,u,v,startairport,endairport,time1,time2,price,id);
//				temp1.add(tt);
//				temp2.add(tt);
//
//			}

			time1 = "���� ����";
			time2 = "�Ϻ� ����";
			companyname = "123";
			price = 1;
			id = 2;
			Result tt = new Result(companyname,u,v,startairport,endairport,time1,time2,price,id);
			temp1.add(tt);
			temp2.add(tt);
			temp1.sort( new PriceComparator() );
			temp2.sort( new DateComparator() );
			//temp1���ռ۸�����temp2����ʱ������
			
			Vector row1,row2;
			for( int i = 0 ; i < temp1.size() ; i++ )
			{
				row1 = new Vector();
				Result rr = (Result)temp1.get(i);
				String s = concat(rr);
				row1.add(s);
				rowdata1.add(row1);
				
				row2 = new Vector();
				rr = (Result)temp2.get(i);
				s = concat(rr);
				row2.add(s);
				rowdata2.add(row2);
			}
			
			pricetable = new JTable(rowdata1,columnnames);
			datetable = new JTable(rowdata2,columnnames);
			settable();
			pricescroll = new JScrollPane(pricetable);
			datescroll = new JScrollPane(datetable);
			
			//pricescroll.getViewport().setBackground(Color.cyan);		//�޸�Scroll��ɫ
			//datescroll.getViewport().setBackground(Color.blue);
			//scroll.setBounds(110,100,500,400);
			
			
			addEvent();					//Ϊ��ť����¼�
			pricebutton.setFont(new Font("����",Font.BOLD,16) );
			datebutton.setFont( new Font("����",Font.BOLD,16) );
			panel.add(pricescroll);
			panel.add(datescroll);
			
			downpanel.add(pricebutton);
			downpanel.add(datebutton);
			
			frame.add(panel);
			frame.add(downpanel,BorderLayout.SOUTH);
			frame.setVisible(true);
			//frame.pack();
			frame.setSize(500, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null);
		}
		catch( Exception ee )
		{
			ee.printStackTrace();
			new Tip("��ʾ�������");
		}
		
	}
	public void addEvent()			//��������ʽ��ť
	{
		//������ʾ��һ�ŵİ�ť
		pricebutton = new JButton("�۸�����");
		pricebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				card.previous(panel);
			}
		});
		//������ʾ��һ�ŵİ�ť
		datebutton = new JButton("����ʱ������");
		datebutton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				card.next(panel);
			}
		});
		
	}
	//����ѯ�������ʽ��ʾ
	public String concat( Result result )
	{
		String total,place,time,airport,last;
		String space = "&nbsp;";	//HTML�еĿո�
		String tab = "&#9;";		//HTML�е�tab
		String sspace = space+space+space;
		place = Generate_HTML_String("����", "150%", "red", result.startplace+"---------"+result.endplace);
				
		time = Generate_HTML_String("����", "115%", "black", result.starttime+sspace+sspace+result.endtime);
		
		airport = Generate_HTML_String("����", "125%", "black", result.startairport+sspace+sspace+result.endairport);
		
		last = Generate_HTML_String("����", "125%", "black", result.companyname+sspace+"RMB:"+String.valueOf(result.price) );
		total = "<html>"+place+time+airport+last+"</html>";
		//System.out.println(total);
		return total;
	}
	public String Generate_HTML_String(String font,String size_percentage,String color,String content )
	{
		String q = "\"";
		String total = "<p style = "+q+"font-family:"+font+";"
				+"font-size:"+size_percentage+";"
				+"color:"+color+q+">"
				+content
				+"</p>";
		//System.out.println(total);
		return total;
	}
	class MyMouseAdapter extends MouseAdapter		//������������λѡ�����
	{
		public void mouseClicked( MouseEvent e )
		{
			
			int t1 = pricetable.getSelectedRow();	//getselectedRow �Ǵ�0��ʼ��
			int t2 = datetable.getSelectedRow();
			
			if( t1 >= 0 )
			{
//				new ChooseSeat( temp1.get(t1),number );
				frame.dispose();
			}
			else if( t2 >= 0 )
			{
//				new ChooseSeat( temp2.get(t2),number );
				frame.dispose();
			}
			
		}
	}
	public void settable()
	{
		pricetable.setRowHeight(130);			//���ø߶�
		datetable.setRowHeight(130);
		pricetable.setBackground(Color.WHITE);		//�޸ı����ɫ
		datetable.setBackground(Color.WHITE);
		
		pricetable.addMouseListener( new MyMouseAdapter()  );
		datetable.addMouseListener( new MyMouseAdapter() );
		
		//pricetable.setFont( new Font("����",Font.BOLD,20) );
		//pricetable.setGridColor(gridColor);
		
		
		DefaultTableCellRenderer cr = new DefaultTableCellRenderer();	//����������
		cr.setHorizontalAlignment(JLabel.CENTER);
		pricetable.setDefaultRenderer(Object.class, cr);
		datetable.setDefaultRenderer(Object.class, cr);					//����������
		

		//pricetable.setFont(new Font("����",Font.PLAIN,15)  );
		//datetable.setFont(new Font("����",Font.PLAIN,15)  );
		//jt.setBounds(200, 100, 600, 700);
	}
	public ConfirmInterface(String u,String v,String date,int number )		//������	//������
	{																		//������	//������
		//���췽���� ��Ҫ�����ǲ�ѯ��������洢��rs�У����ҵ���������
		
		try
		{
			this.number = number;
			this.u = u;
			this.v = v;
			panel.setLayout(null);
			String cc = "Select departure_time,arrival_time,company_name,price,flight_id "
					+ "from airline_company,flight "
					+ " where airline_company.company_id = flight.company_id "
					+"and flight.flight_id in "
					+"("
						+"select flight_id from flight where "
						+ "departure_place = '"+u+"' and destination ='"+v+"'"
						+" and year(departure_time) ="+getyear(date)
						+" and month(departure_time)="+getmonth(date)
						+" and day(departure_time)="+getday(date)
					+")";
			//System.out.println(cc);
			
			st[1] = new Connect().st;
			rs = st[1].executeQuery(cc);
			
			st[2] = new Connect().st;
			ResultSet tt = st[2].executeQuery("select airport_name from airport " + 
					"where airport_place = '"+u+"'");
			//System.out.println(rs);
			
			tt.next();
			startairport = tt.getString(1);	//�õ���ʼ����
			
			st[3] = new Connect().st;
			String ss = "select airport_name from airport " + 
					"where airport_place = '"+v+"'";
			//System.out.println(ss);
			tt = st[3].executeQuery(ss);
			
			tt.next();
			endairport = tt.getString(1);
			//System.out.println(rs);
			showtable();
			
		}
		catch( Exception ee )
		{
			new Tip("��ѯʧ�ܣ�������û����");
			ee.printStackTrace();
			//new Tip("��ѯʧ�ܣ����������ݿ�����ʧ��");
		}
	}
	/*
	public static void main( String args[] )
	{
		new ConfirmInterface("����", "�人", "2018-01-01", 1);
	}
	*/
}
