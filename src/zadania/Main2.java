package zadania;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        howManyOfSixNumbersChoosenFromFortyNineIsOk(sixRandomNumbers(), givenNumbers());
    }

    public static int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(48) + 1;
    }

    public static int[] sixRandomNumbers() {
        int[] tableOf6Numbers = new int[6];
        for (int i = 0; i < tableOf6Numbers.length; i++) {
            int number = randomNumber();
            if (checkRepeat(tableOf6Numbers, number)) {
                i--;
            }
            tableOf6Numbers[i] = number;
        }
        Arrays.sort(tableOf6Numbers);
        return tableOf6Numbers;
    }

    public static int[] givenNumbers() {
        Scanner scan = new Scanner(System.in);
        int[] tabOfGivenNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.print("Podaj " + (i + 1) + " cyfre, w zakresie 1-49: ");
            while (!scan.hasNextInt()) {
                System.out.println(" ");
                System.out.print("To nie jest liczba, podaj prawidłową liczbe w zakresie 1-49: ");
                scan.next();
            }
            int number = scan.nextInt();
            if (number > 0 && number < 50 && !checkRepeat(tabOfGivenNumbers, number)) {
                tabOfGivenNumbers[i] = number;
            } else {
                i--;
            }
            System.out.println(" ");
        }
        Arrays.sort(tabOfGivenNumbers);
        return tabOfGivenNumbers;
    }

    private static boolean checkRepeat(int[] givenNumbers, int number) {
        for (int givenNumber : givenNumbers)
            if (givenNumber == number) {
                boolean b = true;
                if (b) return true;
            }
        return false;
    }

    private static void howManyOfSixNumbersChoosenFromFortyNineIsOk(int[] sixRandomNumbers, int[] givenNumbers) {
        int sum = 0;
        System.out.println("Wylosowane liczby to: " + Arrays.toString(sixRandomNumbers));
        System.out.println("Liczby wytypowane przez Ciebie to: " + Arrays.toString((givenNumbers)));
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (sixRandomNumbers[i] == givenNumbers[j]) {
                    sum++;
                }
            }
        }
        if (sum < 3) {
            System.out.println("Trafiłeś " + sum + " cyfry. Słabo");
        } else if (sum == 3) {
            System.out.println("Trafiłeś " + sum + " cyfry. Nagroda 20 pln.");
        } else if (sum == 4) {
            System.out.println("Trafiłeś " + sum + " cyfry. Nagroda 100 pln.");
        } else if (sum == 5) {
            System.out.println("Trafiłeś " + sum + " cyfr. Nagroda 100 kpln.");
        } else if (sum == 6) {
            System.out.println("Trafiłeś " + sum + " cyfr. Ty to masz szczęście... zagraj w Totka!");
        }
    }
}