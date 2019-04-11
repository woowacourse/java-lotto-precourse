package domain;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 구입 금액을 입력
 * 구입한 로또 수량 계산
 * 수량에 맞는 로또 생성 및 출력
 */
public class LottoShop {

    public List<Lotto> purchaseLotto() {
        int price;
        int amount;
        List<Lotto> lottoList;

        price = inputValidPrice();
        amount = amountOfLotto(price);
        lottoList = createAllLotto(amount);

        printAllLotto(lottoList);
        return lottoList;
    }

    private int inputValidPrice() {
        String price;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("구입금액을 입력해 주세요.");
            price = sc.nextLine();
        } while (isValidPrice(price) == false);

        return Integer.parseInt(price);
    }

    private boolean isValidPrice(String price) {
        boolean result = true;

        if (isValidPricePattern(price) == false) {
            System.out.println("구입금액은 1,000 단위 입니다.");
            result = false;
        }
        return result;
    }

    private boolean isValidPricePattern(String invalidInput) {
        String pattern = Constant.MULTIPLE_THOUSAND_PATTERNS;
        return Pattern.matches(pattern, invalidInput);
    }

    private int amountOfLotto(int price) {
        return price / Constant.CONVERSION_LOTTO_AND_PRICE;
    }

    private List<Lotto> createAllLotto(int amount) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            createLotto(lottoList);
        }
        return lottoList;
    }

    private void createLotto(List<Lotto> userLottoList) {
        List<Integer> determinedNumberList = new ArrayList<>();

        for (int i = 0; i < Constant.LOTTO_NUMBER_SIZE; i++) {
            fillRandomNumber(determinedNumberList);
        }
        Collections.sort(determinedNumberList);

        userLottoList.add(new Lotto(determinedNumberList));
    }

    private void fillRandomNumber(List<Integer> determinedNumberList) {
        int randomNumber;

        do {
            randomNumber = makeRandomNumber();
        } while (determinedNumberList.contains(randomNumber));

        determinedNumberList.add(randomNumber);
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * Constant.MAXIMUM_LOTTO_NUMBER)
                + Constant.MINIMUM_LOTTO_NUMBER;
    }

    private void printAllLotto(List<Lotto> userLottoList) {
        Iterator<Lotto> iter = userLottoList.iterator();

        System.out.println(userLottoList.size() + "개를 구매했습니다.");
        while (iter.hasNext()) {
            iter.next().printLottoNumber();
        }
    }
}
