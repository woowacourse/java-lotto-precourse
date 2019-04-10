import logic.LottoSimulator;
import ui.ConsoleIOIneterface;

/**
 * @author delf
 */
public class LottoApplication {
    public static void main(String[] args) {
        new LottoSimulator().with(new ConsoleIOIneterface()).run();
    }
}
