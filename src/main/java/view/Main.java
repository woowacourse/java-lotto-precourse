package view;

public class Main {

    public static void main (String[] args) {
        UserInput userView = new UserInput();

        try {
            userView.inputMoney();
            userView.displayLotto();
            userView.inputWinningLotto();
            userView.displayRank();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
