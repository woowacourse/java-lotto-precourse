package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    public static boolean isStringNumber(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void alertMoneyNotice(int inputMoney, int MIN, int MAX) {
        if (MIN > inputMoney) {
            System.out.println("금액이 부족합니다.");
        }

        if (inputMoney > MAX) {
            System.out.println("1인당 최대 10만원까지 구매 가능합니다.");
        }
    }

    public static boolean isProperMoney(int inputMoney) {
        int MIN_LOTTO_PRICE = 1000;
        int MAX_LOTTO_PRICE = 100000;

        alertMoneyNotice(inputMoney, MIN_LOTTO_PRICE, MAX_LOTTO_PRICE);

        if ((MIN_LOTTO_PRICE <= inputMoney)
                && (inputMoney <= MAX_LOTTO_PRICE)) {
            return true;
        }

        return false;
    }

    public static int payMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");
        String inputMoney = scanner.nextLine();
        boolean isProper = isStringNumber(inputMoney);

        if (!isProper) {
            inputMoney = repayMoney();
        }

        return Integer.parseInt(inputMoney);
    }

    public static String repayMoney() {
        boolean isProper = false;
        String inputMoney = "";

        while (!isProper) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("구입금액을 제대로 입력해주세요.");
            inputMoney = scanner.nextLine();
            isProper = isStringNumber(inputMoney);
        }

        return inputMoney;
    }

    public static int receiveMoney() {
        boolean isProper = false;
        int paidMoney = 0;

        while (!isProper) {
            paidMoney = payMoney();
            isProper = isProperMoney(paidMoney);
        }

        return paidMoney;
    }

    public static int getPurchasableNumber(int money) {
        int ONE_LOTTO_PRICE = 1000;
        int purchasableNumber = money / ONE_LOTTO_PRICE;

        return purchasableNumber;
    }

    public static int getCharge(int money) {
        int ONE_LOTTO_PRICE = 1000;
        int charge = money % ONE_LOTTO_PRICE;

        return charge;
    }

    public static List<Integer> generateLottoNumber() {
        HashSet<Integer> numbers = new HashSet<>();

        while (numbers.size() != 6) {
            numbers.add((int) (Math.random() * 45 + 1));
        }

        List<Integer> lottoNumbers = new ArrayList<>(numbers);

        return lottoNumbers;
    }

    public static List<Lotto> purchaseLotto(int money) {
        int purchasableLotto = getPurchasableNumber(money);
        List<Lotto> boughtLotto = new ArrayList<>();

        for (int i = 0; i < purchasableLotto; i++) {
            Lotto lotto = new Lotto(generateLottoNumber());
            boughtLotto.add(lotto);
        }

        return boughtLotto;
    }

    public static void announcePurchaseResult(List<Lotto> lottos, int charge) {
        int numberOfNumber = lottos.size();
        String message = String.format(
                "\n거스름돈은 %d 원이고, %d개를 구매하였습니다.",charge, numberOfNumber);

        System.out.println(message);

        for (Lotto lotto : lottos) {
            lotto.showNumbers();
        }
    }

    public static boolean isProperLength(String[] inputNumbers) {
        int PROPER_LOTTO_LENGTH = 6;

        if (inputNumbers.length == PROPER_LOTTO_LENGTH) {
            return true;
        }

        return false;
    }

    public static boolean isProperLottoNumber(String number) {
        if (isStringNumber(number)) {
            int numberInt = Integer.parseInt(number);

            return (1 <= numberInt) && (numberInt <= 45);
        }

        return false;
    }

    public static boolean isProperLottoNumbers(String[] inputNumbers) {
        if (!isProperLength(inputNumbers)) {
            return false;
        }

        for (String number : inputNumbers) {
            if (!isProperLottoNumber(number)) {
                return false;
            }
        }

        return true;
    }

    public static String[] inputWinningNumbers(boolean isFirstTry) {
        Scanner scanner = new Scanner(System.in);

        if (isFirstTry) {
            System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        } else {
            System.out.println("\n지난 주 당첨 번호를 제대로 입력해 주세요.");
        }

        String inputNumbers = scanner.nextLine();
        String[] inputNumbersList = inputNumbers.split(",");

        return inputNumbersList;
    }

    public static String[] receiveWinningNumbers() {
        boolean isFirstTry = true;
        String[] inputNumbers = inputWinningNumbers(isFirstTry);
        boolean isProper = isProperLottoNumbers(inputNumbers);

        while (!isProper) {
            isFirstTry = false;
            inputNumbers = inputWinningNumbers(isFirstTry);
            isProper = isProperLottoNumbers(inputNumbers);
        }

        return inputNumbers;
    }

    public static String inputBonusNumber(boolean isFirstTry) {
        Scanner scanner = new Scanner(System.in);

        if (isFirstTry) {
            System.out.println("\n보너스 볼을 입력해 주세요.");
        } else {
            System.out.println("\n보너스 볼을 제대로 입력해 주세요.");
        }

        String inputBonusNumber = scanner.nextLine();

        return inputBonusNumber;
    }

    public static int receiveBonusNumber() {
        boolean isFirstTry = true;
        String inputBonusNumber = inputBonusNumber(isFirstTry);
        boolean isProper = isProperLottoNumber(inputBonusNumber);

        while (!isProper) {
            isFirstTry = false;
            inputBonusNumber = inputBonusNumber(isFirstTry);
            isProper = isProperLottoNumber(inputBonusNumber);
        }

        return Integer.parseInt(inputBonusNumber);
    }

    public static List<Integer> changeElementTypeStrToInt(String[] lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();

        for (String number : lottoNumbers) {
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    public static WinningLotto generateWinningLotto() {
        List<Integer> numbers = changeElementTypeStrToInt(receiveWinningNumbers());
        int bonusNumber = receiveBonusNumber();

        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    public static void main(String[] args) {
        int paidMoney = receiveMoney();
        int charge = getCharge(paidMoney);
        List<Lotto> purchasedLotto = purchaseLotto(paidMoney);

        announcePurchaseResult(purchasedLotto, charge);
        generateWinningLotto();

    }
}
