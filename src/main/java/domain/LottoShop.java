package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 로또를 사고 통계를 보여주는 객체
 */

public class LottoShop {
    static final int PRICE = 1000;

    private List<Lotto> lottoList;
    private final int purchaseAmount;
    private WinningLotto latestWinningLotto;
    private static int[] sortByRank = new int[6];


    public List<Integer> generateSixNumber() {
        List<Integer> range = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(range);
        List<Integer> temp = range.subList(0, 6);
        Collections.sort(temp);
        return temp;
    }

    public LottoShop() {
        purchaseAmount = purchase() / PRICE;
        lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(new Lotto(generateSixNumber()));
        }
    }

    public int purchase() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextInt();
    }

    public void printLottoList() {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

    public List<Integer> getWinningNumbers() {
        String winningNumbers;
        Scanner scan = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumbers = scan.nextLine();

        /* 입력한 당첨번호를 , 로 구분해서 리턴*/
        return Stream.of(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public int getBonusNumber() {
        int bonusNum;
        Scanner scan = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNum = scan.nextInt();
        while (bonusNum < 1 || bonusNum > 45) {
            System.out.println("1과 45 사이의 정수를 입력해 주세요");
            bonusNum = scan.nextInt();
        }
        return bonusNum;
    }

    public void enterWinningLotto() {
        Lotto lotto = new Lotto(getWinningNumbers());
        int bonusNum = getBonusNumber();

        /* 보너스 볼 예외처리*/
        while (lotto.getNumbers().contains(bonusNum)) {
            System.out.println("보너스 볼은 당첨 번호와 다릅니다. 다시 입력해주세요.");
            bonusNum = getBonusNumber();
        }
        latestWinningLotto = new WinningLotto(lotto, bonusNum);
    }

    public void showStatistics() {
        int profit = this.checkWinning();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printDetailByRank(Rank.FIFTH);
        printDetailByRank(Rank.FOURTH);
        printDetailByRank(Rank.THIRD);
        printDetailByRank(Rank.SECOND);
        printDetailByRank(Rank.FIRST);
        System.out.println("총 수익률은 " + (double) profit / (purchaseAmount * PRICE) + "입니다.");
    }

    public void printDetailByRank(Rank r) {
        if (r == Rank.SECOND) {
            System.out.print(r.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + r.getWinningMoney() + "원) - ");
            System.out.println(sortByRank[rankToInteger(r)] + "개");
            return;
        }
        System.out.print(r.getCountOfMatch() + "개 일치 (" + r.getWinningMoney() + "원) - ");
        System.out.println(sortByRank[rankToInteger(r)] + "개");
    }

    public int checkWinning() {
        int sum = 0;
        for (Lotto lotto : lottoList) {
            Rank r = latestWinningLotto.match(lotto);
            sum += r.getWinningMoney();
            sortByRank[rankToInteger(r)]++;
        }
        return sum;
    }

    public int rankToInteger(Rank r) {
        if (r == Rank.FIRST) {
            return 0;
        }
        if (r == Rank.SECOND) {
            return 1;
        }
        if (r == Rank.THIRD) {
            return 2;
        }
        if (r == Rank.FOURTH) {
            return 3;
        }
        if (r == Rank.FIFTH) {
            return 4;
        }
        return 5;
    }

    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        shop.printLottoList();
        shop.enterWinningLotto();
        shop.showStatistics();
    }
}
