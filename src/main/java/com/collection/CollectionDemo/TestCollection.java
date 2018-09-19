package com.collection.CollectionDemo;

/*
 * 补充 3.集合
 * 		Collection 接口  1:add(Object obj),addAll(Collection coll),size(),clear(),isEmpty()
 * 					  2:remove(Object obj),removeAll(Collection coll),retainAll(Collection coll)
 * 						equals(Object obj),contains(Object obj),containsAll(Collection coll),hashCode()
 * 					  3:iterator(),toArray();
 * 			-----List :存储有序的，可以重复的对象.新增的方法:删除remove(int index) 修改set(int index,Object obj) 
 * 												获取 get(int index) 插入 add(int index,Object obj)
 * 						添加进集合List集合中的元素(或对象)所在的类一定要重写equals()方法
 * 					----- :ArrayList(主要方法) LinkedList(对于频繁的插入删除操作) Vector(古老的方法,线程安全的,效率低于ArrayList)
 * 			-----Set :存储无序,不可重复的对象
 * 					----- :HashSet LinkedSet TreeSet
 * 		Map 接口 :存储键值对的数据
 * 			----- : HashMap LinkedHasMap TreeMap HashTable(子类-Properties)
 * 				
 */					
public class TestCollection {

}

