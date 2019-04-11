package com.nekisse;

import com.nekisse.domain.LottoNumber;
import com.nekisse.generator.LottoRandomNumberGenerator;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomNumberGeneratorTest {

    @Test
    public void 랜덤_번호_사이즈() {
        LottoRandomNumberGenerator randomLottoGenerator = new LottoRandomNumberGenerator();
        List<LottoNumber> randomNumbers = randomLottoGenerator.generate();
        assertThat(randomNumbers.size()).isEqualTo(6);
    }

    @Test
    public void 랜덤_번호_중복_테스트() {
        LottoRandomNumberGenerator randomLottoGenerator = new LottoRandomNumberGenerator();
        List<LottoNumber> randomNumbers = randomLottoGenerator.generate();
        List<LottoNumber> removeDuplicates = randomNumbers.stream()
            .distinct()
            .collect(Collectors.toList());
        assertThat(removeDuplicates.size()).isEqualTo(randomNumbers.size());
    }



}