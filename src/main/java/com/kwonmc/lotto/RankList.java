package com.kwonmc.lotto;

import java.util.HashMap;

public class RankList extends HashMap<Rank, Integer> {
    public boolean put(Rank key) {
        if (this.containsKey(key)) {
            super.put(key, this.get(key) + 1);
            return true;
        }
        super.put(key, 0);
        return true;
    }
}
