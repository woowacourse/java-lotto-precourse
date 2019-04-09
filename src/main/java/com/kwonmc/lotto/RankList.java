package com.kwonmc.lotto;

import java.util.ArrayList;
import java.util.Collections;

public class RankList {
    private ArrayList<Rank> ranks;
    private int[] counts;

    public RankList() {
        this.ranks = new ArrayList<>(6); // enum Rank 의 순서대로 indexing
        this.counts = new int[6]; // enum Rank 의 순서대로 counting 하기 위한 배열
        Collections.addAll(this.ranks, Rank.values());
        System.out.println(ranks.size());
    }

    public int size() {
        return ranks.size();
    }

    public boolean add(Rank rank) {
        int index = this.ranks.indexOf(rank);
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
