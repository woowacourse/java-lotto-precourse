package domain;

import constnum.Const;
import exception.LottoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayMatchingLotto {
    private static int USER_PAYMENT;

    public void play() {
        USER_PAYMENT = receivePaymentFromUser();
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

}
