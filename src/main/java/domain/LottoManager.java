/**
 * LottoManager.class        1.00 2019/04/06
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */
package domain;

import java.util.*;

/**
 * 로또 번호를 생성하고 관리하는 클래스
 *
 * @version 1.00
 * @author 이남준
 */
public class LottoManager implements Constants {
    LottoBuyer buyer;
    WinningLotto winningLotto;
    private static Random random = new Random();

    public LottoManager() {
        buyer = new LottoBuyer();
    }

    public static List<Integer> makeRandomNumber() {

        ArrayList<Integer> randomNumbers = new ArrayList<>();
        int randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1) + 1;

        while (randomNumbers.size() != SIZE_OF_LOTTO) {
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
            randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1) + 1;
        }
        Collections.sort(randomNumbers);

        return randomNumbers;
    }

    public void makeWinningLotto() {
        List<Integer> lottoNumbers = makeRandomNumber();
        Lotto lotto = new Lotto(lottoNumbers);
        int bonusNumber = makeBonusNumber(lottoNumbers);

        winningLotto = new WinningLotto(lotto, bonusNumber);
        System.out.println("\n" + "당첨 번호");
        System.out.println(winningLotto.getLotto().getNumbers() + " + 보너스 : " + winningLotto.getBonusNo());
    }

    private int makeBonusNumber(List<Integer> lotto) {
        int randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1);
        while (lotto.contains(randomNumber)) {
            randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1);
        }
        return randomNumber;
    }

    public void checkRanks() {
        Lotto[] lottos = buyer.getPurchasedLottos();
        Rank[] resultRanks = new Rank[buyer.getCountOfLottos()];

        for (int i = 0; i < buyer.getCountOfLottos(); i++) {
            resultRanks[i] = winningLotto.match(lottos[i]);
        }

        buyer.setRanks(resultRanks);
    }

    public void printResults() {
        BuyerResult buyerResult = buyer.getBuyerResult();
        int[] countOfWinningLottos = buyerResult.getCountOfWinningLottos();

        System.out.println("\n" + "당첨 통계" + "\n" + "--------------");
        System.out.println("3개 일치 (5000원) - " + countOfWinningLottos[4]);
        System.out.println("4개 일치 (50000원) - " + countOfWinningLottos[3]);
        System.out.println("5개 일치 (1500000원) - " + countOfWinningLottos[2]);
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + countOfWinningLottos[1]);
        System.out.println("6개 일치 (2000000000원) - " + countOfWinningLottos[0]);
        if(buyerResult.getTotalWinningMoney() == 0) {
            System.out.println("총 수익률은 0.000 입니다.");
            return;
        }
        System.out.println("총 수익률은 " + ((double)buyerResult.getTotalWinningMoney() / ((double)buyer.getCountOfLottos()
                * 1000)) + "입니다.");

    }
}
