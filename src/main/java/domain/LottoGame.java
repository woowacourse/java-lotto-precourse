package domain;

public class LottoGame {
    private static final String INFO_BUY_MONEY = "구입금액을 입력해 주세요.";

    public static void main(String[] args){
        System.out.println(INFO_BUY_MONEY);
        CreateUserLotto.createRandom();
        CreateUserLotto.createLotto(5);
    }
}
