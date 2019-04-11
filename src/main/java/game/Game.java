package game;

import domain.Lotto;
import domain.WinningLotto;

import java.util.*;

/**
 * 로또 게임을 진행하는 클래스
 */
public class Game {
    static final int LOTTO_PRICE = 1000;
    private static List<Lotto> lottos;           // 구입한 로또들이 담긴 리스트
    private static Buyer buyer;
    private static Analyzer analyzer;
    private static LottoMachine lottoMachine;
}
