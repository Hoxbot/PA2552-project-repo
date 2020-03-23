package pa2552_maven_project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestSimpleCryption_DecryptString.class, 		//1 
	TestSimpleCryption_EncryptString.class,			//2
//	TestBasicWindow_PaintWindow.class,				//3
	TestBasicWindow_PaintWindow_Eyeless.class		//4
	})
public class AllTests {
	//
}
