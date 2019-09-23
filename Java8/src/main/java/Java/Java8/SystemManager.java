package Java.Java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;

/**
* <p>className: SystemManager</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月31日
*/
public class SystemManager {
	private static String initString;
	static{
		String currentString = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("a.txt"));
			initString = reader.lines().findFirst().orElse(null);
		} catch (FileNotFoundException e) {
			throw new NoSuchElementException("file initconif.txx");
		}
	}
	
	public SystemManager(){
		if(initString.length()==0){
			throw new IllegalArgumentException("file initconif.txx");
		}
		System.out.println("It works");
	}
	
	public static void main(String args[]){
		SystemManager aManager = new SystemManager();
	}
}
