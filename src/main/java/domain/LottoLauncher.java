package domain;

import java.util.List;

public class LottoLauncher {
    public static void main(String[] args) {
        doGame();
    }

    private static void doGame() {
        String userInputMoneyAmount = Lotto.askUserMoneyAmount();
        List<Lotto> listOfUserLottos = makeListOfLottosAndPrint(userInputMoneyAmount);
        WinningLotto winningLotto = makeWinningLotto();
        calculateStatisticsAndPrint(userInputMoneyAmount, listOfUserLottos, winningLotto);
    }

    private static List<Lotto> makeListOfLottosAndPrint(String userInputMoneyAmount) {
        List<Lotto> listOfUserLottos = Lotto.makeListOfUserLottos(userInputMoneyAmount);
        Lotto.printLottos(listOfUserLottos);
        return listOfUserLottos;
    }

    private static WinningLotto makeWinningLotto() {
        String winningNumbers = WinningLotto.askUserWinningNumbers();
        int bonusNumber = WinningLotto.askUserBonusNumber(winningNumbers);
        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }

    private static void calculateStatisticsAndPrint(String userInputMoneyAmount, List<Lotto> listOfUserLottos, WinningLotto winningLotto) {
        List<Rank> listOfUserLottosRanks = WinningLotto.createListOfUserLottosRanks(winningLotto, listOfUserLottos);
        List<Rank> listOfRanksInOrder = Lotto.makeListOfRanksInOrder();
        List<Integer> listOfRankOccurences = Lotto.makeListOfRankOccurences(listOfRanksInOrder, listOfUserLottosRanks);
        Lotto.printStatistics(listOfRanksInOrder, listOfRankOccurences);
        Lotto.printProfitRate(userInputMoneyAmount, listOfUserLottosRanks);
    }
}
