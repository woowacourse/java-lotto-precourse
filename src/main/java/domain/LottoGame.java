package domain;

import java.util.*;

/**
 * 로또게임을 진행하는 객체
 */
public class LottoGame {
    private static final int THE_NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_PRICE = 1000;
    private static final String PRINT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    private List<Lotto> lottoes;

    public LottoGame() {

    }

    public void turnOn() {
        start();
    }

    private void start() {

    }

    private int getLottoPurchaseMoney() {
        String lottoPurchaseMoney;

        do {
            lottoPurchaseMoney = inputLottoPurchaseMoney();
        } while (!isValidLottoPurchaseMoney(lottoPurchaseMoney));

        return Integer.parseInt(lottoPurchaseMoney);
    }

    private String inputLottoPurchaseMoney() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private boolean isValidLottoPurchaseMoney(String lottoPurchaseMoney) {
        if (!isInteger(lottoPurchaseMoney)) {
            return false;
        }
        if (isNegativeNumber(Integer.parseInt(lottoPurchaseMoney))) {
            return false;
        }

        return true;
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < THE_NUMBER_OF_LOTTO_NUMBERS) {
            int lottoNumber = createLottoNumber();
            addLottoNumber(lottoNumber, lottoNumbers);
        }

        return lottoNumbers;
    }

    private int createLottoNumber() {
        return (int) (Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
    }

    private void addLottoNumber(int lottoNumber, List<Integer> lottoNumbers) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private void registerLottoes() {
        lottoes = new ArrayList<>();
        int lottoCount = getLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottoes.add(createLotto());
        }
    }

    private int getLottoCount() {
        int lottoPurchaseMoney = getLottoPurchaseMoney();

        return lottoPurchaseMoney / LOTTO_PRICE;
    }

    private void printLottoes() {
        System.out.println(lottoes.size() + PRINT_LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottoes) {
            lotto.printLottoNumbers();
        }
    }
}
