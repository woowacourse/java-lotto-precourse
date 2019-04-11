import domain.LottoManager;

public class App {
    public static void main(String[] args) {
        LottoManager lottoManager = LottoManager.getInstance();
        lottoManager.startLotto();
    }
}
