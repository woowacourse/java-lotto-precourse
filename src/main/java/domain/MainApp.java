package domain;

import java.util.*;

public class MainApp {
    static final int MIN_VALID_MONEY_TO_BUY_LOTTO = 1000;
    static final int LOTTO_PRICE = 1000;
    static final String MESSAGE_WRONG_MONEY_TO_BUY_LOTTO = "잘못된 입력입니다. 1000으로 나누어 떨어지는 양의 정수를 입력해 주세요.";

    public static void main(String[] args) {
        printLottos(createLottosWorth(5000));
    }


    /**
     * 사용자가 입력한 로또 구입 금액이 적절한지 판단하는 메소드
     */
    public static boolean isValidMoneyToBuyLotto(int money) {
        return ((money >= MIN_VALID_MONEY_TO_BUY_LOTTO) && (money % LOTTO_PRICE == 0));
    }

    /**
     * 사용자에게 정수를 입력받아 반환하는 메소드
     */
    public static int getIntegerFromUser() {
        Scanner rd = new Scanner(System.in);
        while(true) {
            try {
                return rd.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(MESSAGE_WRONG_MONEY_TO_BUY_LOTTO);
                rd.nextLine();
            }
        }
    }

    /**
     * 사용자에게 로또 구입 금액을 입력받는 메소드
     */
    public static int getMoneyToBuyLotto() {
        int money;

        while (!isValidMoneyToBuyLotto(money = getIntegerFromUser())) {
            System.out.println(MESSAGE_WRONG_MONEY_TO_BUY_LOTTO);
        }
        return money;
    }

    /**
     * 로또 한개를 무작위로 발급하는 메소드
     */
    public static Lotto createRandomLotto() {
        TreeSet<Integer> lottoNumbers = new TreeSet<Integer>();                     // 중복을 허용하지 않는 TreeSet 컬렉션을 사용한다.
        int randomNumber;

        while (lottoNumbers.size() < 6) {
            randomNumber = (int)(Math.random() * 45) + 1;                           // 1~45 사이의 정수 하나를 무작위로 생성한다.
            lottoNumbers.add(randomNumber);
        }

        ArrayList<Integer> arrLottoNumbers = new ArrayList<Integer>(lottoNumbers);  // TreeSet 을 ArrayList 로 변환한다.
        return new Lotto(arrLottoNumbers);
    }

    /**
     * 로또 구입 금액에 해당하는 수의 로또를 발급하는 메소드
     */
    public static ArrayList<Lotto> createLottosWorth(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        ArrayList<Lotto> listOfLottos = new ArrayList<Lotto>();

        for (int i=0; i<numberOfLottos; i++) {
            listOfLottos.add(createRandomLotto());
        }
        return listOfLottos;
    }

    /**
     * 로또 번호들을 출력하는 메소드
     */
    public static void printLottos(ArrayList<Lotto> lottoList) {
        Iterator<Lotto> it = lottoList.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }


}
