package domain;

import java.util.*;
import java.io.IOException;

/**
 * 사용자 입력과 정보 출력을 위한 클래스
 * 사용자 입력에 대한 예외 처리를 하는 클래스
 */
public class LottoIO {
    public static void printPurchase() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static int receivePrice() throws IOException {
        Scanner s = new Scanner(System.in);
        String priceString = s.nextLine();
        try {
            checkInvalidPrice(priceString);
            return Integer.parseInt(priceString);
        } catch (IOException e) {
            throw new IOException();
        } catch (NumberFormatException e2) {
            throw new IOException();
        }
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printlottoNumber(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < LottoConstant.LOTTO_MAX_COUNT - 1; i++) {
            System.out.print(lotto.get(i) + ", ");
        }
        System.out.println(lotto.get(LottoConstant.LOTTO_MAX_COUNT - 1) + "]");
    }

    public static List<Integer> receiveWinningLotto() throws IOException {
        List<Integer> winningLottoNumber = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String lottoLine = s.nextLine();
        String[] winningLottoNumberString = lottoLine.split(",");
        if (winningLottoNumberString.length != 6) {
            throw new IOException();
        }
        for (int i = 0; i < winningLottoNumberString.length; i++) {
            checkInvalidInput(winningLottoNumberString[i]);
            winningLottoNumber.add(Integer.parseInt(winningLottoNumberString[i]));
        }
        checkDuplicate(winningLottoNumberString);
        return (winningLottoNumber);
    }

    public static int receiveBonusNumber(List<Integer> winningLottoNumberList) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            int bonusNumber = s.nextInt();
            checkDuplicateBonusNumber(winningLottoNumberList, bonusNumber);
            return bonusNumber;
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능 합니다.");
            throw new IOException();
        }
    }

    /*
     * 보너스 볼의 번호가 당첨 번호와 중복 되는 경우 예외 처리
     */
    public static void checkDuplicateBonusNumber(List<Integer> winningLottoNumberList, int bonusNumber) throws IOException {
        if (winningLottoNumberList.contains(bonusNumber)) {
            System.err.println("보너스 볼이 당첨 번호와 중복 됩니다.");
            throw new IOException();
        }
    }
    /*
     * 구입 금액이 1000원 미만인 경우 예외 처리
     */
    public static void checkInvalidPrice(String priceString) throws IOException {
        int price = Integer.parseInt(priceString);
        if (price < LottoConstant.LOTTO_PRICE) {
            System.err.println("로또를 구매할 수 없습니다.");
            throw new IOException();
        }
    }

    /*
     * 받은 입력이 숫자가 아닌 경우 예외 처리
     */
    public static void checkInvalidInput(String winningLottoNumber) throws IOException {
        try {
            int lottoNumber = Integer.parseInt(winningLottoNumber);
            checkInvalidInput(lottoNumber);
        } catch (NumberFormatException e) {
            System.err.println("숫자가 아닙니다.");
            throw new IOException();
        } catch (IOException e2) {
            throw new IOException();
        }
    }

    /*
     * 받은 숫자가 1 ~ 45 사이의 숫자가 아닌 경우 예외 처리
     */
    public static void checkInvalidInput(int bonusNumber) throws IOException {
        if (bonusNumber < LottoConstant.RANDOM_NUMBER_LOWER_LIMIT || bonusNumber > LottoConstant.RANDOM_NUMBER_UPPER_LIMIT) {
            System.err.println("1 ~ 45 사이의 숫자가 아닙니다.");
            throw new IOException();
        }
    }

    /*
     * 보너스 볼 숫자가 중복된 숫자인 경우 예외 처리
     */
    public static void checkDuplicate(String[] winningLottoNumberString) throws IOException {
        List<Integer> winningLottoNumberIntegerList = new ArrayList<Integer>();
        for (int i = 0; i < winningLottoNumberString.length; i++) {
            winningLottoNumberIntegerList.add(Integer.parseInt(winningLottoNumberString[i]));
        }
        HashSet<Integer> winningLottoNumberHashSet = new HashSet<Integer>(winningLottoNumberIntegerList);
        if (winningLottoNumberHashSet.size() != winningLottoNumberIntegerList.size()) {
            throw new IOException();
        }
    }

    /*
     * 로또 게임 결과 출력
     */
    public static void printLottoResult(List<Lotto> lottoList, WinningLotto winningLotto) {
        List<Rank> rankList = new ArrayList<Rank>();
        System.out.println("당첨 통계\n----------");
        double yield;
        for (int i = 0; i < lottoList.size(); i++) {
            rankList.add(winningLotto.match(lottoList.get(i)));
        }
        printRankAll(rankList);
        yield = Calculation.calcYield(rankList, lottoList.size());
        System.out.printf("총 수익률은 %.3f 입니다.\n", yield);
    }

    public static void printRankCount(List<Rank> rankList, int countOfMatch, boolean matchBonus) {
        Rank currentRank = Rank.valueOf(countOfMatch, matchBonus);
        int rankCount = Collections.frequency(rankList, currentRank);
        if (!matchBonus) {  // Bonus 볼 불일치
            System.out.println(currentRank.getCountOfMatch() + "개 일치(" + currentRank.getWinningMoney() + "원)- " + rankCount + "개");
            return;
        }
        System.out.println(currentRank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + currentRank.getWinningMoney() + "원)- " + rankCount + "개");
    }

    public static void printRankAll(List<Rank> rankList) {
        Rank[] rank = Rank.values();
        for (int i = 0; i < LottoConstant.LOTTO_PRINT_RANK_LIMIT; i++) {
            printRankCount(rankList, rank[LottoConstant.LOTTO_PRINT_RANK_LIMIT-1-i].getCountOfMatch(), (rank[LottoConstant.LOTTO_PRINT_RANK_LIMIT-1-i] == Rank.SECOND));
        }
    }
}
