/**
 * 우아한테크코스 프리코스 3주차 미션
 * 로또 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 당첨 번호에 대한 처리를 하는 클래스
 */
public class Studio {
    private final int MIN_NUM = 1;                  /* 로또 번호의 최솟값 */
    private final int MAX_NUM = 45;                 /* 로또 번호의 최댓값 */
    private final int COUNT_NUMS = 6;               /* 로또 한 장의 번호 갯수 */

    private WinningLotto winningLotto;
    private Lotto inputLotto;
    private int inputBonusNum;

    public Studio() {

    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public boolean enterWinningNums(String strNums) throws Exception {
        List<String> winningNumStrList = new ArrayList<>(
                Arrays.asList(strNums.replaceAll(" ", "").split(",")));  /* 입력 받은 문자열의 공백 제거, ','로 분리 */
        TreeSet<Integer> winningNumIntSet = new TreeSet<>();                                        /* 트리셋의 중복처리와 정렬 기능 활용 */
        for (String winningNum : winningNumStrList)
            winningNumIntSet.add(Integer.parseInt(winningNum));
        if (winningNumIntSet.size() != COUNT_NUMS)                                                  /* 번호의 갯수가 로또 규칙에 맞지 않을 경우 */
            throw new Exception("번호의 갯수가 맞지 않습니다.");
        if (winningNumIntSet.first() < MIN_NUM || winningNumIntSet.last() > MAX_NUM)                /* 번호의 범위가 로또 규칙에 맞지 않을 경우 */
            throw new Exception("번호의 범위에 맞지 않습니다.");
        inputLotto = new Lotto(new ArrayList<>(winningNumIntSet));
        return true;
    }

    public boolean enterWinningBonus(String strBonus) throws Exception {
        inputBonusNum = Integer.parseInt(strBonus);
        if (inputBonusNum < MIN_NUM || inputBonusNum > MAX_NUM)                                     /* 번호의 범위가 로또 규칙에 맞지 않을 경우 */
            throw new Exception("보너스 볼이 로또 번호의 범위에 맞지 않습니다.");
        return true;
    }

    /**
     * 보너스볼이 당첨번호에 포함되는지 확인하고 없으면 WinningLotto 객체를 생성하는 메소드
     *
     * @return 보너스볼이 포함되면 True, 포함되지 않으면 False
     */
    public boolean containBonusNum() {
        if (inputLotto.contains(inputBonusNum)) {
            System.out.println("보너스 번호가 당첨 번호에 포함됩니다.");
            return true;
        }
        winningLotto = new WinningLotto(inputLotto, inputBonusNum);

        return false;
    }
}
