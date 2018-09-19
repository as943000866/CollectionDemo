package com.reflection;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {
	@Test
	public void test1() throws ClassNotFoundException{
		String className = "com.reflection.Person";
		Class clazz = Class.forName(className);
		
		Constructor[] cons = clazz.getDeclaredConstructors();
		for (Constructor constructor : cons) {
			System.out.println(constructor);
		}
	}
	
	
	@Test
	public void test2() throws Exception{
		String className = "com.reflection.Person";
		Class clazz = Class.forName(className);
		//getDeclaredConstructor(Class class,...) 通过运行时类获取指定的构造器
		Constructor cons = clazz.getDeclaredConstructor(String.class,int.class);
		cons.setAccessible(true);
		Person p = (Person) cons.newInstance("lmg",10);
		System.out.println(p);
	}
}
