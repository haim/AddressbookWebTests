package apilipen.addressbook.appmanager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void selectGroup(int index) {
		
		
	driver.findElements(By.name("selected[]")).get(index).click();;
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

	public int getGroupCount() {
		// TODO 
		return driver.findElements(By.name("selected[]")).size();
	}

	public List<GroupData> getGroupList() {
		List <GroupData> groups = new ArrayList<GroupData>() ;
		
		List <WebElement> elements  = driver.findElements(By.cssSelector("span.group"));
		for ( WebElement element : elements){
			String name = element.getText();
			GroupData group = new GroupData (name , null, null );
			groups.add(group);
			System.out.println(name);
		}
		
		return groups;
	}

	
}
