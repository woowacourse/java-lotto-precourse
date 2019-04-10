package domain;

import constnum.Const;
import exception.LottoException;

import java.util.*;

public class PlayMatchingLotto {
    private static int USER_PAYMENT;

    public void play() {
        USER_PAYMENT = setPayment();
        int amountLotto = USER_PAYMENT/Const.PRIECE_OF_SINGLE_LOTTO;
        printLottoPaymentAmt(amountLotto);
        List<Lotto> userLotto = makeLottoList(amountLotto);
        Lotto winLotto = new Lotto(setLastWinLotto());
        WinningLotto winningLotto = new WinningLotto(winLotto, setBonus(winLotto));
        List<Rank> ranks = new ArrayList<>();
        ranks = setRankList(winningLotto, userLotto,ranks);
        setResultLotto(ranks, USER_PAYMENT);
    }

    /**
     * 사용자로부터 입력받은 구매 금액을 체크해 예외 발생.
     * 1. 정수 체크
     * 2. 1,000 미만 , 100,000 초과 체크
     * */
    private int setPayment() {
        int userPayment;
        System.out.println(Const.STR_ENTER_PAYMENT_TO_USER);
        try{
            userPayment = receivePaymentFromUser();
        } catch(NumberFormatException e){
            userPayment = exceptPayment(Const.EX_PAYMENT_ONLY_NUM_TO_USER);
        } catch (LottoException e){
            userPayment = exceptPayment(e.EXCEPTION_STR);
        }
        return userPayment;
    }

    /**
     * 사용자로부터 구매 금액 입력받기.
     * 1000 미만, 100000 초과일 경우 예외 발생시킴.
     * */
    private int receivePaymentFromUser() throws NumberFormatException, LottoException {
        int userPayment;
        Scanner sc = new Scanner(System.in);
        userPayment = Integer.parseInt(sc.nextLine());
        isPaymentConditionOk(userPayment);
        return userPayment;
    }

    private int exceptPayment(String exceptStr){
        System.out.println(exceptStr);
        return setPayment();
    }

    private void isPaymentConditionOk(int userPayment){
        if(userPayment < Const.MIN_PRICE_OF_LOTTO_BUY || userPayment > Const.MAX_PRICE_OF_LOTTO_BUY){
            throw new LottoException(Const.EX_PAYMENT_CONDITION_TO_USER);
        }
    }

    private void printLottoPaymentAmt(int amountLotto){
        System.out.println();
        System.out.println(amountLotto + Const.STR_NOTI_PAYMENTLOTTO_AMT);
    }

    private List<Lotto> makeLottoList(int amountLotto){
        List<Lotto> userLotto = new ArrayList<>(amountLotto);
        for(int i = 0 ; i < amountLotto ; i++){
            userLotto.add(i,new Lotto(makeLottoNumList()));
            userLotto.get(i).printLottoNums();
        }
        return userLotto;
    }

    private List<Integer> makeLottoNumList(){
        List<Integer> lottoNum =  new ArrayList<>();
        while (lottoNum.size() != Const.LOTTO_NUM_CNT){
            lottoNum = addLottoNumList(lottoNum);
        }
        return lottoNum;
    }

    private List<Integer> addLottoNumList(List<Integer> lottoNum){
        int num = makeRandNumber();
        if(!lottoNum.contains(num)){
            lottoNum.add(num);
        }
        return lottoNum;
    }

    /**
     * 1~45 사이의 난수 생성.
     * 로또번호 List 객체에 숫자가 있으면 다시 생성
     * */
    private int makeRandNumber(){
        Random random = new Random();
        int randNum = random.nextInt(Const.MAX_NUM_OF_LOTTO_TO_SELECT) + 1;
        return randNum;
    }

    private List<Integer> setLastWinLotto(){
        List<Integer> winnerList;
        System.out.println("\n"+Const.STR_ENTER_LAST_WIN_NUMBRES);
        try{
            winnerList = receiveLastWinLottoFromUser();
        }catch (NumberFormatException e){
            winnerList = exceptLastWinLotto(Const.EX_WIN_ONLY_NUM_TO_USER);
        }catch (LottoException e){
            winnerList = exceptLastWinLotto(e.EXCEPTION_STR);
        }
        return winnerList;
    }

    private List<Integer> exceptLastWinLotto(String exceptStr){
        System.out.println(exceptStr);
        return setLastWinLotto();
    }

    private List<Integer> receiveLastWinLottoFromUser() throws NumberFormatException, LottoException {
        List<Integer> winnerList = new ArrayList<>(Const.LOTTO_NUM_CNT);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(",");
        for(String s : strArr){
            winnerList = addWinLottoList(winnerList,Integer.parseInt(s));
        }
        isLastWinLottoConditionOk(strArr.length);
        return winnerList;
    }

    private void isLastWinLottoConditionOk(int arrLength) throws LottoException{
        if(arrLength != Const.LOTTO_NUM_CNT){
            throw new LottoException(Const.EX_WIN_CNT_CONDITION_TO_USER);
        }
    }

    private List<Integer> addWinLottoList(List<Integer> winnerList, int num) throws LottoException{
        isAddWinLottoConditionOk(winnerList,num);
        winnerList.add(num);
        return winnerList;
    }

    private void isAddWinLottoConditionOk(List<Integer> winnerList, int num) throws LottoException{
        if(num < Const.MIN_NUM_OF_LOTTO_TO_SELECT || num > Const.MAX_NUM_OF_LOTTO_TO_SELECT) {
            throw new LottoException(Const.EX_LOTTO_CONDITION_TO_USER);
        }
        if(winnerList.contains(num)){
            throw new LottoException(Const.EX_WIN_NOT_OVERLAP_TO_USER);
        }
    }

    private int setBonus(Lotto winLotto){
        int bonus;
        try{
            bonus = receiveBonusFromUserException(winLotto);
        } catch(NumberFormatException e){
            bonus = exceptBonus(winLotto,Const.EX_BONUS_ONLY_NUM_TO_USER);
        } catch (LottoException e){
            bonus = exceptBonus(winLotto,e.EXCEPTION_STR);
        }
        return bonus;
    }

    private int exceptBonus(Lotto winLotto, String exceptStr) throws LottoException{
        System.out.println(exceptStr);
        return setBonus(winLotto);
    }

    private int receiveBonusFromUserException(Lotto winLotto) throws NumberFormatException, LottoException{
        System.out.println(Const.STR_ENTER_LAST_WIN_BONUS);
        Scanner sc = new Scanner(System.in);
        int bonus = Integer.parseInt(sc.nextLine());
        isBonusConditionOk(winLotto,bonus);
        return bonus;
    }

    /**
     * 보너스 볼 런타임 예외 조건
     * 1. 1 이상 45 이하 숫자만 가능
     * 2. 당첨 번호랑 중복되면 안됨.
     * */
    private void isBonusConditionOk(Lotto winLotto, int bonus) throws NumberFormatException, LottoException{
        if(bonus < Const.MIN_NUM_OF_LOTTO_TO_SELECT || bonus > Const.MAX_NUM_OF_LOTTO_TO_SELECT){
            throw new LottoException(Const.EX_LOTTO_CONDITION_TO_USER);
        }
        if(winLotto.getNumbers().contains(bonus)){
            throw new LottoException(Const.EX_BONUS_NOT_OVERLAP_TO_USER);
        }
    }

    private List<Rank> setRankList(WinningLotto winningLotto, List<Lotto> userLotto, List<Rank> ranks){
        for(Lotto ulotto : userLotto){
            ranks.add(winningLotto.match(ulotto));
        }
        return ranks;
    }

    /**
     * Rank List를 사용해 결과 세팅.
     * 세팅 후 결과 출력.
     * */
    private void setResultLotto(List<Rank> ranks, int USER_PAYMENT){
        printResultTitle();
        LottoResult lottoResult = new LottoResult(ranks);
        lottoResult.calWinningMoneyPercent(USER_PAYMENT);
        lottoResult.printRankResultList();
        printResultLotto(lottoResult);
    }

    private void printResultTitle(){
        System.out.println(Const.RESULT_TITLE);
        System.out.println(Const.RESULT_BAR);
    }

    private void printResultLotto(LottoResult lottoResult){
        String resultStr = Const.RESULT_PRIZE_PERCENT_FRONT + lottoResult.getWinningMoneyPercent() + Const.RESULT_PRIZE_PERCENT_BACK;
        System.out.println(resultStr);
    }

}
