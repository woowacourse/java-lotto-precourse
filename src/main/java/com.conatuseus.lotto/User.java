package com.conatuseus.lotto;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class User {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String MONEY_REGEX = "[0-9]+";
    private List<Lotto> lottoList;
    private int money;
    private int numberOfLotto;

    public User(){
        this.lottoList=new LinkedList<>();
    }

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
        this.setNumberOfLotto(money/1000);
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    private void setNumberOfLotto(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public void inputMoney() throws IOException {
        String input;
        do {
            System.out.println("구입금액을 입력해 주세요.(0이상 1000원 단위)");
            input=br.readLine();
        }while (!this.isMoneyValid(input));

        this.setMoney(Integer.parseInt(input));
    }

    private boolean isMoneyValid(String input) {
        if(!input.matches(MONEY_REGEX)){
            return false;
        }
        int tInputMoney=Integer.parseInt(input);
        return (tInputMoney % 1000) == 0;
    }

}
