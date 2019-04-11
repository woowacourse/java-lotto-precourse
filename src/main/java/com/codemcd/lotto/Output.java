/*
 * @(#)Output.java
 * v2.0
 * 2019/04/11
 */

package com.codemcd.lotto;

import java.util.List;

/**
 * 구입한 로또 번호와 당첨 결과를 출력하는 클래스
 *
 * @author 박성범
 * @version v2.0
 */
public class Output {

    public static void printLottoNumbers(List<Lotto> lottoList) {
        System.out.println();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottoList.size(); ++i) {
            System.out.println("[" + lottoList.get(i).getLottoNumberWithComma() + "]");
        }
    }

    public static void printLottoResult(List<Integer> countOfRank, double earningsRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("%-36s", "3개 일치 (5,000원)") + "- " + countOfRank.get(5) + "개");
        System.out.println(String.format("%-36s", "4개 일치 (50,000원)") + "- " + countOfRank.get(4) + "개");
        System.out.println(String.format("%-36s", "5개 일치 (1,500,000원)") + "- " + countOfRank.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countOfRank.get(2) + "개");
        System.out.println(String.format("%-36s", "6개 일치 (2,000,000,000원)") + "- " + countOfRank.get(1) + "개");
        System.out.println("총 수익률은 " + String.format("%.3f", earningsRate) + " 입니다.");
    }
}
