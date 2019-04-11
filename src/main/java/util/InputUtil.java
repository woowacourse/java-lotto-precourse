/*
 *@(#)InputUtil.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package util;

import java.util.*;

/**
 * 로또 게임에서 전반적인 입력에 대한 기능을 하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class InputUtil {

        private static final long inputPurchaseAmountFormatError = -999_999_999_999l;
        private static final int inputBonusBallFormatError = -999_999_999;

        public static long inputPurchaseAmount() {
                Scanner scan = new Scanner(System.in);
                long input;
                try {
                        input = scan.nextLong();
                } catch (InputMismatchException e) {
                        System.err.println("입력 형식 오류");
                        return inputPurchaseAmountFormatError;
                }
                return input;
        }

        public static List<Integer> inputLastWeekWinningNumber() {
                Scanner scan = new Scanner(System.in);
                String winningNumberInput = scan.nextLine();
                return ConvertToListWinningNumberInput(winningNumberInput);
        }

        public static int inputBonusBall() {
                Scanner scan = new Scanner(System.in);
                int bonusball;
                try {
                        bonusball = scan.nextInt();
                } catch (InputMismatchException e) {
                        System.err.println("입력 형식 오류");
                        return inputBonusBallFormatError;
                }
                return bonusball;
        }

        private static List<Integer> ConvertToListWinningNumberInput(String winningNumberInput) {
                List<Integer> winningNumber = new ArrayList<Integer>();
                String[] winningNumberString = winningNumberInput.split(",");
                if (!checkInputLastWeekWinningNumber(winningNumberString)) {
                        return null;
                }
                for (String OneOfWinningNumber : winningNumberString) {
                        winningNumber.add(Integer.parseInt(OneOfWinningNumber));
                }
                return winningNumber;
        }

        private static boolean checkInputLastWeekWinningNumber(String[] winningNumberString) {
                if (!checkLastWeekWinningNumberSize(winningNumberString)
                        || !checkLastWeekWinningNumberFormat(winningNumberString)
                        || !checkLastWeekWinningNumber1to45(winningNumberString)
                        || !checkLastWeekWinningNumberDuplication(winningNumberString)) {
                        return false;
                }
                return true;
        }

        private static boolean checkLastWeekWinningNumberSize(String[] winningNumberString) {
                if (winningNumberString.length != 6) {
                        System.err.println("입력 갯수 오류(','5개로 구분해주세요.)");
                        return false;
                }
                return true;
        }

        private static boolean checkLastWeekWinningNumberFormat(String[] winningNumberString) {
                boolean check = true;
                for (String winningNumber : winningNumberString) {
                        check = !checkLastWeekWinningNumberFormatOne(winningNumber) ? false : check;
                }
                if (check == false) {
                        System.err.println("입력 형식 오류");
                }
                return check;
        }

        private static boolean checkLastWeekWinningNumberFormatOne(String winningNumber) {
                try {
                        Double.parseDouble(winningNumber);
                        return true;
                } catch (NumberFormatException e) {
                        return false;
                }
        }

        private static boolean checkLastWeekWinningNumber1to45(String[] winningNumberString) {
                boolean check = true;
                for (String winningNumber : winningNumberString) {
                        check = !checkLastWeekWinningNumber1to45One(winningNumber) ? false : check;
                }
                if (check == false) {
                        System.err.println("1~45범위 밖 숫자 입력 오류");
                }
                return check;
        }

        private static boolean checkLastWeekWinningNumber1to45One(String winningNumber) {
                if (Integer.parseInt(winningNumber) < 1 || Integer.parseInt(winningNumber) > 45) {
                        return false;
                }
                return true;
        }

        private static boolean checkLastWeekWinningNumberDuplication(String[] winningNumberString) {
                List<Integer> list = new ArrayList<Integer>();
                for (String winningNumber : winningNumberString) {
                        list.add(Integer.parseInt(winningNumber));
                }
                Collections.sort(list);
                return checkListDuplication(list);
        }

        private static boolean checkListDuplication(List<Integer> list) {
                boolean check = true;
                for (int i = 1; i < list.size(); i++) {
                        check = (list.get(i) == list.get(i - 1)) ? false : check;
                }
                if (check == false) {
                        System.err.println("중복 값 입력 오류");
                }
                return check;
        }
}
