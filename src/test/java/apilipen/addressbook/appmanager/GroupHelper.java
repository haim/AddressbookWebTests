package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import apilipen.addressbook.model.GroupData;

public class GroupHelper {

	private WebDriver driver;


	
 GroupHelper(WebDriver wd) {
	  this.driver = wd;
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

	public void deleteSelectedGroup() {
		driver.findElement(By.name("delete")).click();
	}

	public void selectGroup() {
		driver.findElement(By.name("selected[]")).click();
	}

}