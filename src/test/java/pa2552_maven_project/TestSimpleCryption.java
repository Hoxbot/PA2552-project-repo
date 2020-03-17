package pa2552_maven_project;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSimpleCryption {

	@Test
	public void test() {
		SimpleCryption obj = new SimpleCryption();
		
		String test_msg = "I AM BEING TESTED!\n";
		System.out.println(test_msg);
		
		String test_msg_2 = obj.EinsteinLevelEncryption(test_msg);
		System.out.println(test_msg_2);
		
		assertNotEquals(test_msg, test_msg_2);
	}

}
