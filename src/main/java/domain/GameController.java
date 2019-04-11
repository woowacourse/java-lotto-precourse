package domain;

import java.util.*;

public class GameController {

    private static final int LOTTO_PRICE = 1000;
    private Map<Integer,Integer> matchCount;

    public GameController(){
        matchCount = new TreeMap<>();
        matchCount.put(Rank.FIRST.getWinningMoney(),0);
        matchCount.put(Rank.SECOND.getWinningMoney(),0);
        matchCount.put(Rank.THIRD.getWinningMoney(),0);
        matchCount.put(Rank.FOURTH.getWinningMoney(),0);
        matchCount.put(Rank.FIFTH.getWinningMoney(),0);
        matchCount.put(Rank.MISS.getWinningMoney(),0);
    }

    public void startGame() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int purchasePrice = scanner.nextInt();
        assignPurchaseLottoList(amountLotto(purchasePrice), purchaseLottoList);
        statsWinningLotto(winningLottoNumber(scanner), bonusNumber(scanner), purchaseLottoList, purchasePrice);
    }

    private int amountLotto(int purchasePrice) {
        return (purchasePrice / LOTTO_PRICE);
    }

    private void assignPurchaseLottoList(int numberOfLotto, List<Lotto> purchaseLottoList) {
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto assignLotto = new Lotto(new ArrayList<>());
            assignLotto.getLottoNumber();
            purchaseLottoList.add(assignLotto);
        }

        System.out.println();
    }

    private Lotto winningLottoNumber(Scanner scanner){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Lotto winningNumber = new Lotto(new ArrayList<>());
        winningNumber.assignWinningLotto(scanner.next());

        return winningNumber;
    }

    private int bonusNumber(Scanner scanner){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private void statsWinningLotto(Lotto winningNumber, int bonusNumber, List<Lotto> purchaseLottoList, int purchasePrice){
        WinningLotto matchLotto = new WinningLotto(winningNumber, bonusNumber);

        int prizeMoney = 0;
        for(Lotto userLotto : purchaseLottoList){
            int getMoney = matchLotto.match(userLotto).getWinningMoney();
            matchCount.put(getMoney, matchCount.get(getMoney)+1);
            prizeMoney += matchLotto.match(userLotto).getWinningMoney();
        }
        printStats(matchCount, ((float)prizeMoney/(float)purchasePrice));
    }

    private void printStats(Map<Integer,Integer> matchCount, float rateOfPrize){
        System.out.println("\n당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000)- " + matchCount.get(Rank.FIFTH.getWinningMoney()) + "개");
        System.out.println("4개 일치 (50000)- " + matchCount.get(Rank.FOURTH.getWinningMoney()) + "개");
        System.out.println("5개 일치 (1500000)- " + matchCount.get(Rank.THIRD.getWinningMoney()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000)- " + matchCount.get(Rank.SECOND.getWinningMoney()) + "개");
        System.out.println("6개 일치 (200000000)- " + matchCount.get(Rank.FIRST.getWinningMoney()) + "개");
        System.out.println("총 수익률 " + rateOfPrize + "입니다.");
    }

}
