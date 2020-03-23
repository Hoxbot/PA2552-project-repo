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
//import java.awt.image.BufferedImage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBasicWindow_PaintWindow_Eyeless {

	//Instances-----------------------------------------------------------------
    private static BasicWindow cut;
    private static SimpleCryption crpt;
    
    //private Random rand = new Random();
    
    //Management----------------------------------------------------------------
    //NTS: @BeforeClass = Runs when testing class is created, before any tests are run
    @BeforeClass
    public static void SetUp(){
        //
    	cut = new BasicWindow();
    	cut.PaintWindow();
    	
    	crpt = new SimpleCryption();
    }
    
    //NTS: @AfterClass = Used to clean up after a @BeforeClass function
    @AfterClass
    public static void TearDown(){
        //
    	
    	//cut.CloseWindow(); <- Prevents tests from finishing?
    		//NTS: Not needed anyway. JUnit closes the program.
    	
    	cut = null;
    	
    	crpt = null;
    }
    
    //NTS: @Before = Done before each test
    @Before
    public void InitTest() throws Exception {
        //
    }
    
    //NTS: @After = Done after each test
    @After
    public void CleanUpTest() throws Exception {
    	//cut.CloseWindow(); <- Actually ends program execution
        //cut = null;
    	cut.input_box.setText("");
    	cut.output_box.setText("");
    }
    
    //Tests---------------------------------------------------------------------
	@Test
	public void Test01_CheckForInputField() {
		//Test if there is a field for input
		//>Clicking the field allows one to edit it
		
		//Check that we are allowed to write
		assertTrue(cut.input_box.isEditable());
		
		//Write into field
		cut.input_box.setText("Jamalahejochmendu");
		
		//Check that the field has an entry
		String entry = cut.input_box.getText();
		assertNotEquals(0, entry.length());
		
	}
	
	@Test
	public void Test02_CheckForOutputField() {
		//Test if there is a field for output
		//>Clicking the field DOES NOT allow one to edit it
		
		//Check that we are NOT allowed to write
		assertFalse(cut.output_box.isEditable());
	}
	
	@Test
	public void Test03_EncryptInput() {
		//Test writing something into input and then click encrypt
		//>String in input box is correctly encrypted and put in output box
		
		//Input text
		String text = "What is the hardest part\nof a vegetable to eat?";
		cut.input_box.setText(text);
				
		//Click on encrypt
		cut.encrypt_btn.doClick();
		
		//Verify things happened
		String result = cut.output_box.getText();
		
		assertEquals(result, crpt.EncryptString(text));	
	}
	
	@Test
	public void Test04_DecryptInput() {
		//Test writing something into input and then click decrypt
		//>String in input box is correctly decrypted and put in output box
		
		//Input text
		String text = "fou6NW]cpt} *=k,f:";
		cut.input_box.setText(text);
						
		//Click on encrypt
		cut.decrypt_btn.doClick();
				
		//Verify things happened
		String result = cut.output_box.getText();
				
		assertEquals(result, crpt.DecryptString(text));	
	}
	
	//Support Functions---------------------------------------------------------
}
