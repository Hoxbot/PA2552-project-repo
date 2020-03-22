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
//import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBasicWindow_PaintWindow {

	//Instances-----------------------------------------------------------------
    private BasicWindow cut;
    //private Random rand = new Random();
    
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
    	cut = new BasicWindow();
    	cut.PaintWindow();
    }
    
    //NTS: @After = Done after each test
    @After
    public void CleanUpTest() throws Exception {
    	cut.CloseWindow();
        cut = null;
    }
    
    //Tests---------------------------------------------------------------------
	@Test
	public void Test01_CheckForInputField() {
		//Test if there is a field for input
		//>Image recognition finds it
		//>Clicking the field allows one to edit it
		fail("Not yet implemented");
	}
	
	@Test
	public void Test02_CheckForOutputField() {
		//Test if there is a field for output
		//>Image recognition finds it
		//>Clicking the field DOES NOT allow one to edit it
		fail("Not yet implemented");
	}
	
	@Test
	public void Test03_CheckForButtons() {
		//Test if there is two buttons
		//>There is a button labeled "Encrypt Text"
		//>There is a button labeled "Decrypt Text"
		fail("Not yet implemented");
	}
	
	@Test
	public void Test04_EncryptInput() {
		//Test writing something into input and then click encrypt
		//>String in input box is correctly encrypted and put in output box
		fail("Not yet implemented");
	}
	
	@Test
	public void Test05_DecryptInput() {
		//Test writing something into input and then click decrypt
		//>String in input box is correctly decrypted and put in output box
		fail("Not yet implemented");
	}

}
