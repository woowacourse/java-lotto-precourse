package domain;

import java.util.*;

public class User {
    private ArrayList<Lotto> lottoList;
    private Scanner scanner;
    private String pay;
    private int lottoCnt;

    User(){
        scanner = new Scanner(System.in);
        lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
    
    public int getPay(){
        return Integer.parseInt(pay);
    }

    public String inputBonus(){
        String input;
        input = scanner.nextLine();
        return input;
    }

    public List<String> inputNumbers(){
        String input;
        input = scanner.nextLine();
        return tokenize(input);
    }

    public List<String> tokenize(String input){
        List<String> winningNumbers = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            winningNumbers.add(token.nextToken());
        }
        return winningNumbers;
    }

    public String inputMoney(){
        pay = scanner.nextLine();
        return pay;
    }

    int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(45) + 1;
    }

    public void makeLottoList(){
        lottoCnt = Integer.parseInt(pay) / 1000;

        for(int i=0; i<lottoCnt; i++){
            lottoList.add(makeLotto());
        }
    }

    public void printLottoList(){
        System.out.print(lottoCnt);
        System.out.println("개를 구매했습니다.");
        for(int i=0; i<lottoCnt; i++){
            lottoList.get(i).printLotto();
        }
        System.out.println();
    }

    public Lotto makeLotto(){
        boolean[] checkNumber = new boolean[46];
        ArrayList<Integer> numbers = new ArrayList<>();
        Lotto lotto;

        // indent 1로 나중에 수정하자
        for(int i=0; i<6; i++){
            int number = getRandomNumber();
            if(!checkNumber[number]) {
                checkNumber[number] = true;
                numbers.add(number);
                continue;
            }
            i--;
        }

        lotto = new Lotto(numbers);
        return lotto;
    }
}
