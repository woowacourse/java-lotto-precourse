import java.util.*;
import java.io.Console;
import domain.*;

public class Main {
    /** 상수 영역 */
    private final static int LOTTO_NUM_START = 1;
    private final static int LOTTO_NUM_END = 45;
    private final static int LOTTO_NUM_LENGTH = 6;
    private final static int LOTTO_PRICE = 1000;
    private final static Random random = new Random();
    private final static String INPUT_INT_ERROR
            = "올바른 숫자가 입력되지 않았습니다. 다시 입력해 주세요.";
    
    /** 1에서 45 사이의 임의의 정수 하나를 생성하여 반환 */
    private static int getLottoNum() {
        return random.nextInt(LOTTO_NUM_END) + LOTTO_NUM_START;
    }
    
    /** 문자열을 입력받아, 쉼표를 기준으로 나누어 문자열 배열로 반환 */
    private static String[] getInput(String message) {
        Console console = System.console();
        String inputData = console.readLine(message + "\n"); // 메시지 출력
        return inputData.split(",\\s*"); // 정규 표현식 적용 - 띄어쓰기 때문
    }
    
    /** 입력된 문자열을 정수로 형변환할 수 있을지 테스트 */
    private static boolean isOnlyNumber(String string) {
        if (string.length() == 0) {
            return false; // 빈 문자열은 취급하지 않는다.
        }
        return string.chars() // String -> IntStream
                .map(i -> (i - '0')) // 형변환 발생
                .noneMatch(i -> (i < 0 || i > 9)); // 0부터 9 사이의 숫자인가
    }
    
    /** 임의의 정수 하나를 입력받아 반환한다. */
    private static int inputSingleInt(String message) {
        String temp = getInput(message)[0];
        boolean check = isOnlyNumber(temp);
        while (!check) { // 입력에 문제가 있으면 계속 재입력 요구
            temp = getInput(INPUT_INT_ERROR)[0];
            check = isOnlyNumber(temp);
        }
        return Integer.parseInt(temp);
    }
    
    /** main 진입점 */
    public static void main(String[] args) {
        // Test code - 추후 삭제 예정
        // List<Integer> lottoNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Lotto lotto = new Lotto(lottoNums);
        // System.out.println(lotto);
    }
}
