package domain;
import java.util.Scanner;

public class LottoGame {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		int price = getPrice();
		int lottoCount = price/1000;
		System.out.println(lottoCount + "개를 구매했습니다.");
		
	}
	
	public static int getPrice() {
		System.out.println("구입 금액을 입력해 주세요.");
		int price = scan.nextInt();
		return price;
	}

}
