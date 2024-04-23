import java.util.ArrayList;
import java.util.Random;

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            return null;
        }

        Random randomCard = new Random();
        int cardPicked = randomCard.nextInt(cards.size());
        return cards.remove(cardPicked);
    }
}
