/**
 * LottoManager.class        1.00 2019/04/06
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 로또 번호를 생성하고 관리하는 클래스
 *
 * @version 1.00
 * @author 이남준
 */
public class LottoManager implements Constants {
    LottoBuyer buyer = new LottoBuyer();
    WinningLotto winningLotto;
    private static Random random = new Random();

    public static List<Integer> makeRandomNumber() {

        ArrayList<Integer> randomNumbers = new ArrayList<>();
        int randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1) + 1;

        while (randomNumbers.size() != SIZE_OF_LOTTO) {
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
            randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1) + 1;
        }
        return randomNumbers;
    }

    public void makeWinningLotto() {
        List<Integer> lottoNumbers = makeRandomNumber();
        Lotto lotto = new Lotto(lottoNumbers);
        int bonusNumber = makeBonusNumber(lottoNumbers);

        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    private int makeBonusNumber(List<Integer> lotto) {
        int randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1);
        while(lotto.contains(randomNumber)) {
            randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1);
        }
        return randomNumber;
    }
}
