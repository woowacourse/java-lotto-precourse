package domain;

public class UserInputDuplicateNumberException extends UserInputException {
    @Override
    void printErrorMessage() {
        System.out.println("중복된 숫자가 있으면 안됩니다.");
    }
}
