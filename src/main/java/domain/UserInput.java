package domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {

    private String userInput;
    private BufferedReader br;

    private static final String INPUT_ERROR_MESSAGE = "입력 에러가 발생했습니다.";
    private static final String REQUEST_INTEGER = "올바른 형식의 정수값을 입력하세요.";
    private static final String REQUEST_POSITIVE_NUMBER = "양수를 입력하세요.";
    private static final String REQUEST_SIX_NUMBERS = "올바른 형식으로 6개의 숫자를 입력하세요";
    private static final String REQUEST_CORRECT_LOTTO_NUMBERS = "올바른 로또 번호(1~45)를 입력하세요";

    public UserInput() {
        this.userInput = "";
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void listen(){
        while(!this.setUserInput());
    }

    private boolean setUserInput(){
        try {
            this.userInput = br.readLine();
            return true;
        } catch (Exception e) {
            this.showMessgae(INPUT_ERROR_MESSAGE);
            return false;
        }
    }

    public String getCashToBuyLotto(){
        do{
            this.listen();
        }while(!this.validateCashToBuyLotto(this.userInput));

        return this.userInput;
    }

    public boolean validateCashToBuyLotto(String inputCash){
        if(!isValidIntegerNumber(inputCash)){
            return false;
        }

        int cash = Integer.parseInt(inputCash);
        if(!isValidCash(cash)){
            return false;
        }

        return true;
    }

    public boolean isValidIntegerNumber(String inputNum){
        try{
            Integer.parseInt(inputNum);
            return true;
        }catch (Exception e){
            this.showMessgae(REQUEST_INTEGER);
            return false;
        }
    }

    public boolean isValidCash(int cash){
        if(cash < 0){
            this.showMessgae(REQUEST_POSITIVE_NUMBER);
            return false;
        }

        return true;
    }

    public void showMessgae(String msg){
        System.out.println(msg);
    }

}
