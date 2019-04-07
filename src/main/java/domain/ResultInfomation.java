package domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class ResultInfomation {
    private List<Rank> ranks = new ArrayList<>();
    private EnumMap<Rank, Integer> enumMap;


    public ResultInfomation(List<Rank> ranks) {
        this.ranks = ranks;
        this.enumMap = createEnumMap();
    }

    private EnumMap<Rank, Integer> createEnumMap(){
        EnumMap<Rank, Integer> map = new EnumMap<Rank, Integer>(Rank.class);
        int cnt;

        for(Rank type : Rank.values()){
            map.put(type, 0);
        }

        for(Rank rank : ranks){
            cnt = map.get(rank);
            map.put(rank, ++cnt);
        }

        return map;
    }
}
