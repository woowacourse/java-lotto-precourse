package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
	private final static int PRICE = 1000;
	private final static int MAX_BALL_NUM = 45;
	private final static int NUM_BALL = 6;
	private static int numLotto;
	private static List<Lotto> myLottos = new ArrayList<>();
	private static WinningLotto winningLotto;
	private static HashMap<Rank, Integer> result = new HashMap<Rank, Integer>(Rank.values().length);

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	// 추가 기능 구현
	private static void inputCost() throws NumberFormatException, IOException {
		System.out.println("구입금액을 입력해주세요. ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ret = Integer.parseInt(br.readLine());
		numLotto = ret / PRICE;
	}

	private static void recurInputCost() {
		try {
			inputCost();
		} catch (Exception e) {
			System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
			recurInputCost();
		}
	}

	private static List<Integer> generateNumbers() {
		Set<Integer> set = new LinkedHashSet<>(NUM_BALL);
		while (set.size() < NUM_BALL) {
			set.add((int) (Math.random() * MAX_BALL_NUM) + 1);
		}
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		return list;
	}
	
	private static void generateMyLottos() {
		System.out.println("\n" + numLotto + "개를 구매하였습니다.");
		for (int i = 0; i < numLotto; i++) {
			List<Integer> numbers = generateNumbers();
			myLottos.add(new Lotto(numbers));
			System.out.println(numbers.toString());
		}
	}

	public static void main(String[] args) { // 객체로 불러 실행해야한다면 shell()로 대체한다.
		recurInputCost();
		generateMyLottos();

	}
}
