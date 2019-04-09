package view;

import controller.LottoController;
import domain.Lotto;
import domain.Rank;


import java.util.*;

/**
 * 사용자와 직접적으로 관련된 클래스
 */
public class UserView{
    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final int MONEY_MAX = 100000;

    private static final String MONEY_BOUND_EXCEPTION = "보다 큰 금액을 입력해주세요 (10만원 이하).";
    private static final String MONEY_DIVISION_EXCEPTION = "의 배수 금액을 입력해주세요.";
    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 " + LOTTO_SIZE + "자리 입니다.";
    private static final String LOTTO_BOUND_EXCEPTION = "로또 번호는 "+ LOTTO_BOUND +"이하 양수입니다.";
    private static final String LOTTO_BONUS_EXCEPTION = "로또 번호와 중복입니다.";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자가 아닙니다.";
    private static final String LOTTO_DELIMITER = ",";

    private static final String MONEY_INPUT_VIEW = "구입금액을 입력해 주세요.";
    private static final String LOTTO_INPUT_VIEW = "지난 주 당첨 번호을 입력해 주세요.";
    private static final String BONUS_INPUT_VIEW = "보너스 볼을 입력해 주세요.";
    private static final String BUY_VIEW = "개를 구매했습니다.";
    private static final String RESULT_VIEW = "당첨 통계\n" + "---------";
    private static final String YIELD_VIEW_FRONT = "총 수익률은 ";
    private static final String YIELD_VIEW_BACK  = "입니다.";
    private static final String RANK_VIEW_FRONT = "개 일치 (";
    private static final String RANK_VIEW_SECOND = "개 일치, 보너스 볼 일치(";
    private static final String RANK_VIEW_MIDDLE = "원)- ";
    private static final String RANK_VIEW_BACK = "개";

    private Scanner sc = new Scanner(System.in);
    private LottoController lottoController;

    public void inputMoney() {
        System.out.println(MONEY_INPUT_VIEW);
        String userInput = sc.nextLine();
        System.out.println();

        int money = makeNumber(userInput);
        testValidMoney(money);

        this.lottoController = new LottoController(money);
    }

    public void displayLotto() {
        List<Lotto> lottoList = lottoController.getLottoList();

        System.out.println(lottoList.size() + BUY_VIEW);
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void inputWinningLotto() {
        System.out.println(LOTTO_INPUT_VIEW);
        String userInput = sc.nextLine();
        String[] inputStr = userInput.split(LOTTO_DELIMITER);

        List<Integer> numberList = makeWinningNumbers(inputStr);
        int bonusNo = inputBonusLottoNo(numberList);

        Lotto winningLotto = new Lotto(numberList);

        lottoController.setWinningLotto(winningLotto, bonusNo);
    }

    public void displayStats() {
        Rank[] displayOrder = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        Map<Rank, Integer> rankResult = lottoController.getRankMap();

        System.out.println(RESULT_VIEW);

        for (Rank rank : displayOrder) {
            System.out.println(makeRankString(rank, rankResult.getOrDefault(rank, 0)));
        }

        System.out.println(YIELD_VIEW_FRONT + lottoController.getLottoYield() + YIELD_VIEW_BACK);
    }

    private String makeRankString(Rank rank, int rankCount) {
        if (rank == Rank.SECOND) {
            return String.format("%d%s%d%s%d%s", rank.getCountOfMatch(), RANK_VIEW_SECOND,
                    rank.getWinningMoney(), RANK_VIEW_MIDDLE, rankCount, RANK_VIEW_BACK);
        }

        return String.format("%d%s%d%s%d%s", rank.getCountOfMatch(), RANK_VIEW_FRONT,
                rank.getWinningMoney(), RANK_VIEW_MIDDLE, rankCount, RANK_VIEW_BACK);
    }

    private List<Integer> makeWinningNumbers(String[] inputStr) {
        Set<Integer> inputNoSet = new TreeSet<>();

        for (String str : inputStr) {
            int lottoNo = makeLottoNo(str);
            inputNoSet.add(lottoNo);
        }
        testValidLottoSize(inputNoSet);

        return new ArrayList<>(inputNoSet);
    }

    private int inputBonusLottoNo(List<Integer> lottoNumbers) {
        System.out.println(BONUS_INPUT_VIEW);
        String userInput = sc.nextLine();
        System.out.println();

        int bonusNo = makeLottoNo(userInput);
        testValidBonusLottoNo(bonusNo, lottoNumbers);

        return bonusNo;
    }

    private int makeNumber(String str) {
        int num;

        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION);
        }
        return num;
    }

    private int makeLottoNo(String str) {
        int number;

        number = makeNumber(str);
        testValidLottoBounds(number);

        return  number;
    }

    private void testValidMoney(int money) {
        if ((money < LOTTO_PRICE) || (money > MONEY_MAX)) {
            throw new IllegalArgumentException(LOTTO_PRICE + MONEY_BOUND_EXCEPTION);
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + MONEY_DIVISION_EXCEPTION);
        }
    }

    private void testValidLottoSize(Set<Integer> numberSet) {
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
    }

    private void testValidLottoBounds(int num) {
        if (  (num < 0) || (num > LOTTO_BOUND) ) {
            throw new IllegalArgumentException(LOTTO_BOUND_EXCEPTION);
        }
    }

    private void testValidBonusLottoNo(int bonusNo, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNo)) {
            throw new IllegalArgumentException(LOTTO_BONUS_EXCEPTION);
        }
    }
}
