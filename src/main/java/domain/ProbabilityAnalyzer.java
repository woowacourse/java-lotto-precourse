package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 생성된 로또들의 확률을 구하는 객
 *
 * @version 1.0(2019.04.10)
 * @author jongyoon Kim
 */
public class ProbabilityAnalyzer {
    private static Inputter inputter = new Inputter();
    private static LottoCreator lottoCreator = new LottoCreator();

    public static void main(String[] args) {
        ProbabilityAnalyzer probabilityAnalyzer = new ProbabilityAnalyzer();
        probabilityAnalyzer.ProbabilityAnalyze();
    }

    public void ProbabilityAnalyze(){
        ArrayList<Lotto> lottoList = inputLottoAmountAndCreateLottoList();
        WinningLotto winningLotto = inputWinningNumAndCreateWinningLotto();
        for(Lotto lotto : lottoList){
            Rank rank = winningLotto.match(lotto);
        }
    }

    private ArrayList<Lotto> inputLottoAmountAndCreateLottoList(){
        int lottoAmount = inputter.inputPurchaseAmount();
        return lottoCreator.purchaseLottoForAmount(lottoAmount);
    }

    private WinningLotto inputWinningNumAndCreateWinningLotto(){
        String inputtedWinningNum = inputter.inputWinningNumber();
        List<Integer> splittedWinningNum = lottoCreator.splitWinningNumAndCheckingReInput(inputtedWinningNum);
        int bonusNum = inputter.inputBonusNumber(splittedWinningNum);
        return lottoCreator.createWinningLotto(splittedWinningNum, bonusNum);
    }
}
