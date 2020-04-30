package kr.ac.mjc.sungbin.homework;

public class GugudanTest {
	
	public static void main(String[] args) {

		Gugudan gugudan = new Gugudan();
		for (int n = 2; n <= 9; n++) {
			final int dan = n;
			new Thread(() -> {
				gugudan.printDan(dan);
			}).start();
		}
	}

}
