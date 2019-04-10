package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

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

	private final List<Integer> numbers; // 중복된 숫자가 있으면 안되니 set이 더 좋을 것 같은데, 혹시 list의 더 좋은 점이 있는 지 궁금합니다.

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	// 추가 기능 구현

	private static int inputInt(String massage) throws NumberFormatException, IOException {
		System.out.println(massage);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ret = Integer.parseInt(br.readLine());
		return ret;
	}

	private static List<Integer> inputIntList(String massage) throws NumberFormatException, IOException {
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(massage);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		return list;
	}

	private static void inputCost() {
		try {
			numLotto = inputInt("구입금액을 입력해주세요. ") / PRICE;
		} catch (Exception e) {
			System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
			inputCost();
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

	private static int isValidIntForLotto(int num) {
		return ((num > 0) && (num <= MAX_BALL_NUM)) ? 1 : 0;
	}

	private static boolean isValidLengthForLotto(List<Integer> list) {
		Set set = new LinkedHashSet<Integer>(list);
		return (set.size() == NUM_BALL);
	}

	private static boolean isValidIntListForLotto(List<Integer> list) {
		if (!isValidLengthForLotto(list))
			return false;
		int bool = 1;
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			bool *= isValidIntForLotto(it.next());
		}
		return (bool == 1);
	}

	private static List<Integer> recurInputIntList() {
		List<Integer> list = new ArrayList<Integer>();
		try {
			list = inputIntList("\n지난 주 당첨 번호를 입력해주세요. (,로 구분한 6자리 숫자)");
		} catch (Exception e) {
			System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
			recurInputIntList();
		}
		return list;
	}

	private static Lotto customLotto() {
		List<Integer> list = recurInputIntList();
		if (!isValidIntListForLotto(list)) {
			System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
			customLotto();
		}
		return new Lotto(list);
	}

	private static int recurInputBonusBall() {
		int ball = 0;
		try {
			ball = inputInt("\n보너스 볼을 입력해 주세요.");
		} catch (Exception e) {
			System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
			recurInputBonusBall();
		}
		return ball;
	}

	private static int inputBonusBall() {
		int ball = recurInputBonusBall();
		if (isValidIntForLotto(ball) == 0) {
			System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
			inputBonusBall();
		}
		return ball;
	}

	private static void inputWinningLotto() {
		Lotto lotto = customLotto();
		int bonusNo = inputBonusBall();
		winningLotto = new WinningLotto(lotto, bonusNo);
	}

	public static void main(String[] args) { // 객체로 불러 실행하고자 한다면 shell()로 대체한다.
		inputCost();
		generateMyLottos();
		inputWinningLotto();

	}

	boolean contains(int num) {
		return numbers.contains(num);
	}

	int numOfSharedNumber(Lotto compLotto) {
		int ret = 0;
		Iterator<Integer> it = numbers.iterator();
		while (it.hasNext()) {
			ret += compLotto.contains(it.next()) ? 1 : 0;
		}
		return ret;
	}
}
