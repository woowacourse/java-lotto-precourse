package domain;

import java.util.*;

import static domain.Validator.LOTTO_MAXIMUM_NUMBER_COUNT;
import static domain.Validator.LOTTO_MAXIMUM_NUMBER_VALUE;

/**
 * 로또들을 생성하는 객체
 *
 * @version 1.1(2019.04.11)
 * @author jongyoon Kim
 */
public class LottoCreator {
    private static Validator validator = new Validator();

    public WinningLotto createWinningLotto(List<Integer> winningNum, int bonus){
        return new WinningLotto(createLotto(winningNum), bonus);
    }

    /**
     * 로또를 산 만큼 로또 생성 및 생성된 로또 출력
     *
     * @param amount 로또 개수
     * @return 입력 받은 개수만큼 로또를 생성하여 반환
     */
    public ArrayList<Lotto> purchaseLottoForAmount(int amount){
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            Lotto createdLotto = createLotto(createRandomNumbers(LOTTO_MAXIMUM_NUMBER_COUNT));
            System.out.println(createdLotto.getLottoNumbers());
            lottoList.add(createdLotto);
        }
        return lottoList;
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

    /**
     * 입력 받은 당첨 번호를 ","를 기준으로 나누고 중복이거나 최댓값을 넘어간다면 재입력
     *
     * @param winningNum 당첨 번호
     * @return 최종적으로 뽑힌 당첨 번호
     */
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

    /**
     * 조건 확인 후 재입력
     *
     * @param isReInput 재입력 조건
     * @param origin 기존 입력
     * @return 조건에 만족한다면 재입력, 만족하지 않는다면 기존 입력 반환
     */
    private String reInputWinningNumbers(boolean isReInput, String origin){
        if(isReInput){
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
