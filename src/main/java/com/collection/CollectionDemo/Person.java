package com.collection.CollectionDemo;

public class Person implements Comparable{
	private String name;
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	static int init = 1000;
	
	@Override
	public int hashCode() {
		final int prime = 31; //质数   不能被除
		int result = 1;
		//使用迭代的方式   取比较唯一的hashCode
		result = prime * result + age; 
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
		//return init++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public int compareTo(Object o) {
		if(o instanceof Person){
			Person p = (Person) o;
			int i = this.name.compareTo(p.name);
			if(i == 0){
				return this.age.compareTo(p.age);
			}
			return i;
		}
		return 0;
	}
	
	
}
