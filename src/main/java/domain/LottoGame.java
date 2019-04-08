package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static domain.LottoMoney.getLottoMoney;

public class LottoGame {

    private static final int LOTTO_LENGTH = 6;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;

    public static List<Integer> makeLottoNumber(){

        Random lottoNumber = new Random();
        List<Integer> lottoNumberList = new ArrayList<Integer>();

        for(int i = 0; i<LOTTO_LENGTH; i++){

            lottoNumberList.add(lottoNumber.nextInt(END_LOTTO_NUMBER)+START_LOTTO_NUMBER);
        }
        return lottoNumberList;
    }

    public static void takeLottoNumber(List<Lotto> lottoNumberList,int getMoney){

        for(int i=0;i<getMoney;i++){

            Lotto lottoNumber = lottoNumberList.get(i);
            lottoNumber.print(lottoNumberList.get(i));
        }
    }

    public static void makeTotalLotto(){

        int lottoMoney = getLottoMoney();
        List<Lotto> totalLotto = new ArrayList<Lotto>();
        for(int i=0; i<lottoMoney; i++){

            Lotto lottoNumber = new Lotto(makeLottoNumber());
            totalLotto.add(lottoNumber);
        }
        takeLottoNumber(totalLotto, lottoMoney);
    }
}
