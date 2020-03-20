package pa2552_maven_project;

public class Main {

	public static void main(String[] args) {
		SimpleCryption obj = new SimpleCryption();
		
		String wake_msg = "I HAVE AWOKEN!\n";
		System.out.println(wake_msg);
		System.out.println(obj.EncryptString(wake_msg));
	}
	
}
