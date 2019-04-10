package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLottos {
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private final int LOTTO_NUMBER_COUNT = 6;

    private List<Lotto> userLottos;
    private List<Integer> basicLottoNumbers;
    private Map<Rank, Integer> ResultMap = new LinkedHashMap<>();

    public UserLottos(int lottoCount) {
        Util.printConsole(lottoCount + "개를 구매했습니다.");
        makeLottos(lottoCount);
    }

    private void makeLottos(int lottoCount) {
        userLottos = new ArrayList<>();
        basicLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> selectedLottoNumbers = generateLottoNumber();
            Util.printConsole(selectedLottoNumbers);
            userLottos.add(new Lotto(selectedLottoNumbers));
        }
    }

    private List<Integer> generateLottoNumber() {
        Collections.shuffle(basicLottoNumbers);
        List<Integer> selectedLottoNumbers = new ArrayList<>(basicLottoNumbers.subList(0, LOTTO_NUMBER_COUNT));
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
