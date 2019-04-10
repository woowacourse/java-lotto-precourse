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
}
