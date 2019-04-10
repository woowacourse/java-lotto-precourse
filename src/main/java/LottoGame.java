import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
    List<Lotto> lottos;

    public LottoGame(){
        this.lottos = new ArrayList<>();
    }

    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = sc.nextInt();
        generateLottos(purchaseAmount);
    }

    private boolean isOverlap(List<Integer> numbers, int number){
        return numbers.stream().anyMatch(s -> s == number);
    }

    private Lotto makeLotto(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            int number = (int) Math.random() * 45 + 1;
            if (isOverlap(numbers, number)){
                i--;
                continue;
            }
            numbers.add(number);
        }
        return new Lotto(numbers);
    }

    private void generateLottos(int purchaseAmount){
        int lottoAmount = purchaseAmount / 1000;
        for (int i = 0; i < lottoAmount; i++) {
            this.lottos.add(makeLotto());
        }
    }
}
