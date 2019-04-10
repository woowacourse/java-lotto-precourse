/*
 * AppMain
 *
 * version 1.0
 *
 * 2019/04/10
 */

package domain;

/**
 * 로또 어플리케이션이 실행되는 클래스
 *
 * @author 김성훈
 * @version 1.0
 */
public class AppMain {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        userInput.inputTotalPrice();
    }
}
