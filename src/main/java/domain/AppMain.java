/*
 * AppMain
 *
 * version 1.0
 *
 * 2019/04/10
 */

package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 어플리케이션이 실행되는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
public class AppMain {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCount = userInput.inputTotalPrice();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoGenerator.setLottoNumber());
            lottoList.add(lotto);
            lotto.printLottoNumbers();
        }

        userInput.inputBonusNumber(userInput.inputWinningNumbers());
    }
}
