package domain;

public class Process {
    static void lottoProcess() {
        LottoBuy.lotto_Amounts_Input_Print();
        LottoBuy.lotto_Buy_Input();
        LottoBuy.lottos_Object_Create();
        LottoBuy.lottos_Number_Print();

        WinningLotto_Input.last_Week_Winning_Number_Create();
        WinningLotto_Input.bonus_Number_Create();
        WinningLotto_Input.winningLotto_Object_Create();

        WinningResult.resultProcess();
    }
}
