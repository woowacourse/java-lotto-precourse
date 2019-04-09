package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoGame {

    static List<Lotto> lottoList;
    static WinningLotto winningLotto;

    private void createLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> createdLottoList = new LinkedList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto createdLotto = Lotto.createRandomLotto();
            createdLottoList.add(createdLotto);
        }
        lottoList = createdLottoList;
    }

    private void printLottos() {
        for (int i = 0; i < lottoList.size(); i++) {
            lottoList.get(i).printLottoNumbers();
        }
    }

    private Map<Rank, Integer> calculateLottoMatch() {
        Map<Rank, Integer> rankCounter = createSortAppliedRankCounter();
        addAllRankTypes(rankCounter);

        for (int i = 0; i < lottoList.size(); i++) {
            Rank rank = winningLotto.match(lottoList.get(i));
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
        return rankCounter;
    }

    /**
     * TreeMap을 생성해 반환합니다. TreeMap은 key(Rank)가 countOfMatch의 내림차순으로 정렬하기로
     * 약속되어있습니다. 이렇게 하는 이유는, 앞으로 여러 Rank가 추가되더라도 Rank.java 에만 그 종류를
     * 추가하면 Rank별로 print할때 자동으로 정렬이 되어 print되도록 하기 위함입니다.
     *
     * @return Map<Rank, Integer> 랭크별로 갯수를 세는데 이용되는 Map 반환
     */
    private Map<Rank, Integer> createSortAppliedRankCounter() {
        Map<Rank, Integer> rankSortedMap = new TreeMap<Rank, Integer>((Rank a, Rank b) -> {
            if (a.getWinningMoney() != b.getWinningMoney()) {
                return (a.getWinningMoney() < b.getWinningMoney()) ? -1 : 1;
            }

            return 0;
        });
        return rankSortedMap;
    }

    /**
     * rankCounter를 입력받아, 모든 종류의 Rank를 미리 입력해놓는 함수입니다.
     *
     * @return Map<Rank, Integer>
     */
    private void addAllRankTypes(Map<Rank, Integer> rankCounter) {
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }
}
