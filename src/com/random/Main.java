package com.random;

import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

abstract class AbstractMain {
    static int a = 1;
    static String b = "Prateek";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(a+ " -AbstractMain- "+ b);
	}

}

public class Main{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /*    Map<Student, String> map = new HashMap<>();
        map.put(new Student(1,"Prateek"), ":1");
        map.put(new Student(1,"Neha"), ":2");
        map.put(new Student(1,"Nikhil"), ":3");
        map.put(new Student(1,"Sumit"), ":4");
        map.put(new Student(1,"Amarjit"), ":5");
        map.put(new Student(1,"Neha"), ":3");
		System.out.println(AbstractMain.a+ " -Main- "+ AbstractMain.b);
		System.out.println(map);
		System.out.println(map.get(new Student(1,"Neha")));
		System.out.println(map.entrySet());*/
		
		
		/*ScriptEngineManager mgr = new ScriptEngineManager();
		  ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
		  try {
		    jsEngine.eval("print('Hello, world!')");
		  } catch (ScriptException ex) {
		      ex.printStackTrace();
		  }    
		  */
		
		//Collections.addAll(set, arr);
		  
		  ScriptEngineManager mgr = new ScriptEngineManager();
		  List<ScriptEngineFactory> factories = 
		      mgr.getEngineFactories();
		  for (ScriptEngineFactory factory: factories) {
		    System.out.println("ScriptEngineFactory Info");
		    String engName = factory.getEngineName();
		    String engVersion = factory.getEngineVersion();
		    String langName = factory.getLanguageName();
		    String langVersion = factory.getLanguageVersion();
		    System.out.printf("\tScript Engine: %s (%s)\n", 
		        engName, engVersion);
		    List<String> engNames = factory.getNames();
		    for(String name: engNames) {
		      System.out.printf("\tEngine Alias: %s\n", name);
		    }
		    System.out.printf("\tLanguage: %s (%s)\n", 
		        langName, langVersion);
		  }    
		
		
	}
	
	static class Student{
	int id;
	String name;
	
	public Student(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public int hashCode(){
		return this.id;
		
	}
	
	@Override
	public boolean equals(Object o){
		if(this == o) return true;
		if(o == null || this == null) return false;
		Student s = (Student) o;
		if(this.name.equals(s.name) && this.id == s.id) return true;
		return false;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	}
	
}
