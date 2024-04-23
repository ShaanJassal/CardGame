import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private String name;
    private boolean Stick;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.Stick = false;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public boolean Stick() {
        return Stick;
    }

    public void stick() {
        Stick = true;
    }

    public int cardsInHand() {
        int value = 0;
        int aceVal = 0;

        for (Card card : hand) {
            String rank = card.getRank();
            if (rank.equals("Ace")) {
                aceVal++;
            } else if (rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")) {
                value += 10;
            } else {
                value += Integer.parseInt(rank);
            }
        }

        for (int i = 0; i < aceVal; i++) { // determines if value of ace is one or eleven
            if (value + 11 <= 21) {
                value += 11;
            } else {
                value += 1;
            }
        }

        return value;
    }

    public void clearHand() {
        hand.clear();
        Stick = false;
    }
}
