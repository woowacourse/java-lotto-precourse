package domain;

public class Valid {

    public static boolean isInputHasChar(String[] input) {
        try {
            for (int i = 0; i < input.length; i++)
                Integer.parseInt(input[i]);

        } catch (Exception e) {
            return true;
        }
        return false;
    }
        
}
