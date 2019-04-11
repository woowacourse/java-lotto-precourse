import domain.Lotto;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    public static void main(String[] args) {
        LottoGameInputView lottoGameInputView = new LottoGameInputView();
        LottoGameOutputView lottoGameOutputView = new LottoGameOutputView();
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputLotto = new ArrayList<>();

        lottoGameInputView.askBuyingMoney();
        int buyingMoney = scanner.nextInt();
        LottoGenerator lottoGenerator = new LottoGenerator(buyingMoney);
        lottoGameOutputView.printBuyingLottosCount(lottoGenerator);
        lottoGameOutputView.printGeneratedLottos(lottoGenerator);

        lottoGameInputView.askWinnningLottoNumbers();
        String[] lotto = scanner.next().split(",");
        for(int i = 0; i < lotto.length; i++) {
            inputLotto.add(Integer.parseInt(lotto[i]));
        }
        Collections.sort(inputLotto);

        lottoGameInputView.askBonusLottoNumber();
        int bonusNo = scanner.nextInt();

        WinningLotto winningLotto = new WinningLotto(new Lotto(inputLotto), bonusNo);

        lottoGameOutputView.printResult(new LottoResult(lottoGenerator.getGenerateLottos(), winningLotto));
    }
} 
