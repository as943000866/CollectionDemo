package com.reflection;

public class Animal {
	String name;
	public int age;
	static String desc = "我是一个动物";

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

	public Animal() {
		super();
	}

	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

	private static void info() {
		System.out.println("动物");

	}

	private void show(String desc) {
		System.out.println("我是一个:" + desc);
	}
}
