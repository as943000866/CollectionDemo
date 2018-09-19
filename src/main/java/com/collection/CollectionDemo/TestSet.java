package com.collection.CollectionDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/*
 * Collection 接口  
 * 		-----List :
 * 			----- :ArrayList(主要方法)
 *  		----- :LinkedList(对于频繁的插入删除操作)
 *  		----- : Vector(古老的方法,线程安全的,效率低于ArrayList)
 * 		-----Set :存储无序,不可重复的对象,Set常用的方法都是Collection中定义的
 * 			----- :HashSet(主要实现类)
 * 			----- :LinkedSet
 * 			----- : TreeSet
 * 
 */
public class TestSet {
	
	/*
	 * LinkedHashSet:使用链表维护了一个添加进集合中的顺序。导致当我们遍历LinkedHashSet集合
	 * 元素时,是按照添加进去的顺序遍历的!
	 * 
	 * LinkedHashSet插入性能略低于HashSet,但是迭代访问Set里面的全部元素时有很好的性能。
	 */
	@Test
	public void testLinkedHashSet(){
		
		Set set = new LinkedHashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add(null);

		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	
	/*
	 * Set:存储的元素是无序的,不可重复的!
	 * 1.无序性:无序性!=随机性 真正的无序性,指的是元素在底层存储的位置是无序的。
	 * 2.不可重复性:当向Set中添加进相同的元素的时候,后面的这个不能添加进去。
	 * 
	 * Set中的元素是如何存储的呢?使用哈希算法。
	 * 当向Set中添加对象时,首先调用此对象所在类的hashCode方法,计算此对象的哈希值。此哈希值
	 * 决定了此对象在Set中的存储位置。若此位置之前没有对象存储,则这个对象直接存储到此位置。若此
	 * 位置已有对象存储,在通过equals()比较这两个对象是否相同。如果相同,后一个对象就不能再添加
	 * 进来。
	 * 万一返回false,都存储 (不建议如此)
	 * >要求:hashCode()方法要与equals()方法一致
	 * 说明:要求添加进Set中的元素所在的类,一定要重写equals()和hashCode()方法
	 */
	@Test
	public void testHashSet(){
		
		Set set = new HashSet();
		set.add(123);
		set.add(456);
		set.add("AA");
		set.add("BB");
		set.add(null);
		Person p1 = new Person("MM", 22);
		Person p2 = new Person("MM", 22);
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		set.add(p1);
		set.add(p2);
		System.out.println(p1.equals(p2));
		System.out.println(set.size());
		System.out.println(set);
	}
}
