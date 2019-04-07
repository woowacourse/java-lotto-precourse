package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Shop extends Config {

    private Lotto[] lottoBundle;
    private int count;

    public Shop(int price){
        this.count = price / 1000;
        this.lottoBundle = new Lotto[count];
    }

    public Lotto[] sellLotto(int price) {
        System.out.println("로또 번호를 입력하세요. 번호는 , 로 구분됩니다.");
        for (int i = 0; i < count; i++) {
            lottoBundle[i] = createLotto(getLottoNumber());
            System.out.println("입력되었습니다.");
        }
        return lottoBundle;
    }

    public WinningLotto createWinningLotto() {
        new Scanner(System.in);
        System.out.println("당첨 번호를 입력해주세요");
        Lotto lotto = createLotto(getLottoNumber());
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = createBonusNumber(lotto.getLottoNumber());
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        return winningLotto;
    }

    private Lotto createLotto(ArrayList<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private ArrayList<Integer> getLottoNumber() {
        int[] numberArray = new LottoPaper().getLottoNumber();
        ArrayList<Integer> lottoNumber = (ArrayList<Integer>) Arrays.stream(numberArray).boxed().collect(Collectors.toList());
        return lottoNumber;
    }

    public void printLotto(Lotto[] lottobundle) {
        int amount = lottobundle.length;
        System.out.println(amount + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++) {
            System.out.println(lottobundle[i].printLottoNumber());
        }
    }

    private int createBonusNumber(List<Integer> winningNumber) {
        int bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        return bonusNumber;
    }

    private int checkBonusNumberValidation(int bonusNumber, List<Integer> winningNumber) {
        Scanner scan = new Scanner(System.in);
        try {
            int signedBonusNumber = scan.nextInt();
            bonusNumber = checkBonusNumberRange(signedBonusNumber, winningNumber);
            bonusNumber = checkDuplicateBonusNumber(bonusNumber, winningNumber);
        } catch (InputMismatchException e) {
            resetScanner();
            bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        }
        return bonusNumber;
    }

    private int checkBonusNumberRange(int bonusNumber, List<Integer> winningNumber) {
        if (bonusNumber > LOTTO_MAX_VALUE || bonusNumber <= LOTTO_MIN_VALUE) {
            System.out.println("번호는 1이상 45이하의 수만 입력이 가능합니다.");
            bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        }
        return bonusNumber;
    }

    private int checkDuplicateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            System.out.println("보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
            bonusNumber = checkBonusNumberValidation(INITIAL_VALUE, winningNumber);
        }
        return bonusNumber;
    }
}
