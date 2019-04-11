package domain.Program.Config;

import domain.Program.Print;

import java.util.List;

public class Validation {
    public static void checkNumberRange(long value, int min, int max) throws Exception {
        if ((value >= min) && (value <= max)) {
            return;
        }
        Print.getRange();
        throw new Exception("범위를 벗어났습니다.");
    }

    public static void checkNumberRest(long value, int divider) throws Exception {
        if (value % divider == 0) {
            return;
        }
        Print.getPriceValidation();
        throw new Exception("나누어 떨어지지 않습니다.");
    }

    public static void checkSelfLottoNumber(String value) throws Exception {
        if (value.matches(Constant.LOTTO_REGEX_CHECK)) {
            return;
        }
        Print.getInputFail();
        Print.getLottoInputValidation();
        throw new Exception("형식에 어긋났습니다.");
    }

    public static void checkBonusNumberDuplication(List<Integer> lottoPaper, int bonusNumber) throws Exception {
        if (!lottoPaper.contains(bonusNumber)) {
            return;
        }
        Print.getBonusDuplication();
        throw new Exception("보너스가 당첨번호와 중복입니다.");
    }
}
