package com.collection.thread;

/*
 * Threa的常见的方法
 * 1.start():启动线程并执行相应的run()方法
 * 2.run():子线程要执行的代码放入run()方法中
 * 3.currentThread():静态的,调用当前的线程
 * 4.getName():获取此线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():调用此方法的线程释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join()方法,表示:当执行到此方法,A线程停止执行,直至B线程执行完毕,
 * A线程再接着join()之后的代码执行
 * 8.isAlive():判断当前线程是否存活
 * 9.sleep(long l):显式的让当前线程睡眠l毫秒
 * 10.线程通信:wait()  notify()   notifyAll()
 * 
 * 设置优先级
 * getPriority():返回线程优先级
 * setPriority(int newPriority):改变线程的优先级
 */
class SubThread1 extends Thread{
	public void run(){
		for(int i = 1; i <= 100; i++){
//			try {
//				Thread.currentThread().sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority() + ":" +i);
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		SubThread1 st1 = new SubThread1();	
		st1.setName("子线程1");
		st1.setPriority(Thread.MAX_PRIORITY);
		st1.start();
		Thread.currentThread().setName("=====主线程1");
		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority() + ":" +i);
//			if(i % 10 == 0){
//				Thread.currentThread().yield();
//			}
			
//			if(i == 20){
//				try {
//					st1.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(st1.isAlive());
	}
}
