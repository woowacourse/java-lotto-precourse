package domain.validator;

import java.util.List;

public class BonusNumValidator implements Validator {

    private final String bonusNum;
    private final List<Integer> winningNumList;

    public BonusNumValidator(String bonusNum, List<Integer> winningNumList) {
        this.bonusNum = bonusNum;
        this.winningNumList = winningNumList;
    }

    @Override
    public boolean doesValid() {
        return doesBonusNumInputIsValid()
                && doesBonusNumIsValid()
                && doesBonusNumIsNotDuplicate();
    }

    boolean doesBonusNumInputIsValid() {
        return new LottoInputValidator(bonusNum).doesValid();
    }

    boolean doesBonusNumIsValid() {
        return new LottoNumValidator(bonusNum).doesValid();
    }

    boolean doesBonusNumIsNotDuplicate() {
        return !winningNumList.contains(convertStringToInt(bonusNum));
    }

    private int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
}
