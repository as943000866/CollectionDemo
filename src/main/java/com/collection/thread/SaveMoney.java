package com.collection.thread;

//银行有一个账号。
//有两个储户分别向同一个账户存3000元,每次存1000,存3次。每次存完打印账户余额。
class Save implements Runnable {

	int money = 0;

	public void run() {
		for (int i = 0; i < 3; i++) {
			synchronized (this) {
				try {
					Thread.currentThread().sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				money = money + 1000;
				System.out.println(Thread.currentThread().getName() + "往账户存入:" + 1000 + "==当前余额为" + money);
			}
		}

	}

}

public class SaveMoney {
	public static void main(String[] args) {
		Save save = new Save();
		Thread s1 = new Thread(save);
		Thread s2 = new Thread(save);

		s1.setName("张三");
		s2.setName("李四");

		s1.start();
		s2.start();
	}
}
