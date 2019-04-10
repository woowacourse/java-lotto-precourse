package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
	
	LottoGenerator lottoGenerator = new LottoGenerator();

    private List<Lotto> makeLotto() {
    	ArrayList<Lotto> lottos = lottoGenerator.makeLotto();
    	
    	for (int i = 0; i < lottos.size(); i++) {
    		System.out.println(lottos.get(i).toString());
    	}
    	
    	return lottos;
    }
	
}