package domain;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * LottoGame 전체를 위한 Class
 */
public class LottoGame {
    /*
     * 로또 게임 시작 후 로또 구매를 위한 메소드
     * 사용자로부터 구입금액을 받아서 그 가격만큼 로또 구매 후 출력
     */
    public List<Lotto> startLottoGame() {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        LottoIO.printPurchase();
        try {
            int price = LottoIO.receivePrice();
            int lottoCount = Calculation.calcLottoCount(price);
            LottoIO.printLottoCount(lottoCount);
            lottoList = buyLotto(lottoCount);
        } catch (IOException e) {
            System.err.println("입력이 잘못 되었습니다. 게임을 종료합니다.");
            return null;
        }
        return lottoList;
    }

    /*
     * 구매 금액에 맞는 개수 만큼 로또 구매하는 메소드
     */
    public List<Lotto> buyLotto(int lottoCount) {
        List<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Lotto.generateRandomNumber());
            lottoList.add(lotto);
            LottoIO.printlottoNumber(lotto.getLotto());
        }
        return lottoList;
    }

    /*
     * 사용자로부터 당첨 번호와 보너스 번호를 받아 당첨 결과 출력
     */
    public void playLottoGame(List<Lotto> lottoList) {
        try {
            List<Integer> winningLottoNumberList = LottoIO.receiveWinningLotto();
            int bonusNumber = LottoIO.receiveBonusNumber(winningLottoNumberList);
            LottoIO.checkInvalidInput(bonusNumber);
            Lotto lotto = new Lotto(winningLottoNumberList);
            WinningLotto winningLotto = new WinningLotto(lotto,bonusNumber);
            LottoIO.printLottoResult(lottoList, winningLotto);
        } catch(IOException e){
            System.err.println("입력이 잘못 되었습니다. 게임을 종료합니다.");
            return;
        }
    }
}
