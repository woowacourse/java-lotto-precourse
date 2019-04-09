package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }

    public static String askUserWinningNumbers() {
        boolean isUserInputRight = false;
        String userInput = "E @ askUserWinningNumbers";
        while(!isUserInputRight) {
            userInput = Lotto.askAndReceiveInput("지난 주 당첨 번호를 입력해주세요.");
            userInput = userInput.replaceAll("\\s+","");
            isUserInputRight = checkUserInputWinningNumbers(userInput);
        }
        return userInput;
    }


}
