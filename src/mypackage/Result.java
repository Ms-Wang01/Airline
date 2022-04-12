package mypackage;

import java.util.*;

public class Result 
{
	
	public String companyname;
	public String startplace,endplace;
	public String startairport,endairport;
	public String starttime,endtime;
	public int id;
	public float price;
	public Result(String companyname,String startplace,String endplace,String startairport,String endairport,String starttime,String endtime,float price,int id )
	{
		this.id = id;
		this.companyname = companyname;
		this.starttime = starttime;
		this.startplace = startplace;
		this.startairport = startairport;
		this.endplace = endplace;
		this.endtime = endtime;
		this.endairport = endairport;
		this.price = price;
		
	}
	/*public static void main( String args[] )
	{
		Vector<Result> v = new Vector<Result>();
		v.add( new Result("公司1"," 武汉","北京 ","机场1","机场2","12:00","13:00",(float)123,1) ) ;
		v.add( new Result("公司2"," 武汉","北京 ","机场1","机场2","1:00","13:00",(float)11,2) );
		v.add( new Result("公司3"," 武汉","北京 ","机场1","机场2","24:00","13:00",(float)6,3) );
		
		v.sort(new DateComparator() );
		v.sort(new PriceComparator() );
		for( int i = 0 ; i < v.size() ; i++ )
			System.out.println( ( (Result)v.get(i) ).companyname );
	}*/
}
/*
 * 
 * 
 */
