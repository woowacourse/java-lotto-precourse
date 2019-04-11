package ui;

import domain.Game;
import validation.BonusNoValidation;
import validation.LottoValidation;
import validation.MoneyValidation;
import validation.Validation;

import java.util.List;
import java.util.Scanner;

/**
 * GameUI 객체는 로또 게임의 사용자 인터페이스를 담당한다.
 *
 * @author 조남균
 */
public class GameUI {
	private Game game;

	public GameUI() {
		game = new Game();
	}

	public void run() {
		try(Scanner sc = new Scanner(System.in)) {
			game.setMoney(askMoney(sc));
			System.out.println(game.getLotto());

			List<Integer> numbers = askNumbers(sc);
			game.setWinningLotto(numbers, askBonusNo(sc, numbers));
			System.out.println(game.getResult());
		}
	}

	private int askMoney(Scanner sc) {
		String message = "구입금액을 입력해 주세요.";
		Validation<Integer> validation = new MoneyValidation();

		Input<Integer> input = new Input<>(sc, message, validation);

		return input.ask();
	}

	private List<Integer> askNumbers(Scanner sc) {
		String message = "지난 주 당첨번호를 입력해 주세요.";
		Validation<List<Integer>> validation = new LottoValidation();

		Input<List<Integer>> input = new Input<>(sc, message, validation);

		return input.ask();
	}

	private int askBonusNo(Scanner sc, List<Integer> numbers) {
		String message = "보너스 볼을 입력해 주세요";
		Validation<Integer> validation = new BonusNoValidation(numbers);

		Input<Integer> input = new Input<>(sc, message, validation);

		return input.ask();
	}
}
