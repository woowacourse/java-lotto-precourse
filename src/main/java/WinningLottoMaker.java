import domain.Lotto;
import domain.WinningLotto;

import java.util.*;

public class WinningLottoMaker {
    public static Scanner sc = new Scanner(System.in);

    public static WinningLotto getWinningLotto(){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = getWinningNumber();
        int bonusNum = getBonusNumber(list);
        return new WinningLotto(new Lotto(list),bonusNum);
    }

    private static List<Integer> getWinningNumber(){
        List<Integer> list;
        while (true){
            System.out.println("\n지난 주 당첨번호를 입력해 주세요(콤마로 구분해서 입력).");
            list = stringToList(sc.nextLine());
            Collections.sort(list);
            if(validate(list)){
                break;
            }
            System.out.println("유효한 숫자를 입력하세요.");
        }
        return list;
    }

    private static List<Integer> stringToList(String input){
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input);
        while(st.hasMoreTokens()){
            list.add(Integer.valueOf(st.nextToken(",")));
        }
        return list;
    }

    private static boolean validate(List<Integer> list){
        if(list.size()!=6)
            return false;
        for(int elem : list)
            if(elem<1 || elem>45)
                return false;
        for(int i=1; i<list.size(); i++)
            if(list.get(i-1) == list.get(i))
                return false;
        return true;
    }

    private static int getBonusNumber(List<Integer> list){
        int bonus;
        while(true){
            System.out.println("보너스 볼을 입력해 주세요.");
            bonus = sc.nextInt();
            if(!list.contains(bonus) && bonus>=1 && bonus<=45) break;
            System.out.println("유효한 보너스 볼을 입력해 주세요.");
        }
        return bonus;
    }
}
