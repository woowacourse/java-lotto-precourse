package exception;

public class LottoConditionException extends Exception {

    public LottoConditionException() {
        System.out.println("※ 보너스 볼 입력 조건 오류");
        System.out.println("1 이상 45 이하의 자연수만 입력해주세요!");
    }
}
