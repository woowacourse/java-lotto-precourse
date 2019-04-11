package domain;

import lotto.Lotto;
import lotto.Rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static constants.ConsoleConstants.*;

public class Console {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int readMoney() throws IOException {
        System.out.println(START_MESSAGE);
        return Integer.parseInt(bufferedReader.readLine());
    }

    public int[] readWinningNumbers() throws IOException {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String readMassage = bufferedReader.readLine().replaceAll(REGEX,"");
        return Arrays.stream(readMassage.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int readBonusNumber() throws IOException {
        System.out.println(BONUS_NUMBERS_MESSAGE);
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void writeLottos(List<Lotto> lottos) {
        System.out.println(ENTER + lottos.size() + BUYING_MESSAGE);
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void writeResult(TreeMap<Rank, Long> stats) {
        System.out.println(RESULT_MASSAGE);

        stats.forEach((rank, count) -> System.out.println(resultForm(rank, count)));

        System.out.println(RESULT_RATE_MESSAGE + new State().returnOfRate(stats) + RESULT_RATE_END_MESSAGE);
    }

    private String resultForm(Rank rank, long count) {
        if (rank == Rank.MISS) {
            return "";
        }
        StringBuilder form = new StringBuilder(rank.getCountOfMatch() + RESULT_MATCH_COUNT);

        if (rank == Rank.SECOND) {
            form.append(RESULT_BONUS);
        }
        form.append(RESULT_OPEN_BRACKET + rank.getWinningMoney() + RESULT_WON + RESULT_CLOSE_BRACKET + count + RESULT_COUNT);
        return form.toString();
    }
}