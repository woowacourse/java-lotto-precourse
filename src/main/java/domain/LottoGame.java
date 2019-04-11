package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또 게임을 진행하는 객체
 */
public class LottoGame {
    private List<Lotto> lottos = new ArrayList<>();
    private List<WinningLotto> winningLotto = new ArrayList<>();
    private static final int GAME_PRICE = 1_000;
    private static final int UPPER_LIMIT = 100_000;
    private static final int WINNING_LOTTO_INDEX = 0;       // winningLotto ArrayList에서 실제 winningLotto 객체가 저장된 인덱스

    public void issueLottos() {
        int userMoney = 0;

        while (userMoney == 0) {
            userMoney = validateUserMoney(getUserMoney(getUserInput()));
        }

        buyLottos(userMoney);
        printLottos();
    }

    public void setWinningLotto() {
        Lotto winningNumbers = new Lotto(getWinningNumbers());
        int bonusNumber = getBonusNumber(winningNumbers);

        winningLotto.add(new WinningLotto(winningNumbers, bonusNumber));
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

    private int validateUserMoney(int userMoney) {
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

    private List<Integer> getWinningNumbers() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            userInput = scan.nextLine();
        } while (!validateWinningNumbers(userInput));

        return new ArrayList<>(parseWinningNumbers(userInput));
    }

    private boolean validateWinningNumbers(String userInput) {
        Set<Integer> winningNumbers = parseWinningNumbers(userInput);

        if ((winningNumbers.size() != 6) || (Collections.max(winningNumbers) > 45) || (Collections.min(winningNumbers) < 1)) {
            System.out.println("당첨 번호는 1~45 사이의 숫자 6개를 중복되지 않게 쉼표(,)로 구분하여 입력해주세요.");

            return false;
        }

        return true;
    }

    private Set<Integer> parseWinningNumbers(String userInput) {
        Set<String> parsedStringNumber = new HashSet<>(Arrays.asList(userInput.split(",")));

        try {
            Set<Integer> parsedIntNumber = parsedStringNumber.stream()
                    .map(s -> Integer.parseInt(s)).collect(Collectors.toSet());

            return parsedIntNumber;
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

    private int getBonusNumber(Lotto winningNumbers) {
        Scanner scan = new Scanner(System.in);
        int bonusNumber = 0;

        while (bonusNumber == 0) {
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNumber = validateBonusNumber(
                    changeBonusNumberToInt(scan.nextLine()), winningNumbers);
        }

        return bonusNumber;
    }

    private int changeBonusNumberToInt(String userInput) {
        try {
            int bonusNumber = Integer.parseInt(userInput);

            return bonusNumber;
        } catch (Exception e) {
            return 0;
        }
    }

    private int validateBonusNumber(int userInput, Lotto winningNumbers) {
        if ((winningNumbers.hasNumber(userInput)) ||
                (userInput < 1) ||
                (userInput > 45)) {
            System.out.println("보너스 볼 번호는 1~45 사이의 당첨 번호와 겹치지 않는 정수로 입력해주세요.");

            return 0;
        }

        return userInput;
    }
}
