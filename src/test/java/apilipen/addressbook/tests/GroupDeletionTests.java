package apilipen.addressbook.tests;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    

    
    @Test
    public void GroupDeletionTests() {
    	  app.getNavigationHelper().gotoGroupPage();  
    	  app.  getGroupHelper().selectGroup();  
    	  app.  getGroupHelper().deleteSelectedGroup();
    	  app.  getGroupHelper().returnToGroupPage();
    }
    
  
}
