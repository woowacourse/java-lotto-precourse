package domain;

import java.util.ArrayList;
import java.util.Scanner;
import static domain.Const.*;

/**
 * 입/출력 관리 클래스
 */
public class IO {
    Scanner scan = new Scanner(System.in);

    public Price inputPurchaseAmount() {
        int userInPrice;
        System.out.println("구입금액을 입력해 주세요.");
        userInPrice = scan.nextInt();
        if (userInPrice < 1000) {
            printPriceError();
        }
        return new Price(userInPrice);
    }

    public void printChange(Price price) {
        if (price.getChange() != 0) {
            System.out.println("거스름돈은 " + price.getChange() + "원 입니다.");
        }
    }

    public ArrayList<Integer> inputWinningNumber() {
        ArrayList<Integer> userInWinningList = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        for (int i = 0; i < LOTTO_NUMBER_SIZE; ++i) {
            userInWinningList.add(scanNextIntLoop());
        }
        return userInWinningList;
    }

    public int inputBonusNumber() {
        int userInBonusNumber;
        System.out.println("보너스 볼을 입력해 주세요");
        userInBonusNumber = scanNextIntLoop();
        return userInBonusNumber;
    }

    public void printPurchaseLotto(Price price) {
        if (price.getTickets() > 0) {
            System.out.println(price.getTickets() + "개를 구매했습니다.");
        }
    }

    public void printLottoList(ArrayList<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); ++i) {
            printLottoNumber(lottoList.get(i));
        }
    }

    public void printLottoNumber(Lotto lotto) {
        StringBuffer msg = new StringBuffer();
        msg.append('[');
        for (int i = 0; i < LOTTO_NUMBER_SIZE; ++i) {
            msg.append(lotto.getNumbers().get(i)).append(", ");
        }
        msg.delete(msg.length() - 2, msg.length()).append(']').toString();
        System.out.println(msg);
    }

    public double moneyGain(int prize, Price price) {
        return prize / (double) price.getPrice();
    }

    public void printStatistics(int[] winningArray, Price price) {
        int prize = 0;
        for (int i = 0; i < LOTTO_GRADE_NUMBER; ++i) {
            StringBuffer msg = new StringBuffer();
            msg.append(int2Rank(i)).append("개 일치 (");
            msg.append(int2Rank(i).getWinningMoney()).append("원)- ");
            msg.append(winningArray[i]).append("개").toString();
            System.out.println(msg);
            prize += int2Rank(i).getWinningMoney() * winningArray[i];
        }
        System.out.printf("총 수익률은 %.3f 입니다.", moneyGain(prize, price));
    }

    private void printPriceError() {
        System.out.println(TICKET_PRICE + "원 미만의 금액으로는 구매할 수 없습니다.");
    }

    private boolean checkBound(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }

//    private boolean indexingCheckOverlap(ArrayList<Integer> arrayList, int number) {
//        for (int i = 0; i < arrayList.size(); ++i) {
//            return checkOverlap(arrayList.get(i), number);
//        }
//        return true;
//    }
//
//    private boolean checkOverlap(int numberInArr, int number) {
//        if (numberInArr == number) {
//            return false;
//        }
//        return true;
//    }

    private int scanNextIntLoop() {
        int number = scan.nextInt();
        if (checkBound(number) == false) {
            System.out.println("1 ~ 45 사이의 수를 입력해 주세요.");
            number = scanNextIntLoop();
        }
//        if (indexingCheckOverlap(arrayList, number) == false) {
//            System.out.println("중복된 수는 입력하실 수 없습니다.");
//            number = scanNextIntLoop(arrayList);
//        }
        return number;
    }

    /*
     *  10Line 초과
     */
    private Rank int2Rank(int idx) {
        if (idx == 0) {
            return Rank.FIRST;
        }
        if (idx == 1) {
            return Rank.SECOND;
        }
        if (idx == 2) {
            return Rank.THIRD;
        }
        if (idx == 3) {
            return Rank.FOURTH;
        }
        if (idx == 4) {
            return Rank.FIFTH;
        }
        return null;
    }
}
