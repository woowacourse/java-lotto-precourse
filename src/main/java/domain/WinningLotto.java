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
        // TODO 로직 구현
        boolean bonus = userLotto.getLottoNumbers().contains(bonusNo);
        userLotto.getLottoNumbers().retainAll(lotto.getLottoNumbers()); // !!주의!! retainAll()은 전달된 리스트 내용이 바뀔수 있다.
        return Rank.valueOf(userLotto.getLottoNumbers().size(), bonus); // 지금은 결과를 확인한 후 번호는 필요 없으므로 사용했다.
    }
}
