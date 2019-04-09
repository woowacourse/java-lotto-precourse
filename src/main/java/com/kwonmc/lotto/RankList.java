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

    public boolean add(Rank rank) {
        
    }
}
