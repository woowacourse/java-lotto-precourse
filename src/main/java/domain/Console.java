package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Console {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int MINIMUM_LOTTO_PRICE = 1000;

    public static int getInputLottoMoney() {
        Util.printConsole("구입금액을 입력해 주세요.");
        int inputLottoCount = Util.divideThousand(Util.fromStringToInteger(Util.removeBlank(Util.getConsoleInput())));
        if (!Util.isGreaterThanZero(inputLottoCount)) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. " + MINIMUM_LOTTO_PRICE + " 이상 입력해 주세요.");
        }
        return inputLottoCount;
    }

    public static List<Integer> getWinningLottoNumber() {
        Util.printConsole("지난주 당첨 번호를 입력해 주세요.");
        List<Integer> result = new ArrayList<>();
        for (String string : Util.splitStringbyComma(Util.removeBlank(Util.getConsoleInput()))) {
            result.add(Util.fromStringToInteger(string));
        }
        if (result.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_NUMBER_COUNT + "개 필요합니다.");
        }
        Util.checkLottoNumber(result);
        return result;
    }

    public static int getWinngLottoBonus() {
        Util.printConsole("보너스볼을 입력해 주세요.");
        return Util.fromStringToInteger(Util.removeBlank(Util.getConsoleInput()));
    }

    public static void printResult(Map<Rank, Integer> results) {
        for (Map.Entry<Rank, Integer> entry : results.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            Util.printConsole(Util.getRankMessage(rank, count));
        }
    }
}
