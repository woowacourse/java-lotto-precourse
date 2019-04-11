/*
 * 클래스 이름: ProcessWinningLotto.java
 * 버전 정보: 1.0.0
 * 날짜: 2019/04/11
 * Copyright 2019 Inkwon Lee
 */
package domain;

import java.util.*;

/*
 * 당첨번호가 몇개 인지 결과를 보여주는 클래스
 * hashMap 으로 당첨결과 구현
 */
public class ProcessWinningLotto {

    private Map<Integer, Integer> matchMap;

    ProcessWinningLotto() {
        matchMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            matchMap.put(rank.getWinningMoney(), 0);
        }
    }

    private Lotto winningLottoNumber(Scanner scanner) {
        Lotto winningNumber = new Lotto(new ArrayList<>());
        while (true) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String inputNumber = scanner.nextLine();
            String[] winningLottoArray = inputNumber.split(",");
            if (InputException.getInstance().blankWinningLotto(winningLottoArray) || InputException.getInstance().checkSizeWinningNumber(winningLottoArray)
                    || InputException.getInstance().assignOverlapNumber(winningLottoArray) || InputException.getInstance().checkNonNumber(inputNumber)
                    || InputException.getInstance().checkRangeNumber(winningLottoArray)) {
                continue;
            }
            winningNumber.assignWinningLotto(winningLottoArray);
            return winningNumber;
        }
    }

    private int bonusNumber(Scanner scanner) {
        while (true) {
            System.out.println("보너스 볼을 입력해 주세요.");
            String bonusNumber = scanner.nextLine();
            if (InputException.getInstance().hasBlankException(bonusNumber) || InputException.getInstance().isNumberFormatException(bonusNumber)
                    || InputException.getInstance().isMinusNumberException(bonusNumber) || InputException.getInstance().hasCheckLottoNumberException(bonusNumber)
                    || InputException.getInstance().overlapBonusNumber(bonusNumber)) {
                continue;
            }
            return Integer.parseInt(bonusNumber);
        }
    }

    public void statsWinningLotto(List<Lotto> purchaseLottoList, Scanner scanner, int purchasePrice) {
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber(scanner), bonusNumber(scanner));
        int prizeMoney = 0;

        for (Lotto userLotto : purchaseLottoList) {
            int getMoney = winningLotto.match(userLotto).getWinningMoney();
            matchMap.put(getMoney, matchMap.get(getMoney) + 1);
            prizeMoney += winningLotto.match(userLotto).getWinningMoney();
        }

        printStats((float) prizeMoney / (float) purchasePrice);
    }

    private void printStats(float rateOfPrize) {
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000)- " + matchMap.get(Rank.FIFTH.getWinningMoney()) + "개");
        System.out.println("4개 일치 (50000)- " + matchMap.get(Rank.FOURTH.getWinningMoney()) + "개");
        System.out.println("5개 일치 (1500000)- " + matchMap.get(Rank.THIRD.getWinningMoney()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000)- " + matchMap.get(Rank.SECOND.getWinningMoney()) + "개");
        System.out.println("6개 일치 (200000000)- " + matchMap.get(Rank.FIRST.getWinningMoney()) + "개");
        System.out.println("\n총 수익률은 " + String.format("%.3f", rateOfPrize) + "입니다.");
    }

}
