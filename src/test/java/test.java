import com.conatuseus.lotto.appController.AppController;
import com.conatuseus.lotto.appView.AppView;
import com.conatuseus.lotto.model.Lotto;
import com.conatuseus.lotto.model.Rank;
import com.conatuseus.lotto.model.WinningLotto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class test {
    @Test
    public void 사용자_로또_금액_입력_유효성_확인(){      // isMoneyValid 메소드 private로 변경 위해서 주석으로 변경 -> 클래스 구조 변경하면서 재확인불가
//        User user=new User();
//        assertThat(user.isMoneyValid("12345"),is(false));
//        assertThat(user.isMoneyValid(" 1000"),is(false));
//        assertThat(user.isMoneyValid("1000 "),is(false));
//        assertThat(user.isMoneyValid("-1"),is(false));
//        assertThat(user.isMoneyValid("1000"),is(true));
//        assertThat(user.isMoneyValid("0"),is(true));
//        assertThat(user.isMoneyValid("010000"),is(true));
//        assertThat(user.isMoneyValid("abcd"),is(false));
//        assertThat(user.isMoneyValid("a1000"),is(false));
//        assertThat(user.isMoneyValid("008000"),is(true));
    }

    @Test
    public void 지난주_당첨번호_유효성_확인(){
        String[][] check={
            {"0","1","2","3","4","5"},           // 0 : false
            {" ","2","3","4","3"},              // 1 :false;
            {"","","","","",""},                // 2: false         --> 오류났다 체크
            {"1","2","3","4","5"},              // 3: false
            {"1","2","3","4","5","6"},          // 4 : true
            {"1","1","1","1","1","1"},          // 5 : false
            {"40","41","42","43","44","46"},    // 6 : false
            {"100","1","2","3","4","5"},        // 7 : false
            {"a","3","2","1","5","6"},          // 8 : false;       // 오류남
            {"40","12","2","3","5","4"},        // 9 : true
            {"1","2"}                           // 10 : false
        };
        assertThat(AppView.isWinningLottoValid(check[0]),is(false));
        assertThat(AppView.isWinningLottoValid(check[1]),is(false));
        assertThat(AppView.isWinningLottoValid(check[2]),is(false));
        assertThat(AppView.isWinningLottoValid(check[3]),is(false));
        assertThat(AppView.isWinningLottoValid(check[4]),is(true));
        assertThat(AppView.isWinningLottoValid(check[5]),is(false));
        assertThat(AppView.isWinningLottoValid(check[6]),is(false));
        assertThat(AppView.isWinningLottoValid(check[7]),is(false));
        assertThat(AppView.isWinningLottoValid(check[8]),is(false));
        assertThat(AppView.isWinningLottoValid(check[9]),is(true));
        assertThat(AppView.isWinningLottoValid(check[10]),is(false));
    }

    @Test
    public void 보너스_번호_입력_유효성_확인(){

        assertThat(AppView.isWinningBonusValid("1"),is(true));
        assertThat(AppView.isWinningBonusValid("2"),is(true));
        assertThat(AppView.isWinningBonusValid("46"),is(false));
        assertThat(AppView.isWinningBonusValid(""),is(false));
        assertThat(AppView.isWinningBonusValid("-1"),is(false));
        assertThat(AppView.isWinningBonusValid("50"),is(false));
        assertThat(AppView.isWinningBonusValid("~~!!"),is(false));
        assertThat(AppView.isWinningBonusValid("A"),is(false));
        assertThat(AppView.isWinningBonusValid("*"),is(false));

    }

    @Test
    public void 사용자의_로또와_당첨로또_match함수_확인(){
        WinningLotto winningLotto=new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6))),7);

        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,40,41,42)))),is(Rank.FIFTH));       // 3개 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(40,41,42,43,44,45)))),is(Rank.MISS));     // 0개 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(40,41,42,43,44,7)))),is(Rank.MISS));      // 보너스번호만 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,41,42)))),is(Rank.FOURTH));       // 4개 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,42)))),is(Rank.THIRD));         // 5개 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)))),is(Rank.FIRST));          // 6개 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,7)))),is(Rank.SECOND));         // 5개+ 보너스 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,10,20,40,41,42)))),is(Rank.MISS));     // 1개 일치
        assertThat(winningLotto.match(new Lotto(new ArrayList<>(Arrays.asList(1,2,30,40,41,42)))),is(Rank.MISS));      // 2개 일치


    }

    @Test
    public void 사용자로또_당첨개수_확인(){
        AppController appController=new AppController();

    }

    @Test
    public void 수익률_계산_확인(){
        AppController appController=new AppController();
        assertThat(appController.getReturnOfRate(5000L,10000),is(0.5));
        assertThat(appController.getReturnOfRate(10000L,5000),is(2.0));
        assertThat(appController.getReturnOfRate(2_000_000_000L,1_000_000),is(2000.0));
        assertThat(appController.getReturnOfRate(5000L,8000),is(0.625));
    }
}
