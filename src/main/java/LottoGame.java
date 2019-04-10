import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoGame {
    List<Lotto> lottos;
    WinningLotto winningLotto;

    public LottoGame(){
        this.lottos = new ArrayList<>();
    }

    public void gameStart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = sc.nextInt();
        generateLottos(purchaseAmount);
        printLottos();
        System.out.println("지난주 당첨 번호를 입력해주세요");
        String winningNumbers = sc.next();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = sc.nextInt();
        makeWinningLotto(winningNumbers, bonusBall);
        gameResult();
    }

    private void gameResult(){
        List<Integer> matchResult = getMatchResult();
        for (int i = 4; i >= 0; i--){
            Rank rank = Rank.values()[i];
            String result = "(" + rank.getWinningMoney() + "원) - " + matchResult.get(rank.ordinal()) + "개";
            printMatchResult(rank, result);
        }
    }

    private void printMatchResult(Rank rank, String result){
        if (rank == Rank.SECOND){
            result = rank.getCountOfMatch() + "개 일치, 보너스볼 일치 " + result;
            System.out.println(result);
            return;
        }
        result = rank.getCountOfMatch() + "개 일치 " + result;
        System.out.println(result);
    }

    private List<Integer> getMatchResult(){
        int [] matchResult = new int[6];
        for (Lotto lotto : this.lottos){
            Rank result = winningLotto.match(lotto);
            matchResult[result.ordinal()] += 1;
        }
        return Arrays.stream(matchResult).boxed().collect(Collectors.toList());
    }

    private void makeWinningLotto(String winningNumbers, int bonusBall){
        List<Integer> numbers = Arrays.stream(winningNumbers.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);
        this.winningLotto = new WinningLotto(lotto, bonusBall);
    }

    private void printLottos(){
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    private boolean isOverlap(List<Integer> numbers, int number){
        return numbers.stream().anyMatch(s -> s == number);
    }

    private Lotto makeLotto(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            int number = (int) (Math.random() * 45) + 1;
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
