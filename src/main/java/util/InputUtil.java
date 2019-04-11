package util;

import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {
    private static final String INPUT_LOTTO_SIZE_MENT = "로또는 6개의 숫자만 가능합니다.";

    public static List<Integer> convertToList(String[] strings) {
        try {
            List<Integer> convertedList = Arrays.stream(strings)
                    .map((string -> Integer.parseInt(string.trim())))
                    .collect(Collectors.toList());
            checkInputValid(convertedList);
            return convertedList;
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_LOTTO_SIZE_MENT);
        }
    }

    private static void checkInputValid(List<Integer> convertToList) throws IllegalArgumentException {
        if (convertToList.size() != 6) {
            throw new IllegalArgumentException(InputView.INPUT_ERROR_MENT);
        }
    }
}