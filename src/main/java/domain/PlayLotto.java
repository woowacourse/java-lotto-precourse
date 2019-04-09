/*
 * @PlayLotto.java     0.1 2019-04-10
 * Copyright(c) 2019 LeeYunSeop All rights reserved.
 * */

package domain;

import utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Lotto는 다음 순서로 진행한다.
 * 1. Lotto 구입 금액 입력
 * 2. 금액에 맞는 갯수 구입
 * 3. 당첨 번호 입력
 * 4. 보너스 볼 입력
 * 5. 당첨 확인 및 통계 출력
 *
 * @author yun
 * @version 0.1
 */
public class PlayLotto {
    private List<Lotto> myLotto = new ArrayList<>(); // 구입한 내 Lotto List
    private WinningLotto winningLotto; // 당첨 번호 및 보너스 볼

    /**
     * Lotto 실행
     */
    public void play() {
        int money = insertMoney();
        purchaseLotto(money);
        setWinningLotto();
        printWinningStatistics(money);
    }

    /**
     * 구입 금액 입력
     * 0 이상의 자연수
     *
     * @return 구입 금액
     */
    public int insertMoney() {
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        while (money < 0) {
            System.out.println("Lotto 구입금액은 0이상의 자연수입니다.");
            System.out.println("구입금액을 입력해 주세요.");
            money = sc.nextInt();
        }
        return money;
    }

    /**
     * 구입 금액으로 Lotto 구매
     * 한 장당 1000원
     * myLotto instance variable에 Lotto object 저장
     *
     * @param money 구입 금액
     */
    public void purchaseLotto(int money) {
        List<Integer> lottoNumber; // Lotto 번호 List
        int lottoPrice = 1000;
        int numberOfLotto = money / lottoPrice; // 구입할 Lotto 개수
        System.out.printf("\n%d개를 구매했습니다.\n", numberOfLotto);
        for (int i = 0; i < numberOfLotto; i++) {
            lottoNumber = generatingLottoNumber(); // Lotto 번호 생성
            System.out.println(lottoNumber);
            myLotto.add(new Lotto(lottoNumber));
        }
    }

    /**
     * winningLotto instance variable에 당첨 번호와 보너스 볼 저장
     */
    public void setWinningLotto() {
        List<Integer> winningLottoNumber = insertWinningLottoNumber();
        int bonusNumber;
        ValidBonusNumber validBonusNumber;
        do {
            bonusNumber = insertBonusNumber();
            validBonusNumber = new ValidBonusNumber(winningLottoNumber, bonusNumber);
        } while (validBonusNumber.isValid());
        winningLotto = new WinningLotto(new Lotto(winningLottoNumber), bonusNumber);
    }

    /**
     * 당첨 번호 입력
     *
     * @return 크기가 6인 중복 없는 1 ~ 45 사이의 자연수 List
     */
    public List<Integer> insertWinningLottoNumber() {
        Scanner sc = new Scanner(System.in);
        String[] rawWinningNumber;
        ValidLottoNumber validLottoNumber;
        do {
            System.out.println("지난 주 당첨 번호를 입력해주세요.");
            rawWinningNumber = sc.nextLine().split(",");
            validLottoNumber = new ValidLottoNumber(rawWinningNumber);
        } while (validLottoNumber.isValid());
        return Utils.convertString2Int(rawWinningNumber);
    }

    /**
     * 보너스 볼 입력
     */
    public int insertBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해주세요.");
        return sc.nextInt();
    }

    /**
     * 당첨 통계 출력
     * 당첨 등급에 대해 각 당첨 횟수 출력
     * 총 수익률 출력
     *
     * @param money 구입 금액
     */
    public void printWinningStatistics(int money) {
        System.out.println("\n당첨 통계\n-------");
        int totalWinningPrice = 0;
        List<Rank> lottoResultList = matchLotto();
        int lottoFrequency; // 당첨 등급별 빈도
        for (Rank rank : Rank.values()) {
            lottoFrequency = Collections.frequency(lottoResultList, rank);
            printWinningMessage(rank, lottoFrequency);
            totalWinningPrice += lottoFrequency * rank.getWinningMoney();
        }
        System.out.printf("총 수익률은 %.3f입니다.\n",
                (float) totalWinningPrice / money);
    }

    /**
     * 구입한 Lotto와 당첨 번호를 비교
     *
     * @return 당첨 결과
     */
    public List<Rank> matchLotto() {
        Rank lottoResult;
        List<Rank> lottoResultList = new ArrayList<>();
        for (Lotto lotto : myLotto) {
            lottoResult = winningLotto.match(lotto);
            lottoResultList.add(lottoResult);
        }
        return lottoResultList;
    }

    /**
     * 등급에 따른 메세지 출력
     *
     * @param matchResult 당첨 등급
     * @param number      당첨 등급의 빈도수
     */
    public void printWinningMessage(Rank matchResult, int number) {
        int countOfMatch = matchResult.getCountOfMatch();
        int winningMoney = matchResult.getWinningMoney();
        int winningMinCount = matchResult.getWinningMinCount();
        if (matchResult == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원)- %d개\n",
                    countOfMatch, winningMoney, number);
        } else if (countOfMatch >= winningMinCount) {
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    countOfMatch, winningMoney, number);
        }
    }

    /**
     * Lotto 번호 생성
     *
     * @return 1 ~ 45 사이, 크기가 6인 List
     */
    public List<Integer> generatingLottoNumber() {
        int lottoCount = 6; // Lotto 숫자 갯수
        int lottoNumberBegin = 1; // Lotto 숫자 범위, 시작
        int lottoNumberEnd = 45; // Lotto 숫자 범위, 끝
        List<Integer> lottoNumber = new ArrayList<>();
        for (int number = lottoNumberBegin; number <= lottoNumberEnd; number++) {
            lottoNumber.add(number);
        }
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, lottoCount);
    }
}

/**
 * 보너스 볼 입력에 대한 검사
 * 1 ~ 45 사이의 자연수
 * 당첨 번호와 중복 여부
 *
 * @author yun
 * @version 0.1
 */
class ValidBonusNumber extends ValidLottoNumber {
    private int bonusNumber;
    private List<Integer> winningLottoNumber;

    public ValidBonusNumber(List<Integer> winningLottoNumber, int bonusNumber) {
        super(null);
        this.winningLottoNumber = winningLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    /**
     * 보너스 볼이 유효성 여부
     *
     * @return 조건을 만족하면 false
     */
    public boolean isValid() {
        return !isValidBonusNumber() || hasBonusNumber();
    }

    /**
     * 보너스 볼이 1 ~ 45 사이 속하는지 확인
     *
     * @return 조건 만족시 true
     */
    public boolean isValidBonusNumber() {
        if (LOTTO_NUMBER_BEGIN <= bonusNumber &&
                bonusNumber <= LOTTO_NUMBER_END) {
            return true;
        }
        System.out.println("보너스 볼의 범위는 1 ~ 45 사이의 자연수입니다.");
        return false;
    }

    /**
     * 보너스 볼이 당첨 번호와 중복 여부
     *
     * @return 중복시 true
     */
    public boolean hasBonusNumber() {
        if (winningLottoNumber.contains(bonusNumber)) {
            System.out.println("당첨번호와 보너스 볼이 중복됬습니다.");
            return true;
        }
        return false;
    }
}

/**
 * 당첨 번호가 규칙을 만족하는지 검사
 * 1 ~ 45 사이의 자연수
 * 크기가 6인 List
 * 중복여부
 *
 * @author yun
 * @version 0.1
 */
class ValidLottoNumber {
    protected final int LOTTO_NUMBER_BEGIN = 1;
    protected final int LOTTO_NUMBER_END = 45;
    private String[] rawWinningNumber;

    public ValidLottoNumber(String[] rawWinningNumber) {
        this.rawWinningNumber = rawWinningNumber;
    }

    /**
     * 조건을 만족 여부
     *
     * @return 만족시 false
     */
    public boolean isValid() {
        return !isValidNumberOfRange() ||
                !isValidSizeOfWinningNumber() ||
                !isDuplicatedNumber();
    }

    /**
     * 중복 여부
     *
     * @return 중복시 false
     */
    public boolean isDuplicatedNumber() {
        int frequency;
        int threshold = 1; // 중복여부 기준
        List<Integer> intNumber = Utils.convertString2Int(rawWinningNumber);
        for (int i = LOTTO_NUMBER_BEGIN; i <= LOTTO_NUMBER_END; i++) {
            frequency = Collections.frequency(intNumber, i);
            if (frequency > threshold) {
                System.out.println("중복된 당첨번호가 있습니다.");
                return false;
            }
        }
        return true;
    }

    /**
     * 1 ~ 45 사이의 자연수
     *
     * @return 만족시 true
     */
    public boolean isValidNumberOfRange() {
        List<Integer> intNumber = Utils.convertString2Int(rawWinningNumber);
        for (int number : intNumber) {
            if (number < LOTTO_NUMBER_BEGIN || number > LOTTO_NUMBER_END) {
                System.out.println("당첨번호는 1 ~ 45 사이의 자연수입니다.");
                return false;
            }
        }
        return true;
    }

    /**
     * 콤마(,)로 구분한 당첨 번호 크기 확인
     *
     * @return 크기가 6이면 true
     */
    public boolean isValidSizeOfWinningNumber() {
        int lottoCount = 6; // Lotto List 사이즈
        if (rawWinningNumber.length != lottoCount) {
            System.out.println("당첨번호는 콤마(,)로 구분하며 6개의 자연수입니다.");
            return false;
        }
        return true;
    }
}