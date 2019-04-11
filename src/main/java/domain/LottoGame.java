package domain;

import domain.util.UserInput;

import java.util.*;

public class LottoGame {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int PRIZE_OF_BONUS = 30000000;

    private List<Lotto> lottos;
    private WinningLotto winningLotto;
    private LottoManager lottoManager = new LottoManager();

    public void start() {
        setLottoList(getNumOfLottos());
        setWinningLotto();
        Map<Rank, Integer> winningStatic = new HashMap<>();
        setWinningStatic(winningStatic);
        printWinningStatic(winningStatic);
        printEarningRate(winningStatic);
    }

    private int getNumOfLottos() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = getPurchaseAmount();
        int change = purchaseAmount % PRICE_OF_LOTTO;
        if (change != 0) {
            System.out.println(String.format("거스름돈은 %d원 입니다.", change));
        }
        return (purchaseAmount / PRICE_OF_LOTTO);
    }

    private int getPurchaseAmount() {
        int purchaseAmount = UserInput.getInteger();
        if (purchaseAmount < PRICE_OF_LOTTO) {
            System.out.println(String.format("로또 한장의 금액(%d원) 이상을 입력하세요", PRICE_OF_LOTTO));
            return getPurchaseAmount();
        }
        return purchaseAmount;
    }

    private void setLottoList(int numOfLottos) {
        lottos = new ArrayList<>();
        LottoManager lottoManager = new LottoManager();
        for (int i = 0; i < numOfLottos; i++) {
            lottos.add(lottoManager.generateLotto());
        }
        System.out.println(String.format("\n%d개를 구매했습니다.", numOfLottos));
        printLottos();
    }

    private void printLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private void setWinningLotto() {
        List<Integer> winningNums = new ArrayList<>();
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        winningNums.addAll(getWinningNums());
        System.out.println("보너스 볼을 입력해 주세요.");
        winningLotto = new WinningLotto(new Lotto(winningNums), getBonusNumber(winningNums));
    }

    private List<Integer> getWinningNums() {
        List<Integer> winningNums = new ArrayList<>();
        try {
            winningNums.addAll(stringListToIntegerList(getSequence(UserInput.getString())));
            lottoManager.validateWinningLotto(new ArrayList<>(winningNums));
            return winningNums;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getWinningNums();
        }
    }

    private List<String> getSequence(String userInput) throws Exception {
        String delimeter = ",";
        validateSequenceSyntax(userInput, delimeter);
        return Arrays.asList(userInput.split(delimeter));
    }

    private void validateSequenceSyntax(String string, String delimeter) throws Exception {
        int delimeterCount = string.length() - string.replace(delimeter, "").length();
        if ((delimeterCount + 1) != Arrays.asList(string.split(delimeter)).size()) {
            throw new Exception(",로 구분하는 수열을 입력하세요");
        }
    }

    private Collection<? extends Integer> stringListToIntegerList(List<String> stringList) throws Exception{
        List<Integer> integerList = new ArrayList<>();
        for(String string : stringList) {
            integerList.add(stringToInteger(string));
        }
        return integerList;
    }

    private Integer stringToInteger(String string) throws Exception{
        try{
            return Integer.valueOf(string);
        } catch (Exception e) {
            throw new Exception("정수값이 아닙니다");
        }
    }

    private int getBonusNumber(List<Integer> winningNums) {
        int bonus = UserInput.getInteger();
        try {
            lottoManager.validateBonusNum(bonus, winningNums);
            return bonus;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNums);
        }
    }

    private void setWinningStatic(Map<Rank, Integer> winningStatic) {
        Rank rank;
        for (Lotto lotto : lottos) {
            rank = winningLotto.match(lotto);
            winningStatic.put(rank, winningStatic.getOrDefault(rank, 0) + 1);
        }
    }

    private void printWinningStatic(Map<Rank, Integer> winningStatic) {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);

        System.out.println("\n당첨 통계\n---------");
        for (Rank rank : ranks) {
            printRankString(rank, winningStatic.getOrDefault(rank, 0));
        }
    }

    private void printRankString(Rank rank, Integer winningNumber) {
        String bonus = " ";
        if (rank.getCountOfMatch() == 0) {
            return;
        }
        if (rank.getWinningMoney() == PRIZE_OF_BONUS) {
            bonus = ", 보너스 볼 일치";
        }
        System.out.println(String.format("%d개 일치%s(%d원)- %d개", rank.getCountOfMatch(), bonus, rank.getWinningMoney(), winningNumber));
    }

    private void printEarningRate(Map<Rank, Integer> winningStatic) {
        float expenses = 0;
        float earnings = 0;
        for (Rank rank : winningStatic.keySet()) {
            expenses += PRICE_OF_LOTTO * winningStatic.get(rank);
            earnings += rank.getWinningMoney() * winningStatic.get(rank);
        }
        System.out.println(String.format("총 수익률은 %f입니다.", (earnings / expenses)));
    }

}
