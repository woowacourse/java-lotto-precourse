package domain;

import java.util.*;

public class LottoGame {
    public static boolean isStringNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isRangeIn(int number, int min, int max) {
        if ((min <= number) && (number <= max)) {
            return true;
        }

        return false;
    }

    public static void alertMoneyNotice(int inputMoney, int min, int max) {
        if (min > inputMoney) {
            System.out.println("금액이 부족합니다.");
        }

        if (inputMoney > max) {
            System.out.println("1인당 최대 10만원까지 구매 가능합니다.");
        }
    }

    public static boolean isProperMoney(String inputMoney) {
        if (isStringNumber(inputMoney)) {
            int MIN_LOTTO_PRICE = 1000;
            int MAX_LOTTO_PRICE = 100000;
            int money = Integer.parseInt(inputMoney);

            alertMoneyNotice(money, MIN_LOTTO_PRICE, MAX_LOTTO_PRICE);

            return isRangeIn(money, MIN_LOTTO_PRICE, MAX_LOTTO_PRICE);
        }

        return false;
    }

    public static String inputMoney(boolean isFirstTry) {
        Scanner scanner = new Scanner(System.in);

        if (isFirstTry) {
            System.out.println("구입 금액을 입력해 주세요.");
        } else {
            System.out.println("구입 금액을 제대로 입력해 주세요.");
        }

        String answer = scanner.nextLine();
        return answer;
    }

    public static int payMoney() {
        boolean isFirstTry = true;
        String inputMoney = inputMoney(isFirstTry);
        boolean isProper = isProperMoney(inputMoney);

        while (!isProper) {
            isFirstTry = false;
            inputMoney = inputMoney(isFirstTry);
            isProper = isProperMoney(inputMoney);
        }

        return Integer.parseInt(inputMoney);
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

    public static void announcePurchaseResult(List<Lotto> lottos, int charge) {
        int numberOfNumber = lottos.size();
        String message = String.format(
                "\n거스름돈은 %d 원이고, %d개를 구매하였습니다.",charge, numberOfNumber);

        System.out.println(message);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Lotto> purchaseLotto(int money) {
        int purchasableLotto = getPurchasableNumber(money);
        int charge = getCharge(money);
        List<Lotto> boughtLotto = new ArrayList<>();

        for (int i = 0; i < purchasableLotto; i++) {
            Lotto lotto = new Lotto(generateLottoNumber());
            boughtLotto.add(lotto);
        }

        announcePurchaseResult(boughtLotto, charge);
        return boughtLotto;
    }

    public static boolean isProperLength(String[] inputNumbers) {
        int PROPER_LOTTO_LENGTH = 6;
        Set<String> removeDuplicate = new HashSet<>(Arrays.asList(inputNumbers));

        if (removeDuplicate.size() == PROPER_LOTTO_LENGTH) {
            return true;
        }

        return false;
    }

    public static boolean isProperLottoNumber(String inputnumber) {
        if (isStringNumber(inputnumber)) {
            int MIN_LOTTO_NUMBER = 1;
            int MAX_LOTTO_NUMBER = 45;
            int number = Integer.parseInt(inputnumber);

            return isRangeIn(number, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
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
        return inputNumbers.split(",");
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

    public static boolean isProperBonusNumber(String inputBonusNumber,
                                              String[] inputLottoNumber) {
        if (isProperLottoNumber(inputBonusNumber)) {
            return !Arrays.asList(inputLottoNumber).contains(inputBonusNumber);
        }

        return false;
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

    public static int receiveBonusNumber(String[] lottoNumbers) {
        boolean isFirstTry = true;
        String inputBonusNumber = inputBonusNumber(isFirstTry);
        boolean isProper = isProperBonusNumber(inputBonusNumber, lottoNumbers);

        while (!isProper) {
            isFirstTry = false;
            inputBonusNumber = inputBonusNumber(isFirstTry);
            isProper = isProperBonusNumber(inputBonusNumber, lottoNumbers);
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
        String[] inputNumbers = receiveWinningNumbers();
        List<Integer> numbers = changeElementTypeStrToInt(inputNumbers);
        int bonusNumber = receiveBonusNumber(inputNumbers);

        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        return winningLotto;
    }

    public static List<Integer> getLottoResult(List<Lotto> userLottos,
                                            WinningLotto winningLotto) {
        List<Integer> lottoResult = Arrays.asList(0,0,0,0,0,0);

        for (Lotto lotto : userLottos) {
            Rank rank = winningLotto.match(lotto);
            lottoResult.set(rank.ordinal(), lottoResult.get(rank.ordinal()) + 1);
        }

        return lottoResult;
    }

    public static void announceRankResult(Rank rank, int countOfMatch,
                                          int winningMoney, int countOfWin) {
        if (rank == Rank.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개",
                    countOfMatch, winningMoney, countOfWin));
        } else if (rank != Rank.MISS) {
            System.out.println(String.format("%d개 일치(%d원) - %d개",
                    countOfMatch, winningMoney, countOfWin));
        }
    }

    public static int getRankResult(List<Integer> result, Rank rank) {
        int countOfMatch = rank.getCountOfMatch();
        int winningMoney = rank.getWinningMoney();
        int countOfWin = result.get(rank.ordinal());
        int totalWinningMoney = winningMoney * countOfWin;

        announceRankResult(rank, countOfMatch, winningMoney, countOfWin);

        return totalWinningMoney;
    }

    public static List<Rank> reverseEnum(Rank[] initEnum) {
        List<Rank> reverseEnum = new ArrayList<>();

        for (int i = initEnum.length - 1; i >= 0; i--) {
            reverseEnum.add(initEnum[i]);
        }

        return reverseEnum;
    }

    public static int getWinningMoney(List<Lotto> userLottos,
                                      WinningLotto winningLotto) {
        int totalWinningMoney = 0;
        List<Integer> result = getLottoResult(userLottos,winningLotto);

        System.out.println("\n당첨통계\n--------");

       for (Rank rank : reverseEnum(Rank.values())) {
            totalWinningMoney += getRankResult(result, rank);
        }

        return totalWinningMoney;
    }

    public static void announceEarningRate(int paidMoney, int winningMoney) {
        double earningRate = winningMoney / paidMoney;

        System.out.println(String.format("총 수익률은 %.3f 입니다.", earningRate));
    }

    public static void main(String[] args) {
        int paidMoney = payMoney();
        List<Lotto> purchasedLotto = purchaseLotto(paidMoney);
        WinningLotto winningLotto = generateWinningLotto();
        int winningMoney = getWinningMoney(purchasedLotto, winningLotto);

        announceEarningRate(paidMoney, winningMoney);
    }
}
