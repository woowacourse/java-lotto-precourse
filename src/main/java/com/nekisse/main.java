package com.nekisse;

import com.nekisse.domain.*;
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
        Lotto lott = WininngLottoGenerator.createLotto(inputWinningLottoNumbers);
        WinningLotto winningLotto = new WinningLotto(lott, inputBonusNumber);


    }
}
