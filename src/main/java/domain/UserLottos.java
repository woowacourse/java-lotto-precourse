package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottos {
    private List<Lotto> userLottos = new ArrayList<>();

    public UserLottos(String moneyString){
        try{
            int buyToLottoMoney = (Integer.parseInt(moneyString) / 1000);

            List<Integer> basicLottoNumbers = new ArrayList<>();
            for (int i = 1; i <= 45; i ++){
                basicLottoNumbers.add(i);
            }
            System.out.println(buyToLottoMoney + "개를 구매했습니다.");
            for (int i = 1; i <= buyToLottoMoney; i++){
                Collections.shuffle(basicLottoNumbers);
                List<Integer> selectedLottoNumbers = new ArrayList<>(basicLottoNumbers.subList(0,6));
                System.out.println(selectedLottoNumbers);
                userLottos.add(new Lotto(selectedLottoNumbers));
            }
        }catch (NumberFormatException ex){
            throw new NumberFormatException("구입금액은 숫자만 가능합니다.");
        }
    }
    public int getUserLottosCount(){
        return userLottos.size();
    }

    public void checkWinningLotto(WinningLotto winningLotto){
        for (Lotto lotto : userLottos){
            System.out.println(winningLotto.match(lotto).getCountOfMatch());

        }
    }


}
