package apilipen.addressbook.tests;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    

    
    @Test
    public void GroupDeletionTests() {
    	  app.   gotoGroupPage();   	
    	  app. selectGroup();
    	  app. deleteSelectedGroup();
    	  app.  returnToGroupPage();
    }
    
  
}
