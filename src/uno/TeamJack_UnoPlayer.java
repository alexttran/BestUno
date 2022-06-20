package uno;

import java.util.ArrayList;
import java.util.List;

public class TeamJack_UnoPlayer implements UnoPlayer {

    /**
     * play - This method is called when it's your turn and you need to
     * choose what card to play.
     * <p>
     * The hand parameter tells you what's in your hand. You can call
     * getColor(), getRank(), and getNumber() on each of the cards it
     * contains to see what it is. The color will be the color of the card,
     * or "Color.NONE" if the card is a wild card. The rank will be
     * "Rank.NUMBER" for all numbered cards, and another value (e.g.,
     * "Rank.SKIP," "Rank.REVERSE," etc.) for special cards. The value of
     * a card's "number" only has meaning if it is a number card.
     * (Otherwise, it will be -1.)
     * <p>
     * The upCard parameter works the same way, and tells you what the
     * up card (in the middle of the table) is.
     * <p>
     * The calledColor parameter only has meaning if the up card is a wild,
     * and tells you what color the player who played that wild card called.
     * <p>
     * Finally, the state parameter is a GameState object on which you can
     * invoke methods if you choose to access certain detailed information
     * about the game (like who is currently ahead, what colors each player
     * has recently called, etc.)
     * <p>
     * You must return a value from this method indicating which card you
     * wish to play. If you return a number 0 or greater, that means you
     * want to play the card at that index. If you return -1, that means
     * that you cannot play any of your cards (none of them are legal plays)
     * in which case you will be forced to draw a card (this will happen
     * automatically for you.)
     */

    private GameState state;

    public int play(List<Card> hand, Card upCard, UnoPlayer.Color calledColor,
                    GameState state) {
        this.state = state;
        int numNum = 0;
        int numColor = 0;
        int numWilds = 0;
        int numWild4 = 0;
        int numSkipColor = 0;
        int numReverseColor = 0;
        int numDraw2Color = 0;
        int numRankReverse = 0;
        int numRankDraw2 = 0;
        int numRankSkip = 0;
        int numPlayable = 0;
        int[] numCards = state.getNumCardsInHandsOfUpcomingPlayers();
        int nextPersonCards = numCards[0];
        Color mostCommonColor = mostCommonCalledColor(hand, state);
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++)
            arr.add("");
        Color color = upCard.getColor();
        if (upCard.getRank() == Rank.WILD || upCard.getRank() == Rank.WILD_D4) {
            color = calledColor;
        }
        if (upCard.getRank() == Rank.DRAW_TWO) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getRank() == Rank.DRAW_TWO) {
                    arr.set(i, "RankDraw2");
                    numRankDraw2++;
                    numPlayable++;
                } else if (hand.get(i).getColor() == color) {
                    if (hand.get(i).getRank() == Rank.SKIP) {
                        arr.set(i, "Skip");
                        numSkipColor++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.DRAW_TWO) {
                        arr.set(i, "Draw 2");
                        numDraw2Color++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.REVERSE) {
                        arr.set(i, "Reverse");
                        numReverseColor++;
                        numPlayable++;
                    } else {
                        arr.set(i, "Color");
                        numColor++;
                        numPlayable++;
                    }
                }
            }
        }
        if (upCard.getRank() == Rank.SKIP) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getRank() == Rank.SKIP) {
                    arr.set(i, "RankSkip");
                    numRankSkip++;
                    numPlayable++;
                } else if (hand.get(i).getColor() == color) {
                    if (hand.get(i).getRank() == Rank.SKIP) {
                        arr.set(i, "Skip");
                        numSkipColor++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.DRAW_TWO) {
                        arr.set(i, "Draw 2");
                        numDraw2Color++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.REVERSE) {
                        arr.set(i, "Reverse");
                        numReverseColor++;
                        numPlayable++;
                    } else {
                        arr.set(i, "Color");
                        numColor++;
                        numPlayable++;
                    }
                }
            }
        }
        if (upCard.getRank() == Rank.REVERSE) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getRank() == Rank.REVERSE) {
                    arr.set(i, "RankReverse");
                    numRankReverse++;
                    numPlayable++;
                } else if (hand.get(i).getColor() == color) {
                    if (hand.get(i).getRank() == Rank.SKIP) {
                        arr.set(i, "Skip");
                        numSkipColor++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.DRAW_TWO) {
                        arr.set(i, "Draw 2");
                        numDraw2Color++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.REVERSE) {
                        arr.set(i, "Reverse");
                        numReverseColor++;
                        numPlayable++;
                    } else {
                        arr.set(i, "Color");
                        numColor++;
                        numPlayable++;
                    }
                }
            }
        }
        if (upCard.getRank() == Rank.WILD || upCard.getRank() == Rank.WILD_D4) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getColor() == color) {
                    if (hand.get(i).getRank() == Rank.SKIP) {
                        arr.set(i, "Skip");
                        numSkipColor++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.DRAW_TWO) {
                        arr.set(i, "Draw 2");
                        numDraw2Color++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.REVERSE) {
                        arr.set(i, "Reverse");
                        numReverseColor++;
                        numPlayable++;
                    } else {
                        arr.set(i, "Color");
                        numColor++;
                        numPlayable++;
                    }
                }
            }
        }
        if (upCard.getRank() == Rank.NUMBER) {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getColor() == color) {
                    if (hand.get(i).getRank() == Rank.SKIP) {
                        arr.set(i, "Skip");
                        numSkipColor++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.DRAW_TWO) {
                        arr.set(i, "Draw 2");
                        numDraw2Color++;
                        numPlayable++;
                    } else if (hand.get(i).getRank() == Rank.REVERSE) {
                        arr.set(i, "Reverse");
                        numReverseColor++;
                        numPlayable++;
                    } else {
                        arr.set(i, "Color");
                        numColor++;
                        numPlayable++;
                    }
                } else if (hand.get(i).getNumber() == upCard.getNumber()) {
                    arr.set(i, "Number");
                    numNum++;
                    numPlayable++;
                }
            }
        }
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == Rank.WILD) {
                arr.set(i, "Wild");
                numWilds++;
                numPlayable++;
            } else if (hand.get(i).getRank() == Rank.WILD_D4) {
                arr.set(i, "Wild4");
                numWild4++;
                numPlayable++;
            }
        }
        if (numPlayable > 0) {
            if (numRankDraw2 != 0 && numColor(hand.get(arr.indexOf("RankDraw2")).getColor(), hand) > numColor(color, hand))
                return arr.indexOf("RankDraw2");
            else if (numDraw2Color != 0 && nextPersonCards <= 3)
                return arr.indexOf("Draw 2");
            else if (numRankSkip != 0 && nextPersonCards < numCards[1] && numColor(hand.get(arr.indexOf("RankSkip")).getColor(), hand) > numColor(color, hand))
                return arr.indexOf("RankSkip");
            else if (numSkipColor != 0 && nextPersonCards <= 3 && nextPersonCards < numCards[1])
                return arr.indexOf("Skip");
            else if (numRankReverse != 0 && nextPersonCards < numCards[numCards.length - 2] && numColor(hand.get(arr.indexOf("RankReverse")).getColor(), hand) > numColor(color, hand))
                return arr.indexOf("RankReverse");
            else if (numReverseColor != 0 && nextPersonCards <= 3 && nextPersonCards < numCards[numCards.length - 2])
                return arr.indexOf("Reverse");
            else if (numColor != 0 && numNum == 0)
                return arr.indexOf("Color");
            else if (numColor != 0 && numNum != 0 && color == mostCommonColor)
                return arr.indexOf("Number");
            else if (numColor < numNum && hand.get(arr.indexOf("Number")).getColor() != mostCommonColor)
                return arr.indexOf("Number");
            else if (numColor != 0 && numColor >= numNum)
                return arr.indexOf("Color");
            else if (numNum != 0 && numNum > numColor)
                return arr.indexOf("Number");
            else if (numDraw2Color != 0)
                return arr.indexOf("Draw 2");
            else if (numRankDraw2 != 0)
                return arr.indexOf("RankDraw2");
            else if (numSkipColor != 0)
                return arr.indexOf("Skip");
            else if (numRankSkip != 0)
                return arr.indexOf("RankSkip");
            else if (numReverseColor != 0)
                return arr.indexOf("Reverse");
            else if (numRankReverse != 0)
                return arr.indexOf("RankReverse");
            else if (numWilds != 0)
                return arr.indexOf("Wild");
            else if (numWild4 != 0)
                return arr.indexOf("Wild4");
        }
        return -1;
    }

    public int numColor(Color c, List<Card> hand) {
        int count = 0;
        for (Card card : hand) {
            if (card.getColor() == c)
                count++;
        }
        return count;
    }

    public Color mostCommonColor(List<Card> hand) {
        int numRed = 0;
        int numBlue = 0;
        int numGreen = 0;
        int numYellow = 0;
        for (Card c : hand) {
            if (c.getColor() == Color.RED)
                numRed++;
            if (c.getColor() == Color.BLUE)
                numBlue++;
            if (c.getColor() == Color.GREEN)
                numGreen++;
            if (c.getColor() == Color.YELLOW)
                numYellow++;
        }
        Color color = null;
        if (numRed >= numBlue && numRed >= numGreen && numRed >= numYellow)
            color = Color.RED;
        else if (numBlue >= numRed && numBlue >= numGreen && numBlue >= numYellow)
            color = Color.BLUE;
        else if (numGreen >= numRed && numGreen >= numBlue && numGreen >= numYellow)
            color = Color.GREEN;
        else
            color = Color.YELLOW;
        return color;
    }

    public Color nextMostCommonColor(List<Card> hand) {
        int numRed = 0;
        int numBlue = 0;
        int numGreen = 0;
        int numYellow = 0;
        for (Card c : hand) {
            if (c.getColor() == Color.RED)
                numRed++;
            if (c.getColor() == Color.BLUE)
                numBlue++;
            if (c.getColor() == Color.GREEN)
                numGreen++;
            if (c.getColor() == Color.YELLOW)
                numYellow++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(numRed);
        list.add(numBlue);
        list.add(numGreen);
        list.add(numYellow);
        for (int m = 0; m < list.size() - 1; m++)
            for (int n = m + 1; n < list.size(); n++) {
                if (list.get(n) < list.get(m)) {
                    int temp = list.get(m);
                    list.set(n, temp);
                    list.set(m, list.get(n));
                }
            }
        if (list.get(2) == numRed)
            return Color.RED;
        else if (list.get(2) == numBlue)
            return Color.BLUE;
        else if (list.get(2) == numGreen)
            return Color.GREEN;
        else
            return Color.YELLOW;
    }

    public Color mostCommonCalledColor(List<Card> hand, GameState state) {
        Color[] arr = state.getMostRecentColorCalledByUpcomingPlayers();
        int numRed = 0;
        int numBlue = 0;
        int numGreen = 0;
        int numYellow = 0;
        for (Color c : arr) {
            if (c == Color.RED)
                numRed++;
            if (c == Color.BLUE)
                numBlue++;
            if (c == Color.GREEN)
                numGreen++;
            if (c == Color.YELLOW)
                numYellow++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(numRed);
        list.add(numBlue);
        list.add(numGreen);
        list.add(numYellow);
        for (int m = 0; m < list.size() - 1; m++)
            for (int n = m + 1; n < list.size(); n++) {
                if (list.get(n) < list.get(m)) {
                    int temp = list.get(m);
                    list.set(n, temp);
                    list.set(m, list.get(n));
                }
            }
        if (list.get(3) == numRed)
            return Color.RED;
        else if (list.get(3) == numBlue)
            return Color.BLUE;
        else if (list.get(3) == numGreen)
            return Color.GREEN;
        else if (list.get(3) == numYellow)
            return Color.YELLOW;
        else
            return Color.NONE;
    }

    /**
     * callColor - This method will be called when you have just played a
     * wild card, and is your way of specifying which color you want to
     * change it to.
     * <p>
     * You must return a valid Color value from this method. You must not
     * return the value Color.NONE under any circumstances.
     */
    public Color callColor(List<Card> hand) {
        Color c = mostCommonColor(hand);
        if (c == mostCommonCalledColor(hand, state)) {
            return nextMostCommonColor(hand);
        }
        return mostCommonColor(hand);
    }

}


