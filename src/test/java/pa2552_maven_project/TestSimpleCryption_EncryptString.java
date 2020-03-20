package pa2552_maven_project;

//JUnit
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

//Java
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleCryption_TestEncryptString {

	//Instances-----------------------------------------------------------------
    private SimpleCryption cut;
    private Random rand = new Random();
    
    //Management----------------------------------------------------------------
    //NTS: @BeforeClass = Runs when testing class is created, before any tests are run
    @BeforeClass
    public static void SetUp(){
        //
    }
    
    //NTS: @AfterClass = Used to clean up after a @BeforeClass function
    @AfterClass
    public static void TearDown(){
        //
    }
    
    //NTS: @Before = Done before each test
    @Before
    public void InitTest() throws Exception {
        //
    	cut = new SimpleCryption();
    }
    
    //NTS: @After = Done after each test
    @After
    public void CleanUpTest() throws Exception {
        cut = null;
    }
    
    //Tests---------------------------------------------------------------------
	@Test
	public void Test01_HappyPath_AllSigns() {
		//Test if the encryption function changes the contents of a string with all standard signs
		//>The contents should change
		//>The length of the string should remain the same
		
		String msg = "";
		
		for(int i = 32; i < 127; i++) {
			//Add all common ascii signs
			msg = msg + (char)i;
		}
		
		String enc_msg = cut.EncryptString(msg);
		
		assertNotEquals(msg, enc_msg);
		assertEquals(msg.length(), enc_msg.length());
	}
	
	@Test
	public void Test02_HappyPath_SingleSign() {
		//Test what happens if only one sign is supplied
		//>The character should offset its ascii value by 1
		
		String msg = "";
		
		for(int i = 32; i < 127; i++) {
			//Try all common ascii signs
			msg = "" + (char)i;
			
			String enc_msg = cut.EncryptString(msg);
			
			assertEquals((int)(msg.charAt(0)), (int)(enc_msg.charAt(0)));
		}
		
	}
	
	@Test
	public void Test03_HappyPath_NoSign() {
		//Test what happens when a string without any signs is entered
		//>The functions should make no alterations
		
		String msg = "";
		
		String enc_msg = cut.EncryptString(msg);
		
		assertEquals(msg, enc_msg);
	}
	
	@Test
	public void Test04_OutsideLowerBound() {
		//Test what happens if string contains a random sign out of the lower ascii bound
		//>The character should not be affected
		
		String msg = "abcdef";
		
		int x = rand.nextInt(31)+0;
		
		msg = msg.substring(0,2) + (char)x + msg.substring(3);
		
		String enc_msg = cut.EncryptString(msg);
		
		assertEquals(x, (int)(enc_msg.charAt(3)));
	}
	
	@Test
	public void Test05_OutsideHigherBound() {
		//Test what happens if string contains a random sign out of the higher ascii bound
		//>The character should not be affected
		
		String msg = "abcdef";
		
		int x = 127;
		
		msg = msg.substring(0,2) + (char)x + msg.substring(3);
		
		String enc_msg = cut.EncryptString(msg);
		
		assertEquals(x, (int)(enc_msg.charAt(3)));
	}
	
			//NTS: Negative ascii?
	@Test
	public void Test06_SadPath() {
		//Test what happens if a message isn't containing a proper ascii string
		//(-1 isn't on the ascii table)
		//>The program should ignore the sign as it lies outside lower bound
		//>(In this case Java seems to translate it to a number)
		
		int x = -1;
		
		String msg = "" + (char)x;
		
		//System.out.println(x + " " + (char)90);
		
		String enc_msg = cut.EncryptString(msg);
		
		assertEquals(x, (int)(enc_msg.charAt(0)));
	}
	

}
