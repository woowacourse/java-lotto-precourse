package domain.validator;

public class LottoInputValidator implements Validator {

    private String input;

    public LottoInputValidator(String input) {
        this.input = input;
    }

    @Override
    public boolean doesValid() {
        return doesInputIsNumeric();
    }

    boolean doesInputIsNumeric() {
        return input.matches("[0-9]+");
    }
}
