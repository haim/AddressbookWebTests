package core;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    

    
    @Test
    public void GroupDeletionTests() {
        gotoGroupPage();   	
    	selectGroup();
    	deleteSelectedGroup();
    	returnToGroupPage();
    }
    
  
}
