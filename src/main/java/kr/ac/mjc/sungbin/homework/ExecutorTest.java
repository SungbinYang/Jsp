package kr.ac.mjc.sungbin.homework;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class ExecutorTest {
	
	public static void main(String[] args) {
		// worker threads 가 5개인 스레드 풀 생성
		Executor threadPool = Executors.newFixedThreadPool(5);
		
		Gugudan gugudan = new Gugudan();
		for (int n = 2; n <= 9; n++) {
			final int dan = n;
			threadPool.execute(() -> {
				gugudan.printDan(dan);
			});
		}
	}

}
