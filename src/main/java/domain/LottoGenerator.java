package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constant.*;

public class LottoGenerator {
    private static List<Lotto> lottoList;
    private static WinningLotto winningLotto;


    LottoGenerator() {
        lottoList = new ArrayList<>();
    }

    public void GenerateLottoes(int purchaseAmount) {
        int lottoCount = FindLottoCount(purchaseAmount);

        for (int i = 0; i < lottoCount; i++) {
            GenerateLotto();
        }
    }

    private int FindLottoCount(int purchaseAmount) {
        return purchaseAmount / PRIZE_OF_LOTTO;
    }

    private void GenerateLotto() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        lottoList.add(new Lotto(randomNumberGenerator.GenerateRandomNumbers()));
    }

    public void GenerateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    public static WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public static List<Lotto> getLottoList() {
        return lottoList;
    }

}
