package domain;

/**
 * 당첨 번호를 담당하는 객체
 */

/*
 WinningLotto 기본 생성자를 추가할 수 없다.
 lotto, bonusNo 변수의 접근 제어자인 private을 변경할 수 없다.
 WinningLotto에 필드(인스턴스 변수)를 추가할 수 없다.
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
        return null;
    }
}
