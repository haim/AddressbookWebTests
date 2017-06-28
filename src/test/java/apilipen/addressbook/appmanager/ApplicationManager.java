package apilipen.addressbook.appmanager
;

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

import apilipen.addressbook.model.ContactData;
import apilipen.addressbook.model.GroupData;

public class ApplicationManager {

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

	public void init() throws IOException {
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

	public void login(String username, String password) {
	
		  driver.findElement(By.name("user")).click();
		  driver.findElement(By.name("user")).clear();	
		driver.findElement(By.name("user")).sendKeys(username);
		
		  driver.findElement(By.name("pass")).click();
		  driver.findElement(By.name("pass")).clear();
		  driver.findElement(By.name("pass")).sendKeys(password);
		  driver.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
	}

	public void returnToGroupPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void fillGroupForm(GroupData groupData) {
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

	public void initGropCreation() {
		driver.findElement(By.name("new")).click();
	}

	public void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	public void stop() {
		driver.quit();
	}

	public void deleteSelectedGroup() {
		driver.findElement(By.name("delete")).click();
	}

	public void selectGroup() {
		driver.findElement(By.name("selected[]")).click();
	}

	public void fillContactCreation(ContactData contactData) {
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contactData.getFname());
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contactData.getLname());
		driver.findElement(By.name("address")).click();
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contactData.getAddr());
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contactData.getPhone());
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
	}

	public void submitContactCreation() {
		driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
	}

	public void gotoContactPage() {
		driver.findElement(By.linkText("add new")).click();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
	    try {
	    	driver.switchTo().alert();
	        return true;
	    } catch (NoAlertPresentException e) {
	        return false;
	    }
	}

}
