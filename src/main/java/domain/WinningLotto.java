package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto; //당첨번호 저장 6개
    private final int bonusNo; //당첨보너스 번호 저장 1개

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    } //당첨 번호를 저장한다 (보너스 포함 7개)

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    } //당첨번호와 맞는지 확인하는 메소드
}
