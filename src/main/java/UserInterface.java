import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }
}
