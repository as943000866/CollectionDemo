package com.collection.thread;


/*
 * 创建两个子线程,让其中一个输出1-100之间的偶数,另一个输出1-100之间的奇数	
 */
class SubThread3 extends Thread{
	@Override
	public void run() {
		for (int i = 1; i < 100; i++) {
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName() +":"+i);
			}
		}
	}
}


class SubThread4 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i % 2 !=0){
				System.out.println(Thread.currentThread().getName() +":"+i);
			}
		}
	}
}

public class TestThread2 {
	public static void main(String[] args) {
		SubThread3 st1 = new SubThread3();
		SubThread4 st2 = new SubThread4();
//		st1.start();
//		st2.start();
		
		//使用匿名类创建Thread
		new Thread(){
			public void run() {
				for (int i = 1; i < 100; i++) {
					if(i % 2 == 0){
						System.out.println(Thread.currentThread().getName() +":"+i);
					}
				}
			}
			
		}.start();
		
		new Thread(){
			public void run() {
				for (int i = 1; i < 100; i++) {
					if(i % 2 != 0){
						System.out.println(Thread.currentThread().getName() +":"+i);
					}
				}
			}
			
		}.start();
	}
}
