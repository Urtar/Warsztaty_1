package zadania;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        guess();
    }

    private static void guess() {
        System.out.println("Pomyśl liczbę od 1-1000, a ja ją zgadnę w maksymalnie 10 próbach");
        int max = 1000, min = 0, guess;
        Scanner scan = new Scanner(System.in);
        String help = "";
        int counter = 0;
        while (!help.equals("zgadles")) {
            guess = (((max - min) / 2) + min);
            System.out.println("Zgaduję: " + guess);
            System.out.println("Prosze o podpowiedz: \"za duzo\", \" za malo\",\" zgadles\"");
            help = scan.nextLine();
            switch (help) {
                case "za duzo":
                    max = guess;
                    break;
                case "za malo":
                    min = guess;
                    break;
                case "zgadles":
                    System.out.println("Zgadlem w: " + counter + " probach!:)");
                    break;
                default:
                    System.out.println("Nie oszukuj!");
                    break;
            }
            counter++;
        }
    }
}
