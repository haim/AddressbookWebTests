package apilipen.addressbook.tests;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import apilipen.addressbook.model.GroupData;

public class GroupCreationTests  extends TestBase {
	
	
	
	
	   @Test (enabled = false)
	    public void testGroupCreation() {	
		   app.getNavigationHelper().gotoGroupPage();  
		   
		// modifacation "int"   to List:    int before = app.getGroupHelper().getGroupCount(); 	
		List <GroupData> before = app.getGroupHelper().getGroupList() ; //	 with new method getGroupList()  
		  GroupData newGroup = new GroupData("testR", "testR", "testR");
 // before.get(before.size() - 1).getId(),
		app.getGroupHelper().createGroup(newGroup);
		  
		   List <GroupData>  after = app.getGroupHelper().getGroupList();
	        Assert.assertEquals(after.size() , before.size() + 1);
	        
	        
	        // add to old List new created group


	// calculating max indeficator of new     created group 
	        int max = 0;
	        for (GroupData g : after){
	        	 if (g.getId() > max)  {max =  g.getId();  }
	        }

	        newGroup.setId(max);
		    before .add(newGroup);
	        Assert.assertEquals( new HashSet<Object>(before),    new HashSet<Object>(after));
	   }



	@Test
	public void testGroupCreation2() {
		app.getNavigationHelper().gotoGroupPage();

		// modifacation "int"   to List:    int before = app.getGroupHelper().getGroupCount();
		List<GroupData> before = app.getGroupHelper().getGroupList(); //	 with new method getGroupList()
		GroupData newGroup = new GroupData("testR", "testR", "testR");
		// before.get(before.size() - 1).getId(),
		app.getGroupHelper().createGroup(newGroup);

		List<GroupData> after = app.getGroupHelper().getGroupList();
		Assert.assertEquals(after.size(), before.size() + 1);


		// add to old List new created group
		before.add(newGroup);



		// 1.  calculating max indentificator  Utilizing  Comparator(java 8)
		/**  video 4/9
		 * переменная типа Comparator, которая умеет сравнивать
		 обьекты типа  GroupData и в нее присваеваем значение обьекти типа Comparator

		 */
		//  anonimus  function  :            parameters       body of function
		//    Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

//  ** or :
//		 Comparator<? super GroupData> byId =	 new Comparator<GroupData>() {
//              // adding implemented method (Comparator - it's interface)
//			@Override
//			public int compare(GroupData o1, GroupData o2) {return Integer.compare(o1.getId(), o2.getId());}
//		};



		// replace byId in  .max(byId)
		//	int max2 =   after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();


		before .add(newGroup);
		//  newGroup.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());




		newGroup.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
		Assert.assertEquals( new HashSet<Object>(before),    new HashSet<Object>(after));

	}




	}
