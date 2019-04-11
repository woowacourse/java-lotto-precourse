package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoManager {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBER = 6;

    public Lotto generateLotto() {
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i< NUMBER_OF_LOTTO_NUMBER; i++) {
            sequence.add(getUniqueRandomInt(sequence));
        }
        Collections.sort(sequence);
        return new Lotto(sequence);
    }

    private Integer getUniqueRandomInt(List<Integer> sequence) {
        int randomInt;
        do {
            randomInt = getRandomInt();
        } while (sequence.contains(randomInt));
        return randomInt;
    }

    private int getRandomInt() {
        Random random = new Random();
        return (random.nextInt(MAX_LOTTO_NUMBER + 1 - MIN_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
    }

    public void validateWinningLotto(ArrayList<Integer> winningLotto) throws Exception{
        int removedNum;
        validateWinningLottoSize(winningLotto);
        while (!winningLotto.isEmpty()) {
            removedNum = winningLotto.remove(0);
            validateLottoNumRange(removedNum);
            validateUniqueLottoNum(removedNum, winningLotto);
        }
    }

    private void validateWinningLottoSize(List<Integer> winningLotto) throws Exception {
        if (winningLotto.size() != NUMBER_OF_LOTTO_NUMBER) {
            throw new Exception(String.format("%d개의 당첨번호를 ,로 구분하여 입력하세요", NUMBER_OF_LOTTO_NUMBER));
        }
    }

    private void validateLottoNumRange(int num) throws Exception {
        if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
            throw new Exception(String.format("로또 번호의 범위는 %d~%d 입니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    private void validateUniqueLottoNum(int num, List<Integer> winningLotto) throws Exception {
        if (winningLotto.contains(num)) {
            throw new Exception("중복되지 않는 번호를 입력하세요.");
        }
    }

    public void validateBonusNum(int bonus, List<Integer> winningNums) throws Exception {
        validateLottoNumRange(bonus);
        validateUniqueLottoNum(bonus, winningNums);
    }
}
