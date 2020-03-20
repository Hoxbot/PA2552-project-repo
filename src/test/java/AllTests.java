import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pa2552_maven_project.SimpleCryption_TestEncryptString;
import pa2552_maven_project.SimpleCryption_TestDecryptString;

@RunWith(Suite.class)
@SuiteClasses({
	SimpleCryption_TestEncryptString.class,	//Test class 1 
	SimpleCryption_TestDecryptString.class	//Test class 2
	})
public class AllTests {

}
