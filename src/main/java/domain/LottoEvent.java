package domain;

import domain.handler.LottoInputHandler;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LottoEvent {

    public static final int LOTTO_PRICE = 1000;

    private final LottoInputHandler lottoInputHandler;
    private final LottoFactory lottoFactory;
    private final List<Lotto> lottoList;
    private WinningLotto winningLotto;

    public LottoEvent() {
        lottoInputHandler = new LottoInputHandler();
        lottoFactory = new LottoFactory();
        lottoList = new ArrayList<>();
        winningLotto = null;
    }

    private void buyLotto() {
        int purchaseAmount = lottoInputHandler.getPurchaseAmount();
        buyLottoWithPurchaseAmount(purchaseAmount);
    }

    private void buyLottoWithPurchaseAmount(int purchaseAmount) {
        int numOfLottoToCreate = purchaseAmount / LOTTO_PRICE;
        while (numOfLottoToCreate > 0) {
            Lotto lotto = lottoFactory.getInstance();
            lottoList.add(lotto);
            numOfLottoToCreate--;
        }
    }

    private void createWinningLotto() {
        List<Integer> winningNumList = convertIntArrayToList(lottoInputHandler.getWinningNums());
        int bonusNum = lottoInputHandler.getBonusNum();

        createWinningLottoWithParams(winningNumList, bonusNum);
    }

    private void createWinningLottoWithParams(List<Integer> winningNumList, int bonusNum) {
        Lotto winner = lottoFactory.getInstance(winningNumList);
        winningLotto = new WinningLotto(winner, bonusNum);
    }

    private List<Integer> convertIntArrayToList(int[] winningNums) {
        return Arrays.stream(winningNums).boxed().collect(Collectors.toList());
    }
}
