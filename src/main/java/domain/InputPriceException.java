package domain;

public class InputPriceException {

    private InputPriceException() {
    }

    private static class InputExceptionHolder {
        public static final InputPriceException INSTANCE = new InputPriceException();
    }

    public static InputPriceException getInstance() {
        return InputExceptionHolder.INSTANCE;
    }


    public boolean isMinusNumberException(String input){
        if (Integer.parseInt(input) < 0){
            System.out.println(ErrorMessage.HAS_MINUS_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean hasNumberOfChiperException(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            System.out.println(ErrorMessage.HAS_NUMBER_OF_CHIPER_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean hasBlankException(String input){
        if (input.contains(" ") || "".equals(input)) {
            System.out.println(ErrorMessage.HAS_BLANK_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean isNumberFormatException(String input){
        char[] charArray = input.toCharArray();
        if(charArray[0] != 45){
            return charArrayCheck(charArray);
        }
        for(int i = 1 ; i < charArray.length ; i++){
            return charArrayCheck(charArray, i);
        }
        return false;
    }

    private boolean charArrayCheck(char[] charArray){
        if(charArray[0] < 48 || charArray[0] > 57) {
            System.out.println(ErrorMessage.INPUTMISSMATCHEXCEPTION_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    private boolean charArrayCheck(char[] charArray, int i){
        if(charArray[i] < 48 || charArray[i] > 57) {
            System.out.println(ErrorMessage.INPUTMISSMATCHEXCEPTION_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

}
