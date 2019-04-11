/**
 * 우아한테크코스 프리코스 3주차 미션
 * 로또 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * 로또 번호를 생성하는 클래스
 */
public class Store {
    private final int MIN_NUM = 1;                  /* 로또 번호의 최솟값 */
    private final int MAX_NUM = 45;                 /* 로또 번호의 최댓값 */
    private final int COUNT_NUMS = 6;               /* 로또 한 장의 번호 갯수 */
    private final int LOTTO_PRICE = 1000;           /* 로또 한 장의 가격 */

    private Random random;

    public Store() {
        random = new Random();
    }

    /**
     * @param budget 입력받은 구매 금액
     * @return 구매 금액으로 생성한 로또 객체의 ArrayList
     */
    public List<Lotto> sellLotto(int budget) {
        List<Lotto> lottoPaper = new ArrayList<>();
        if (budget < LOTTO_PRICE) {
            System.out.println("돈이 부족해서 살 수 없습니다.");
            return lottoPaper;
        }
        for (int i = 0; i < budget / LOTTO_PRICE; i++)
            lottoPaper.add(pickNumsAuto());

        return lottoPaper;
    }

    /**
     * @return 무작위로 생성된 로또 객체
     */
    private Lotto pickNumsAuto() {
        TreeSet<Integer> lottoNumTree = new TreeSet<>();            /* 트리셋을 사용하여 중복 처리와 정렬 기능 활용*/

        for (; lottoNumTree.size() < COUNT_NUMS; )
            lottoNumTree.add(random.nextInt(MAX_NUM) + MIN_NUM);

        return new Lotto(new ArrayList<>(lottoNumTree));
    }

}
