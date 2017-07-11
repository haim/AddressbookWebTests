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

	public void create(GroupData groupData) {
		 initGropCreation();
		 fillGroupForm(groupData);
		 submitGroupCreation();
		 returnToGroupPage();
		
	}
	
	public void modify(int index, GroupData newGroup) {
		selectGroup(index);  
		initGroupModification();  
		fillGroupForm (newGroup);
		submitGroupModification();
		returnToGroupPage();
	}
	
	public void delete(int index) {
		selectGroup(index);  
    	 deleteSelectedGroup();
    	 returnToGroupPage();
	} 

	
	public boolean isThereAGroup() {
		
		return isElementPresent(By.name("selected[]"));
	}

	public int getGroupCount() {
		// TODO 
		return driver.findElements(By.name("selected[]")).size();
	}


	public List<GroupData> list() {
		List <GroupData> groups = new ArrayList<GroupData>() ;		
		List <WebElement> elements  = driver.findElements(By.cssSelector("span.group"));
		for ( WebElement element : elements){
			String name = element.getText();
			
			int id = Integer.parseInt(element.findElement(By.tagName("input"))
					               .getAttribute("value"));
		//	GroupData group = new GroupData ().withId(id).withName(name);
			// new GroupData (id, name , null, null );
			groups.add(new GroupData ().withId(id).withName(name));
			System.out.println(name +" " +  id);
		}
		
		return groups;
	}

	
}
