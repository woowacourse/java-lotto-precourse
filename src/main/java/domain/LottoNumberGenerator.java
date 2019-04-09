package domain;

import domain.interfaces.NumberGenerator;

import java.util.Random;

public class LottoNumberGenerator implements NumberGenerator {

    Random random = new Random();

    @Override
    public int getNumber() {
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER;
    }
}
