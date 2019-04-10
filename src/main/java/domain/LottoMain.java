package domain;

import java.util.List;

public class LottoMain {
    public static void main(String[] args){
        UserLottos userLottos = new UserLottos(Console.getInputLottoMoney());
        List<Integer> winningLottoNumber = Console.getWinningLottoNumber();
        int winningLottoBonus = Console.getWinngLottoBonus();
        Util.checkBonusNumber(winningLottoNumber, winningLottoBonus);

        Lotto winningLottoBase = new Lotto(winningLottoNumber);
        WinningLotto winningLotto = new WinningLotto(winningLottoBase, winningLottoBonus);
        userLottos.checkUserLottos(winningLotto);
    }


}
