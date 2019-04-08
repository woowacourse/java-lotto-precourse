package com.kwonmc.lotto;

import java.util.ArrayList;

public class Game {
    private int purchaseAmount; // 구매금액
    private ArrayList<Lotto> myLottoList; // 구매한 로또 번호들
    private WinningLotto winningLotto;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setMyLottoList(ArrayList<Lotto> myLottoList) {
        this.myLottoList = myLottoList;
    }

    public ArrayList<Lotto> getMyLottoList() {
        return myLottoList;
    }

    public void setWinningLotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }
}
