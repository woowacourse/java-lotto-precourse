package domain;

import java.util.*;

public class LottoGame {

    private static final int LOTTO_LENGTH = 6;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int START_LOTTO_NUMBER = 1;
    public static final int GET_LOTTO_MONEY = 1000;

    private List<Integer> makeLottoNumber(){

        Random lottoNumber = new Random();
        List<Integer> lottoNumberList = new ArrayList<Integer>();

        for(int i = 0; i<LOTTO_LENGTH; i++){

            lottoNumberList.add(lottoNumber.nextInt(END_LOTTO_NUMBER)+START_LOTTO_NUMBER);
            for(int j=0; j<i;j++){

                i = checkLottoNumber(lottoNumberList,i,j);
            }
        }
        return lottoNumberList;
    }

    private int checkLottoNumber(List<Integer> lottoNumberList,int location, int afterLocation){
        if(lottoNumberList.get(location) == lottoNumberList.get(afterLocation)){
            lottoNumberList.remove(location);
            location--;
        }
        return location;
    }

    private void takeLottoNumber(List<Lotto> lottoNumberList,int getMoney){

        for(int i=0;i<getMoney;i++){

            Lotto lottoNumber = lottoNumberList.get(i);
            lottoNumber.showBuyLotto(lottoNumberList.get(i));

        }
    }

    public List<Lotto> makeTotalLotto(int money){

        int lottoMoney = money/GET_LOTTO_MONEY;
        System.out.println(lottoMoney + "개를 구매했습니다.");
        List<Lotto> totalLotto = new ArrayList<Lotto>();
        for(int i=0; i<lottoMoney; i++){

            Lotto lottoNumber = new Lotto(makeLottoNumber());
            totalLotto.add(lottoNumber);
        }
        takeLottoNumber(totalLotto, lottoMoney);
        return totalLotto;
    }

    public Lotto getLastWinNumber() {

        List<String> inputWinNumber;
        List<Integer> result;
        System.out.println("지난주 당첨 번호를 입력해주세요");
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
        Lotto lastLotto = new Lotto(result);
        return lastLotto;
    }

    private List<Integer> getInLastWinLotto(List<String> lastWinNumberList){

        List<Integer> inputLastNumberInteger = new ArrayList<Integer>();
        for(int i=0; i<lastWinNumberList.size(); i++){

            inputLastNumberInteger.add(Integer.parseInt(lastWinNumberList.get(i)));
            for(int j=0; j<i;j++){

                i = checkLastInLottoNumber(inputLastNumberInteger,i,j);
            }
        }
        return inputLastNumberInteger;
    }
    private int checkLastInLottoNumber(List<Integer> lottoNumberList,int location, int afterLocation){
        if(lottoNumberList.get(location) == lottoNumberList.get(afterLocation)){
            System.out.println("로또 번호는 중복하여 선택이 안됩니다");
            throw new IllegalArgumentException();
        }
        return location;
    }

    private List<Integer> checkLastWinLotto(List<String> lastWinLotto){

        checkLastLottoNumberisTrueAll(lastWinLotto);
        List<Integer> lastWinLottoList = getInLastWinLotto(lastWinLotto);
        checkLastLottoNumber(lastWinLottoList);
        checkLastWinLottoSize(lastWinLottoList);

        return lastWinLottoList;
    }

    private void checkLastLottoNumber(List<Integer> lastWinLotto){

        for(int i=0;i<lastWinLotto.size();i++){

            checkLottoNumberRange(lastWinLotto,i);
        }
    }

    private void checkLottoNumberRange(List<Integer> lastWinLotto, int numberLocation){
        if(lastWinLotto.get(numberLocation) < START_LOTTO_NUMBER || lastWinLotto.get(numberLocation) > END_LOTTO_NUMBER){

            System.out.println("로또 번호는 1 ~ 45 까지 입력가능합니다.");
            throw new IllegalArgumentException();
        }
    }
    private void checkLastWinLottoSize(List<Integer> lastWinLotto){

        while(lastWinLotto.size() != LOTTO_LENGTH){

            System.out.println("로또 번호는 6개를 선택 하셔야합니다");
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

    public int addBonusLottoNumber(){

        int bonusNumber;
        System.out.println("보너스 볼을 입력해 주세요");
        while(true){
            try{
                bonusNumber = checkBonusLottoNumberRange();
                break;
            } catch (Exception e){

                System.out.println("보너스 번호를 다시 입력해주세요");
            }
        }
        return bonusNumber;

    }

    private int checkBonusLottoNumberRange(){

        Scanner bonusLottoNumber = new Scanner(System.in);
        int bonusNumber = bonusLottoNumber.nextInt();

        if((bonusNumber < START_LOTTO_NUMBER) || (bonusNumber > END_LOTTO_NUMBER)){

            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
}
