package com.jeet.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JuiceFactory extends Thread {

	private static  List<String> synchronizedList = Collections.synchronizedList(new ArrayList<String>());

	public static  synchronized String manufactureBottleCap() {
		return "juiceCap";
	}

	public static synchronized String manufactureJuiceBottle() {
		return "juiceBottle";
	}

	public static synchronized String manufactureJuice() {
		return "juice";
	}

	public static void main(String a[]) {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronizedList.add(manufactureBottleCap());
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronizedList.add(manufactureJuiceBottle());
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronizedList.add(manufactureJuice());
			}
		});

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (synchronizedList) {
            Iterator<String> iterator = synchronizedList.iterator();
            while (iterator.hasNext()) {
                System.out.println("Synchronized Array List Items: " + iterator.next());
            }
        }  

	}
}
