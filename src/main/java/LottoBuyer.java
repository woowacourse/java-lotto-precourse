import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoBuyer {
    private List<Lotto> lottoList = new ArrayList<>();
    private int initMoney;
    private int curMoney;

    public void buyLottos(){
        int cost = LottoSeller.giveLottos(initMoney, lottoList);
        curMoney -= cost;
    }

    public void setMoney() {
        Scanner sc = new Scanner(System.in);
        int money;
        while(true){
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.valueOf(sc.nextLine());
            if(money>=1000) break;
            System.out.println("1000원 이상의 구입금액을 입력해주세요");
        }
        this.initMoney = money;
    }

    public int getInitMoney() {
        return initMoney;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
