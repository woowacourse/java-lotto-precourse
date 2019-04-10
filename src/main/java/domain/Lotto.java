package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    public final static int oneLottoAmount = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){ return this.numbers;}

    public void PrintLottoNum(){
        System.out.print("[");
        for (int i = 0; i < oneLottoAmount-1; i++) {
            System.out.print(numbers.get(i)+",");
        }
        System.out.print(numbers.get(oneLottoAmount-1));
        System.out.println("]");
    }

    public int IsIncludeWinNumber(int winningNumber) {
        if(numbers.contains(winningNumber))
            return 1;
        return 0;
    }

    public boolean IsIncludeBonusNumber(int bonusNum){
        if(numbers.contains(bonusNum))
            return true;
        return false;
    }
    // 추가 기능 구현
}
