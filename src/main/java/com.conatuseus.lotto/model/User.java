package com.conatuseus.lotto.model;


import java.util.LinkedList;
import java.util.List;


public class User {
    private List<Lotto> lottoList;
    private int buyMoney;
    private int numberOfLotto;

    public User() {
        this.setLottoList(new LinkedList<>());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(int money) {
        this.buyMoney = money;
        this.setNumberOfLotto(money / 1000);
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    private void setNumberOfLotto(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
    }

    public void makeLottoList() {
        for (int i = 0; i < this.getNumberOfLotto(); i++) {
            this.getLottoList().add(new Lotto(MakeRandom.makeRandomNumberList()));
        }
    }
}
