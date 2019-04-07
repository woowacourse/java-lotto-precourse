package domain;

import java.util.*;

public class InputLottoInformation {
    private Scanner sc ;
    private List<Lotto> lotto ;
    private final int lottoPrice = 1000;
    private final int maxLottoNo = 45;
    private final int minLottoNo = 1;
    private final int LottoBallCount = 6;
    private HashSet<Integer> overlapNo;

    private void init() {
        sc = new Scanner(System.in);
    }

    public int getLottoPurchasePrice() {
        init();
        int purchasePrice = 0;
        do {
            purchasePrice = checkPriceOnlyNumber(purchasePrice);
        } while (checkPrice(purchasePrice));
        return purchasePrice;
    }

    private int checkPriceOnlyNumber(int purchasePrice) {
        try {
            System.out.println(Message.lottoInputMessage.get("INPUT_PURCHASEMONEY"));
            purchasePrice = sc.nextInt();
        } catch (InputMismatchException ime) {
            sc= new Scanner(System.in);
            System.out.println(Message.errorMessage.get("ERROR_ONLYNUMBER"));
            return getLottoPurchasePrice();
        }
        return purchasePrice;
    }

    private boolean checkPrice(int pirce) {
        if (pirce <lottoPrice) { // 1000보다 적음 못삼
            System.out.println(Message.errorMessage.get("ERROR_MONEYSHORT"));
            return true;
        }
        return false;
    }

    public List<Lotto> getGeneratedLottoNumber(int money) {
        setLottoNumber(money);
        return lotto;
    }

    private void setLottoNumber(int money) {
        for (int i = money; i >=lottoPrice; i -= lottoPrice) {
            overlapNo = new HashSet<>();
            lotto.add(new Lotto(setSixNumber()));
        }
    }

    private List<Integer> setSixNumber() {
        List<Integer> lottonumber = new LinkedList<>();
        do {
            overlapNo.add((int) ((Math.random() * 44) + 1)); //1~45
        } while (overlapNo.size() < LottoBallCount);
        Iterator<Integer> it = overlapNo.iterator();
        while (it.hasNext()) {
            lottonumber.add((int) it.next());
        }
        return lottonumber;
    }
}
