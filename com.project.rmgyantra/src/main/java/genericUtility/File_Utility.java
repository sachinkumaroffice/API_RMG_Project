package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {

	
	public String readDataFromFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream(IPathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}
}
