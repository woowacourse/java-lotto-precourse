package domain;

class MatchInformation {
    private int countOfMatch;
    private boolean matchBonus = false;

    int getCountOfMatch() {
        return countOfMatch;
    }

    boolean getMatchBonus() {
        return matchBonus;
    }

    void matchNumber() {
        countOfMatch++;
    }

    void matchBonusNumber() {
        matchBonus = true;
    }
}
