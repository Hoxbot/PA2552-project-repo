package pa2552_maven_project;

public class Main {

	public static void main(String[] args) {
		SimpleCryption obj = new SimpleCryption();
		
		//String wake_msg = "I HAVE AWOKEN! I OWN 17 DOGS! MY ZEAL IS ENDLESS!\n";
		String wake_msg = "!![n_|m^u0\n";
		System.out.println(wake_msg);
		
		String crpt_msg = obj.EncryptString(wake_msg);
		System.out.println(crpt_msg);
		
		String decrpt_msg = obj.DecryptString(crpt_msg);
		System.out.println(decrpt_msg);
	}
	
}
