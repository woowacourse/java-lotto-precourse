package domain;

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
