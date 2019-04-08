package domain;


import java.util.ArrayList;
import java.util.List;

/**
 * Lotto Game을 시작하고 끝내기 위한 Class
 */
public class Main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottoList = new ArrayList<Lotto>();
        lottoList = lottoGame.startLottoGame();
        if (lottoList == null) {
            return;
        }
        lottoGame.playLottoGame(lottoList);
    }
}
