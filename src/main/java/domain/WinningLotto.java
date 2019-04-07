package domain;



import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;
    private int countOfMatch = 0;
    private Boolean matchBonus = false;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        countOfMatch = 0;
        userLotto.getNumbers().retainAll(lotto.getNumbers());

        checkBonus(userLotto);
        for (int i = 0; i<userLotto.getNumbers().size(); i++) {
            countOfMatch++;
        }

        Rank rank = Rank.valueOf(countOfMatch,matchBonus);
        System.out.println("상금 : " + rank.getWinningMoney());
        System.out.println("매치횟수 : " + rank.getCountOfMatch());

        return null;
    }

    public void checkBonus(Lotto userLotto) {
        if (userLotto.getNumbers().contains(bonusNo)) {
            matchBonus = true;
        }
    }
}
