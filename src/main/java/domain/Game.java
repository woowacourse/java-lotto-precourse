package domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Lotto> userLottoTickets;
    private WinningLotto winningLotto;
    private int money;

    private static final int lottoPrice = 1000;
    private static final int numberOfRanks = 6;


    public Game() {
        userLottoTickets = new ArrayList<>();
        PickingNumbers.fill();
    }

    public void inputUserLotto() {
        this.money = Display.inputMoney();
        int sizeOfLottoTickets = money / lottoPrice;
        makeUserLotto(sizeOfLottoTickets);
        Display.showBoughtLotto(userLottoTickets);
    }

    public void makeUserLotto(int sizeOfLottoTickets) {
        for (int i = 0; i < sizeOfLottoTickets; i++) {
            PickingNumbers.shuffle();
            ArrayList<Integer> tmp = new ArrayList<Integer>(PickingNumbers.getSix());
            Lotto lotto = new Lotto(tmp);
            userLottoTickets.add(lotto);
        }
    }

    public void inputWinningLotto() {
        List<Integer> lastWeekWinningNumbers = Display.inputLastWeekWinningNumbers();
        int bonusNo = Display.inputBonusNumber();
        makeWinningLotto(lastWeekWinningNumbers, bonusNo);
    }

    public void makeWinningLotto(List<Integer> lastWeekWinningNumbers, int bonusNo) {
        winningLotto = new WinningLotto(new Lotto(lastWeekWinningNumbers), bonusNo);
    }

    public void calculateRank() {
        Profit.initMap();
        for (int i = 0; i < userLottoTickets.size(); i++) {
            Rank rank = winningLotto.match(userLottoTickets.get(i));
            Profit.addUserRanks(rank);
        }
        Profit.calculateRank();
    }

    public void displayResults(){
        Display.showStatistics();
        Display.showProfitRate(money);
    }

    public void initGame() {
        inputUserLotto();
        inputWinningLotto();
        calculateRank();
        Profit.printCountRanks();
        displayResults();
    }
}
