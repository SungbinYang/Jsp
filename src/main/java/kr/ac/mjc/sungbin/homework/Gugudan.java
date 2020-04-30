package kr.ac.mjc.sungbin.homework;

public class Gugudan {
	
	public synchronized void printDan(int n) {
		System.out.format("\n%d Dan (%s)\n", n,
				Thread.currentThread().getName());
		for (int i = 1; i <= 9; i++) {
			System.out.format("%d * %d = %d\n", n, i, n * i);
			try {
				Thread.sleep(100); // 100ms(0.1초) 동안 쉰다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
