import domain.Lotto;
import domain.LottoInfo;
import domain.LottoReader;
import domain.WinningLotto;

import java.util.*;
import java.util.regex.Pattern;

public class LottoReaderFromUser implements LottoReader {
    private static final int INVALID = -1;

    private Scanner sc;

    public LottoReaderFromUser() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public WinningLotto readWinningLotto() {
        System.out.println();

        var nums = _readWinningNums();

        var bonusNo = _readBonusNo(nums);

        return new WinningLotto(new Lotto(nums), bonusNo);
    }

    private List<Integer> _numsStrToNums(String numsStr) {
        if (!Pattern.matches("^[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,*$", numsStr)) {
            return new ArrayList();
        }

        var nums = new ArrayList<Integer>();
        for (var numStr : numsStr.split(",")) {
            nums.add(Integer.parseInt(numStr));
        }
        return nums;
    }

    private boolean isAllUnique(List<Integer> nums) {
        var set = new HashSet<Integer>();
        for (var num : nums) {
            set.add(num);
        }
        return nums.size() == set.size();
    }

    private boolean isAllValidLottoNum(List<Integer> nums) {
        for (var num : nums) {
            if (!LottoInfo.isLottoNum(num)) return false;
        }
        return true;
    }

    private boolean isValidLottoNums(List<Integer> nums) {
        if (!isAllValidLottoNum(nums)) {
            System.out.printf("입력되는 번호는 %d ~ %d 사이의 번호여야 합니다.\n", LottoInfo.LOTTO_NUM_START, LottoInfo.LOTTO_NUM_END);
            return false;
        }
        if (!isAllUnique(nums)) {
            System.out.println("중복되는 번호가 없어야 합니다.");
            return false;
        }
        return nums.size() == LottoInfo.LOTTO_LENGTH;
    }

    private List<Integer> _tryReadWinningNums() {
        var numsStr = sc.nextLine();
        System.out.println("line: " + numsStr);
        var nums = _numsStrToNums(numsStr);

        if (!isValidLottoNums(nums)) return new ArrayList();

        return nums;
    }

    private List<Integer> _readWinningNums() {
        List<Integer> winningNums = new ArrayList();
        while (winningNums.size() != LottoInfo.LOTTO_LENGTH) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            System.out.println("정확한 입력을 위해 ','와 숫자만 사용해서 입력해주세요. 6개의 번호가 필요합니다 ex) 1,2,3,4,5,6");
            winningNums = _tryReadWinningNums();
        }
        return winningNums;
    }

    private int _readInt() {
        System.out.println("보너스 볼을 입력해 주세요");
        int num = INVALID;

        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("got: \n" + sc.nextLine());
            sc.nextLine();
        }
        return num;
    }

    private int _tryReadBonusNo(List<Integer> nums) {
        var bonusNo = _readInt();
        if (bonusNo == INVALID || !LottoInfo.isLottoNum(bonusNo)) {
            System.out.printf("로또번호는 %d ~ %d 인 숫자입니다\n", LottoInfo.LOTTO_NUM_START, LottoInfo.LOTTO_NUM_END);
            return INVALID;
        }
        if (nums.contains(bonusNo)) {
            System.out.println("보너스 볼은 당첨번호와 동일 할 수 없습니다.\n당첨번호 " + Arrays.toString(nums.toArray()));
            return INVALID;
        }
        return bonusNo;
    }

    private int _readBonusNo(List<Integer> nums) {
        var bonusNo = INVALID;
        while (bonusNo == INVALID) {
            bonusNo = _tryReadBonusNo(nums);
        }
        return bonusNo;
    }
}
