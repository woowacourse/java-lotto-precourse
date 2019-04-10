package domain.Program.Config;

import domain.Program.Print;

public class Validation {
    public static void checkNumberRange(long value, int min, int max)throws Exception{
        if((value > min) && (value <= max)){
            return;
        }
        Print.getRange();
        throw new Exception("범위를 벗어났습니다.");
    }

    public static void checkNumberRest(long value, int divider)throws Exception{
        if(value%divider==0){
            return;
        }
        Print.getPriceValidation();
        throw new Exception("나누어 떨어지지 않습니다.");
    }

    public static void checkSelfLottoNumber(String value)throws Exception{
        if(value.matches(Constant.LOTTO_REGEX_CHECK)){
            return;
        }
        Print.getLottoInputValidation();
        throw new Exception("형식에 어긋났습니다.");
    }
}
