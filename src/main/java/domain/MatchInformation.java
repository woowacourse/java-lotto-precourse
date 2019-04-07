package domain;

public class MatchInformation {
    private int countOfMatch;
    private boolean matchBonus = false;

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public void matchNumber() {
        countOfMatch++;
    }

    public void matchBonusNumber() {
        matchBonus = true;
    }
}
