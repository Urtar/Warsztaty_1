package zadania;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        int rand = randomNumber();
        guessNumber(rand);
    }

    static int randomNumber() {
        Random rand = new Random();
        int randomNumber = rand.nextInt((100) + 1);
        return randomNumber;
    }

    static void guessNumber(int rand) {
        int number = givenNumber();
        int counter = 0;
        while (number != rand) {
            if (number > rand) {
                System.out.println("Za dużo!");
                number = givenNumber();
                counter++;
            } else if (number < rand) {
                System.out.println("Za mało!");
                number = givenNumber();
                counter++;
            }
        }
        System.out.println("Zgadłeś! w " + counter + " próbach!!!:)");
    }
    public static int givenNumber () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbe w zakresie 1 - 100:");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("To nie jest liczba, spróbuj jeszcze raz");
        }
        return scan.nextInt();
    }
}