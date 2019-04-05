package view;

public class Main {

    public static void main (String[] args) {
        UserInput userView = new UserInput();

        try {
            userView.inputMoney();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
