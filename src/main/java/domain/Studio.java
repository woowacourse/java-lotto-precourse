package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Studio {
    private final int MIN_NUM = 1;                  /* 로또 번호의 최솟값 */
    private final int MAX_NUM = 45;                 /* 로또 번호의 최댓값 */
    private final int COUNT_NUMS = 6;               /* 로또 한 장의 번호 갯수 */

    private WinningLotto winningLotto;
    private Lotto inputLotto;
    private int inputBonusNum;

    public Studio() {

    }

    public boolean enterWinningNums(String strNums) throws Exception {
        List<String> winningNumStrList = new ArrayList<>(Arrays.asList(strNums.replaceAll(" ", "").split(",")));
        TreeSet<Integer> winningNumIntSet = new TreeSet<>();
        for (String winningNum : winningNumStrList)
            winningNumIntSet.add(Integer.parseInt(winningNum));
        if (winningNumIntSet.size() != COUNT_NUMS)
            throw new Exception("번호의 갯수가 맞지 않습니다.");
        if (winningNumIntSet.first() < MIN_NUM || winningNumIntSet.last() > MAX_NUM)
            throw new Exception("번호의 범위에 맞지 않습니다.");
        inputLotto = new Lotto(new ArrayList<>(winningNumIntSet));
        return true;
    }

    public boolean enterWinningBonus(String strBonus) throws Exception {
        inputBonusNum = Integer.parseInt(strBonus);
        if (inputBonusNum < MIN_NUM || inputBonusNum > MAX_NUM)
            throw new Exception("보너스 볼이 로또 번호의 범위에 맞지 않습니다.");
        return true;
    }

    public boolean containBonusNum() {
        if (inputLotto.contains(inputBonusNum)) {
            System.out.println("보너스 번호가 당첨 번호에 포함됩니다.");
            return true;
        }
        winningLotto = new WinningLotto(inputLotto, inputBonusNum);

        return false;
    }
}

