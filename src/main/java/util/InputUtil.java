package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {
    public static List<Integer> convertToList(String[] strings) {
        List<Integer> convertedList = Arrays.stream(strings)
                .map((string -> Integer.parseInt(string.trim())))
                .collect(Collectors.toList());
        return convertedList;
    }
}