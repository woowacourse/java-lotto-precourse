package com.nekisse;

import com.nekisse.domain.*;
import com.nekisse.generator.LottoRandomNumberGenerator;
import com.nekisse.generator.WinningLottoGenerator;
import com.nekisse.view.InputView;
import com.nekisse.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int inputAmount = InputView.getInputAmount();
        Money money = new Money(inputAmount);

        LottoMachine lottoMachine = new LottoMachine(new LottoRandomNumberGenerator());
        UserLottos userLottos = lottoMachine.buyLotto(money);
        OutputView.PrintUserBuyLottos(userLottos, money);

        String inputWinningLottoNumbers = InputView.getInputWinningLottoNumbers();
        LottoNumber inputBonusNumber = InputView.getInputBonusWinningLottoNumber();
        Lotto lotto = WinningLottoGenerator.createLotto(inputWinningLottoNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto, inputBonusNumber);
        LottoResult lottoResult = new LottoResult(winningLotto, userLottos);
        OutputView.printResult(lottoResult);
    }
}
