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
    private static BasicWindow cut_arr[] = {null, null, null, null};
    int current_test_number = 0;
    private static Eye eye;
    //private Random rand = new Random();
    
    //Management----------------------------------------------------------------
    //NTS: @BeforeClass = Runs when testing class is created, before any tests are run
    @BeforeClass
    public static void SetUp(){
        //
    	eye = new Eye();
    }
    
    //NTS: @AfterClass = Used to clean up after a @BeforeClass function
    @AfterClass
    public static void TearDown(){
        //
    	eye = null;
    	
    	for(int i = 0; i < cut_arr.length; i++) {
    		if (cut_arr[i] != null) { cut_arr[i].CloseWindow(); }
    		cut_arr[i] = null;
    	}
    	
    }
    
    //NTS: @Before = Done before each test
    @Before
    public void InitTest() throws Exception {
        //
    	cut_arr[current_test_number] = new BasicWindow();
    	cut_arr[current_test_number].PaintWindow();
    }
    
    //NTS: @After = Done after each test
    @After
    public void CleanUpTest() throws Exception {
    	//cut.CloseWindow(); <- Actually ends program execution
        //cut = null;
    	current_test_number++;
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
		
		//Try to find the empty field again (there should be none)
		Match m2 = FindMatchOnScreen("img_rec/img_input_field.png");
		assertEquals(null, m2);
		
		
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
				
		//Try to find the empty field again (should still be there)
		Match m2 = FindMatchOnScreen("img_rec/img_output_field.png");
		assertNotEquals(null, m2);
	}
	
	@Test
	public void Test03_EncryptInput() {
		//Test writing something into input and then click encrypt
		//>String in input box is correctly encrypted and put in output box
		
		//Find empty input field
		Match m1 = FindMatchOnScreen("img_rec/img_input_field.png");
		assertNotEquals(null, m1);
				
		//Move mouse, click on it and input text
		eye.click(m1.getCenterLocation());
		eye.type("What is the hardest part\nof a vegetable to eat?");
				
		//Click on encrypt
		Match m2 = FindMatchOnScreen("img_rec/img_encrypt_button.png");
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
		eye.click(m1.getCenterLocation());
		eye.type("fou6NW]cpt} *=k,f");
						
		//Click on encrypt
		Match m2 = FindMatchOnScreen("img_rec/img_decrypt_button.png");
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
