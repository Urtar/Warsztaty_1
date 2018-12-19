package zadania;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main4 {

    public static void main(String[] args) {
        System.out.println("Wynik rzutów to: " + cubeData());
    }

    public static int cubeData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dane w formacie xDy+z, gdzie x ilosc rzutow, y rodzaj kostki (3, 4, 6, 8, 10, 12, 20 lub 100), z to liczba modyfikator: ");

        String str = scan.nextLine();
        StringTokenizer strToken = new StringTokenizer(str, "D" + "+" + " ");
        int number = strToken.countTokens();
        //System.out.println("Ilosc tokenow: " + number);
        int x, y, z;
        if (number == 2) {
            x = 1;
            y = Integer.parseInt(strToken.nextToken());
            z = Integer.parseInt(strToken.nextToken());
        } else if (number == 3) {
            x = Integer.parseInt(strToken.nextToken());
            y = Integer.parseInt(strToken.nextToken());
            z = Integer.parseInt(strToken.nextToken());
        } else {
            System.out.println("Nieprawidlowe dane");
            return 0;
        }
        if (!checkTheCubeType(y)) {
            System.out.println("Nieprawidlowa kostka, dopuszczalne to: (3, 4, 6, 8, 10, 12, 20 lub 100)");
            return 0;
        }
        return score(x, y, z);
    }

    public static int randomNumber(int y) {
        Random rand = new Random();
        return rand.nextInt(y) + 1;
    }

    public static int score(int x, int y, int z) {
        //System.out.println(x + " " + y + " " + z);
        int score = 0;
        for (int i = 0; i < x; i++) {
            score = score + x * randomNumber(y);
        }
        return score + z;
    }

    public static boolean checkTheCubeType(int y) {
        int[] cubes = {3, 4, 6, 8, 10, 12, 20, 100};
        for (int i = 0; i < cubes.length; i++) {
            if (y == cubes[i]) {
                return true;
            }
        }
        return false;
    }
}


//D3, D4, D6, D8, D10, D12, D20, D100.