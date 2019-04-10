import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberCreator {
    private final static int lottoNum = 6;
    private final static int lottoNumBound = 45;

    public static List<Integer> createLottoNums(){
        List<Integer> list = new ArrayList<Integer>();
        while(list.size()<lottoNum)
            pushIfNonDuplicatedNum(list);
        Collections.sort(list);
        return list;
    }

    private static int createLottoNum(){
        Random random = new Random();
        int newNum = random.nextInt(lottoNumBound)+1;
        return newNum;
    }

    private static void pushIfNonDuplicatedNum(List<Integer> list){
        int newNum = createLottoNum();
        if(!list.contains(newNum))
            list.add(newNum);
    }
}
