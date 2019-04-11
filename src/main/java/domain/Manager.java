package domain;

import java.util.*;

public class Manager {
    private User user;
    private ArrayList<Integer> winningNumbesrs;
    private boolean[] checkNumbers;
    private WinningLotto winningLotto;
    private Map<Rank, Integer> winningMap;

    Manager(){
        user = new User();
        winningNumbesrs = new ArrayList<>();
        checkNumbers = new boolean[46];
        winningMap = new LinkedHashMap<>();
    }

    public void startGame(){
        while(!firstQuery());
        user.makeLottoList();
        user.printLottoList();
        while(!secondQuery());
        while(!thirdQuery());
        printResult();
    }

    public void initWinningMap(){
        winningMap.put(Rank.FIFTH, 0);
        winningMap.put(Rank.FOURTH, 0);
        winningMap.put(Rank.THIRD, 0);
        winningMap.put(Rank.SECOND, 0);
        winningMap.put(Rank.FIRST, 0);
    }

    public int makeWinningMap(){
        initWinningMap();
        int totalMoney = 0;

        for(int i=0; i<user.getLottoList().size(); i++){
            Rank rank = winningLotto.match(user.getLottoList().get(i));
            if(rank == Rank.MISS) continue;
            totalMoney += rank.getWinningMoney();
            int count = winningMap.get(rank);
            winningMap.put(rank, count+1);
        }

        return totalMoney;
    }

    public void printRank(Rank rank, int count){
        if (rank != Rank.SECOND){
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + count + "개");
            return;
        }
        System.out.println(rank.getCountOfMatch() + "개 일치, 보너스볼 일치 (" + rank.getWinningMoney() + "원)- " + count + "개");
    }

    public void searchWinningMap(){
        for(Map.Entry<Rank, Integer> factor : winningMap.entrySet()){
            Rank rank = factor.getKey();
            int count = factor.getValue();
            printRank(rank, count);
        }
    }

    public void printEarningRate(int earningAmount, int pay){
        System.out.print("총 수익률은 ");
        System.out.print((double)earningAmount / (double)pay);
        System.out.println("입니다.");
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---------");

        int earningAmount = makeWinningMap();
        searchWinningMap();
        printEarningRate(earningAmount, user.getPay());
    }

    public List<Integer> makeWinningList(){
        List<Integer> winningList = new ArrayList<>();

        for(int i = 1; i<46; i++) {
            if(checkNumbers[i]) winningList.add(i);
        }

        return winningList;
    }

    public void makeWinningLotto(int bonus){
        Lotto lotto = new Lotto(makeWinningList());
        winningLotto = new WinningLotto(lotto, bonus);
    }

    public boolean thirdQuery(){
        System.out.println("보너스 볼을 입력해 주세요.");
        String ret = user.inputBonus();

        if(!CheckFormatError(ret) || !checkRangeNumber(Integer.parseInt(ret))
                || !checkDuplicateNumber(Integer.parseInt(ret))){
            return false;
        }

        makeWinningLotto(Integer.parseInt(ret));
        return true;
    }

    public boolean secondQuery(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<String> ret = user.inputNumbers();

        if(!checkWinningNumbers(ret)){
            return false;
        }

        return true;
    }

    public void initCheckNumbers(){
        for(int i=1; i<46; i++){
            checkNumbers[i] = false;
        }
    }

    public boolean checkDuplicateNumber(int number){
        if(checkNumbers[number]){
            System.out.println(InputError.DUPLICATE_ERROR);
            return false;
        }
        return true;
    }

    public boolean checkRangeNumber(int number){
        if(number<1 || number>45){
            System.out.println(InputError.NUMBER_RANGE_ERROR);
            return false;
        }
        return true;
    }

    public boolean checkNumberCount(int cnt){
        if(cnt != 6){
            System.out.println(InputError.NUMBER_CNT_ERROR);
            return false;
        }
        return true;
    }

    public boolean checkWinningNumbers(List<String> list){
        initCheckNumbers();

        int cnt = 0;

        for(int i=0; i<list.size(); i++){
            int number = Integer.parseInt(list.get(i));

            if(!CheckFormatError(list.get(i)) || !checkDuplicateNumber(number)
                    || !checkRangeNumber(number)) return false;

            checkNumbers[number] = true;
            cnt++;
        }

        return checkNumberCount(cnt);
    }

    public boolean firstQuery(){
        System.out.println("구입금액을 입력해 주세요.");
        String ret = user.inputMoney();

        if(!CheckFormatError(ret) || !CheckMinusError(Integer.parseInt(ret))
                || !CheckRestError(Integer.parseInt(ret))) return false;

        return true;
    }

    public boolean CheckRestError(int input){
        if(input % 1000 != 0){
            System.out.println(InputError.REST_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckMinusError(int input){
        if(input <= 0) {
            System.out.println(InputError.MINUS_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckFormatError(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            System.out.println(InputError.NUMBER_FORMAT_ERROR);
            return false;
        }
        return true;
    }

}
