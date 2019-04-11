package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 출력 메시지와 관련된 기능 객체
 */
public class MessageManager {
    private Scanner scanner;
    private List<Integer> lastLotto;

    public MessageManager() {
        scanner = new Scanner(System.in);
        lastLotto = new ArrayList<>();
    }

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
            Controller.money = Integer.parseInt(inputValue);

            return checkInputRangeRight();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkInputRangeRight() {
        return ((Controller.money >= Controller.MINIMUM_MONEY)
                && (Controller.money <= Controller.MAXIMUM_MONEY));
    }

    public void askLastWinningLotto() {
        String[] winningNumbers;
        String inputValue;

        do {
            lastLotto.clear();
            System.out.println("지난 주 당첨 번호 6개를 중복없이 입력해 주세요.");
            winningNumbers = scanner.nextLine().split(",");
            System.out.println("보너스 볼을 입력해 주세요.");
            inputValue = scanner.nextLine();
        } while (!makeLastLotto(winningNumbers, inputValue));
    }

    /* 지난주 당첨 번호와 보너스 볼을 lastLotto에 add 하는 기능 */
    public boolean makeLastLotto(String[] winningNumbers, String inputValue) {
        try {
            lastLotto = Arrays.stream(winningNumbers).map(Integer::parseInt)
                    .collect(Collectors.toList());

            lastLotto.add(Integer.parseInt(inputValue));

            return checkNumberRight();
        } catch (NumberFormatException e) {                                     // 숫자가 아닌 경우에 발생 할수 있는 예외처리
            return false;
        }
    }

    public boolean checkNumberRight() {
        if (lastLotto.size() != Controller.LOTTOS_NUMBER) {                          //숫자가 7개가 맞는지 확인
            return false;
        }

        if (lastLotto.stream().filter(num -> (num <= Controller.LOTTOS_LIMIT_NUMBER && num >= 1))
                .count() != Controller.LOTTOS_NUMBER) {                               // 1-45 사이 값인지 확인
            return false;
        }

        return (lastLotto.stream().distinct().count() == lastLotto.size());     //중복되는 것이 있는지 확인
    }

    public List<Integer> getLastLottoList() {
        return lastLotto;
    }
}
