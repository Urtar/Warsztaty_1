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
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj liczbe w zakresie 1 -100:");
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println("To nie jest liczba, spróbuj jeszcze raz");
        }
        int number = scan.nextInt();
        int counter = 0;
        while (number != rand) {
            if (number > rand) {
                System.out.println("Za dużo!");
                number = scan.nextInt();
                counter++;
            } else if (number < rand) {
                System.out.println("Za mało!");
                number = scan.nextInt();
                counter++;
            }
        }
        System.out.println("Zgadłeś! w " + counter + " próbach!!!:)");
    }
}