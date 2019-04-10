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

        Rank lottoRank = Rank.valueOf(matchValue,includeSecond);
        return lottoRank;
    }

    private List<Integer> matchAmount(List<Lotto> userLottoList){

        int correctNumber = 0;
        List<Integer> correctAmountList = new ArrayList<Integer>();

        for(int i=0;i<userLottoList.size();i++){
           correctNumber = matchAmountIncrease(userLottoList.get(i).findLotto(), correctNumber);
           correctAmountList.add(correctNumber);
           correctNumber = 0;
        }
        return correctAmountList;
    }

    private int matchAmountIncrease(List<Integer> amountList, int correctNumber){
        for(int i=0; i<amountList.size(); i++){
            correctNumber = checkmatchValue(amountList.get(i),correctNumber);
        }
        return correctNumber;
    }

    private int checkmatchValue(int value,int correctAmount){
        if(lotto.findLotto().contains(value)){
            correctAmount++;
        }
        return correctAmount;
    }

    private boolean findSecondCorrect(List<Integer> amountList, int bonusNumber){

        boolean findSecondState = false;
        if(amountList.contains(bonusNumber)){
            findSecondState = true;
        }
        return findSecondState;
    }

    private List<Integer> saveRank(WinningLotto winLotto,List<Lotto> lottoList){

        List<Integer> rankList = new ArrayList<Integer>();;

        for(int i=0;i<lottoList.size();i++){
            rankList.add(match(winLotto.matchAmount(lottoList).get(i),findSecondCorrect(lottoList.get(i).findLotto(),winLotto.bonusNo)).getCountOfMatch());
        }
        return rankList;
    }

    private int takeLottoMoney(List<Integer> rankList,List<Lotto> lottoList){

        int earnMoney = 0;

        for(int i=0;i<rankList.size();i++){
            Rank matchMoney = Rank.valueOf(rankList.get(i),findSecondCorrect(lottoList.get(i).findLotto(),
                    this.bonusNo));
            earnMoney += matchMoney.getWinningMoney();
        }
        return earnMoney;
    }

    private void printLottoRank(List<Integer> rankList,int earnMoney, int spendMoney) {

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) -" + checkFifthRank(rankList));
        System.out.println("4개 일치 (50000원) -" + checkFourthRank(rankList));
        System.out.println("5개 일치 (1500000원) -" + checkThirdRank(rankList));
        System.out.println("5개 일치 보너스 번호 일치(30000000원) -" + checkSecondRank(rankList));
        System.out.println("6개 일치 (2000000000원) -" + checkFirstRank(rankList));
        System.out.println("총 수익률은 "+ (double) earnMoney / spendMoney +" 입니다.");
    }

    private int checkFifthRank(List<Integer> matchValueList){
        int count = 0;
        Rank fifthRank = Rank.FIFTH;
        for(int i=0;i<matchValueList.size();i++){
            count += checkRankPosition(matchValueList,fifthRank,i);
        }
        return count;
    }

    private int checkFourthRank(List<Integer> matchValueList){
        int count = 0;
        Rank fourthRank = Rank.FOURTH;
        for(int i=0;i<matchValueList.size();i++){
            count += checkRankPosition(matchValueList,fourthRank,i);
        }
        return count;
    }

    private int checkThirdRank(List<Integer> matchValueList){
        int count = 0;
        Rank thirdRank = Rank.THIRD;
        for(int i=0;i<matchValueList.size();i++){
            count += checkRankPosition(matchValueList,thirdRank,i);
        }
        return count;
    }

    private int checkSecondRank(List<Integer> matchValueList){
        int count = 0;
        Rank SecondRank = Rank.SECOND;
        for(int i=0;i<matchValueList.size();i++){
            count += checkRankPosition(matchValueList,SecondRank,i);
        }
        return count;
    }

    private int checkFirstRank(List<Integer> matchValueList){
        int count = 0;
        Rank FisrtRank = Rank.FIRST;
        for(int i=0;i<matchValueList.size();i++){
            count += checkRankPosition(matchValueList,FisrtRank,i);
        }
        return count;
    }

    private int checkRankPosition(List<Integer> matchValueList,Rank temp,int location){
        int count = 0;
        if(matchValueList.get(location) == temp.getCountOfMatch()){
            count++;
        }
        return count;
    }
}
