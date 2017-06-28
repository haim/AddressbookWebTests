package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

	
private	WebDriver driver;
	
	
	public NavigationHelper(WebDriver wd){
		
		this.driver = wd;
	}
	
	
	
	public void gotoGroupPage() {
		driver.findElement(By.linkText("groups")).click();
	}

}
