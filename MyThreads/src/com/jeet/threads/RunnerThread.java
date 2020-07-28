package com.jeet.threads;

class TestThread implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
		System.out.println("Thread is running"+i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		}
	}
}

public class RunnerThread {
	public static void main(String[] args) {
		TestThread t1 = new TestThread();
		t1.run();
		
	}
}
