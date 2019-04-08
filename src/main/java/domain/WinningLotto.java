package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
	// 인스턴스 변수 추가 X
    private final Lotto lotto;
    private final int bonusNo;

    // 기본 생성자 추가 불가능
    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        int count = userLotto.getCount(lotto);
        boolean isBonus = userLotto.contains(bonusNo);
        return Rank.valueOf(count, isBonus);
    }
}
