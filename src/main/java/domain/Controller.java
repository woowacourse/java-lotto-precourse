package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 게임의 흐름을 컨트럴하는 마스터 객체
 */
public class Controller {
    private static final int MINIMUM_MONEY = 1000;      //로또 구입할수 있는 최소 가격
    private static final int MAXIMUM_MONEY = 100000;    //로또 구입할수 있는 최대 가격
    Scanner scanner = new Scanner(System.in);
    private static final int LOTTOS_NUMBER = 7;         //로또의 번호 갯수
    private static final int LOTTOS_LIMIT_NUMBER = 45;  //로또번호 한도 숫자

    private int money;
    private List<Lotto> lottos = new ArrayList<>();

    public void askHowMany() {
        String inputValue;

        do {
            System.out.println("1000원 이상, 10만원 이하 구입금액을 입력해 주세요.");
            inputValue = scanner.nextLine();
        } while (!isNumber(inputValue));
    }

    /* Overflow가 일어나는지, 숫자인지 체크하는 메소드 */
    public boolean isNumber(String inputValue) {
        try {
            money = Integer.parseInt(inputValue);

            return checkInputRight();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkInputRight() {
        return ((money >= MINIMUM_MONEY) && (money <= MAXIMUM_MONEY));
    }

    public void buyLotto() {
        int lottoAmount = calculateLottoAmount();

        System.out.printf("%d개를 구매했습니다.\n", lottoAmount);

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(makeRandomNumber()));
        }
    }

    /* 받은 돈으로 살수 있는 로또 갯수와 거스름돈 반환 */
    public int calculateLottoAmount() {
        if ((money % MINIMUM_MONEY) != 0) {
            System.out.printf("%d 남았습니다.\n", money % MINIMUM_MONEY);
        }

        return money / MINIMUM_MONEY;
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        int randomNum;

        do {
            randomNum = (int) (Math.random() * LOTTOS_LIMIT_NUMBER) + 1;
        } while (checkNumberToList(randomNum, randomNumberList));

        return randomNumberList;
    }

    /* 생성된 숫자가 중복되는지 확인 및 7개 만들어졌는지 확인 하는 메소드 */
    public boolean checkNumberToList(int randomNum, List<Integer> randomNumberList) {
        if (randomNumberList.size() == LOTTOS_NUMBER) {
            return false;
        }

        if (!randomNumberList.contains(randomNum)) {
            randomNumberList.add(randomNum);
        }
        return true;
    }

    /* 만들어진 로또들의 숫자 전부 보여주기 */
    public void showLottosNumber() {
        for (Lotto each : lottos) {
            System.out.println(each.getNumbersList().toString());
        }
    }
}
