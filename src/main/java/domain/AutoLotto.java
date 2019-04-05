package domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLotto {

    public List<Integer> makeAutoNumber(int cnt){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<6; i++){
            list.add(makeRandomNum());
        }
        return list;
    }

    private int makeRandomNum(){
        int num = (int) (Math.random() * 45) + 1;
        return num;
    }

}
