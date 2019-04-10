package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Store {
    private final int MIN_NUM = 1;                  /* 로또 번호의 최솟값 */
    private final int MAX_NUM = 45;                 /* 로또 번호의 최댓값 */
    private final int COUNT_NUMS = 6;               /* 로또 한 장의 번호 갯수 */
    private final int LOTTO_PRICE = 1000;           /* 로또 한 장의 가격 */

    private Random random;

    public Store() {
        random = new Random();
    }

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

    private Lotto pickNumsAuto() {
        TreeSet<Integer> lottoNumTree = new TreeSet<>();

        for (; lottoNumTree.size() < COUNT_NUMS; )
            lottoNumTree.add(random.nextInt(MAX_NUM) + MIN_NUM);

        return new Lotto(new ArrayList<>(lottoNumTree));
    }

}
