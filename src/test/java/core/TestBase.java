package core;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	
	static WebDriver driver;
	
	
	 public static void setWebDriver(String browser) throws IOException {

	
		               Logger logger = Logger.getLogger("");
		               logger.setLevel(Level.OFF);
		               String driverPath = "";

		      if ((browser == "Firefox") && (System.getProperty("os.name").toUpperCase().contains("MAC")))

		               {driverPath = "./src/main/resources/webdrivers/mac/geckodriver.sh";}


		 else if ((browser == "Firefox") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))

		               {driverPath = "./src/main/resources/webdrivers/pc/geckodriver.exe";}

		 else if ((browser == "Chrome") && (System.getProperty("os.name").toUpperCase().contains("MAC")))

		               {driverPath = "./src/main/resources/webdrivers/mac/chromedriver";}

		 else if ((browser == "Chrome") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))

		               {driverPath = "./src/main/resources/webdrivers/pc/chromedriver.exe";}

		 else if ((browser == "Safari") && (System.getProperty("os.name").toUpperCase().contains("MAC")))

		              {}

	
		 else if ((browser == "Safari") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))

		              {throw new IllegalArgumentException("Safari is not available for Windows");}

		 else if ((browser == "IE") && (System.getProperty("os.name").toUpperCase().contains("MAC")))

		              {throw new IllegalArgumentException("Internet Explorer is not available for macOS");}

		 else if ((browser == "IE") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))

		              {driverPath = "./src/main/resources/webdrivers/pc/IEDriverServer.exe";}

		 else if ((browser == "Edge") && (System.getProperty("os.name").toUpperCase().contains("MAC")))

		              {throw new IllegalArgumentException("Microsoft Edge is not available for macOS");}

		 else if ((browser == "Edge") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))

		              {driverPath = "./src/main/resources/webdrivers/pc/MicrosoftWebDriver.exe";}

		               else if (browser == "HtmlUnit") {}

		               else   {throw new IllegalArgumentException("Unknown OS");}

		               switch (browser) {

		               case "Firefox":

		                      System.setProperty("webdriver.gecko.driver", driverPath);

		                      driver = new FirefoxDriver();
		                      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		                      driver.manage().window().maximize();
		                      break;

		  
		               case "Chrome":

		
		                      System.setProperty("webdriver.chrome.driver", driverPath);
		                      System.setProperty("webdriver.chrome.silentOutput", "true");

		                      ChromeOptions option = new ChromeOptions();

		                      if (System.getProperty("os.name").toUpperCase().contains("MAC"))
		                      {option.addArguments("-start-fullscreen");}
		                      else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))

		
		                      {option.addArguments("--start-maximized");}
		                      else {throw new IllegalArgumentException("Unknown OS");}
		                      driver = new ChromeDriver(option);
		                      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		                      break;

		               case "Safari":

		                      SafariOptions options = new SafariOptions();
		                      options.setUseCleanSession(true);
		                      options.setPort(55555);
		                      driver = new SafariDriver(options);
		                      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		                      driver.manage().window().maximize();
		                      break;

		               case "IE":

		    DesiredCapabilities IEDesiredCapabilities = DesiredCapabilities.internetExplorer();
		 IEDesiredCapabilities.setCapability (InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		 IEDesiredCapabilities.setCapability (InternetExplorerDriver.INITIAL_BROWSER_URL, "");

		                      IEDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		                      IEDesiredCapabilities.setJavascriptEnabled(true);
		                      IEDesiredCapabilities.setCapability("enablePersistentHover", false);

		                      System.setProperty("webdriver.ie.driver", driverPath);
		                      driver = new InternetExplorerDriver(IEDesiredCapabilities);
		                      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		                      driver.manage().window().maximize();
		                      break;
		               case "Edge":
		                      System.setProperty("webdriver.edge.driver", driverPath);
		                      driver = new EdgeDriver();
		                      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		                      driver.manage().window().maximize();

		                      break;

		               case "HtmlUnit":
		                      driver = new HtmlUnitDriver();
		                      ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		                      break;
		               default:
		                      throw new IllegalArgumentException("Unknown Broweser");
		               }
		        }


	@BeforeMethod
	public void setUp() throws Exception {
	//	           String in_browser = System.getProperty("browser");
	
		String in_browser = "Chrome"; // Firefox or Chrome or Safari or IE or Edge
		              setWebDriver(in_browser);
		             // String url = "http://alex.academy/ua";
		             // String url = "http://localhost/addressbook/index.php";
		            //  driver.get(url);
		             // String ua = driver.findElement(By.id("id_ua")).getText(); 
		              
		          	driver.get("http://localhost/addressbook/index.php");
		              
		              login("admin", "secret");
		              
		    }


	private void login(String username, String password) {
	
		  driver.findElement(By.name("user")).click();
		  driver.findElement(By.name("user")).clear();	
		driver.findElement(By.name("user")).sendKeys(username);
		
		  driver.findElement(By.name("pass")).click();
		  driver.findElement(By.name("pass")).clear();
		  driver.findElement(By.name("pass")).sendKeys(password);
		  driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
	}


	protected void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}


	protected void subminGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}


	protected void fillGroupForm(GroupData groupData) {
		driver.findElement(By.name("group_name")).click();
		  driver.findElement(By.name("group_name")).clear();
		  driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
		  driver.findElement(By.name("group_header")).click();
		  driver.findElement(By.name("group_header")).clear();
		  driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
		  driver.findElement(By.name("group_footer")).click();
		  driver.findElement(By.name("group_footer")).clear();
		  driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
	}


	protected void initGropCreation() {
		driver.findElement(By.name("new")).click();
	}


	protected void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}


	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}


	protected void deleteSelectedGroup() {
		driver.findElement(By.name("delete")).click();
	}


	protected void selectGroup() {
		driver.findElement(By.name("selected[]")).click();
	}


	public static boolean isAlertPresent(FirefoxDriver wd) {
	    try {
	    	driver.switchTo().alert();
	        return true;
	    } catch (NoAlertPresentException e) {
	        return false;
	    }
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


