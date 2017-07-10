package core.Sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//simpleArray();
		simpleArrayList();
	}

	private static void simpleArray() {
		String[] langs = {"Java", "Python", "C#", "Ruby"} ;
		
for (String l : langs) {   //  int i = 0 ; i < langs.length; i ++
	
	System.out.println("I want to know: "  + l);
}
	}

	
	
	private static void simpleArrayList() {
		List<String> languages = Arrays.asList("Java", "Python", "C#", "Ruby");   // new ArrayList<String>();
//		languages.add("Java");
//		languages.add("Python");
//		languages.add("C#");
//		languages.add("Ruby");
		
for (String l : languages) {   //  int i = 0 ; i < languages.size(); i ++
	
	System.out.println("I want to know: "  + l); // + languages.get(i);
}
	}
	
	
}
