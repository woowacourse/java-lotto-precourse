package com.conatuseus.lotto.model;


import com.conatuseus.lotto.appController.AppController;

import java.util.LinkedList;
import java.util.List;


public class User {
    private List<Lotto> lottoList;
    private int money;

    public User() {
        this.setLottoList(new LinkedList<>());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void setLottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumberOfLotto() {
        return this.getMoney() / AppController.LOTTO_COST;
    }

    public void makeLottoList() {
        for (int i = 0; i < this.getNumberOfLotto(); i++) {
            this.getLottoList().add(new Lotto(MakeLotto.makeRandomNumberList()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("구입 금액 : ").append(this.getMoney()).append("\n");
        sb.append("구입 목록").append("\n").append(this.getLottoList());
        return sb.toString();
    }
}
