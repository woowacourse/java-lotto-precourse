package util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
        public static long inputPurchaseAmount() {
                Scanner scan = new Scanner(System.in);
                long input;
                try {
                        input = scan.nextLong();
                }catch(InputMismatchException e){
                        System.err.println("입력 형식 오류");
                        return -999_999_999_999l;
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
                int bonusball = scan.nextInt();
                return bonusball;
        }

        private static List<Integer> ConvertToListWinningNumberInput(String winningNumberInput) {
                List<Integer> winningNumber = new ArrayList<Integer>();
                String[] winningNumberString = winningNumberInput.split(",");
                for (String OneOfWinningNumber : winningNumberString) {
                        winningNumber.add(Integer.parseInt(OneOfWinningNumber));
                }
                return winningNumber;
        }
}
