package domain.Elements;

import domain.Program.Config.Constant;
import domain.Program.Input;
import domain.Program.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private static List<Integer> lottoNumberBox = new ArrayList<>();
    private List<Integer> lottoNumber;

    public LottoPaper(int type){
        if(type==1){
            setRandomLottoNumber();
            return;
        }
        setSelfLottoNumber();
    }

    public List<Integer> getLottoNumber(){
        return lottoNumber;
    }

    @Override
    public String toString(){
        return lottoNumber.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    private void setRandomLottoNumber(){
        this.lottoNumber = makeRandomLottoNumber();
    }

    private List<Integer> makeRandomLottoNumber(){
        fillLottoBox();
        List<Integer> lottoNumber = new ArrayList<>();
        for(int i=0; i<6; i++){
            lottoNumber.add(lottoNumberBox.remove(Random.createNumber(Constant.LOTTO_MAX - 1 - i)));
        }
        return lottoNumber;
    }

    private static void fillLottoBox(){
        lottoNumberBox.clear();
        for(int i = Constant.LOTTO_MIN; i<=Constant.LOTTO_MAX; i++){
            lottoNumberBox.add(i);
        }
    }

    private void setSelfLottoNumber(){
        this.lottoNumber = makeSelfLottoNumber();
    }

    private List<Integer> makeSelfLottoNumber(){
        String selfLottoString = Input.setSelfLottoNumber();
        String[] selfLottoArray = selfLottoString.split(",");
        return Arrays.stream(selfLottoArray).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
