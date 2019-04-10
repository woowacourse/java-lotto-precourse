package domain.Program.Config;

public class Validation {
    public static void checkNumberRange(long value, int min, int max)throws Exception{
        if((value > min) && (value <= max)){
            return;
        }
        System.out.println("범위를 벗어난 금액입니다.");
        throw new Exception("범위를 벗어났습니다.");
    }

    public static void checkNumberRest(long value, int divider)throws Exception{
        if(value%divider==0){
            return;
        }
        System.out.println("1000단위로 입력해주세요");
        throw new Exception("나누어 떨어지지 않습니다.");
    }

    public static void checkSelfLottoNumber(String value)throws Exception{
        if(value.matches(Constant.LOTTO_REGEX_CHECK)){
            return;
        }
        System.out.println("형식에 맞추어 작성해주세요. ex)1,2,3,4,5,6");
        throw new Exception("잘 작성하세요");
    }
}
