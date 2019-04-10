package util;

import domain.Lotto;

public class PrintUtil {
        public void printPurchaseAmountInputMessage(){
                System.out.println("구입금액을 입력해 주세요.");
        }

        public void printPurchaseConfirmMessage(int numberOfLotto){
                System.out.println(numberOfLotto+"개를 구매했습니다.");
        }

        public void printPurchasedLottoList(Lotto[] lottos){
                for(Lotto lotto : lottos){
                        printPurchasedLotto(lotto);
                }
        }

        public void printLastWeekWinningNumberInputMessage(){
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        }

        public void printBonusBallInputMessage(){
                System.out.println("보너스 볼을 입력해 주세요.");
        }

        public void printWinStatsMessage(){
                System.out.println("\n당첨통계");
                System.out.println("---------");
        }

        private void printPurchasedLotto(Lotto lotto){
                lotto.printNumbers();
        }
}
