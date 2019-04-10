package domain;

import java.util.*;

public class Console {
    private final static int LOTTO_NUMBER_COUNT = 6;


    public static int getInputLottoMoney(){
        Util.printConsole("구입금액을 입력해 주세요.");
        int inputLottoCount = Util.divideThousand(Util.fromStringToInteger(Util.getConsoleInput()));
        if (!Util.isGreaterThanZero(inputLottoCount)){
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. 1000원 이상 입력해 주세요.");
        }
        return inputLottoCount;
    }

    public static List<Integer> getWinningLottoNumber(){
        Util.printConsole("지난주 당첨 번호를 입력해 주세요.");
        List<Integer> result = new ArrayList<>();
        for (String string : Util.splitStringbyComma(Util.removeBlank(Util.getConsoleInput()))){
            result.add(Util.fromStringToInteger(string));
        }

        if (result.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호는 " + LOTTO_NUMBER_COUNT + "개 필요합니다.");
        }

        return result;
    }

    public static int getWinngLottoBonus(){
        Util.printConsole("보너스볼을 입력해 주세요.");
        return Util.fromStringToInteger(Util.removeBlank(Util.getConsoleInput()));
    }

    public static void printResult(Map<Rank,Integer> results){
        for(Rank rank : results.keySet()){
            Util.printConsole(rank.getCountOfMatch() + "개 일치("+rank.getWinningMoney()+"원) - " + results.get(rank) + "개");
        }

    }
}
