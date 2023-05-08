package vtigerFrameworkReal.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	public String readtPropertyFile(String key) throws IOException
	{
		FileInputStream fis  = new FileInputStream("./data/vtgr.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}
}
