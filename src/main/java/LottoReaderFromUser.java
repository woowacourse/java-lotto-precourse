import domain.Lotto;
import domain.LottoReader;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoReaderFromUser implements LottoReader {

    private Scanner sc;

    public LottoReaderFromUser() {
        this.sc = new Scanner(System.in);
    }
    @Override
    public WinningLotto readWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        var numsStr = sc.next();

        var nums = new ArrayList<Integer>();
        for(var numStr : numsStr.split(",")) {
            nums.add(Integer.parseInt(numStr));
        }

        System.out.println("보너스 볼을 입력해 주세요");
        var bonusNo = sc.nextInt();

        // 아.. 어차피.. lotto 번호인지 확인하는 부분이 필요하구먼

        return new WinningLotto(new Lotto(nums), bonusNo);
    }
}
