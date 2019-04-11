package domain;

public class UserInputWinningNumberSizeException extends UserInputException {

    @Override
    public void printErrorMessage() {
        System.out.println("로또 번호는 6개를 입력하셔야 합니다.");
    }
}
