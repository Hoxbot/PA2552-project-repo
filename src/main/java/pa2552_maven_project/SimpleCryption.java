package pa2552_maven_project;

import java.lang.String;

public class SimpleCryption {
	String encrypted_file_name = "encryped.txt";
		
	//Functions
	//Private
	private int OffsetAscii(int in_ascii, int in_offset) {
		
		if(in_ascii < 32 || in_ascii > 126) {
			return in_ascii;
		}
		
		in_ascii += in_offset;
		
		while (in_ascii > 126) {
			in_ascii -= 95;			//NTS:	Correction offsets are 95, not 94.
		}							//		This is because the value is at least
		while (in_ascii < 32) {		//		1 out of the desired range (32 - 126).
			in_ascii += 95;
		}
		
		return in_ascii;
	}
	
	//Public
	public String EncryptString(String in_msg) {
		
		//If length is 0, return
		if(in_msg.length() == 0) {return in_msg;}
		
		//Encrypted message
		//-length of message offsets first sign
		//-ascii value of (encrypted) first sign offsets the second
		//-second for third, etc
		int len = in_msg.length();
		
		String enc_msg = "" + (char)OffsetAscii((int)in_msg.charAt(0), len);
		
		for(int i = 1; i < len; i++) {
			enc_msg += (char)OffsetAscii((int)in_msg.charAt(i), (int)enc_msg.charAt(i-1));
		}
		
		return enc_msg;
	}
	
	public String DecryptString(String in_msg) {
		//If length is 0, return
		if(in_msg.length() == 0) {return in_msg;}
				
		//Decrypted message
		int len = in_msg.length();
				
		String org_msg = "" + (char)OffsetAscii((int)in_msg.charAt(0), -len);
		
		for(int i = 1; i < len; i++) {
			org_msg += (char)OffsetAscii((int)in_msg.charAt(i), -(int)in_msg.charAt(i-1));
		}
		
		return org_msg;
	}
	
	
}
