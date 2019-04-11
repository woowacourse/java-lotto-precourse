package com.nekisse.domain;

public class Money {

    public static final int LOTTO_PRICE = 1000;
    private final int buyAmount;


    public Money(int inputAmount) {
        if (inputAmount < LOTTO_PRICE || inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("금액은 1000원 단위입니다.");
        }
        this.buyAmount = inputAmount;
    }

    public int buyLottoCount() {
        return buyAmount / LOTTO_PRICE;
    }

    public double getProfits(LottoResult lottoResult) {
        int sumTotal = getSumProfits(lottoResult);
        return sumTotal / (double) buyAmount;
    }

    private int getSumProfits(LottoResult lottoResult) {
        int sumTotal = 0;
        for (Rank rank : Rank.values()) {
            int money =totalPrizeCalculator(rank, lottoResult.getLottoResults().get(rank));
            sumTotal += money;
        }
        return sumTotal;
    }

    private int totalPrizeCalculator(Rank rank, Integer sameCount) {
        return rank.getWinningMoney() * sameCount;
    }
}
