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
public class TestSimpleCryption_DecryptString {

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
	public void Test01_HappyPath_Random() {
		//Test encrypting a 10 sign message and then decrypt it
		//>Message before encryption and after decryption should be the same
		
		String msg = "";
		
		//Add 10 random ascii signs
		for(int i = 0; i < 10; i++) {
			int x = rand.nextInt(94)+32;
			msg = msg + (char)x;
		}
		
		//Check that this type of string can be decrypted
		AssertEncryptDecryptSame(msg);
	}
	
	@Test
	public void Test02_HappyPath_AllLegalSigns() {
		//Test encrypting a message with all signs in the 32-126 ascii span
		//>Message before encryption and after decryption should be the same
		
		String msg = "";
		
		//Add all common ascii signs
		for(int i = 32; i < 127; i++) {
			msg = msg + (char)i;
		}
		
		//Check that this type of string can be decrypted
		AssertEncryptDecryptSame(msg);
	}
	
	@Test
	public void Test03_HappyPath_NoSigns() {
		//Test encrypting a message with no signs
		//>Message before encryption and after decryption should be the same
		
		String msg = "";
		
		//Check that this type of string can be decrypted
		AssertEncryptDecryptSame(msg);
	}
	
	@Test
	public void Test04_OutsideLowerBound() {
		//Test encrypting a message with a sign from outside the lower bound 
		//>Message before encryption and after decryption should be the same
		
		String msg = "";
		
		//Add 10 random ascii signs
		for(int i = 0; i < 10; i++) {
			int x = rand.nextInt(94)+32;
			msg = msg + (char)x;
		}
		
		int x = rand.nextInt(31)+0;
		msg = msg.substring(0,2) + (char)x + msg.substring(3);
		
		//Check that this type of string can be decrypted
		AssertEncryptDecryptSame(msg);
	}
	
	@Test
	public void Test05_OutsideHigherBound() {
		//Test encrypting a message with a sign from outside the higher bound 
		//>Message before encryption and after decryption should be the same
		
		String msg = "";
		
		//Add 10 random ascii signs
		for(int i = 0; i < 10; i++) {
			int x = rand.nextInt(94)+32;
			msg = msg + (char)x;
		}
		
		int x = 127;
		msg = msg.substring(0,2) + (char)x + msg.substring(3);
		
		//Check that this type of string can be decrypted
		AssertEncryptDecryptSame(msg);
	}
	
	@Test
	public void Test06_SadPath() {
		//Test what happens if a message isn't containing a proper ascii string
		//>The program should ignore the sign as it lies outside lower bound
		
		int x = -2;
		String msg = "" + (char)x;
		
		//Check that this type of string can be decrypted
		AssertEncryptDecryptSame(msg);
	}
	
	//Support Functions---------------------------------------------------------
	private void AssertEncryptDecryptSame(String in_msg) {
		String enc_msg = cut.EncryptString(in_msg);
		String org_msg = cut.DecryptString(enc_msg);
		
		assertEquals(in_msg, org_msg);
	}

}
