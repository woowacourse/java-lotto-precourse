package domain;

import lotto.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static constants.ConsoleConstants.*;

public class Console {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int readMoney() throws IOException {
        System.out.println(START_MESSAGE);
        return Integer.parseInt(bufferedReader.readLine());
    }

    public int[] readWinningNumbers() throws IOException {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return Arrays.stream(bufferedReader.readLine().split(REGEX))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int readBonusNumber() throws IOException {
        System.out.println(BONUS_NUMBERS_MESSAGE);
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void writeLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + BUYING_MESSAGE);
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}