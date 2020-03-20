package pa2552_maven_project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	SimpleCryption_TestDecryptString.class, //1 
	SimpleCryption_TestEncryptString.class 	//2
	})
public class AllTests {

}
