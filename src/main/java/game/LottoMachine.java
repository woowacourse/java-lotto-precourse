package game;

import domain.Lotto;

import java.util.*;

import static game.Buyer.NUMBER_PER_LOTTO;
import static game.Buyer.LOTTO_NUMBER_BOUNDARY;

/**
 * 당첨 번호와 보너스 번호를 만드는 객체
 */
public class LottoMachine {
    private static final int MIN_BOUNDARY = 1;
    private static int bonusNumInput;            // 입력받은 보너스 숫자

    /*
     * 당첨 번호가 조건에 맞으면 발급
     */
    public Lotto makeWinningLotto() {
        String input;
        Scanner scanner = new Scanner(System.in);
        List<Integer> list;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        do {
            input = scanner.nextLine();
            list = inspector(input);
        } while (!inspectLottoCondition(list));
        return new Lotto(list);
    }

    /*
     * 당첨번호 입력에서의 문자, 공백 예외 처리
     * (에러를 catch할 경우 아무것도 하지 않고 list를 리턴함으로써
     *          makeWinningLotto()에서 반복문을 돌도록 함)
     */
    public List<Integer> inspector(String input) {
        List<Integer> sample = new ArrayList<>();
        try {
            sample = translator(input);
        } catch (NumberFormatException e) {

        } catch (InputMismatchException e) {

        }
        return sample;
    }

    /*
     * 입력받은 문장을 번호로 변환하여 리스트에 담음
     */
    public List<Integer> translator (String input) {
        String[] num = input.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            list.add(Integer.parseInt(num[i]));
        }
        return list;
    }

    /*
     * 당첨번호의 중복, 입력 개수, 입력 범위 처리
     */
    public boolean inspectLottoCondition(List<Integer> list) {
        boolean satisfy, sign;
        satisfy = (new HashSet(list).size() == NUMBER_PER_LOTTO) ? true : false;
        for (int value : list) {
            sign = (value >= MIN_BOUNDARY && value <= LOTTO_NUMBER_BOUNDARY) ? true : false;
            satisfy = satisfy && sign;
        }
        if (satisfy == false) {
            System.out.println("로또 규칙에 맞게 당첨 번호를 다시 입력해주세요.");
        }
        return satisfy;
    }

    /*
     * 보너스 숫자 입력하고 조건을 만족할 시 발급
     */
    public int makeBonusNum(Lotto winnerLotto) {
        boolean satisfy;
        System.out.println("보너스 볼을 입력해 주세요.");
        do {
            satisfy = inspectInputBonusNum();
            satisfy = satisfy && inspectBoundaryBonusNum(bonusNumInput);
            satisfy = satisfy && inspectDuplicateBonusNum(winnerLotto, bonusNumInput);
        } while (!satisfy);
        System.out.println();
        return bonusNumInput;
    }

    /*
     * 보너스 숫자 중복 처리
     */
    public boolean inspectDuplicateBonusNum(Lotto winnerLotto, int bonusNum) {
        HashSet<Integer> set = new HashSet(winnerLotto.getNumbers());
        boolean satisfier = true;
        set.add(bonusNum);
        if (set.size() == winnerLotto.getNumbers().size()) {
            satisfier = false;
        }
        printReInputBonusNum(satisfier);
        return satisfier;
    }
}
