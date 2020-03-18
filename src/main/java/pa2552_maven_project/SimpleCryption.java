package pa2552_maven_project;

import java.lang.String;

public class SimpleCryption {
	String encrypted_file_name = "encryped.txt";
		
	//Functions
	public String EinsteinLevelEncryption(String msg) {
		
		for(int i = 0; i<msg.length(); i++) {
			int a = (int) msg.charAt(i);
			
			if(a >= 64 && a <=122) {
				a += 1;
				if (a > 122) {a = 64;}
			}
			
			msg = msg.substring(0, i) + (char)a + msg.substring(i+1);
			
		}
			
		return msg;
	}
	
}
