package domain;

import java.util.*;

public class PlayLotto {

    private List<Lotto> userLottos;
    private List<Integer> tempNumbers;
    private WinningLotto masterLotto;
    private int money;

    private void getWinningNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 담청 번호를 입력해 주세요.");
        String winningNo = sc.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNo = sc.nextInt();
        getMasterLottoNo(winningNo, bonusNo);
    }

    private void getMasterLottoNo(String winningNo, int bonusNo) {
        tempNumbers = new ArrayList<Integer>();
        String[] arr;
        arr = winningNo.split(",");
        for (String num : arr) {
            int tempInt = Integer.parseInt(num);
            tempNumbers.add(tempInt);
        }
        Lotto masterTemp = new Lotto(tempNumbers);
        masterLotto = new WinningLotto(masterTemp, bonusNo);
    }

    private void getUserLottos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요");
        money = sc.nextInt();
        System.out.println(money / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < (money / 1000); i++) {
            addLotto();
            userLottos.get(i).printNo();
        }
    }

    private void addLotto() {
        tempNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            getDifferentNumber();
        }
        listSort();
        Lotto temp = new Lotto(tempNumbers);
        userLottos.add(temp);
    }

    private void getDifferentNumber() {
        Random random = new Random();
        boolean addCheak = true;
        int temp = 0;
        while (addCheak) {
            addCheak = false;
            temp = random.nextInt(45) + 1;
            addCheak = tempNumbers.contains(temp);
        }
        tempNumbers.add(temp);
    }

    private void listSort() {
        Collections.sort(tempNumbers);
    }

}
