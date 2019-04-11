package domain;


import java.util.ArrayList;
import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(int matchValue,boolean includeSecond) {

        return Rank.valueOf(matchValue,includeSecond);
    }

    private List<Integer> getMatchCountOfLottos(List<Lotto> userLottoList){

        int correctNumber;
        List<Integer> correctAmountList = new ArrayList<>();

        for (Lotto lotto1 : userLottoList) {

            correctNumber = getCountOfMatch(lotto1.catchLotto());
            correctAmountList.add(correctNumber);
        }
        return correctAmountList;
    }

    private int getCountOfMatch(List<Integer> lottoNumberList){

        int correctNumber = 0;
        for (Integer integer : lottoNumberList) {

            correctNumber = increaseMatchRight(integer, correctNumber);
        }
        return correctNumber;
    }

    private int increaseMatchRight(int value, int correctAmount){

        if(lotto.catchLotto().contains(value)){

            correctAmount++;
        }
        return correctAmount;
    }

    private boolean checkBonusNumberCorrect(List<Integer> lottoNumberList, int bonusNumber){

        boolean findSecondState = false;
        if(lottoNumberList.contains(bonusNumber)){

            findSecondState = true;
        }
        return findSecondState;
    }

    private List<Rank> saveCoincideLotto(WinningLotto winnerLotto, List<Lotto> lottoList){

        List<Rank> rankList = new ArrayList<>();
        for(int i=0;i<lottoList.size();i++){

            Integer countOfMatch = winnerLotto.getMatchCountOfLottos(lottoList).get(i);
            boolean isBonusNumberRight = checkBonusNumberCorrect(lottoList.get(i).catchLotto(), winnerLotto.bonusNo);
            rankList.add(match(countOfMatch, isBonusNumberRight));
        }
        return rankList;
    }

    private int calculateEarnMoney(List<Rank> rankList){

        int earnMoney = 0;
        for (Rank rank : rankList) {

            earnMoney += rank.getWinningMoney();
        }
        return earnMoney;
    }

    private void printLottoRank(List<Rank> rankList,int earnMoney, int spendMoney) {

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) -" + calculateFifthRank(rankList));
        System.out.println("4개 일치 (50000원) -" + calculateFourthRank(rankList));
        System.out.println("5개 일치 (1500000원) -" + calculateThirdRank(rankList));
        System.out.println("5개 일치 보너스 번호 일치(30000000원) -" + calculateSecondRank(rankList));
        System.out.println("6개 일치 (2000000000원) -" + calculateFirstRank(rankList));
        System.out.println("총 수익률은 "+ (double) earnMoney / (double) spendMoney +" 입니다.");
    }

    private int calculateFifthRank(List<Rank> matchValueList){

        int fifthCount = 0;
        Rank fifthRank = Rank.FIFTH;

        for (Rank rank : matchValueList) {

            fifthCount += calculateRankPosition(rank, fifthRank);
        }
        return fifthCount;
    }

    private int calculateFourthRank(List<Rank> matchValueList){

        int fourthCount = 0;
        Rank fourthRank = Rank.FOURTH;

        for (Rank rank : matchValueList) {
            fourthCount += calculateRankPosition(rank, fourthRank);
        }
        return fourthCount;
    }

    private int calculateThirdRank(List<Rank> matchValueList){

        int thirdCount = 0;
        Rank thirdRank = Rank.THIRD;

        for (Rank rank : matchValueList) {
            thirdCount += calculateRankPosition(rank, thirdRank);
        }
        return thirdCount;
    }

    private int calculateSecondRank(List<Rank> matchValueList){

        int secondCount = 0;
        Rank secondRank = Rank.SECOND;

        for (Rank rank : matchValueList) {

            secondCount += calculateRankPosition(rank, secondRank);
        }
        return secondCount;
    }

    private int calculateFirstRank(List<Rank> matchValueList){
        int firstCount = 0;
        Rank fisrtRank = Rank.FIRST;

        for (Rank rank : matchValueList) {

            firstCount += calculateRankPosition(rank, fisrtRank);
        }
        return firstCount;
    }

    private int calculateRankPosition(Rank matchValue,Rank rankPosition){
        int count = 0;
        if(matchValue.equals(rankPosition)){

            count++;
        }
        return count;
    }

    public static void main(String[] args){

        int money = LottoMoney.getLottoMoney();
        LottoGame launchLotto = new LottoGame();
        List<Lotto> lottoList = launchLotto.buyLotto(money);
        WinningLotto winnerLotto = new WinningLotto(launchLotto.getLastWinnerNumber(),launchLotto.inputBonusNumber());
        List<Rank> rankList = winnerLotto.saveCoincideLotto(winnerLotto, lottoList);
        int earnMoney = winnerLotto.calculateEarnMoney(rankList);
        winnerLotto.printLottoRank(rankList,earnMoney,money);
    }
}
