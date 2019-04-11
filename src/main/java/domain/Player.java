package domain;

import domain.interfaces.InputValidator;
import domain.interfaces.NumberGenerator;
import domain.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Player {


    private NumberGenerator numberGenerator;
    private InputValidator inputValidator;
    private UserInterface ui;

    private List<Lotto> lottos;
    public static WinningLotto winningLotto;

    private long validLottoCount;
    private String[] validWinningLotto;
    private int validBonusNo;
    public long validAmount;

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
        printStatistics();
    }

    private void checkPurchaseAmountValidity() {
        try {
            long amount = ui.promptPurchaseAmount();
            while (!inputValidator.isValidPurchaseAmount(amount)) {
                amount = ui.promptPurchaseAmount();
            }
            validAmount = amount;
        } catch (InputMismatchException e) {
            ui.notifyInvalidInput();
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
            ui.notifyInvalidInput();
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
            ui.notifyInvalidInput();
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

    public void printStatistics() {
        StatisticsCalculator calculator = new StatisticsCalculator();
        calculator.calculateStatistics(lottos,winningLotto,validAmount);
        int fifthToFirst = 3;
        for (Rank r : calculator.rankArray) {
            ui.printStatistics(r, calculator.countWins[fifthToFirst++]);
        }
        ui.printProfitRate();
    }

}
