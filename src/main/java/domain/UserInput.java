/*
 * UserInput
 *
 * version 1.1
 *
 * 2019/04/10
 *
 *  */

package domain;

import java.util.Scanner;

/**
 * 로또 번호를 발급받기 위해 사용자로부터 구입 금액을 입력받는 클래스
 *
 * @author 김성훈
 * @version 1.1 2019/04/10  사용자의 입력을 받는다. 1000원 단위의 숫자만 입력가능하며 그 외 경우는 예외처리한다.
 */
public class UserInput {
    private static final int PRICE_PER_LOTTO = 1000;

    private Scanner sc = new Scanner(System.in);

    public int inputTotalPrice() {
        try {
            int totalPrice = inputPrice();
            checkPriceUnit(totalPrice);
            return totalPrice;
        } catch (UserInputException e) {
            e.printErrorMessage();
            return inputTotalPrice();
        }
    }

    private int inputPrice(){
        try {
            System.out.println("구입금액을 입력하세요.");
            return Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            throw new UserInputMismatchException();
        }
    }

    private void checkPriceUnit(int totalPrice) {
        if ((totalPrice % PRICE_PER_LOTTO) != 0) {
            throw new UserInputPriceUnitException(totalPrice);
        }
    }
}
