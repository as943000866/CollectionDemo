package com.reflection;
@MyAnnotation
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
	public String name;
	private int age;
	int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public void show(){
		System.out.println("我是一个人");
	}
	
	public void display(String city){
		System.out.println("我的国籍是:"+city);
	}
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void info(){
		System.out.println("我是中国人");
	}
}
