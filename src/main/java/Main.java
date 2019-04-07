import java.util.*;
import java.io.Console;
import domain.*;

public class Main {
    /** 상수 영역 */
    final static int LOTTO_NUM_START = 1;
    final static int LOTTO_NUM_END = 45;
    final static int LOTTO_NUM_LENGTH = 6;
    
    /** 문자열을 입력받아, 쉼표를 기준으로 나누어 문자열 배열로 반환 */
    private static String[] getInput(String message) {
        Console console = System.console();
        String inputData = console.readLine(message + "\n"); // 메시지 출력
        return inputData.split(",\\s*"); // 정규 표현식 적용 - 띄어쓰기 때문
    }
    
    /** main 진입점 */
    public static void main(String[] args) {
        // Test code - 추후 삭제 예정
        List<Integer> lottoNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNums);
        System.out.println(lotto);
    }
}
