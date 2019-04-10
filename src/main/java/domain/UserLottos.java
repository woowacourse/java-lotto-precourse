package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLottos {
    private List<Lotto> userLottos = new ArrayList<>();
    private List<Integer> basicLottoNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public UserLottos(String moneyString){
        int buyToLottoCount = Util.divideThousand(Util.fromStringToInteger(moneyString));

        if (buyToLottoCount <= 0){
            throw new IllegalArgumentException(moneyString + "는 유효하지 않은 값입니다.");
        }

        Util.printConsole(buyToLottoCount + "개를 구매했습니다.");
        for (int i = 1; i <= buyToLottoCount; i++) {
            Collections.shuffle(basicLottoNumbers);
            List<Integer> selectedLottoNumbers = new ArrayList<>(basicLottoNumbers.subList(0, 6));
            Collections.sort(selectedLottoNumbers);
            System.out.println(selectedLottoNumbers);
            userLottos.add(new Lotto(selectedLottoNumbers));
        }

    }
    public void checkWinningLotto(WinningLotto winningLotto){
        for (Lotto lotto : userLottos){
            System.out.println(winningLotto.match(lotto).getCountOfMatch());

        }
    }
}
