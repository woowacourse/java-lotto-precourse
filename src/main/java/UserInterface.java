import domain.Lotto;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }
}
