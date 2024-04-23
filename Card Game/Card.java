import java.util.ArrayList;

public class Card {
    private String suit;
    private String rank;

    private static String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    private static String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King" };

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public String toString() { // will store the rank and suit into a card format for the user
        return rank + " of " + suit;
    }

    public static ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }

        return deck;
    }
}
