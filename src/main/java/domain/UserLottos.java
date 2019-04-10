package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLottos {
    private List<Lotto> userLottos;
    private List<Integer> basicLottoNumbers;

    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;
    private Map<Rank, Integer> RANK_MAP = new HashMap<>();

    public UserLottos(int lottoCount) {
        Util.printConsole(lottoCount + "개를 구매했습니다.");
        makeLottos(lottoCount);
    }

    private void makeLottos(int buyToLottoCount) {
        userLottos = new ArrayList<>();
        basicLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
        for (int i = 1; i <= buyToLottoCount; i++) {
            List<Integer> selectedLottoNumbers = generateLottoNumber();
            Util.printConsole(selectedLottoNumbers);
            userLottos.add(new Lotto(selectedLottoNumbers));
        }
    }

    private List<Integer> generateLottoNumber() {
        Collections.shuffle(basicLottoNumbers);
        List<Integer> selectedLottoNumbers = new ArrayList<>(basicLottoNumbers.subList(0, 6));
        Collections.sort(selectedLottoNumbers);
        return selectedLottoNumbers;
    }

    public void getResultLottos(WinningLotto winningLotto){
        for (Rank rank : Rank.values()){
            RANK_MAP.put(rank,0);
        }

        int getLottoMoney = 0;
        for (Lotto lotto : userLottos){
            Rank rank = winningLotto.match(lotto);
            getLottoMoney += rank.getWinningMoney();
            RANK_MAP.put(rank, RANK_MAP.get(rank)+1);
        }

        Console.printResult(RANK_MAP);
        Util.printConsole("총 수익률은 " + (float)getLottoMoney/1000/userLottos.size() );
    }

    public int getUserLottosCount() {
        return userLottos.size();
    }
}
