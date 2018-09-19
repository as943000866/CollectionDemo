package com.collection.thread;

/*
 * 使用实现Runnable接口的方式,售票
 * 
 * 此程序存在线程的安全问题:打印车票时,会出现重票、错票
 */
//模拟火车站窗口卖票,开启三个窗口售票,总票数为100张
class Window4 implements Runnable {

	int ticket = 100; //共享变量
	Object obj = new Object();
	public void run() {
		while (true) {
//			synchronized (obj) {
//			synchronized (this) {this表示当前对象,本题中为w1
//				if (ticket > 0) {
//					try {
//						Thread.currentThread().sleep(10);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);
//				}
//			}
			
			show();
		}
	}
	
	public  synchronized void show(){//this表示当前对象,本题中为w1
		if (ticket > 0) {
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);
		}
	}

}

public class TestWindow4 {
	public static void main(String[] args) {
		Window4 w1 = new Window4();
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w1);
		Thread t3 = new Thread(w1);

		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");

		t1.start();
		t2.start();
		t3.start();
	}
}
