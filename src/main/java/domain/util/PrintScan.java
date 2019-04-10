package domain.util;

import domain.Lotto;
import domain.Game;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
public class PrintScan {
    private static Scanner scan = new Scanner(System.in);

    public static int requesetInputMoney () {
        System.out.format("로또를 구매할 금액을 입력해 주세요. 로또는 장당 %d원 입니다.%n",Constant.MIN_INPUT_MONEY);
        return Integer.parseInt(scan.nextLine());
    }

    public static void printOutofRangeNotice(){
        System.out.format("%d이상 %d이하의 숫자를 입력해 주세요.%n",Constant.MIN_INPUT_MONEY,Constant.MAX_INPUT_MONEY);
    }

    public static void printRestMoney(int restMoney){
        System.out.format("%d원의 거스름돈이 남았습니다.%n",restMoney);
    }

    public static void  printUserLottoInformation(List <Lotto> lottos,int numberOfLotto){
        System.out.format("%d장의 로또를 구입했습니다.%n",numberOfLotto);
        System.out.println("----------------------");
        for (int i = 0; i < numberOfLotto; i++){
            String lottoNumberString = lottos.get(i).getLottoNum().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(lottoNumberString);
        }
    }
}
