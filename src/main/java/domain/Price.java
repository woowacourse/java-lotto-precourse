package domain;

import static domain.Const.*;

/**
 * 가격에 따라 티켓을 구매하는 클래스
 */
public class Price {
    private int price;
    private int ticket;

    public Price(int userIn) {
        price = userIn;
        ticket = price / TICKET_PRICE;
    }

    public int getTickets() {
        return ticket;
    }

    public int getChange() {
        return price % TICKET_PRICE;
    }

    public int getPrice() {
        return price;
    }
}
