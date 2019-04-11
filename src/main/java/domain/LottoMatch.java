package domain;

import java.util.*;

public class LottoMatch {
    private Scanner scanner;
    private Lotto winLotto;
    private int bonusNumber;

    public LottoMatch() {
        scanner = new Scanner(System.in);
    }

    public void startLottoMatch() {
        inputWinNumbers();
        inputBonusNumber();
    }

    private void inputWinNumbers() {
        String matchNum;
        while (true) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            try {
                matchNum = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("당첨번호는 숫자만 입력해주세요");
                scanner.nextLine();
                continue;
            }
            String[] splitedNumArray = matchNum.split(",");
            if (checkInputDuplicate(splitedNumArray) && checkInputLength(splitedNumArray) && checkInputEmpty(splitedNumArray) && checkInputFormat(splitedNumArray)) {
                winLotto = new Lotto(splitNum(splitedNumArray));
                break;
            }
        }
    }

    private List<Integer> splitNum(String[] inputArray) {
        List<Integer> winNumList = new ArrayList<>();
        for (String s : inputArray) {
            winNumList.add(Integer.valueOf(s));
        }
        return winNumList;
    }

    private void inputBonusNumber() {
        boolean numChecker = false;
        while (!numChecker){
            System.out.println("보너스 볼을 입력해 주세요.");
            try{
                bonusNumber = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("옳지않은 형식입니다.");
                scanner.nextLine();
                continue;
            }
            numChecker = checkBonusNum(bonusNumber);
        }
        new WinningLotto(winLotto, bonusNumber);
    }

    public Lotto getWinLottoNum() {
        return winLotto;
    }

    public int getBonusNum() {
        return bonusNumber;
    }

    private boolean checkInputLength(String[] inputArray) {
        if (inputArray.length != Constant.LOTTO_NUM_LENGTH) {
            System.out.println("당첨 번호는 6개 입니다.");
            return false;
        }
        return true;
    }

    private boolean checkInputDuplicate(String[] inputArray) {
        Set<String> set = new HashSet<>(Arrays.asList(inputArray));
        return set.size() == inputArray.length;
    }

    private boolean checkInputEmpty(String[] inputArray) {
        for (String s : inputArray) {
            if (s.trim().equals("")) {
                return false;
            }
        }
        return true;
    }

    private boolean checkInputFormat(String[] inputArray) {
        for (String s : inputArray) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBonusNum(int bonusNumber){
        if (bonusNumber < Constant.LOTTO_MIN_VALUE || bonusNumber > Constant.LOTTO_MAX_VALUE){
            System.out.println("로또는 1~45 숫자만 존재합니다.");
            return false;
        }
        return true;
    }
}
