package domain;

import java.util.*;

class ProcessWinningLotto {

    private Map<Integer,Integer> matchMap;

    ProcessWinningLotto(){
        matchMap = new HashMap<>();
        for(Rank rank : Rank.values()){
            matchMap.put(rank.getWinningMoney(), 0);
        }
    }

    private Lotto winningLottoNumber(Scanner scanner){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();

        Lotto winningNumber = new Lotto(new ArrayList<>());
        String[] result = scanner.nextLine().split(",");
        winningNumber.assignWinningLotto(result);

        return winningNumber;
    }

    private int bonusNumber(Scanner scanner){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void statsWinningLotto(List<Lotto> purchaseLottoList, Scanner scanner, int purchasePrice){
        WinningLotto winningLotto = new WinningLotto(winningLottoNumber(scanner), bonusNumber(scanner));

        int prizeMoney = 0;
        for(Lotto userLotto : purchaseLottoList){
            int getMoney = winningLotto.match(userLotto).getWinningMoney();
            matchMap.put(getMoney, matchMap.get(getMoney)+1);
            prizeMoney += winningLotto.match(userLotto).getWinningMoney();
        }

        printStats((float)prizeMoney/(float) purchasePrice);
    }

    private void printStats(float rateOfPrize){
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000)- " + matchMap.get(Rank.FIFTH.getWinningMoney()) + "개");
        System.out.println("4개 일치 (50000)- " + matchMap.get(Rank.FOURTH.getWinningMoney()) + "개");
        System.out.println("5개 일치 (1500000)- " + matchMap.get(Rank.THIRD.getWinningMoney()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000)- " + matchMap.get(Rank.SECOND.getWinningMoney()) + "개");
        System.out.println("6개 일치 (200000000)- " + matchMap.get(Rank.FIRST.getWinningMoney()) + "개");
        System.out.println("\n총 수익률은 " + String.format("%.3f",rateOfPrize) + "입니다.");
    }

}
