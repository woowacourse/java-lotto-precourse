package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class LottoGame {

    private static final int LOTTO_LENGTH = 6;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;
    public static final int GET_LOTTO_MONEY = 1000;

    private List<Integer> makeLottoNumber(){

        Random random = new Random();
        List<Integer> oneLotto = new ArrayList<>();

        for(int i = 0; i<LOTTO_LENGTH; i++){

            oneLotto.add(random.nextInt(END_LOTTO_NUMBER)+START_LOTTO_NUMBER);

            for(int j=0; j<i;j++){

                /* 중복 번호를 확인하기 위한 반복문 */
                i = checkOverlapNumber(oneLotto,i,j);
            }
        }
        return oneLotto;
    }

    private int checkOverlapNumber(List<Integer> oneLotto,int beforeLocation, int afterLocation){

        if(oneLotto.get(beforeLocation).equals(oneLotto.get(afterLocation))){

            oneLotto.remove(beforeLocation);
            beforeLocation--;
        }
        return beforeLocation;
    }

    private void printBuyLotto(List<Lotto> oneLotto,int lottoNumber){

        for(int i=0;i<lottoNumber;i++){

            Lotto lotto = oneLotto.get(i);
            lotto.printBuyLotto(oneLotto.get(i));
        }
    }

    List<Lotto> buyLotto(int money){

        int lottoNumber = money/GET_LOTTO_MONEY;
        List<Lotto> LottoList = new ArrayList<>();

        System.out.println(lottoNumber + "개를 구매했습니다.");

        for(int i=0; i<lottoNumber; i++){

            Lotto lotto = new Lotto(makeLottoNumber());
            LottoList.add(lotto);
        }
        printBuyLotto(LottoList, lottoNumber);
        return LottoList;
    }

    Lotto getLastWinnerNumber() {

        List<String> winnerStringList;
        List<Integer> winnerNumberList;
        System.out.println("지난주 당첨 번호를 입력해주세요");
        while (true) {
            try {

                Scanner scanWinnerString = new Scanner(System.in);
                String winnerString = scanWinnerString.nextLine();
                winnerStringList = Arrays.asList(winnerString.split(","));

                winnerNumberList = checkLastWinnerLotto(winnerStringList);
                break;
            } catch (Exception e) {

                System.out.println("다시 입력해주세요");
            }
        }
        return new Lotto(winnerNumberList);
    }

    private List<Integer> changeStringToInteger(List<String> winnerStringList){

        List<Integer> lastWinnerLotto = new ArrayList<>();
        int i;
        for(i = 0; i<winnerStringList.size(); i++){

            lastWinnerLotto.add(Integer.parseInt(winnerStringList.get(i)));
            for(int j=0; j<i;j++) {
                i = checkSameLastLottoNumber(lastWinnerLotto, i, j);
            }
        }
        return lastWinnerLotto;
    }

    private int checkSameLastLottoNumber(List<Integer> lastWinnerLotto,int beforeLocation, int afterLocation){
        if(lastWinnerLotto.get(beforeLocation).equals(lastWinnerLotto.get(afterLocation))){

            System.out.println("로또 번호는 중복하여 선택이 안됩니다");
            throw new IllegalArgumentException();
        }
        return beforeLocation;
    }

    private List<Integer> checkLastWinnerLotto(List<String> lastWinLotto){

        checkLastWinnerLottoNumberTrue(lastWinLotto);
        List<Integer> lastWinnerLotto = changeStringToInteger(lastWinLotto);
        checkLastWinnerLottoNumberRange(lastWinnerLotto);
        checkLastWinLottoSize(lastWinnerLotto);

        return lastWinnerLotto;
    }

    private void checkLastWinnerLottoNumberRange(List<Integer> lastWinnerLotto){

        for(int i=0;i<lastWinnerLotto.size();i++){

            checkNumberRange(lastWinnerLotto,i);
        }
    }

    private void checkNumberRange(List<Integer> lastWinnerLotto, int numberLocation){
        if(lastWinnerLotto.get(numberLocation) < START_LOTTO_NUMBER || lastWinnerLotto.get(numberLocation) > END_LOTTO_NUMBER){

            System.out.println("로또 번호는 1 ~ 45 까지 입력가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void checkLastWinLottoSize(List<Integer> lastWinnerLotto){

        while(lastWinnerLotto.size() != LOTTO_LENGTH){

            System.out.println("로또 번호는 6개를 선택 하셔야합니다");
            throw new IllegalArgumentException();
        }
    }

    private void checkLastWinnerLottoNumberTrue(List<String> lottoString){
        for (String s : lottoString) {

            checkLastLottoNumberHandling(s);
        }
    }

    private void checkLastLottoNumberHandling(String lottoNumberString){

        try{

            Integer.parseInt(lottoNumberString);
        } catch (NumberFormatException e){

            System.out.println("정확한 값을 입력 해주시기 바랍니다");
            throw e;
        }
    }

    int inputBonusNumber(){

        int bonusNumber;
        System.out.println("보너스 볼을 입력해 주세요");

        while(true){
            try{

                bonusNumber = checkBonusNumberRange();
                break;
            } catch (Exception e){

                System.out.println("보너스 번호를 다시 입력해주세요");
            }
        }
        return bonusNumber;
    }

    private int checkBonusNumberRange(){

        Scanner bonusLottoNumber = new Scanner(System.in);
        int bonusNumber = bonusLottoNumber.nextInt();

        if((bonusNumber < START_LOTTO_NUMBER) || (bonusNumber > END_LOTTO_NUMBER)){

            System.out.println("보너스 번호의 범위를 벗어납니다");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}
