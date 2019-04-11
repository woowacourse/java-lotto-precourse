import domain.Lotto;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    public static void main(String[] args) {
        LottoGameInputView lottoGameInputView = new LottoGameInputView();
        LottoGameOutputView lottoGameOutputView = new LottoGameOutputView();
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputLotto = new ArrayList<>();

        lottoGameInputView.askBuyingMoney();
        int buyingMoney = scanner.nextInt();

        lottoGameInputView.askWinnningLottoNumbers();

        lottoGameInputView.askBonusLottoNumber();
        int bonusNo = scanner.nextInt();

    }
} 
