package view;

/**
 * 프로그램 메인 클래스
 */
public class Main {

    public static void main (String[] args) {
        UserView userView = new UserView();

        try {
            userView.inputMoney();
            userView.displayLotto();
            userView.inputWinningLotto();
            userView.displayStats();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
