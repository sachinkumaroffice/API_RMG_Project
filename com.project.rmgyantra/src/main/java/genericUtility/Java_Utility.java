package genericUtility;

import java.util.Random;

public class Java_Utility {

public int getRanDomNumber() {
		
		Random random = new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
	}
	
}
