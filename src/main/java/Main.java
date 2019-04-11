/**
 * class : Main.class
 *
 * version : 1.0.0
 *
 * date : 2019.04.11
 *
 * author : icarus8050
 */

/**
 * 로또 게임의 시작 클래스
 */
public class Main {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.run();
        game.closeGame();
    }
}
