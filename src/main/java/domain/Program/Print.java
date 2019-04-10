package domain.Program;

import domain.Elements.Lotto;

import java.util.List;

public class Print {
    public static void getLottoBundle(Lotto[] lottoBunbdle){
        for(Lotto lotto: lottoBunbdle) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    public static void getInputPrice(){
        System.out.println("금액을 입력해주세요");
    }

    public static void getType(){
        System.out.println("타입을 선택해주세요.\n 1:자동 2:수동");
    }

    public static void getValidation(){
        System.out.println("유효하지 않는 값입니다.");
    }

    public static void getRange(){
        System.out.println("범위를 벗어났습니다.");
    }

    public static void getPriceValidation(){
        System.out.println("1000단위로 입력해주세요");
    }

    public static void getLottoInputValidation(){
        System.out.println("형식에 맞추어 작성해주세요. ex)1,2,3,4,5,6");
    }
}
