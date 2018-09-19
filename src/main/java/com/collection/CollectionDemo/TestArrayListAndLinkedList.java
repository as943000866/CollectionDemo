package com.collection.CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class TestArrayListAndLinkedList {
	
	@Test
	public void test(){
//		ArrayList list = new ArrayList();
		LinkedList list = new LinkedList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("BB");
		
		//get(int index)
		//set(int index,Object obj)
		list.set(1, 111);
		//add(int index,Object obj)
		list.add(2, "MM");
		//remove(int index)
		list.remove(0);
		System.out.println(list.get(0));
		
		System.out.println();
		//遍历集合元素:方式一
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		//增强for循环
		for(Object obj:list){
			System.out.println(obj);
		}
		System.out.println();
		//一般for循环
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
			
	}
}
