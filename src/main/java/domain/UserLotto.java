package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserLotto {

    private static final int LOTTO_PRICE = 1000;

    public int inputPrice(Scanner scanner) {
        while(true){
            System.out.println("구입 금액을 입력해 주세요.");
            String input = scanner.nextLine();
            if(InputException.getInstance().hasBlankException(input) || InputException.getInstance().isNumberFormatException(input)
                || InputException.getInstance().isMinusNumberException(input) || InputException.getInstance().hasNumberOfChiperException(input)){
                continue;
            }
            return Integer.parseInt(input);
        }
    }

    public void assignPurchaseLottoList(int purchasePrice, List<Lotto> purchaseLottoList) {
        int numberOfLotto = purchasePrice / LOTTO_PRICE;
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        for (int i = 0; i < numberOfLotto; i++) {
            Lotto assignLotto = new Lotto(new ArrayList<>());
            assignLotto.assignPurchaserLottoNumber();
            purchaseLottoList.add(assignLotto);
        }
    }

}
