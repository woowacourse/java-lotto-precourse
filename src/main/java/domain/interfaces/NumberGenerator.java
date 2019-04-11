package domain.interfaces;

import java.util.Set;

public interface NumberGenerator {

    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int LOTTO_LENGTH = 6;
    int LOTTO_BOUND_SIZE = 46;

    int generateRandomNumber();
}
