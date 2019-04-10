package domain;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        UserLottos userLottos = new UserLottos(Console.getInputLottoMoney()); // 구입금액을 입력받아 로또 구매.
        List<Integer> winningLottoNumber = Console.getWinningLottoNumber(); // 당첨번호를 입력받아 리스트에 저장.
        int winningLottoBonus = Console.getWinngLottoBonus();   // 보너스번호를 입력받고 저장.
        Console.checkBonusNumber(winningLottoNumber, winningLottoBonus); // 당첨번호와 보너스번호가 중복되는지 체크.

        Lotto winningLottoBase = new Lotto(winningLottoNumber); // 당첨번호로 이루어진 로또를 생성.
        WinningLotto winningLotto = new WinningLotto(winningLottoBase, winningLottoBonus); // WinningLotto 인스턴스 생성.
        userLottos.checkUserLottos(winningLotto); // 결과 확인.
    }
}
