package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import apilipen.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

	GroupHelper(WebDriver wd) {
	//  this.driver = wd;
	  super(wd);
	}

	public void returnToGroupPage() {
		clickElement(By.linkText("group page"));
	}

	public void submitGroupCreation() {
		clickElement(By.name("submit"));
	}

	

	public void fillGroupForm(GroupData groupData) {
	      setText(By.name("group_name"), groupData.getName());
	      setText(By.name("group_header"), groupData.getHeader());
	      setText(By.name("group_footer"), groupData.getFooter());

	}

	
	public void initGropCreation() {
		clickElement(By.name("new"));
	}

	public void deleteSelectedGroup() {
		clickElement(By.name("delete"));
	}

	public void selectGroup() {
		clickElement(By.name("selected[]"));
	}

	public void initGroupModification() {
		clickElement(By.name("edit"));
		
	}

	public void submitGroupModification() {
		clickElement(By.name("update"));
		
		
	}

	public void createGroup(GroupData groupData) {
		 initGropCreation();
		 fillGroupForm(groupData);
		 submitGroupCreation();
		 returnToGroupPage();
		
	}

	public boolean isThereAGroup() {
		
		return isElementPresent(By.name("selected[]"));
	}

	
}
