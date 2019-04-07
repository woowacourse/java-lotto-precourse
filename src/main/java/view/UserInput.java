package view;

import controller.LottoController;
import domain.Lotto;
import domain.Rank;


import java.util.*;

public class UserInput {

    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;

    private Scanner sc = new Scanner(System.in);
    private LottoController lottoController;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = sc.nextLine();
        System.out.println();

        int money = makeNumber(userInput);
        testValidMoney(money);

        this.lottoController = new LottoController(money);
    }

    public void displayLotto() {
        List<Lotto> lottoList = lottoController.getLottoList();

        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public void inputWinningLotto() {
        System.out.println("지난 주 당첨 번호을 입력해 주세요.");
        String userInput = sc.nextLine();
        String[] inputStr = userInput.split(",");

        List<Integer> numberList = makeWinningNumbers(inputStr);
        int bonusNo = inputBonusLottoNo(numberList);

        Lotto winningLotto = new Lotto(numberList);

        lottoController.setWinningLotto(winningLotto, bonusNo);
    }

    public void displayRank() {
        for (Rank rank : lottoController.getRankList()) {
            System.out.println(rank);
        }
    }

    private List<Integer> makeWinningNumbers(String[] inputStr) {
        Set<Integer> inputNoSet = new TreeSet<>();

        for (int i = 0; i < inputStr.length; i++) {
            int lottoNo = makeLottoNo(inputStr[i]);
            inputNoSet.add(lottoNo);
        }
        testValidLottoSize(inputNoSet);

        return new ArrayList<>(inputNoSet);
    }

    private int inputBonusLottoNo(List<Integer> lottoNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
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
            throw new NumberFormatException("숫자가 아닙니다.");
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
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + "보다 큰 금액을 입력해주세요.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + "의 배수 금액을 입력해주세요.");
        }
    }

    private void testValidLottoSize(Set<Integer> numberSet) {
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또번호는 중복 없이 " + LOTTO_SIZE + "자리 입니다.");
        }
    }

    private void testValidLottoBounds(int num) {
        if (  num < 0 || num > LOTTO_BOUND ) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_BOUND + "이하 양수입니다.");
        }
    }

    private void testValidBonusLottoNo(int bonusNo, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNo)) {
            throw new IllegalArgumentException(bonusNo + "는 유효하지 않은 값입니다.");
        }
    }
}
