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
            System.out.println(Const.STR_ENTER_PAYMENT_ONLY_NUM_TO_USER);
            userPayment = receivePaymentFromUser();
        } catch (LottoException e){
            System.out.println(Const.STR_ENTER_PAYMENT_CONDITION_TO_USER);
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
            throw new LottoException();
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
        int randNum = random.nextInt(Const.MAX_NUM_OF_LOTTO_SELECT) + 1;
        return randNum;
    }



}
