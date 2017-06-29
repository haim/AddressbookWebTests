package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{



	public SessionHelper(WebDriver wd) {
		// TODO Auto-generated constructor stub
		 super(wd);
	}

	
	public void login(String username, String password) {
		
		   setText(By.name("user"), username);
		   setText(By.name("pass"), password);
		   clickElement(By.xpath("//form[@id='LoginForm']/input[3]"));
		 
	}

	
}
