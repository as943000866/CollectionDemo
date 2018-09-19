package com.reflection;

import java.lang.reflect.Field;

import org.junit.Test;

public class TestField {
	//获取指定的属性
	@Test
	public void test1() throws Exception{
		Person p = new Person();
		Class clazz = p.getClass();
		//1.getField(String fieldName)通过运行时类获取声明为public的指定属性
		Field field = clazz.getField("name");
		field.set(p, "lmg");
		System.out.println(p);
		
		//2.getDeclaredField(String fieldName)通过运行时类获取指定的属性
		Field field2 = clazz.getDeclaredField("age");
		//注:在使用getDeclaredField()方法时,要设置setAccessible(ture),防止访问权限不够出错
		field2.setAccessible(true);
		field2.set(p, 10);
		System.out.println(p);
	}
}
