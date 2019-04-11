package com.nekisse.generator;

import com.nekisse.domain.LottoNumber;

import java.util.List;

public interface RandomNumberGenerator {
    List<LottoNumber> generate();

}
