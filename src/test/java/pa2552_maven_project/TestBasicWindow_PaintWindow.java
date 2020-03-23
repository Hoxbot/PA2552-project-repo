/*
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

//EyeAutomate
import eye.Eye;
import eye.Match;

//Java
//import java.util.Random;
import java.awt.image.BufferedImage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBasicWindow_PaintWindow {

	//Instances-----------------------------------------------------------------
    private static BasicWindow cut;
    private static Eye eye;
    //private Random rand = new Random();
    
    //Management----------------------------------------------------------------
    //NTS: @BeforeClass = Runs when testing class is created, before any tests are run
    @BeforeClass
    public static void SetUp(){
        //
    	eye = new Eye();
    	
    	cut = new BasicWindow();
    	cut.PaintWindow();
    }
    
    //NTS: @AfterClass = Used to clean up after a @BeforeClass function
    @AfterClass
    public static void TearDown(){
        //
    	eye = null;
    	
    	//cut.CloseWindow(); <- Prevents tests from finishing?
    		//NTS: Not needed anyway. JUnit closes the program.
    	
    	cut = null;
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
		//>Image recognition finds it
		//>Clicking the field allows one to edit it
		
		//Find empty input field
		Match m1 = FindMatchOnScreen("img_rec/img_input_field.png");
		assertNotEquals(null, m1);
		
		//Move mouse, click on it, input text and move mouse out of the way
		eye.click(m1.getCenterLocation());
		eye.type("Jamalahejochmendu");
		eye.move(m1.getCenterRelativeLocation(-200,-200));
		
		//Check that the field has an entry
		String entry = cut.input_box.getText();
		assertNotEquals(0, entry.length());
		
	}
	
	@Test
	public void Test02_CheckForOutputField() {
		//Test if there is a field for output
		//>Image recognition finds it
		//>Clicking the field DOES NOT allow one to edit it
		
		//Find empty output field
		Match m1 = FindMatchOnScreen("img_rec/img_output_field.png");
		assertNotEquals(null, m1);
				
		//Move mouse, click on it, input text and move mouse out of the way
		eye.click(m1.getCenterLocation());
		eye.type("Nejmenhalloochkansen");
		eye.move(m1.getCenterRelativeLocation(-200,-200));
				
		//Check that the field has no entry
		String entry = cut.input_box.getText();
		assertEquals(0, entry.length());
	}
	
	@Test
	public void Test03_EncryptInput() {
		//Test writing something into input and then click encrypt
		//>String in input box is correctly encrypted and put in output box
		
		//Find empty input field
		Match m1 = FindMatchOnScreen("img_rec/img_input_field.png");
		assertNotEquals(null, m1);
				
		//Move mouse, click on it and input text
		//eye.click(m1.getCenterLocation());
		//eye.type("What is the hardest part\nof a vegetable to eat?");
		
		//NTS: Eye's type() functions seems to have trouble with
		//non-letter signs :/
		cut.input_box.setText("What is the hardest part\nof a vegetable to eat?");
				
		//Click on encrypt
		Match m2 = FindMatchOnScreen("img_rec/img_encrypt_button2.png");
		eye.click(m2.getCenterLocation());
		
		//Verify things happened
		Match m3 = FindMatchOnScreen("img_rec/img_encryption_test.png");
		assertNotEquals(null, m3);	
	}
	
	@Test
	public void Test04_DecryptInput() {
		//Test writing something into input and then click decrypt
		//>String in input box is correctly decrypted and put in output box
		
		//Find empty input field
		Match m1 = FindMatchOnScreen("img_rec/img_input_field.png");
		assertNotEquals(null, m1);
						
		//Move mouse, click on it and input text
		//eye.click(m1.getCenterLocation());
		//eye.type("fou6NW]cpt} *=k,f");
		
		//NTS: Eye's type() functions seems to have trouble with
		//non-letter signs :/
		cut.input_box.setText("fou6NW]cpt} *=k,f:");
		
		//Click on encrypt
		Match m2 = FindMatchOnScreen("img_rec/img_decrypt_button2.png");
		eye.click(m2.getCenterLocation());
				
		//Verify things happened
		Match m3 = FindMatchOnScreen("img_rec/img_decryption_test.png");
		assertNotEquals(null, m3);	
	}
	
	//Support Functions---------------------------------------------------------
	public Match FindMatchOnScreen(String file_name){
        BufferedImage image = eye.loadImage(file_name);
        
        Match match = null;
        
        if(image != null){
            match = eye.findImage(image);
        }
        else {
            System.out.print("\nERROR::[Failed to open file]\n");
        }
        
        return match;
    }
}
*/