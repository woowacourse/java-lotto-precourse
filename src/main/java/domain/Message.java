package domain;

import java.util.HashMap;

public class Message {
    public static HashMap<String, String> lottoInputMessage = new HashMap<String, String>() {
        {
            put("INPUT_PURCHASEMONEY", "구입금액을 입력해 주세요.");
            put("INPUT_LASTWEEK_LOTTONUMBER", "지난주 당첨 번호를 입력해 주세요.");
            put("INPUT_BONUSLOTTO", "보너스 볼을 입력해 주세요.");
        }
    };

    public static HashMap<String,String> lottoOutputMessage = new HashMap<String, String>() {
        {
            put("OUTPUT_BUYLOTTO", "개를 구매했습니다.");
            put("OUTPUT_STATISTICS","당첨 통계");
            put("OUTPUT_STATISTICSLINE","=======");
        }
    };

    public static HashMap<String, String> errorMessage = new HashMap<String, String>() {
        {
            put("ERROR_ONLYNUMBER", "숫자로 입력하세요.");
            put("ERROR_MONEYSHORT", "금액이 부족하여 구매할 수 없습니다.");
        }
    };
}
