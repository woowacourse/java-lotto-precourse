package domain;

import java.util.*;
import java.util.stream.Collectors;

import domain.handler.LottoInputHandler;
import domain.handler.LottoOutputHandler;

public class LottoEvent {

    public static final int LOTTO_PRICE = 1000;

    private final LottoInputHandler lottoInputHandler;
    private final LottoFactory lottoFactory;

    public LottoEvent() {
        lottoInputHandler = new LottoInputHandler();
        lottoFactory = new LottoFactory();
    }

    public void proceed() {
        List<Lotto> purchasedLotto = purchaseLotto();
        WinningLotto winningLotto = createWinningLotto();

        proceedEvent(purchasedLotto, winningLotto);
    }

    private void proceedEvent(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        Map<Rank, Integer> results = doLottoEvent(purchasedLotto, winningLotto);
        int purchaseAmount = purchasedLotto.size() * LOTTO_PRICE;

        showResult(results, purchaseAmount);
    }

    private List<Lotto> purchaseLotto() {
        int purchaseAmount = lottoInputHandler.getPurchaseAmount();
        List<Lotto> purchasedLotto =  purchaseLottoWithPurchaseAmount(purchaseAmount);
        LottoOutputHandler.showPurchasedLotto(purchasedLotto);

        return purchasedLotto;
    }

    private List<Lotto> purchaseLottoWithPurchaseAmount(int purchaseAmount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        int numOfLottoToCreate = purchaseAmount / LOTTO_PRICE;
        while (numOfLottoToCreate > 0) {
            Lotto lotto = lottoFactory.getInstance();
            purchasedLotto.add(lotto);
            numOfLottoToCreate--;
        }

        return Collections.unmodifiableList(purchasedLotto);
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumList = convertIntArrayToList(lottoInputHandler.getWinningNums());
        int bonusNum = lottoInputHandler.getBonusNum(winningNumList);

        return createWinningLottoWithParams(winningNumList, bonusNum);
    }

    private WinningLotto createWinningLottoWithParams(List<Integer> winningNumList, int bonusNum) {
        Lotto winner = lottoFactory.getInstance(winningNumList);

        return new WinningLotto(winner, bonusNum);
    }

    private void showResult(Map<Rank, Integer> results, int purchaseAmount) {
        LottoOutputHandler lottoOutputHandler = new LottoOutputHandler(results);
        lottoOutputHandler.showLottoEventResult();

        lottoOutputHandler.showProfitRate(purchaseAmount);
    }

    private Map<Rank, Integer> doLottoEvent(List<Lotto> purchasedLotto, WinningLotto winningLotto) {
        LottoEventJudge lottoEventJudge = new LottoEventJudge(winningLotto);

        return lottoEventJudge.judgeLottoEvent(purchasedLotto);
    }

    private List<Integer> convertIntArrayToList(int[] winningNums) {
        return Arrays.stream(winningNums).boxed().collect(Collectors.toList());
    }
}
