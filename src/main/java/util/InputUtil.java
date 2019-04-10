package util;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
        public int inputPurchaseAmount() {
                Scanner scan = new Scanner(System.in);
                return scan.nextInt();
        }

        public List<Integer> inputLastWeekWinningNumber() {
                Scanner scan = new Scanner(System.in);
                String winningNumberInput = scan.nextLine();
                return ConvertToListWinningNumberInput(winningNumberInput);
        }

        private List<Integer> ConvertToListWinningNumberInput(String winningNumberInput){
                List<Integer> winningNumber = new ArrayList<Integer>();
                String[] winningNumberString = winningNumberInput.split(",");
                for (String OneOfWinningNumber : winningNumberString) {
                        winningNumber.add(Integer.parseInt(OneOfWinningNumber));
                }
                return winningNumber;
        }
}
