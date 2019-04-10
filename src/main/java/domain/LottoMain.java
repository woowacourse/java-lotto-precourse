package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LottoMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        String buyToLottoMoeny = sc.nextLine();

        UserLottos userLottos = new UserLottos(buyToLottoMoeny);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumber = sc.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = sc.nextLine();

        String[] winningLottoNumberArray = winningLottoNumber.split(",");
        List<Integer> castedWinningLottoNumber = new ArrayList<>();
        for (String lottoNumber : winningLottoNumberArray){
            castedWinningLottoNumber.add(Integer.parseInt(lottoNumber));
        }

        Lotto winningLottoBase = new Lotto(castedWinningLottoNumber);

        WinningLotto winningLotto = new WinningLotto(winningLottoBase, Integer.parseInt(bonusNumber));

        System.out.println("당첨통계");
        System.out.println("-----");

        userLottos.checkWinningLotto(winningLotto);


    }
}
