package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private static final String PURCHASE_GUIDE = "구입금액을 입력해주세요.";
    private static final String SHORTAGE_WARNING = "구입금액이 부족합니다. ";
    private static final String UNIT_WARNING = "1000원 단위로 구입하실 수 있습니다.";
    private static final String QUANTITY_GUIDE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_GUIDE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String BONUSBALL_GUIDE = "보너스 볼을 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;

    private int purchasingMoney;
    private List<Lotto> lotteries = new ArrayList<>();
    private WinningLotto winningLottery;

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.purchasingMoney = game.enterPurchasingMoney();
        int purchasingQuantity = game.getPurchasingQuantity();
        System.out.println(purchasingQuantity + QUANTITY_GUIDE);
        game.purchaseLottery();
        game.winningLottery = game.getWinningLottery();
    }

    private int enterPurchasingMoney() {
        int purchasingMoney;
        do {
            System.out.println(PURCHASE_GUIDE);
            Scanner prompt = new Scanner(System.in);
            purchasingMoney = prompt.nextInt();
        } while (!this.validatePurchasingMoney(purchasingMoney, this.LOTTO_PRICE));
        return purchasingMoney;
    }

    private boolean isMoreThan(int purchasingMoney, int lottoPrice) {
        return (purchasingMoney >= lottoPrice) ? true : false;
    }

    private boolean isMultipleOf(int purchasingMoney, int lottoPrice) {
        return (purchasingMoney % lottoPrice == 0) ? true : false;
    }

    private boolean validatePurchasingMoney(int purchasingMoney,
                                            int lottoPrice) {
        if (!this.isMoreThan(purchasingMoney, lottoPrice)) {
            System.out.println(SHORTAGE_WARNING);
            return false;
        }
        if (!this.isMultipleOf(purchasingMoney, lottoPrice)) {
            System.out.println(UNIT_WARNING);
            return false;
        }
        return true;
    }

    private int getPurchasingQuantity() {
        int quantity = this.purchasingMoney / LOTTO_PRICE;
        return quantity;
    }

    private void purchaseLottery() {
        List<Integer> lottoNumbers;
        int purchasingQuantity = this.getPurchasingQuantity();
        for (int i = 0; i < purchasingQuantity; i++) {
            lottoNumbers = Lotto.generateLottoNumbers();
            Lotto lottery = new Lotto(lottoNumbers);
            this.lotteries.add(lottery);
        }
        for (int i = 0; i < lotteries.size(); i++) {
            System.out.println(this.lotteries.get(i).getNumbers());
        }
    }

    private List<Integer> enterWinningNumbers() {
        System.out.println(WINNING_NUMBER_GUIDE);
        Scanner prompt = new Scanner(System.in);
        String userInput = prompt.nextLine();
        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputNumbers = userInput.split(",");
        for (int i = 0; i < inputNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(inputNumbers[i]));
        }
        return winningNumbers;
    }

    private List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        boolean isValid = false;
        do {
            winningNumbers = this.enterWinningNumbers();
            System.out.println(winningNumbers);
            Lotto winningLottery = new Lotto(winningNumbers);
            isValid = winningLottery.validateWinningNumbers();
        } while (!isValid);
        return winningNumbers;
    }

    private int enterBonusBallNumber() {
        System.out.println(BONUSBALL_GUIDE);
        Scanner prompt = new Scanner(System.in);
        return prompt.nextInt();
    }

    private int getBonusBallNumber(List<Integer> winningNumbers) {
        int bonusBallNumber;
        boolean isValid;
        do {
            bonusBallNumber = this.enterBonusBallNumber();
            isValid = Lotto.validateBonusBallNumber(winningNumbers,
                bonusBallNumber);
        } while (!isValid);
        return bonusBallNumber;
    }

    private WinningLotto getWinningLottery() {
        List<Integer> winningNumbers = this.getWinningNumbers();
        Lotto lottery = new Lotto(winningNumbers);
        int bonusBallNumber = this.getBonusBallNumber(winningNumbers);
        winningLottery = new WinningLotto(lottery, bonusBallNumber);
        return winningLottery;
    }
}
