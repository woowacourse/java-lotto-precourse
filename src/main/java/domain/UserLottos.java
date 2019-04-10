package domain;

import java.util.*;

/**
 * 유저가 구매한 로또들을 관리하는 객체.
 */
public class UserLottos {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Lotto> userLottos;
    private List<Integer> lottoNumberPool;
    private Map<Rank, Integer> ResultMap = new LinkedHashMap<>(); // <Rank, 당첨횟수>

    public UserLottos(int lottoCount) {
        Util.printConsole(lottoCount + "개를 구매했습니다.");
        makeLottos(lottoCount);
    }

    private void makeLottos(int lottoCount) {
        userLottos = new ArrayList<>();
        //1부터 45까지 숫자를 풀에 담아놓는다.
        lottoNumberPool = Console.makeLottoNumberPool();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> selectedLottoNumbers = generateLottoNumber();
            Util.printConsole(selectedLottoNumbers);
            userLottos.add(new Lotto(selectedLottoNumbers));
        }
    }

    private List<Integer> generateLottoNumber() {
        Collections.shuffle(lottoNumberPool);
        List<Integer> selectedLottoNumbers = new ArrayList<>(lottoNumberPool.subList(0, LOTTO_NUMBER_COUNT));
        Collections.sort(selectedLottoNumbers);
        return selectedLottoNumbers;
    }

    public void checkUserLottos(WinningLotto winningLotto) {
        makeResultMap();
        int matchedLottoMoney = getResultUserLottosToMap(winningLotto);

        Console.printResult(ResultMap);
        Util.printConsole("총 수익률은 " + (float) matchedLottoMoney / 10 / getUserLottosCount() + "%입니다.");
    }

    private void makeResultMap() {
        // Rank는 FIRST부터 기술되어 있다. 당첨금이 낮은순으로 출력해야 하므로 순서를 거꾸로 ResultMap에 넣는다.
        for (int i = 5; i >= 0; i--) {
            ResultMap.put(Rank.values()[i], 0);
        }
    }

    private int getResultUserLottosToMap(WinningLotto winningLotto) {
        int matchedMoney = 0;
        for (Lotto lotto : userLottos) {
            Rank rank = lotto.getResultRank(winningLotto);
            Integer count = ResultMap.get(rank);
            matchedMoney += rank.getWinningMoney();
            ResultMap.put(rank, count + 1);
        }
        ResultMap.remove(Rank.MISS);
        return matchedMoney;
    }

    private int getUserLottosCount() {
        return userLottos.size();
    }
}
