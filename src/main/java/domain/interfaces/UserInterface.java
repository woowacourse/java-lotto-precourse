package domain.interfaces;

import domain.Lotto;
import domain.Rank;

import java.util.InputMismatchException;
import java.util.List;

public interface UserInterface {

    int promptTotalPrice() throws InputMismatchException;
    List<Integer> promptWinningNumbers() throws NumberFormatException;
    int promptBonusNumber() throws InputMismatchException;

    void printBoughtLottos(List<Lotto> lottos);
    /**
     * 구체 클래스인 WinningStatistics 보다는 자료구조에 가까운
     * Rank 객체를 전달하는 것이 loose coupling 측면에서 좋을 것으로 판단하였습니다.
     * @param r 당첨 등수
     * @param wins 당첨 횟수
     */
    void printRank(Rank r, int wins);
    void printEarningRate(double earningRate);
    void notifyInvalidInput();
}
