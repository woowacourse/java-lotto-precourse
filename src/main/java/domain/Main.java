package domain;

public class Main {

    private static final String REQUEST_CASH_TO_BUY_LOTTO = "\n구입금액을 입력해주세요.";
    private static final String REQUEST_LAST_WINNING_LOTTO_NUMS = "\n지난주 당첨 번호를 입력해주세요.";
    private static final String REQUEST_BONUS_BALL_NUM = "\n보너스 볼을 입력해주세요.";
    private static final String STATISTIC_MESSAGE = "\n당첨 통계\n---------";

    public static void main(String[] args) {

        LottoGame game = new LottoGame();
        UserInput userInput = new UserInput();

        game.showMessage(REQUEST_CASH_TO_BUY_LOTTO);
        game.setCashToBuyLotto(userInput.getCashToBuyLotto());
        game.createLottos();
        game.showLottos();

        game.showMessage(REQUEST_LAST_WINNING_LOTTO_NUMS);
        String winningLottoNumbers = userInput.getWinningLottoNumbers();
        game.showMessage(REQUEST_BONUS_BALL_NUM);
        String bonusNumber = userInput.getBonusNumber();
        game.setWinningLotto(winningLottoNumbers, bonusNumber);

        game.showMessage(STATISTIC_MESSAGE);
        game.showResult();
        game.showROI();

    }
}
