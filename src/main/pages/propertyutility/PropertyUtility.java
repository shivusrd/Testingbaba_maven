package propertyutility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility 
{
	
static String path ="C:\\Users\\dubey\\OneDrive\\Documents\\GitHub\\18october_framework\\Testdata.properties";
	
	
	public static String getreadproperty(String key)
	{
		String value="";
	
	try 
	{
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		value= prop.getProperty(key);
	}
	catch(Exception e)
	
	{
		System.out.println("issue in getproperty " + e);
	}
	return value;

}
}


