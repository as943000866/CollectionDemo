package com.collection.CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class TestCollections {
	
	/*
	 * Object max(Collection):根据元素的自然顺序,返回给定集合中的最大元素
	 * Object max(Collection,Comparator):根据Comparator 指定的顺序,返回给定集合的最大元素
	 * Object min(Collection)
	 * Object min(Collection,Comparator)
	 * int frequency(Collection,Object):返回指定集合中指定元素的出现次数
	 * void copy(List dest,List src):将src中的内容复制到dest中
	 * boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List中的旧值
	 * 
	 */
	@Test
	public void testCollections2(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(789);
		list.add(223);
		list.add(323);
		
		Object max = Collections.max(list);
		System.out.println(max);
		
		int count = Collections.frequency(list,4567);
		
		System.out.println(count);
		
		//实现List的复制
		//List list1 = new ArrayList(); 错误的实现方式
		List list1 = Arrays.asList(new Object[5]);
		Collections.copy(list1, list);
		System.out.println(list1);
		//通过如下的方式保证list的线程安全性
		List list2 = Collections.synchronizedList(list);
		System.out.println(list2);
	}
	
	/*
	 * reverse(List):反转List	中元素的顺序
	 * shuffle(List):对List 集合元素进行随机排序
	 * sort(List):根据元素的自然顺序队长指定的List集合元素按升序排序
	 * sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
	 * swap(List,int,int):将指定List集合中i 处元素和j 处元素进行交换
	 */
	@Test
	public void testCollections1(){
		List list = new ArrayList();
		list.add(123);
		list.add(456);
		list.add(789);
		list.add(223);
		list.add(323);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.swap(list, 0, 2);
		System.out.println(list);
	}	
	//从键盘随机输入10个整数保存到list中,并按照倒序.从大到小的顺序显示出来
	@Test
	public void test1(){
		Scanner scan = new Scanner(System.in);
		List list = Arrays.asList(new Integer[10]);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, scan.nextInt());
		}
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.sort(list);
		Collections.reverse(list);
		System.out.println(list);
	}
	
	//把学生姓名与考试分数分别录入到Map中,并按分数显示前三名学员的名字
	@Test
	public void test2(){
		Map map = new TreeMap();
		map.put(new Student("AA", 123), 123);
		map.put(new Student("FF", 456), 456);
		map.put(new Student("BB", 345), 345);
		map.put(new Student("CC", 222), 222);
		
		Set entrySet = map.entrySet();
		Iterator iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Object obj = iterator.next();
			Map.Entry entry =  (Entry) obj;
			System.out.println(entry.getKey() +"---->"+entry.getValue());
		}
	}
	
}
