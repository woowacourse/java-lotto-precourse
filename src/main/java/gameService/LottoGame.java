package gameService;

import domain.Lotto;
import domain.WinningLotto;
import input.Inputter;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 게임에 하기 위해 필요한 것들(사용자 입력)을 생성하는 객체
 *
 * @version 1.0(2019.04.11)
 * @author jongyoon Kim
 */
public class LottoGame {
    private static Inputter inputter = new Inputter();
    private static LottoCreator lottoCreator = new LottoCreator();
    private static StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();

    public void run(){
        ArrayList<Lotto> userLottoList = createLottoList(inputLottoAmount());
        List<Integer> winningNum = splitWinningNumAndCheckReInput(inputWinningLotto());
        WinningLotto winningLotto = createWinningLotto(winningNum, inputBonusNum(winningNum));
        statisticalAnalyzer.calcWinningStatistical(userLottoList, winningLotto);
    }

    private int inputLottoAmount(){
        return inputter.inputPurchaseAmount();
    }

    private ArrayList<Lotto> createLottoList(int lottoAmount){
        return lottoCreator.purchaseLottoForAmount(lottoAmount);
    }

    private String inputWinningLotto(){
        return inputter.inputWinningNumber();
    }

    private List<Integer> splitWinningNumAndCheckReInput(String winningNum){
        return lottoCreator.splitWinningNumAndCheckingReInput(winningNum);
    }

    private int inputBonusNum(List<Integer> winningNum){
        return inputter.inputBonusNumber(winningNum);
    }

    private WinningLotto createWinningLotto(List<Integer> winningNum, int bonusNum){
        return lottoCreator.createWinningLotto(winningNum, bonusNum);
    }
}
