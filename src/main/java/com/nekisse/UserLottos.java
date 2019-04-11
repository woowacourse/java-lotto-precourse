package com.nekisse;

import com.nekisse.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class UserLottos{
    List<Lotto> userLottos;

    public UserLottos() {
        this.userLottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        userLottos.add(lotto);
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    @Override
    public String toString() {
        return String.valueOf(userLottos);
    }

}
