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

    /* 보너스 번호 와 당첨된 번호의 갯수에 맞는 등수와, 돈을 반환하는 메소드 */
    public Rank match(int matchValue,boolean includeSecond) {

        return Rank.valueOf(matchValue,includeSecond);
    }

    /* 맞은 번호의 갯수를 반환하는 메소드 */
    private List<Integer> matchAmount(List<Lotto> userLottoList){

        int correctNumber = 0;                                          // 맞은 갯수 저장
        List<Integer> correctAmountList = new ArrayList<>();

        for (Lotto lotto1 : userLottoList) {

            correctNumber = calculateMatchAmount(lotto1.catchLotto(), correctNumber);
            correctAmountList.add(correctNumber);
            correctNumber = 0;
        }
        return correctAmountList;
    }

    /* 로또 번호 갯수만큼 반복 하는 메소드 */
    private int calculateMatchAmount(List<Integer> lottoNumberList, int correctNumber){

        for (Integer integer : lottoNumberList) {

            correctNumber = checkMatchRight(integer, correctNumber);
        }
        return correctNumber;
    }

    /* 맞으면 갯수를 증가 시키는 메소드 */
    private int checkMatchRight(int value,int correctAmount){

        if(lotto.catchLotto().contains(value)){

            /* 맞으면 맞은 갯수 증가 */
            correctAmount++;
        }
        return correctAmount;
    }

    /* 보너스 번호가 맞는지 확인 하는 메소드 */
    private boolean checkCoincideBonusNumber(List<Integer> lottoNumberList, int bonusNumber){

        boolean findSecondState = false;
        if(lottoNumberList.contains(bonusNumber)){

            /* 보너스 번호가 맞으면 */
            findSecondState = true;
        }
        return findSecondState;
    }

    /* 로또 한장 마다 맞은 갯수를 리스트에 저장 하는 메소드 */
    private List<Integer> saveCoincideLotto(WinningLotto winnerLotto, List<Lotto> lottoList){

        List<Integer> rankList = new ArrayList<>();
        for(int i=0;i<lottoList.size();i++){

            rankList.add(match(winnerLotto.matchAmount(lottoList).get(i),checkCoincideBonusNumber(lottoList.get(i).catchLotto(),winnerLotto.bonusNo)).getCountOfMatch());
        }
        return rankList;
    }

    /* 총 번돈을 계산하는 메소드 */
    private int calculateEarnMoney(List<Integer> rankList, List<Lotto> lottoList){

        int earnMoney = 0;
        for(int i=0;i<rankList.size();i++){

            Rank rankMoney = Rank.valueOf(rankList.get(i),checkCoincideBonusNumber(lottoList.get(i).catchLotto(),this.bonusNo));
            earnMoney += rankMoney.getWinningMoney();
        }
        return earnMoney;
    }

    /* 등수별 당첨 갯수 및 수익률을 출력하는 메소드 */
    private void printLottoRank(List<Integer> rankList,int earnMoney, int spendMoney) {

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) -" + calculateFifthRank(rankList));
        System.out.println("4개 일치 (50000원) -" + calculateFourthRank(rankList));
        System.out.println("5개 일치 (1500000원) -" + calculateThirdRank(rankList));
        System.out.println("5개 일치 보너스 번호 일치(30000000원) -" + calculateSecondRank(rankList));
        System.out.println("6개 일치 (2000000000원) -" + calculateFirstRank(rankList));
        System.out.println("총 수익률은 "+ (double) earnMoney / spendMoney +" 입니다.");
    }

    /* 5등 당첨 갯수 계산 하는 메소드 */
    private int calculateFifthRank(List<Integer> matchValueList){

        int fifthCount = 0;
        Rank fifthRank = Rank.FIFTH;

        for(int i=0;i<matchValueList.size();i++){

            fifthCount += calculateRankPosition(matchValueList,fifthRank,i);
        }
        return fifthCount;
    }

    /* 4등 당첨 갯수 계산 하는 메소드 */
    private int calculateFourthRank(List<Integer> matchValueList){

        int fourthCount = 0;
        Rank fourthRank = Rank.FOURTH;

        for(int i=0;i<matchValueList.size();i++){
            fourthCount += calculateRankPosition(matchValueList,fourthRank,i);
        }
        return fourthCount;
    }

    /* 3등 당첨 갯수 계산 하는 메소드 */
    private int calculateThirdRank(List<Integer> matchValueList){

        int thirdCount = 0;
        Rank thirdRank = Rank.THIRD;

        for(int i=0;i<matchValueList.size();i++){
            thirdCount += calculateRankPosition(matchValueList,thirdRank,i);
        }
        return thirdCount;
    }

    /* 2등 당첨 갯수 계산 하는 메소드 */
    private int calculateSecondRank(List<Integer> matchValueList){

        int secondCount = 0;
        Rank secondRank = Rank.SECOND;

        for(int i=0;i<matchValueList.size();i++){

            secondCount += calculateRankPosition(matchValueList,secondRank,i);
        }
        return secondCount;
    }

    /* 1등 당첨 갯수 계산 하는 메소드 */
    private int calculateFirstRank(List<Integer> matchValueList){
        int firstCount = 0;
        Rank fisrtRank = Rank.FIRST;

        for(int i=0;i<matchValueList.size();i++){

            firstCount += calculateRankPosition(matchValueList,fisrtRank,i);
        }
        return firstCount;
    }

    /* 각각 등수의 갯수를 계산해주는 메소드 */
    private int calculateRankPosition(List<Integer> matchValueList,Rank rankPosition ,int location){
        int count = 0;
        if(matchValueList.get(location) == rankPosition.getCountOfMatch()){

            /* 맞은 갯수와 등수에 필요한 갯수가 같을경우 */
            count++;
        }
        return count;
    }

    public static void main(String[] args){

        int money = LottoMoney.getLottoMoney();
        LottoGame launchLotto = new LottoGame();
        List<Lotto> lottoList = launchLotto.buyLotto(money);
        WinningLotto winnerLotto = new WinningLotto(launchLotto.getLastWinnerNumber(),launchLotto.inputBonusNumber());
        int earnMoney = winnerLotto.calculateEarnMoney(winnerLotto.saveCoincideLotto(winnerLotto,lottoList),lottoList);
        winnerLotto.printLottoRank(winnerLotto.matchAmount(lottoList),earnMoney,money);
    }
}
