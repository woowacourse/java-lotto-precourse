package domain;
import java.util.*;

public class PlayLotto {
    public static int purchase_amount;
    public static void main(String[] args){
        getPurchaseAmount();
    }

    public static int getPurchaseAmount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요");
        purchase_amount = sc.nextInt();
        return purchase_amount;
    }
}
