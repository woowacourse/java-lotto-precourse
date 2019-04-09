package domain;

import java.util.*;

/**
 * 로또 게임을 진행하는 객체
 */
public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private static final int GAME_PRICE = 1_000;
    private static final int UPPER_LIMIT = 100_000;

    public void issueLottos() {
        int userMoney = 0;

        while (userMoney == 0) {
            userMoney = validateNumber(getUserMoney(getUserInput()));
        }

        buyLottos(userMoney);
        printLottos();
    }

    private String getUserInput() {
        Scanner scan = new Scanner(System.in);
        String userInput;

        System.out.println("구입금액을 입력해 주세요.");
        userInput = scan.nextLine();

        return userInput;
    }

    private int getUserMoney(String userInput) {
        try {
            int userMoney = Integer.parseInt(userInput);

            return userMoney;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int validateNumber(int userMoney) {
        if ((userMoney <= 0) || ((userMoney % GAME_PRICE) != 0) || (userMoney > UPPER_LIMIT)) {
            System.out.println("구입 금액은 1,000원 단위 0 이상 100,000 이하의 정수로 입력해 주세요.");
            return 0;
        }

        return userMoney;
    }

    private void buyLottos(int userMoney) {
        for (int i = 0; i < (userMoney / GAME_PRICE); i++) {
            List<Integer> lottoNumbers = new ArrayList<>(getRandomNumberList());
            Collections.sort(lottoNumbers);

            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    private Set<Integer> getRandomNumberList() {
        Set<Integer> randomNumberList = new HashSet<>();
        Random rand = new Random();

        while (randomNumberList.size() < 6) {
            randomNumberList.add(rand.nextInt(45) + 1);
        }

        return randomNumberList;
    }

    private void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.showNumbers();
        }
    }
}
