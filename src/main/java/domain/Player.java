package domain;

import domain.interfaces.InputValidator;
import domain.interfaces.NumberGenerator;
import domain.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private NumberGenerator numberGenerator;
    private InputValidator inputValidator;
    private UserInterface ui;

    private List<Lotto> lottos;
    private static List<Integer> numbers;

    private int lottoCount = ui.promptPurchaseAmount() / inputValidator.PRICE_PER_LOTTO;

    public Player(NumberGenerator numberGenerator, InputValidator inputValidator, UserInterface ui) {
        this.numberGenerator = numberGenerator;
        this.inputValidator = inputValidator;
        this.ui = ui;
    }

    private boolean isValidPurchaseAmount(int lottocount) {
        if (!inputValidator.isValidPurchaseAmount(lottocount)) {
            return false;
        }
        return true;
    }


    private void generateLotto() {
        for (int i = 0; i < inputValidator.MAX_LOTTO_LENGTH; ++i) {
            int num = numberGenerator.getNumber();
            numbers.add(num);
        }
    }

    public void generateLottoList() {
        while (!isValidPurchaseAmount(lottoCount)) {
            ui.notifyInvalidPurchaseAmount();
            lottoCount = ui.promptBonusNumber() / inputValidator.PRICE_PER_LOTTO;
        }
        numbers = new ArrayList<>();
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            generateLotto();
            lottos.add(new Lotto(numbers));
            numbers.clear();
        }
    }

    public void printLottoList(){
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

}
