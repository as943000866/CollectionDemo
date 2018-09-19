package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestReflection {
	
	//如何获取Class的实例(3种)

	@Test
	public void test4() throws ClassNotFoundException{
		//1.调用运行时类本身的.class属性
		Class clazz1 = Person.class;
		System.out.println(clazz1);
		//2.通过运行时类的的对象
		Person p = new Person();
		Class clazz2 = p.getClass();
		System.out.println(clazz2);
		//3.通过Class的静态方法获取
		Class clazz3 = Class.forName("com.reflection.Person");
		System.out.println(clazz3);
		//4.(了解)通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class clazz4 = classLoader.loadClass("com.reflection.Person");
		System.out.println(clazz4);
	}
	
	/*
	 * java.lang.Class:是反射的源头。
	 * 我们创建了一个类,通过编译（javac.exe）,生成对应的.class文件。之后我们使用java.exe加载(JVM的类加载器完成的)
	 * 此.class文件,此.class文件加载到内存以后,就是一个运行时类,存在缓存区。那么这个运行时类本身就是一个Class的实例!
	 * 1.每一个运行时类只加载1次 ! 
	 * 2.有了Class的实例以后,我们才可以进行如下的操作
	 * 		1)*创建对应的运行时类对象
	 * 		2) 获取对应的运行时类的完整结构(属性、方法、构造器、内部类、父类、所在的包、注解...)
	 * 		3)*调用对应的运行时类的指定结构(属性、方法、构造器)
	 * 		4)反射的应用:动态代理
	 */
	@Test
	public void test3(){
		Person p = new Person();
		Class clazz = p.getClass();
		System.out.println(clazz);
	}
	//反射的方式
	//有了反射,可以通过反射创建一个类的对象
	
	@Test 
	public void test2() throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
		//1.创建clazz对应的运行时类Person类的对象
		Class clazz = Person.class;
		Person p = (Person) clazz.newInstance();
		//2.通过通过反射调用运行时类的指定属性
		//获取public属性
		Field name = clazz.getField("name");
		name.set(p, "lmg");
		//获取private属性
		Field age = clazz.getDeclaredField("age");
		age.setAccessible(true);
		age.set(p, 20);
		System.out.println(p);
		
		//3.通过反射调用运行时类的指定的方法
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "china");
	}
	
	//在有反射以前,如何创建一个类的对象,并调用其中的方法、属性
	@Test
	public void test1(){
		Person p = new Person();
		p.setName("lmg");
		p.setAge(10);
		System.out.println(p);
		p.show();
		p.display("china");
	}
}
