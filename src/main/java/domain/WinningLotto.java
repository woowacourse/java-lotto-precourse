package domain;

import java.util.HashSet;
import java.util.Set;

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
    HashSet<Integer> hSetOfLotto = new HashSet<Integer>(userLotto.showNumbers());
    HashSet<Integer> hSetOfWinningLotto = new HashSet<Integer>(lotto.showNumbers());
    boolean matchBonus = hSetOfLotto.contains(bonusNo);
    hSetOfLotto.retainAll(hSetOfWinningLotto);
    int matchCount = hSetOfLotto.size();
    return Rank.valueOf(matchCount, matchBonus);
  }
}
