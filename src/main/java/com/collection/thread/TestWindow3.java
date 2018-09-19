package com.collection.thread;

//模拟火车站窗口卖票,开启三个窗口售票,总票数为100张
//存在线程安全问题--->使用同步代码块处理。
class Window3 extends Thread {
	static int ticket = 100;
	static Object obj = new Object();

	public void run() {
		while (true) {
			//synchronized (obj) { 此时的this 为 w1,w2,w3
			/*synchronized (obj) {
				if (ticket > 0) {
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);
				}
			}*/
			//show();
		}
	}
	
	public synchronized void show(){//默认使用this作为锁
		if (ticket > 0) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "售票,票号为" + ticket--);
		}
	}
}

public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w1 = new Window3();
		Window3 w2 = new Window3();
		Window3 w3 = new Window3();
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");

		w1.start();
		w2.start();
		w3.start();
	}
}
