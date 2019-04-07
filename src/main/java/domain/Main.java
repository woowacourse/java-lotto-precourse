package domain;


import java.util.List;

public class Main {
    public static void main(String[] args){
        //Game game = new Game();
        //game.initGame();
        List<Integer> l = Display.inputLastWeekWinningNumbers();
        for(int i : l){
            System.out.println(i);
        }
        //Rank[] r = Rank.values();
        //for(Rank rf : r)
        //System.out.println(rf.ordinal());

    }
}
