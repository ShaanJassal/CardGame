import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a deck for both games
        Deck deck = new Deck();
        deck.cards = Card.generateDeck();

        // Display menu and get user's choice
        System.out.println("Welcome to the Card Games Menu!");
        System.out.println("1. Play Blackjack");
        System.out.println("2. Play Higher or Lower");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                playBlackjack();
                break;
            case 2:
                HigherOrLower.play(deck);
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    private static void playBlackjack() {
        BlackJack game = new BlackJack("Player 1", "Player 2");
        game.play();
    }
}
