package controller;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<Lotto> lottoList = new ArrayList<>();
    private int money;

    public LottoController(int money) {
        this.money = money;
    }
    
    public int getMoney() {
        return money;
    }
}
