package domain;

public class AppMain {

    public static void main(String[] args) {
        new Player(
            new RandomLottoNumberGenerator(),
            new ConsoleUserInterface()
        ).play();
    }
}
