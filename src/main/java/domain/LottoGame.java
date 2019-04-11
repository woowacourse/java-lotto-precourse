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
    private static final int GET_LOTTO_MONEY = 1000;

    /* 로또 번호를 생성하는 메소드 */
    private List<Integer> makeLottoNumber(){

        Random random = new Random();
        List<Integer> oneLotto = new ArrayList<>();

        for(int i = 0; i<LOTTO_LENGTH; i++){

            /* 6개의 로또 번호를 생성하기 위한 반복문 */
            oneLotto.add(random.nextInt(END_LOTTO_NUMBER)+START_LOTTO_NUMBER);

            for(int j=0; j<i;j++){

                /* 중복 번호를 확인하기 위한 반복문 */
                i = checkOverlapNumber(oneLotto,i,j);
            }
        }
        return oneLotto;
    }

    /* 번호 중복시 중복된 번호를 삭제하는 메소드 */
    private int checkOverlapNumber(List<Integer> oneLotto,int beforeLocation, int afterLocation){

        if(oneLotto.get(beforeLocation).equals(oneLotto.get(afterLocation))){

            /* 생성된 번호와 이전에 생성된 번호가 같을경우 */
            oneLotto.remove(beforeLocation);                // 중복 번호 삭제
            beforeLocation--;                               // 삭제된 위치로 다시 돌아간다.
        }
        return beforeLocation;
    }

    /* 구입한 로또를 출력하는 메소드 */
    private void printBuyLotto(List<Lotto> oneLotto,int lottoNumber){

        for(int i=0;i<lottoNumber;i++){

            /* 구입한 로또 장수 만큼 반복 */
            Lotto lotto = oneLotto.get(i);
            lotto.printBuyLotto(oneLotto.get(i));
        }
    }

    /* 로또 구매 메소드 */
    List<Lotto> buyLotto(int money){

        int lottoNumber = money/GET_LOTTO_MONEY;              // 구입한 로또 장수;
        List<Lotto> LottoList = new ArrayList<>();

        System.out.println(lottoNumber + "개를 구매했습니다.");

        for(int i=0; i<lottoNumber; i++){

            /* 로또 장수 만큼 반복 하며 List 저장 */
            Lotto lotto = new Lotto(makeLottoNumber());
            LottoList.add(lotto);
        }
        printBuyLotto(LottoList, lottoNumber);                // 로또 출력
        return LottoList;
    }

    /* 지난주 당첨 번호를 입력 받는 메소드 */
    Lotto getLastWinnerNumber() {

        List<String> winnerStringList;
        List<Integer> winnerNumberList;
        System.out.println("지난주 당첨 번호를 입력해주세요");
        while (true) {
            try {

                /* 로또 번호를 입력받아 저장하는 과정 */
                Scanner scanWinnerString = new Scanner(System.in);
                String winnerString = scanWinnerString.nextLine();
                winnerStringList = Arrays.asList(winnerString.split(","));

                winnerNumberList = checkLastWinnerLotto(winnerStringList);
                break;
            } catch (Exception e) {

                /* 요구조건을 벗어나는 로또 번호 입력시 */
                System.out.println("다시 입력해주세요");
            }
        }
        return new Lotto(winnerNumberList);
    }

    /* 입력받은 문자열 로또번호를 정수로 변환 하는 메소드 */
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

    /* 중복되는 로또 번호 검증하는 메소드 */
    private int checkSameLastLottoNumber(List<Integer> lastWinnerLotto,int beforeLocation, int afterLocation){
        if(lastWinnerLotto.get(beforeLocation).equals(lastWinnerLotto.get(afterLocation))){

            /* 저장된 리스트의 값이 중복 일경우 */
            System.out.println("로또 번호는 중복하여 선택이 안됩니다");
            throw new IllegalArgumentException();
        }
        return beforeLocation;
    }

    /* 지난주 당첨 번호 예외 처리 */
    private List<Integer> checkLastWinnerLotto(List<String> lastWinLotto){

        checkLastWinnerLottoNumberTrue(lastWinLotto);
        List<Integer> lastWinnerLotto = changeStringToInteger(lastWinLotto);
        checkLastWinnerLottoNumberRange(lastWinnerLotto);
        checkLastWinLottoSize(lastWinnerLotto);

        return lastWinnerLotto;
    }

    /* 로또 번호 범위를 검증 하는 메소드 */
    private void checkLastWinnerLottoNumberRange(List<Integer> lastWinnerLotto){

        for(int i=0;i<lastWinnerLotto.size();i++){

            checkNumberRange(lastWinnerLotto,i);
        }
    }

    /* 로또 번호 범위 예외 처리 메소드 */
    private void checkNumberRange(List<Integer> lastWinnerLotto, int numberLocation){
        if(lastWinnerLotto.get(numberLocation) < START_LOTTO_NUMBER || lastWinnerLotto.get(numberLocation) > END_LOTTO_NUMBER){

            /* 로또 번호가 1~45범위를 만족하지 않을경우 */
            System.out.println("로또 번호는 1 ~ 45 까지 입력가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    /* 로또 번호 갯수 검증하는 메소드 */
    private void checkLastWinLottoSize(List<Integer> lastWinnerLotto){

        while(lastWinnerLotto.size() != LOTTO_LENGTH){

            System.out.println("로또 번호는 6개를 선택 하셔야합니다");
            throw new IllegalArgumentException();
        }
    }

    /* 로또번호가 정수인지 아닌지 확인하는 메소드 */
    private void checkLastWinnerLottoNumberTrue(List<String> lottoString){
        for (String s : lottoString) {

            checkLastLottoNumberHandling(s);
        }
    }

    /* 로또번호의 정수 유무에 따라 예외처리 */
    private void checkLastLottoNumberHandling(String lottoNumberString){

        try{

            Integer.parseInt(lottoNumberString);
        } catch (NumberFormatException e){

            /* 정수가 아닌경우 예외처리 */
            System.out.println("정확한 값을 입력 해주시기 바랍니다");
            throw e;
        }
    }

    /* 보너스 번호를 입력받는 메소드 */
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

    /* 보너스 번호의 범위를 검증하는 메소드 */
    private int checkBonusNumberRange(){

        Scanner bonusLottoNumber = new Scanner(System.in);
        int bonusNumber = bonusLottoNumber.nextInt();

        if((bonusNumber < START_LOTTO_NUMBER) || (bonusNumber > END_LOTTO_NUMBER)){

            /* 로또 번호가 1~45를 벗어날경우 */
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}
