package com.random;

import java.util.HashMap;
import java.util.Map;

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
        Map<Student, String> map = new HashMap<>();
        map.put(new Student(1,"Prateek"), ":1");
        map.put(new Student(1,"Neha"), ":2");
        map.put(new Student(1,"Nikhil"), ":3");
        map.put(new Student(1,"Sumit"), ":4");
        map.put(new Student(1,"Amarjit"), ":5");
        map.put(new Student(1,"Neha"), ":3");
		System.out.println(AbstractMain.a+ " -Main- "+ AbstractMain.b);
		System.out.println(map);
		System.out.println(map.get(new Student(1,"Neha")));
		System.out.println(map.entrySet());
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
