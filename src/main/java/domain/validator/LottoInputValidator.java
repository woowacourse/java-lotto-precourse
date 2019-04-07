package domain.validator;

public class LottoInputValidator implements Validator {

    private String input;

    public LottoInputValidator(String input) {
        this.input = input;
    }

    @Override
    public boolean doesValid() {
        return doesInputIsNumeric() && doesInputIsNotNull();
    }

    boolean doesInputIsNumeric() {
        return input.matches("[0-9]+");
    }

    boolean doesInputIsNotNull() {
        return input != null;
    }
}
