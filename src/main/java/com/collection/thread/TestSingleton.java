package com.collection.thread;
//关于懒汉式的线程安全问题:使用同步机制
//对于一般的方法内,使用同步代码块,可以考虑使用this
//对于静态方法而言,使用当前类本身充当锁

class Singleton {
	
	private Singleton(){
		
	}
	
	private static Singleton instance = null;
	public static Singleton getInstance(){
		if(instance == null){//由于synchronized会阻塞其他线程很影响效率,在同步方法外加条件进入同步方法提高效率
			synchronized(Singleton.class){//使用类本身作为锁
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
}
public class TestSingleton {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
	}
}
