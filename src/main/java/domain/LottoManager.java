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
        System.out.println("당첨 번호");
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
        System.out.println();
        System.out.println(buyer.getRanks()[0].getWinningMoney());
    }
}
