package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInputReciever {
    private static final int UNIT_OF_PURCHASE_AMOUNT = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private Scanner scanner = new Scanner(System.in);

    public int RecievePurchaseAmount() {
        int purchaseAmount = 0;
        try {
            purchaseAmount = TryToRecievePurchaseAmount();
        } catch (IllegalArgumentException e) {
           e.printStackTrace();
        }

        return FindLottoCount(purchaseAmount);
    }

    private int FindLottoCount(int purchaseAmount){
        return purchaseAmount / UNIT_OF_PURCHASE_AMOUNT;
    }

    private int TryToRecievePurchaseAmount() throws IllegalArgumentException {
        System.out.println("구매금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();

        if ((purchaseAmount >= UNIT_OF_PURCHASE_AMOUNT) && (purchaseAmount % UNIT_OF_PURCHASE_AMOUNT == 0)) {
            return purchaseAmount;
        }

        throw new IllegalArgumentException(purchaseAmount + "는 유효하지 않은 값입니다.");
    }

    public void TryToRecieveWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String winningNumber = scanner.nextLine();

        List<String> stringWinningNumbers = Arrays.asList(winningNumber.split(","));
        List<Integer> winningNumbers = ConvertListTypeToInt(stringWinningNumbers);

        System.out.println("이후 구현 예정");


    }

    private List<Integer> ConvertListTypeToInt(List<String> stringWinningNumbers){
        List<Integer> WinningNumbers = stringWinningNumbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return WinningNumbers;
    }







}
