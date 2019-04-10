package domain;

import java.util.List;

/*
 * 당첨 통계와 수익률을 찾는 객체
 */
public class LottoGameManager {

	public static void main(String[] args) {
		List<Lotto> userLottos = new LottoGenerator().generateUserLottos();
		WinningLotto winningLotto = new WinningLottoGenerator().generateWinningLotto();
	}

}
