package domain;

import javax.xml.transform.Result;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLottos {
    private final int MIN_LOTTO_NUMBER = 1;
    private final int MAX_LOTTO_NUMBER = 45;

    private List<Lotto> userLottos;
    private List<Integer> basicLottoNumbers;
    private Map<Rank, Integer> ResultMap = new TreeMap<>();

    public UserLottos(int lottoCount) {
        Util.printConsole(lottoCount + "개를 구매했습니다.");
        makeLottos(lottoCount);
    }

    private void makeLottos(int lottoCount) {
        userLottos = new ArrayList<>();
         basicLottoNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
        for (int i = 1; i <= lottoCount; i++) {
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
        for (int i = 5; i > 0; i--){
            ResultMap.put(Rank.values()[i],0);
        }

        int getLottoMoney = 0;

        for (Lotto lotto : userLottos){
            lotto.getResultRank(winningLotto);
        }

        Console.printResult(ResultMap);
        Util.printConsole("총 수익률은 " + (float)getLottoMoney/1000/userLottos.size() );
    }

    public int getUserLottosCount() {
        return userLottos.size();
    }
}
