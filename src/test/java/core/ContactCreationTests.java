package core;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class ContactCreationTests extends TestBase {

  
    
    @Test
    public void testContactCreation() {

    	
    	gotoContactPage();
    	driver.findElement(By.name("firstname")).click();
    	driver.findElement(By.name("firstname")).clear();
    	driver.findElement(By.name("firstname")).sendKeys("Sara");
    	driver.findElement(By.name("lastname")).click();
    	driver.findElement(By.name("lastname")).clear();
    	driver.findElement(By.name("lastname")).sendKeys("Bernar");
    	driver.findElement(By.name("address")).click();
    	driver.findElement(By.name("address")).clear();
    	driver.findElement(By.name("address")).sendKeys("1223, Ednamary way MV, CA 94040");
    	driver.findElement(By.name("home")).click();
    	driver.findElement(By.name("home")).clear();
    	driver.findElement(By.name("home")).sendKeys("966-345-78-89");
    	driver.findElement(By.name("email")).click();
    	driver.findElement(By.name("email")).clear();
    	driver.findElement(By.name("email")).sendKeys("sokolsky@list.ru");
    	driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

	private void gotoContactPage() {
		driver.findElement(By.linkText("add new")).click();
	}
    
  
    
}
