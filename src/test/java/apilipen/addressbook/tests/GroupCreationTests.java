package apilipen.addressbook.tests;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import org.hamcrest.CoreMatchers;
import static org.hamcrest.MatcherAssert.assertThat;

import apilipen.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.Test;
import apilipen.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;

public class GroupCreationTests  extends TestBase {
	

	@Test (enabled = false)
	public void testGroupCreation2() {
		app.goTo().groupPage();
		List<GroupData> before = app.group().list(); //	 with new method getGroupList()
		GroupData newGroup = new GroupData().withName("testR").withHeader("testR").withFooter("testR");
		app.group().create(newGroup);

		List<GroupData> after = app.group().list();
		Assert.assertEquals(after.size(), before.size() + 1);


		before .add(newGroup);
		
		  Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
		  before.sort(byId);
		  after.sort(byId);
		  Assert.assertEquals( before, after);
	}


	@Test					// video 5.6
	public void testGroupCreation3() {
		app.goTo().groupPage();
		Groups before = app.group().all(); //	 with new method getGroupList()
		GroupData newGroup = new GroupData().withName("testR").withHeader("testR").withFooter("testR");
		app.group().create(newGroup);

		Groups after = app.group().all();
		//Assert.assertEquals(after.size(), before.size() + 1);
		 assertThat(after.size(), equalTo( before.size() + 1));

		            //newGroup.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());


		//  Assert.assertEquals( before, after);
		//  MatcherAssert.assertThat(after, CoreMatchers.equalTo(before));
		 assertThat(after, equalTo(
			    before.withAdded(newGroup.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
	}

	
	
	
	
	
	
	
	// add to old List new created group


	// 1.  calculating max indentificator  Utilizing  Comparator(java 8)
	/**  video 4/9
	 * переменная типа Comparator, которая умеет сравнивать
	 обьекты типа  GroupData и в нее присваеваем значение обьекти типа Comparator

	 */
	//  anonimus  function  :            parameters       body of function
	//    Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

//** or :
//	 Comparator<? super GroupData> byId =	 new Comparator<GroupData>() {
//          // adding implemented method (Comparator - it's interface)
//		@Override
//		public int compare(GroupData o1, GroupData o2) {return Integer.compare(o1.getId(), o2.getId());}
//	};

	// replace byId in  .max(byId)
	//	int max2 =   after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

	//  newGroup.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

//	newGroup.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
	}


