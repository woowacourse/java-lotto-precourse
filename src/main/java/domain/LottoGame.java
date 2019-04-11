package domain;

public class LottoGame {
    public static void main(String[] args) {
        Player p = new Player(new LottoNumberGenerator(), new InputValidatorImpl(), new ConsoleUserInterface());
        p.playLotto();
    }


}
