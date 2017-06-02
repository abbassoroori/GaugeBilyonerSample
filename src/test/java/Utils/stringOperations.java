package Utils;

/**
 * Created by mert.yaman on 26/01/2017.
 * Bu class String islemleri icin olusturulmusutur.
 */
public class stringOperations {
	
	public static boolean stringContains(String mainText,String findText)
	{
		if(mainText.contains(findText))
			return true;
		else
			return false;
	}
	
	public static boolean stringStartsWith(String mainText,String startText)
	{
		if(mainText.startsWith(startText))
			return true;
		else
			return false;
	}
	
	public static boolean stringEquals(String mainText,String secondText)
	{
		if(mainText.equals(secondText))
			return true;
		else
			return false;
	}
	
	
}
