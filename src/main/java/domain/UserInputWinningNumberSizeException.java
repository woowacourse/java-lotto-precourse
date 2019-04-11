package domain;

/**
 * 당첨 번호 입력에 대한 갯수 예의 처리 클래스 (6개가 아닌시에)
 */
public class UserInputWinningNumberSizeException extends UserInputException {

    @Override
    public void printErrorMessage() {
        System.out.println("로또 번호는 6개를 입력하셔야 합니다.");
    }
}
