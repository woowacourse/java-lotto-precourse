package domain;

public class Main {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        lottoManager.makeWinningLotto();
        lottoManager.checkRanks();
        lottoManager.printResults();
    }
}
