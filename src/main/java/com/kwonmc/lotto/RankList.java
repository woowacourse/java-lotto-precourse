package com.kwonmc.lotto;

import java.util.HashMap;

public class RankList extends HashMap<Rank, Integer> {
    @Override
    public Integer put(Rank key, Integer value) {
        if (this.containsKey(key)) {
            super.put(key, this.get(key) + 1);
            return super.put(key, value);
        }
        super.put(key, 0);
        return super.put(key, value);
    }
}
