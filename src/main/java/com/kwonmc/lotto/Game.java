/*
 * @(#)Game.java
 *
 * v 0.0.0
 *
 * 2019.04.09
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */
package com.kwonmc.lotto;

import java.util.ArrayList;

/**
 * 게임 진행에 필요한 데이터들이 있는 객체
 *
 * @version 0.0.0
 * @author kwonmc
 */
public class Game {
    private int purchaseAmount; // 구매금액
    private ArrayList<Lotto> myLottoList; // 구매한 로또 번호들
    private WinningLotto winningLotto; // 지난주 당첨 번호와 보너스 번호

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

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
