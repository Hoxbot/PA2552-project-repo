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
public class TestSimpleCryption_EncryptString {

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
		
		//Try all ascii signs in legal range
		for(int i = 32; i < 127; i++) {
			//Generate single sign string
			msg = "" + (char)i;
			
			//Encrypt
			String enc_msg = cut.EncryptString(msg);
			
			//Translate to ascii
			int a_ascii = (int)(msg.charAt(0));
			int b_ascii = (int)enc_msg.charAt(0) - 1;	//Offset it one back.
			if(b_ascii == 31) {b_ascii = 126;};			//Handle special case.
														//Note that it ONLY handles the 31 case.
														//This should prevent the test from by 
														//itself correcting out of bounds errors.
			
			//Assert equality
			assertEquals( a_ascii, b_ascii);
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
		//>All signs but the one out of bound should be changed
		//>Length of string should be the same
		
		//Create a normal string
		String msg = "abcdef";
		
		//Add a "illegal" ascii sign at index x
		int x = rand.nextInt(31)+0;
		int index_x = 2;
		msg = msg.substring(0,index_x) + (char)x + msg.substring(index_x);
		
		//Encrypt
		String enc_msg = cut.EncryptString(msg);
		
		//Assert that the lengths are the same
		assertEquals(msg.length(), enc_msg.length());
		
		//Assert that all signs not at index x are different
		//and that index x is the same  
		for(int i = 0; i < msg.length(); i++) {
			if(i != index_x) {assertNotEquals(msg.charAt(i), enc_msg.charAt(i));}
			else {assertEquals(msg.charAt(i), enc_msg.charAt(i));}
		}
		
	}
	
	@Test
	public void Test05_OutsideHigherBound() {
		//Test what happens if string contains a random sign out of the higher ascii bound
		//>All signs but the one out of bound should be changed
		//>Length of string should be the same
		
		//Create a normal string
		String msg = "abcdef";
		
		//Add a "illegal" ascii sign at index x
		int x = 127;
		int index_x = 2;
		msg = msg.substring(0,index_x) + (char)x + msg.substring(index_x);
		
		//Encrypt
		String enc_msg = cut.EncryptString(msg);
		
		//Assert that the lengths are the same
		assertEquals(msg.length(), enc_msg.length());
		
		//Assert that all signs not at index x are different
		//and that index x is the same  
		for(int i = 0; i < msg.length(); i++) {
			if(i != index_x) {assertNotEquals(msg.charAt(i), enc_msg.charAt(i));}
			else {assertEquals(msg.charAt(i), enc_msg.charAt(i));}
		}
	}
	
	@Test
	public void Test06_SadPath() {
		//Test what happens if a message isn't containing a proper ascii string
		//(-1 isn't on the ascii table)
		//>The program should ignore encrypting the sign as it lies outside lower bound
		
		int x = -1;
		
		String msg = "" + (char)x;
		
		String enc_msg = cut.EncryptString(msg);
		
		assertEquals(msg, enc_msg);
	}
	

}
