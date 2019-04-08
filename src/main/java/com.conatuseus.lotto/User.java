package com.conatuseus.lotto;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class User {
    private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private List<Lotto> lottoList=new LinkedList<>();
    private int money;

    public int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public void inputMoney() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        String input=br.readLine();
        this.setMoney(Integer.parseInt(input));
    }

}
