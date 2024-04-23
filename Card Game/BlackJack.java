import java.util.Scanner;

public class BlackJack {
    private Player player1;
    private Player player2;
    private Deck deck;
    private Scanner scanner;

    public BlackJack(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        deck = new Deck();
        deck.cards = Card.generateDeck();
        scanner = new Scanner(System.in);
    }

    public void play() {
        dealInitialCards();
    
        while (true) {
            playerTurn(player1);
            if (player1.Stick() && player2.Stick()) {
                break;
            }
            playerTurn(player2);
            if (player1.Stick() && player2.Stick()) {
                break;
            }
        }
    
        determineWinner();
    }
    

    private void dealInitialCards() {
        player1.clearHand(); // clears existing hand
        player2.clearHand();
    
        // deals two cards to each player
        for (int i = 0; i < 2; i++) {
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }
    
        System.out.println(player1.getName() + "'s hand: " + player1.getHand()); // displays card to user 
        System.out.println(player2.getName() + "'s hand: " + player2.getHand());
    }
    

    private void playerTurn(Player player) {
        if (!player.Stick()) {
            System.out.println(player.getName() + ", do you want to stick (s) or twist (t)?");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("s")) {
                player.stick();
                System.out.println(player.getName() + " sticks.");
            } else if (choice.equalsIgnoreCase("t")) {
                Card card = deck.dealCard();
                player.addCard(card);
                System.out.println(player.getName() + " twists and draws: " + card);
                System.out.println(player.getName() + "'s hand: " + player.getHand());
            }
        }
    }

    private boolean Bust(Player player) {
        return player.cardsInHand() > 21;
    }

    private void determineWinner() {
        int player1Value = player1.cardsInHand();
        int player2Value = player2.cardsInHand();
    
        boolean player1Bust = Bust(player1);
        boolean player2Bust = Bust(player2);
    
        if (player1Bust && player2Bust) {
            System.out.println("Both players have busted, It's a draw!");
        } else if (player1Bust) {
            System.out.println(player1.getName() + " has busted! " + player2.getName() + " wins!");
        } else if (player2Bust) {
            System.out.println(player2.getName() + " has busted! " + player1.getName() + " wins!");
        } else {
            if (player1Value > player2Value) {
                System.out.println(player1.getName() + " wins!");
            } else if (player1Value < player2Value) {
                System.out.println(player2.getName() + " wins!");
            } else {
                System.out.println("It's a draw!");
            }
        }
    }
    
    
    
}
