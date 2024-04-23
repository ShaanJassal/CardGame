import java.util.Scanner;

public class HigherOrLower {
    public static void play(Deck deck) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        while (true) {
            Card currentCard = deck.dealCard();
            System.out.println("The current card is: " + currentCard);

            System.out.print("Will the next card be higher (h) or lower (l)? ");
            String choice = scanner.next();

            Card nextCard = deck.dealCard();
            System.out.println("The next card is: " + nextCard);

            if (choice.equalsIgnoreCase("h")) {
                if (nextCard.getRank().compareTo(currentCard.getRank()) > 0) {
                    System.out.println("Correct! The next card is higher.");
                    score++;
                } else {
                    System.out.println("Incorrect! The next card is lower.");
                    break;
                }
            } else if (choice.equalsIgnoreCase("l")) {
                if (nextCard.getRank().compareTo(currentCard.getRank()) < 0) {
                    System.out.println("Correct! The next card is lower.");
                    score++;
                } else {
                    System.out.println("Incorrect! The next card is higher.");
                    break;
                }
            } else {
                System.out.println("Invalid option. Please enter 'h' for higher or 'l' for lower.");
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to continue? (yes/no): ");
            String continueChoice = scanner.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over! Your final score is: " + score);
    }
}
