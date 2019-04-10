package domain;

public class LottoBuy {

    static int lotto_money;
    static Lotto[] lottos;

    static void lotto_Amounts_Input_Print(){
        System.out.println(Info.LOTTO_AMOUNTS_INPUT_PRINT);
    }

    static void lotto_Buy_Input(){
        lotto_money = Info.SCAN.nextInt();
    }

    static void lottos_Object_Create(){
        lottos = new Lotto[lotto_money/Info.DIVISION];
        for (int i = Info.ZERO; i < lotto_money/Info.DIVISION; i++){
            lottos[i] = new Lotto(RandomNumberCreate.set_Change_List());
            RandomNumberCreate.random_Set_Number_Reset();
        }
    }

    static void lottos_Number_Print(){
        for (int i =Info.ZERO; i < lottos.length; i++){
            lottos[i].lotto_Number_Print();
        }
    }


}
