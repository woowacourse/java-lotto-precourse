package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int count = 0;
        boolean check_match = matchBonus(userLotto);
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (userLotto.getNumbers().contains(lotto.getNumbers().get(i)))
                count++;
        }
        return Rank.valueOf(count, check_match);
    }

    public Boolean matchBonus(Lotto userLotto) {
        if (userLotto.getNumbers().contains(new Integer(bonusNo)))
            return true;
        return false;
    }
}
