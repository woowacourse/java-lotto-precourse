/*
 * @(#)RankList.java
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

import com.kwonmc.lotto.consts.Numbers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Rank 객체와 그 개수를 보관하기 위한 객체
 *
 * @version 0.0.0
 * @author kwonmc
 * @see Numbers
 */
public class RankList {
    private ArrayList<Rank> ranks;
    private int[] counts;

    public RankList() {
        ranks = new ArrayList<>(Numbers.RANKLIST_CAPACITY); // enum Rank 의 순서대로 indexing
        counts = new int[Numbers.RANKLIST_CAPACITY]; // enum Rank 의 순서대로 counting 하기 위한 배열
        Collections.addAll(ranks, Rank.values());
    }

    public int size() {
        return ranks.size();
    }

    public boolean add(Rank rank) {
        int index = ranks.indexOf(rank);
        this.counts[index]++;
        return true;
    }

    public Rank getRankByIndex(int index) {
        return ranks.get(index);
    }

    public int getCountsByIndex(int index) {
        return counts[index];
    }

    public int getTotalWinningAmount() {
        int winningAmount = 0;
        for (int i = 0; i < 6; i++) {
            int eachRankAmount = ranks.get(i).getWinningMoney() * counts[i];
            winningAmount += eachRankAmount;
        }
        return winningAmount;
    }
}
