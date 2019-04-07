package domain;

public class Calculation {

    /*
     * 구입 금액을 받아서 금액에 맞는 로또 개수 계산
     * TODO: price 넘어오기 전에 예외처리 필요
     */
    public static int calcLottoCount(int price) {
        return (price/1000);
    }

    /*
     * 수익률 계산을 위한 메소드
     * 판매량 계산, 당첨총액 계산하여 최종 수익률 계산을 위함
     */
    public static void RateReturnToInvest() {

    }
}
