package domain;

import java.util.*;

import static domain.Validator.LOTTO_MAXIMUM_NUMBER_COUNT;
import static domain.Validator.LOTTO_MAXIMUM_NUMBER_VALUE;

/**
 * 로또들을 생성하는 객체
 *
 * @version 1.0(2019.04.10)
 * @author jongyoon Kim
 */
public class LottoCreator {
    private static Validator validator = new Validator();

    public WinningLotto createWinningLotto(List<Integer> winningNum, int bonus){
        return new WinningLotto(createLotto(winningNum), bonus);
    }

    public ArrayList<Lotto> purchaseLottoForAmount(int amount){
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            Lotto createdLotto = createNonDuplicatedLotto(lottoList);
            System.out.println(createdLotto.getLottoNumbers());
            lottoList.add(createdLotto);
        }
        return lottoList;
    }

    private Lotto createNonDuplicatedLotto(ArrayList<Lotto> lottoList){
        Lotto lotto;
        do{
            lotto = createLotto(createRandomNumbers(LOTTO_MAXIMUM_NUMBER_COUNT));
        }while (validator.isExistLottoInLottoList(lottoList, lotto));
        return lotto;
    }

    private Lotto createLotto(List<Integer> numbers){
        return new Lotto(numbers);
    }

    private List<Integer> createRandomNumbers(int numberCnt){
        List<Integer> randomNumsList = new ArrayList<>();
        while(randomNumsList.size() < numberCnt){
            int createdNum = createRandomNumAndCheckingExistNumInList(randomNumsList);
            randomNumsList.add(createdNum);
        }
        Collections.sort(randomNumsList);
        return randomNumsList;
    }

    private int createRandomNumAndCheckingExistNumInList(List<Integer> list){
        int randomNum;
        do{
            randomNum = new Random().nextInt(LOTTO_MAXIMUM_NUMBER_VALUE) + 1;
        }while(list.contains(randomNum));
        return randomNum;
    }

    public List<Integer> splitWinningNumAndCheckingReInput(String winningNum){
        List<Integer> splittedWinningNum;
        boolean isDuplicateAndOverNum;
        do{
            splittedWinningNum = winningNumSplit(winningNum);
            isDuplicateAndOverNum = validator.isDuplicateAndNumOverValue(splittedWinningNum);
            winningNum = reInputWinningNumbers(isDuplicateAndOverNum, winningNum);
        }while (isDuplicateAndOverNum);

        return splittedWinningNum;
    }

    private List<Integer> winningNumSplit(String winningNum){
        return changeStrListToIntList(Arrays.asList(winningNum.split(",")));
    }

    private String reInputWinningNumbers(boolean isRestart, String origin){
        if(isRestart){
            return new Inputter().inputWinningNumber();
        }
        return origin;
    }

    private List<Integer> changeStrListToIntList(List<String> strList){
        List<Integer> intList = new ArrayList<>();
        for(String str : strList){
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }
}
