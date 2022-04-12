package mypackage;

import java.util.Comparator;
import java.util.*;

public class PriceComparator implements Comparator<Result>
{

	@Override
	public int compare(Result o1, Result o2) 
	{
		if( o1.price > o2.price )
			return 1;
		return -1;
	}
	
}
