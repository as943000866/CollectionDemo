package com.collection.CollectionDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
/* 	Map 接口 :存储键值对的数据
* 		|----- : HashMap:Map的主要实现类
*  		|----- : LinkedHasMap:使用链表维护添加进Map中的顺序。故遍历Map时,是按添加的顺序遍历的。
*   	|----- : TreeMap:按照添加进Map中的元素的key的指定属性进行排序。要求:key必须是同一个类的对象
*   				自然排序 vs 定制排序
*   	|----- : HashTable:古老的实现类,线程安全的,不建议使用
*   				|----- :Properties :常用来处理属性文件。键和值都为String类型的
*/
public class TestMap {
	//使用Properties处理属性文件
	@Test
	public void test6() throws FileNotFoundException, IOException{
		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("jdbc.properties")));
		String name = properties.getProperty("name");
		String password = properties.getProperty("password");
		System.out.println(name);
		System.out.println(password);
	}
	//定制排序
	@Test
	public void test5(){
		
		Comparator com = new Comparator() {

			public int compare(Object o1, Object o2) {
				if(o1 instanceof Customer && o2 instanceof Customer){
					Customer c1 = (Customer) o1;
					Customer c2 = (Customer) o2;
					int i = c1.getAge().compareTo(c2.getAge());
					if(i == 0){
						return c1.getName().compareTo(c2.getName()); 
					}
					return i;
				}
				return 0;
			}
		};
		
		Map map = new TreeMap(com);
		map.put(new Customer("AA", 20), 99);
		map.put(new Customer("AA", 19), 95);
		map.put(new Customer("EE", 25), 80);
		map.put(new Customer("CC", 22), 85);
		map.put(new Customer("DD", 23), 100);
		
		Set entrySet = map.entrySet();
		for (Object obj : entrySet) {
			Map.Entry entry = (Entry) obj;
			System.out.println(entry.getKey() +"----->"+entry.getValue());
		}
	}
	
	//自然排序
	@Test
	public void test4(){
		Map map = new TreeMap();
		map.put(new Person("AA", 20), 99);
		map.put(new Person("AA", 19), 95);
		map.put(new Person("EE", 25), 80);
		map.put(new Person("CC", 22), 85);
		map.put(new Person("DD", 23), 100);
		
		Set entrySet = map.entrySet();
		for (Object obj : entrySet) {
			Map.Entry entry = (Entry) obj;
			System.out.println(entry.getKey() +"----->"+entry.getValue());
		}
	}
	
	/*
	 * LinkedHashMap遍历整个map时,由于有链表的存在效率比HashMap快,删除添加时效率不如HashMap,因为还要维护链表节点的前后索引
	 */
	@Test
	public void test3(){
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("EE", 456);
		map.put("BB", 789);
		map.put(123, "CC");
		map.put(new Person("AA", 20), "DD");
	
		Set keySet = map.keySet();
		for (Object obj : keySet) {
			System.out.println(obj);
		}
	}
	/*
	 * 如何遍历Map
	 * Set keySet()
	 * Collection values()
	 * Set entrySet()
	 */
	@Test
	public void test2(){
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("EE", 456);
		map.put("BB", 789);
		map.put(123, "CC");
		map.put(new Person("AA", 20), "DD");
		
		//遍历key
		Set keySet = map.keySet();
		for (Object obj : keySet) {
			System.out.println(obj);
		}
		System.out.println();
		
		//遍历value
		Collection values = map.values();
		Iterator iterator = values.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		
		//遍历entry
		//1.使用keySet
		for (Object key : keySet) {
			System.out.println(key + "---->" +map.get(key));
		}
		System.out.println();
		//2.使用EntrySet
		Set entrySet = map.entrySet();
		for (Object obj : entrySet) {
			Map.Entry entry = (Entry) obj;
			System.out.println(entry.getKey() +"----->"+entry.getValue());
		}
	}
	
	
	/*
	 * Object put(Object key,Object value):向Map中添加一个元素
	 * Object remove(Object key):按照指定的key删除此key-value
	 * void putAll(Map t)
	 * void clear():清空
	 * Object get(Object key):获取指定key的value值。若无此key,则返回null
	 * boolean containsKey(Object Key)
	 * boolean containsValue(Object value)
	 * int size() 返回集合的长度
	 * boolean isEmpty()
	 * boolean equals(Object obj)
	 * 
	 * HashMap:
	 * 1.key是用Set来存放的,不可重复。value是用Collection来存放的,可重复
	 * 一个key-value对,是一个Entry。所有的Entry是用Set存放的,也是不可重复的。
	 * 2.向HashMap中添加元素时,会调用key所在类的equals()方法,判断两个key是否
	 * 相同。若相同则只能添加进去后面的那个元素。 
	 */
	@Test
	public void test1(){
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("EE", 456);
		map.put("BB", 789);
		map.put("BB", 555);
		map.put(123, "CC");
		map.put(new Person("AA", 20), "DD");
		map.put(new Person("AA", 20), "DD");
		map.put(null, null);
		System.out.println(map.size());
		System.out.println(map);
		map.remove("BB");
		System.out.println(map);
		Object obj = map.get("BB");
		System.out.println(obj);
	}
}
