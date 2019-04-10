package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RankTest {
    @Test
    public void valueof() {
        assertEquals(Rank.FIFTH,Rank.valueOf(3,false));
        assertEquals(Rank.FOURTH,Rank.valueOf(4,false));
        assertEquals(Rank.THIRD,Rank.valueOf(5,false));
        assertEquals(Rank.SECOND,Rank.valueOf(5,true));
        assertEquals(Rank.FIRST,Rank.valueOf(6,false));

    }

    @Test
    public void valueOfRank() {
        assertEquals(2_000_000_000, Rank.FIRST.getWinningMoney());
    }

    @Test
    public void indexOfRankValuesTest() {
        assertEquals(Rank.FIRST, Rank.values()[0]);
        assertEquals(Rank.SECOND, Rank.values()[1]);
        assertEquals(Rank.MISS, Rank.values()[5]);
        assertEquals(Rank.FIFTH, Rank.valueOf("FIFTH"));
    }

    @Test
    public void sequenceOfRankTest() {
        Map<Rank,Integer> map = new LinkedHashMap<>();
        map.put(Rank.FIFTH, 3);
        map.put(Rank.FOURTH,4);
        map.put(Rank.THIRD, 5);
        map.put(Rank.SECOND,5);
        map.put(Rank.FIRST, 6);

        String result ="";
        for(Map.Entry<Rank, Integer> entry : map.entrySet()){
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            result += count;
        }

        assertEquals("34556",result);
    }
}