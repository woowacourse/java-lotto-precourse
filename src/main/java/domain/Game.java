package domain;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Lotto> userLottoTickets;
    PickingNumbers pickingNumbers;
    WinningLotto winningLotto;
    List<Rank> ranks;
    Profit profit;
    int[] countRanks;
    private int money;

    private static final int lottoPrice = 1000;
    private static final int numberOfRanks = 6;


    public Game(){
        userLottoTickets = new ArrayList<Lotto>();
        pickingNumbers = new PickingNumbers();
        ranks= new ArrayList<Rank>();
        countRanks = new int[numberOfRanks];
    }

    public void inputUserLotto(){
        this.money = Display.inputMoney();
        int sizeOfLottoTickets = money / lottoPrice;
        makeUserLotto(sizeOfLottoTickets);
        Display.showBoughtLotto(userLottoTickets);
    }

    public void makeUserLotto(int sizeOfLottoTickets){
        for(int i = 0; i < sizeOfLottoTickets; i++){
            pickingNumbers.shuffle();
            ArrayList<Integer> tmp =  new ArrayList<Integer>(pickingNumbers.get());
            Lotto lotto = new Lotto(tmp);
            userLottoTickets.add(lotto);
        }
    }

    public void inputWinningLotto(){
        List<Integer> lastWeekWinningNumbers = Display.inputLastWeekWinningNumbers();
        int bonusNo = Display.inputBonusNumber();
        makeWinningLotto(lastWeekWinningNumbers, bonusNo);
    }

    public void makeWinningLotto(List<Integer> lastWeekWinningNumbers, int bonusNo){
        winningLotto = new WinningLotto( new Lotto(lastWeekWinningNumbers), bonusNo);
    }

    public void calculateRank(){
        for(int i = 0; i < userLottoTickets.size(); i++){
            Rank rank = winningLotto.match(userLottoTickets.get(i));
            int index = rank.ordinal();
            System.out.println("index: " + index);
            countRanks[index]++;
            ranks.add(rank);
        }
    }

    public void initGame(){
        inputUserLotto();;
        inputWinningLotto();
        calculateRank();
        for(int i : countRanks)
            System.out.println(i);
        Display.showStatistics(countRanks, Rank.values());
        Display.showProfitRate(countRanks, money);
    }
}
