package domain;

import constnum.Const;
import exception.LottoException;

import java.util.*;

public class PlayMatchingLotto {
    private static int USER_PAYMENT;

    public void play() {
        USER_PAYMENT = receivePaymentFromUser();
        int amountLotto = USER_PAYMENT/Const.PRIECE_OF_SINGLE_LOTTO;
        printLottoPaymentAmt(amountLotto);
        Lotto[] lottos = makeLottoObj(amountLotto);
        Lotto winLotto = new Lotto(receiveLastWinLottoFromUser());
        WinningLotto winningLotto = new WinningLotto(winLotto,receiveBonusFromUser(winLotto));
    }

    /**
     * 사용자로부터 입력받은 구매 금액을 체크해 예외 발생.
     * 1. 정수 체크
     * 2. 1,000 미만 , 100,000 초과 체크
     * */
    private int receivePaymentFromUser() {
        int userPayment;
        System.out.println(Const.STR_ENTER_PAYMENT_TO_USER);
        try{
            userPayment = receivePaymentFromUserException();
        } catch(InputMismatchException e){
            System.out.println(Const.EX_PAYMENT_ONLY_NUM_TO_USER);
            userPayment = receivePaymentFromUser();
        } catch (LottoException e){
            System.out.println(e.EXCEPTION_STR);
            userPayment = receivePaymentFromUser();
        }
        return userPayment;
    }

    /**
     * 사용자로부터 구매 금액 입력받기.
     * 1000 미만, 100000 초과일 경우 예외 발생시킴.
     * */
    private int receivePaymentFromUserException() throws InputMismatchException, LottoException {
        int userPayment;
        Scanner sc = new Scanner(System.in);
        userPayment = sc.nextInt();

        if(userPayment < Const.MIN_PRICE_OF_LOTTO_BUY || userPayment > Const.MAX_PRICE_OF_LOTTO_BUY){
            throw new LottoException(Const.EX_PAYMENT_CONDITION_TO_USER);
        }

        return userPayment;
    }

    private void printLottoPaymentAmt(int amountLotto){
        System.out.println();
        System.out.println(amountLotto + Const.STR_NOTI_PAYMENTLOTTO_AMT);
    }

    private Lotto[] makeLottoObj(int amountLotto){
        Lotto[] lottos = new Lotto[amountLotto];
        for(int i = 0 ; i < amountLotto ; i++){
            lottos[i] = new Lotto(makeLottoNumList());
            lottos[i].printLottoNums();
        }
        return lottos;
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

    private List<Integer> receiveLastWinLottoFromUser(){
        List<Integer> winnerList;
        System.out.println("\n"+Const.STR_ENTER_LAST_WIN_NUMBRES);
        try{
            winnerList = receiveLastWinLottoFromUserException();
        }catch (NumberFormatException e){
            System.out.print(Const.EX_WIN_ONLY_NUM_TO_USER);
            winnerList = receiveLastWinLottoFromUser();
        }catch (LottoException e){
            System.out.print(e.EXCEPTION_STR);
            winnerList = receiveLastWinLottoFromUser();
        }
        return winnerList;
    }

    private List<Integer> receiveLastWinLottoFromUserException() throws NumberFormatException, LottoException {
        List<Integer> winnerList = new ArrayList<>(Const.LOTTO_NUM_CNT);
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split(",");
        for(String s : strArr){
            winnerList = addWinLottoList(winnerList,Integer.parseInt(s));
        }
        if(strArr.length != Const.LOTTO_NUM_CNT){
            throw new LottoException(Const.EX_WIN_CNT_CONDITION_TO_USER);
        }
        return winnerList;
    }

    private List<Integer> addWinLottoList(List<Integer> winnerList, int num) throws LottoException{
        if(num < Const.MIN_NUM_OF_LOTTO_TO_SELECT || num > Const.MAX_NUM_OF_LOTTO_TO_SELECT) {
            throw new LottoException(Const.EX_LOTTO_CONDITION_TO_USER);
        }
        if(winnerList.contains(num)){
            throw new LottoException(Const.EX_WIN_NOT_OVERLAP_TO_USER);
        }
        winnerList.add(num);
        return winnerList;
    }

    private int receiveBonusFromUser(Lotto winLotto){
        int bonus;
        try{
            bonus = receiveBonusFromUserException(winLotto);
        } catch(NumberFormatException e){
            System.out.println(Const.EX_BONUS_ONLY_NUM_TO_USER);
            bonus = receiveBonusFromUser(winLotto);
        } catch (LottoException e){
            System.out.println(e.EXCEPTION_STR);
            bonus = receiveBonusFromUser(winLotto);
        }
        return bonus;
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

}
