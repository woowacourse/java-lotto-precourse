package domain;

import java.util.*;

import static domain.LottoMoney.getLottoMoney;

public class LottoGame {

    private static final int LOTTO_LENGTH = 6;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;

    private List<Integer> makeLottoNumber(){

        Random lottoNumber = new Random();
        List<Integer> lottoNumberList = new ArrayList<Integer>();

        for(int i = 0; i<LOTTO_LENGTH; i++){

            lottoNumberList.add(lottoNumber.nextInt(END_LOTTO_NUMBER)+START_LOTTO_NUMBER);
        }
        return lottoNumberList;
    }

    private void takeLottoNumber(List<Lotto> lottoNumberList,int getMoney){

        for(int i=0;i<getMoney;i++){

            Lotto lottoNumber = lottoNumberList.get(i);
            lottoNumber.showBuyLotto(lottoNumberList.get(i));
        }
    }

    public List<Lotto> makeTotalLotto(){

        int lottoMoney = getLottoMoney();
        List<Lotto> totalLotto = new ArrayList<Lotto>();
        for(int i=0; i<lottoMoney; i++){

            Lotto lottoNumber = new Lotto(makeLottoNumber());
            totalLotto.add(lottoNumber);
        }
        takeLottoNumber(totalLotto, lottoMoney);
        return totalLotto;
    }

    private List<Integer> getLastWinNumber() {

        List<String> inputWinNumber;
        List<Integer> result;
        while (true) {
            try {
                Scanner lastNumber = new Scanner(System.in);
                String lastWinString = lastNumber.nextLine();
                inputWinNumber = Arrays.asList(lastWinString.split(","));

                result = checkLastWinLotto(inputWinNumber);
                break;
            } catch (Exception e) {

                System.out.println("다시 입력해주세요");
            }
        }
        return result;
    }

    private List<Integer> getInLastWinLotto(List<String> lastWinNumberList){

        List<Integer> inputLastNumberInteger = new ArrayList<Integer>();
        for(int i=0; i<lastWinNumberList.size(); i++){

            inputLastNumberInteger.add(Integer.parseInt(lastWinNumberList.get(i)));
        }
        return inputLastNumberInteger;
    }

    private List<Integer> checkLastWinLotto(List<String> lastWinLotto){

        checkLastLottoNumberisTrueAll(lastWinLotto);
        List<Integer> lastWinLottoList = getInLastWinLotto(lastWinLotto);
        checkLastLottoNumber(lastWinLottoList);

        return lastWinLottoList;
    }

    private void checkLastLottoNumber(List<Integer> lastWinLotto){

        for(int i=0;i<lastWinLotto.size();i++){

            checkLottoNumberRange(lastWinLotto,i);
        }
    }

    private void checkLottoNumberRange(List<Integer> lastWinLotto, int numberLocation){
        if(lastWinLotto.get(numberLocation) < START_LOTTO_NUMBER || lastWinLotto.get(numberLocation) > END_LOTTO_NUMBER){

            System.out.println("범위");
            throw new IllegalArgumentException();
        }
    }

    private void checkLastLottoNumberisTrueAll(List<String> lottoNumberString){
        for(int i=0;i<lottoNumberString.size();i++){

            checkLastLottoNumberisTrue(lottoNumberString.get(i));
        }
    }

    private void checkLastLottoNumberisTrue(String integer){

        try{

            Integer.parseInt(integer);
        } catch (NumberFormatException e){

            System.out.println("정확한 값을 입력 해주시기 바랍니다");
            throw e;
        }
    }




}
