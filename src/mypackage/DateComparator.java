package mypackage;

import java.util.Comparator;

public class DateComparator implements Comparator<Result>
{

	@Override
	public int compare(Result a, Result b) 
	{
		return a.starttime.compareTo(b.starttime);
	}

}
