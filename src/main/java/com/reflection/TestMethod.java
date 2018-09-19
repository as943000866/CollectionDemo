package com.reflection;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestMethod {
	
	//获取指定的方法
	@Test
	public void test1() throws Exception{
		String className = "com.reflection.Person";
		Class<?> clazz = Class.forName(className);
		//getMethod(String MethodName) 通过运行时类获取声明为public的指定方法
		Method m1 = clazz.getMethod("show");
		Person p = (Person) clazz.newInstance();
		//调用指定的方法:Object invike(Object obj,Object ... obj)
		m1.invoke(p);
		
		//getDeclaredMethod(String MethodName) 通过运行时类获取指定的方法
		Method m2 = clazz.getDeclaredMethod("display", String.class);
		m2.setAccessible(true);
		m2.invoke(p, "CHN");
		
		//通过invoke()方法获取返回值
		Method m3 = clazz.getDeclaredMethod("toString");
		m3.setAccessible(true);
		String returnVal = (String)m3.invoke(p);
		System.out.println(returnVal);
		
		//对于运行时类中静态方法的调用
		Method m4 = clazz.getDeclaredMethod("info");
		m4.setAccessible(true);
		m4.invoke(Person.class);
	}
}
