package domain;

/**
 * 게임을 하는 플레이 하는 main 공간을 의미하는 객체
 */
public class LottoGame {

    public static void main(String[] arg) {
        Controller controller = new Controller();

        controller.askHowMany();
    }
}
