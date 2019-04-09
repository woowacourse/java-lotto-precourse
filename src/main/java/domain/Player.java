package domain;

import domain.interfaces.InputValidator;
import domain.interfaces.NumberGenerator;
import domain.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final static int LOTTO_BOUND_SIZE = 46;
    private NumberGenerator numberGenerator;
    private InputValidator inputValidator;
    private UserInterface ui;

    private List<Lotto> lottos;
    public static WinningLotto winningLotto;

    private int validLottoCount;
    private String[] validWinningLotto;
    private int validBonusNo;
    public static int validAmount;

    public static int count_FIFTH;
    public static int count_FOURTH;
    public static int count_THIRD;
    public static int count_SECOND;
    public static int count_FIRST;
    public static int profitRate;


    public Player(NumberGenerator numberGenerator, InputValidator inputValidator, UserInterface ui) {
        this.numberGenerator = numberGenerator;
        this.inputValidator = inputValidator;
        this.ui = ui;
    }

    public void playLotto() {
        checkPurchaseAmountValidity();
        generateLottoList();
        ui.printLottoList(lottos,validLottoCount);

        generateWinningLotto();
        calculateStatistics();
        ui.printStatistics();
    }

    private void checkPurchaseAmountValidity() {
        int amount = ui.promptPurchaseAmount();
        while (!inputValidator.isValidPurchaseAmount(amount)) {
            ui.notifyInvalidPurchaseAmount();
            amount = ui.promptPurchaseAmount();
        }
        validAmount = amount;
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
        String[] winningLotto = ui.promptWinningLottoNumber();
        int len = winningLotto.length;
        while (!inputValidator.isValidWinningLotto(len, winningLotto)) {
            ui.notifyInvalidWinningLotto();
            winningLotto = ui.promptWinningLottoNumber();
        }
        validWinningLotto = winningLotto;
    }

    private void checkBonusNumberValidity() {
        int bonusNo = ui.promptBonusNumber();
        while (!inputValidator.isValidBonusNumber(bonusNo)) {
            ui.notifyInvalidBonusNumber();
            bonusNo = ui.promptBonusNumber();
        }
        validBonusNo = bonusNo;
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
        for (Lotto userLotto : lottos) {
            calculateHowManyWins(userLotto);
        }
        int totalWinningMoney = count_FIFTH * Rank.FIFTH.getWinningMoney()
                + count_FOURTH * Rank.FOURTH.getWinningMoney()
                + count_THIRD * Rank.THIRD.getWinningMoney()
                + count_SECOND * Rank.SECOND.getWinningMoney()
                + count_FIRST * Rank.FIRST.getWinningMoney();
        profitRate = totalWinningMoney / Player.validAmount;
    }

    public int calculateHowManyWins(Lotto userLotto) {
        if (winningLotto.match(userLotto) == Rank.MISS) {
            return 0;
        }
        if (winningLotto.match(userLotto) == Rank.FIRST) {
            return ++count_FIRST;
        }
        if (winningLotto.match(userLotto) == Rank.SECOND) {
            return ++count_SECOND;
        }
        if (winningLotto.match(userLotto) == Rank.THIRD) {
            return ++count_THIRD;
        }
        if (winningLotto.match(userLotto) == Rank.FOURTH) {
            return ++count_FOURTH;
        }
        if (winningLotto.match(userLotto) == Rank.FIFTH) {
            return ++count_FIFTH;
        }
        return 0;
    }


}
