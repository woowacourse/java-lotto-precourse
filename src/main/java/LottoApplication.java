import logic.LottoSimulator;
import ui.ConsoleIOInterface;

/**
 * @author delf
 */
public class LottoApplication {
    public static void main(String[] args) {
        new LottoSimulator().with(new ConsoleIOInterface()).run();
    }
}
