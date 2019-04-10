package matcher;

import object.LottoNumber;
import object.WinningLotto;

public abstract class Matcher {
        private final WinningLotto winningLotto;

        public Matcher(WinningLotto winningLotto){
                this.winningLotto = winningLotto;
        }

        public abstract int match(LottoNumber lottoNumber);
}
