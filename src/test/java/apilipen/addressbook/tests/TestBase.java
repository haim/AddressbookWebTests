package apilipen.addressbook.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import apilipen.addressbook.appmanager.ApplicationManager;

public class TestBase  {

	
	public final ApplicationManager app = new ApplicationManager();
	
	
	@BeforeMethod
public void setUp() throws Exception {
		app.init();
		   }





	@AfterMethod
	public void tearDown() {
	app.stop();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) throws IOException {
//
////		           String in_browser = System.getProperty("browser");
//
//		String in_browser = "Chrome"; // Firefox or Chrome or Safari or IE or Edge
//		              setWebDriver(in_browser);
//		             // String url = "http://alex.academy/ua";
//		              String url = "http://localhost/addressbook/index.php";
//		              driver.get(url);
//		             // String ua = driver.findElement(By.id("id_ua")).getText();
//		              
//		         String ua = driver.getTitle();
//		              System.out.println("User Agent: " + ua);
//		            //  if (driver != null)
//		           //   {driver.quit();}
//
//		       }
	 
	 
	 
		}


