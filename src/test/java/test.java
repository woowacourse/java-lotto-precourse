import com.conatuseus.lotto.appView.AppView;
import org.junit.Test;

import java.util.ArrayList;
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

    public void 보너스_번호_입력_유효성_확인(){

    }
}
