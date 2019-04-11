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

    /* userLotto의 6개 번호 중 특정 당첨번호가 있는지*/
    private int isMatchNumbers(Lotto userLotto, int num) {
        if (userLotto.getNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        int countOfMatch = 0;
        boolean matchBonus;

        for (int num : lotto.getNumbers()) {
            countOfMatch += isMatchNumbers(userLotto, num);
        }
        matchBonus = userLotto.getNumbers().contains(bonusNo);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
