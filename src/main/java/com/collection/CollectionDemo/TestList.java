package com.collection.CollectionDemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//ArrayList :List的主要实现类
/*
 * List 相对于Collection,新增加的方法
 * void add(int index,Object obj) 在指定索引位置index,新增加一个元素obj
 * boolean addAll(int index,Collection eles)在索引位置index,新增加一个集合 eles
 * Object get(int index) 获取指定索引位置的元素
 * Object remove(int index) 删除指定索引位置的元素
 * Object set(int index,Object ele) 设置指定索引位置的元素为ele
 * 
 * int indexOf(Object obj) 返回obj在集合中首次出现的位置。没有的话,返回-1
 * int lastIndexOf(Object obj) 返回obj在集合中最后一次出现的位置。没有的话,返回-1
 * List subList(int fromIndex,int toIndex) 返回从fromIndex到toIndex结束的一个子List
 *
 * List 常用的方法:增(add(Object obj)) 删(remove(Object obj))
 * 				改(set(int index,Object obj)) 查(get(int index)
 * 				插(add(int index,Object obj)) 长度(size())
 */
public class TestList {

	@Test
	public void testList1(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("BB");
		System.out.println(list);
		list.add(0, 555);
		System.out.println(list);
		Object obj = list.get(1);
		System.out.println(obj);
		list.remove(0);
		System.out.println(list.get(0));
		list.set(0, 111);
		System.out.println(list);
		
		List list1 = list.subList(0, 3);
		System.out.println(list1);
		
	}
	
	@Test
	public void testList2(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add("AA");
		list.add("BB");
		list.add(456);
		System.out.println(list.indexOf(456));
		System.out.println(list.lastIndexOf(456));
		System.out.println(list.indexOf(123) == list.lastIndexOf(123));
		System.out.println(list.indexOf(444));
	}
}
