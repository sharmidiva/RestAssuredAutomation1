package DataDrivenRESTASSURED;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static Logger logger;
	@BeforeClass
	public void setup() {
		System.out.println("Setuppp");
		logger=Logger.getLogger("RestAssured-Loggers");
		PropertyConfigurator.configure("/Users/diva/eclipse-workspace/RestAssuredAutomation1/src/test/resources/log4j.properties");
	}
	
	

}
