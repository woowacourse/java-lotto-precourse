package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(AMOUNT_QUESTION);
		
		int inputMoney = in.read();
		
		int numberOfLottoToBuy = numberOfLotto(inputMoney);
	}
	
	private static int numberOfLotto(int inputMoney) {
		return inputMoney / 1000;
	}
}
