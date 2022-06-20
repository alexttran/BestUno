package uno;

import java.util.ArrayList;
import java.util.List;

public class TeamRandom_UnoPlayer implements UnoPlayer {

    public int play(List<Card> hand, Card upCard, UnoPlayer.Color calledColor,
                    GameState state) {
        int playable = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).canPlayOn(upCard, calledColor)) {
                arr.add(i);
                playable++;
            }
        }
        if (playable > 0) {
            int j = (int) (Math.random() * arr.size());
            return arr.get(j);
        }
        return -1;
    }

    public UnoPlayer.Color callColor(List<Card> hand) {
        int i = (int) (Math.random() * 4) + 1;
        if (i == 1)
            return UnoPlayer.Color.YELLOW;
        if (i == 2)
            return UnoPlayer.Color.GREEN;
        if (i == 3)
            return UnoPlayer.Color.RED;
        return UnoPlayer.Color.BLUE;
    }
}
