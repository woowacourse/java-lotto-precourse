package baeminHW3;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class mainClass {
	
	public enum Rank {
	    FIRST(6, 2_000_000_000),
	    SECOND(5, 30_000_000), 
	    THIRD(5, 1_500_000),
	    FOURTH(4, 50_000),
	    FIFTH(3, 5_000),
	    MISS(0, 0);

	    private static final int WINNING_MIN_COUNT = 3;

	    private int countOfMatch;
	    private int winningMoney;

	    private Rank(int countOfMatch, int winningMoney) {
	        this.countOfMatch = countOfMatch;
	        this.winningMoney = winningMoney;
	    }

	    public int getCountOfMatch() {
	        return countOfMatch;
	    }

	    public int getWinningMoney() {
	        return winningMoney;
	    }

	    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
	        if (countOfMatch < WINNING_MIN_COUNT) {
	            return MISS;
	        }

	        if (SECOND.matchCount(countOfMatch) && matchBonus) {
	            return SECOND;
	        }

	        for (Rank rank : values()) {
	            if (rank.matchCount(countOfMatch)&& rank != SECOND) {
	                return rank;
	            }
	        }

	        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
	    }

	    private boolean matchCount(int countOfMatch) {
	        return this.countOfMatch == countOfMatch;
	    }
	}
	
	public static void main(String[] args) {
		int buyMoney = getMoney();
		List<Lotto> lotto = buyLotto(buyMoney);
		printLotto(lotto);
	}
	
	public static int getMoney() {
		Scanner scan = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요.");
		int money = scan.nextInt();
		return money;
	}
	
	public static List<Integer> getLottoNumber(int count){
		List <Integer> number = new ArrayList <Integer>();
		Random generator = new Random();
		for(int i=0; i<count; i++) {
			number.add(new Integer(generator.nextInt(45)+1));
		}
		return number;
	}
	
	public static List<Lotto> buyLotto(int money){
		List<Lotto> lotto = new ArrayList<Lotto>();
		for(int i=0; i<money/1000; i++) {
			lotto.add(new Lotto(getLottoNumber(6)));
		}
		
		System.out.println("\n" + money/1000 + "개를 구매했습니다");
		return lotto;
	}
	
	public static void printLotto(List<Lotto> lotto) {
		for(int i=0; i<lotto.size(); i++) {
			lotto.get(i).printNumber();
		}
	}
	
	public static List<Integer> getWinNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		List<Integer> number = new ArrayList<Integer>();
		String temp = scan.nextLine();
		String[] numberByString = temp.split(",");
		for(int i=0; i<numberByString.length; i++) {
			number.add(Integer.valueOf(numberByString[i]));
		}
		return number;
	}
	
	public static int getBonusNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonus = scan.nextInt();
		return bonus;
	}
}
