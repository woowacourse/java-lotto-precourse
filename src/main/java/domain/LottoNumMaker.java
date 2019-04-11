package domain;

import java.util.List;
import java.util.ArrayList;

public class LottoNumMaker {

    private List<Integer> lottoNums;

    public LottoNumMaker() {
        this.lottoNums = new ArrayList<Integer>();
    }

    public List<Integer> createLottoNums() {
        while (this.lottoNums.size() < 6) {
            this.setLottoNum();
        }

        return this.lottoNums;
    }

    private void setLottoNum() {
        int num = (int) (Math.random() * 45) + 1;

        if (!this.lottoNums.contains(num)) {
            this.lottoNums.add(num);
        }
    }

}
