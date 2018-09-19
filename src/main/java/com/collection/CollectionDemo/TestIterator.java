package com.collection.CollectionDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class TestIterator {
	
	
	
	
	//方式一:使用迭代器遍历
	@Test
	public void test1(){
		Collection collection = new ArrayList();
		collection.add(123);
		collection.add("AA");
		collection.add("BB");
		
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	
	//方式一:使用增强for循环遍历
	@Test
	public void test2(){
		Collection collection = new ArrayList();
		collection.add(123);
		collection.add("AA");
		collection.add("BB");
		
		for(Object i: collection){
			System.out.println(i);
		}
	}
}
