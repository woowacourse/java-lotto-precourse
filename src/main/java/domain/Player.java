package domain;

import domain.interfaces.InputValidator;
import domain.interfaces.NumberGenerator;
import domain.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Player {

    private static final int RANK_ARRAY_SIZE = 8;

    private NumberGenerator numberGenerator;
    private InputValidator inputValidator;
    private UserInterface ui;

    private List<Lotto> lottos;
    public static WinningLotto winningLotto;

    public Rank[] rankArray = new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
    public static int[] countWins;
    public static double profitRate;

    private int validLottoCount;
    private String[] validWinningLotto;
    private int validBonusNo;
    public int validAmount;

    public Player(NumberGenerator numberGenerator, InputValidator inputValidator, UserInterface ui) {
        this.numberGenerator = numberGenerator;
        this.inputValidator = inputValidator;
        this.ui = ui;
    }

    public void playLotto() {
        checkPurchaseAmountValidity();
        generateLottoList();
        ui.printLottoList(lottos, validLottoCount);

        generateWinningLotto();
        calculateStatistics();
        printStatistics();
    }

    private void checkPurchaseAmountValidity() {
        try {
            int amount = ui.promptPurchaseAmount();
            while (!inputValidator.isValidPurchaseAmount(amount)) {
                amount = ui.promptPurchaseAmount();
            }
            validAmount = amount;
        } catch (InputMismatchException e) {
            ui.notifyInvalidPurchaseAmount();
            checkPurchaseAmountValidity();
        }
    }

    public void generateLottoList() {
        validLottoCount = validAmount / inputValidator.PRICE_PER_LOTTO;
        LottoGenerator generator = new LottoGenerator(numberGenerator);
        lottos = new ArrayList<>();
        for (int i = 0; i < validLottoCount; ++i) {
            lottos.add(generator.generateLotto());
        }
    }

    private void checkWinningLottoValidity() {
        try {
            String[] winningLotto = ui.promptWinningLottoNumber();
            while (!inputValidator.isValidWinningLotto(winningLotto.length, winningLotto)) {
                winningLotto = ui.promptWinningLottoNumber();
            }
            validWinningLotto = winningLotto;
        } catch (NumberFormatException e) {
            ui.notifyInvalidWinningLotto();
            checkWinningLottoValidity();
        }
    }

    private void checkBonusNumberValidity() {
        try {
            int bonusNo = ui.promptBonusNumber();
            while (!inputValidator.isValidBonusNumber(bonusNo)) {
                bonusNo = ui.promptBonusNumber();
            }
            validBonusNo = bonusNo;
        } catch (InputMismatchException e) {
            ui.notifyInvalidBonusNumber();
            checkBonusNumberValidity();
        }

    }

    public void generateWinningLotto() {
        checkWinningLottoValidity();
        checkBonusNumberValidity();
        List<Integer> numbers = new ArrayList<>();
        for (String s : validWinningLotto) {
            int num = Integer.parseInt(s);
            numbers.add(num);
        }
        winningLotto = new WinningLotto(new Lotto(numbers), validBonusNo);
    }

    public void calculateStatistics() {
        long totalWinningMoney = 0;
        int fifthToFirst = 3;
        countWins = new int[RANK_ARRAY_SIZE];  /*5등은 3개를 맞추었으니 3번 인덱스에 wins를 기록 -> 1등은 7번 인덱스*/
        for (Lotto userLotto : lottos) {
            calculateHowManyWins(userLotto);
        }
        for (Rank r : rankArray) {
            totalWinningMoney += countWins[fifthToFirst++] * r.getWinningMoney();
        }
        profitRate = ((double) totalWinningMoney / validAmount) * 100;
    }

    public void calculateHowManyWins(Lotto userLotto) {
        for (Rank r : rankArray) {
            fillCountWins(r, userLotto);
        }
    }

    public void fillCountWins(Rank r, Lotto userLotto) {
        if (winningLotto.match(userLotto) == r) {
            countWins[r.getCountOfMatch()]++;
            return;
        }
    }

    public void printStatistics() {
        int fifthToFirst = 3;
        for (Rank r : rankArray) {
            ui.printStatistics(r, countWins[fifthToFirst++]);
        }
        ui.printProfitRate();
    }

}
