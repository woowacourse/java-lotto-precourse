package com.conatuseus.lotto;

import com.conatuseus.lotto.appController.AppController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppController appController = new AppController();
        appController.run();
    }
}
