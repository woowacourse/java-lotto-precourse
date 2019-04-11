package domain;

/**
 * 1000원 단위가 아닌 숫자 입력에 대한 예외 처리 클래스
 */
public class UserInputPriceUnitException extends UserInputException {
    private int totalPrice;

    public UserInputPriceUnitException(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public void printErrorMessage() {
        System.out.println("1000원단위로만 입력할 수 있습니다." + totalPrice + "원은 1000원 단위가 아닙니다.");
    }
}
