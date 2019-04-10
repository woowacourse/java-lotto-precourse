package util;

import domain.Lotto;

public class PrintUtil {
        public void printPurchaseInputMessage(){
                System.out.println("구입금액을 입력해 주세요.");
        }

        public void printPurchaseConfirmMessage(int numberOfLotto){
                System.out.println(numberOfLotto+"개를 구매했습니다.");
        }

        public void printPurchasedLotto(Lotto lotto){
                String message = lotto.getNumbers().toString();
                System.out.println(message);
        }
}
