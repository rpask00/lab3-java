import com.sun.source.tree.ArrayAccessTree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
//        zad1();
//        zad2();
//        zad3();
//        zad4();
//        zad5();
        zad6();
    }

    void zad1() {
        Random rd = new Random();
        int[] arr = new int[10];
        int minNum = 100;
        int maxNum = -100;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt() % 11;
            System.out.println(arr[i]);

            maxNum = Math.max(arr[i], maxNum);
            minNum = Math.min(arr[i], minNum);
        }

        double srednia = (double) Arrays.stream(arr).sum() / arr.length;

        System.out.println("max num:");
        System.out.println(maxNum);
        System.out.println("min num");
        System.out.println(minNum);
        System.out.println("avg num");
        System.out.println(srednia);


        int wieksze = 0;
        int mniejsze = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > srednia) {
                wieksze++;
            } else {
                mniejsze++;
            }
        }

        System.out.println("wiekszych: ");
        System.out.println(wieksze);
        System.out.println("mniejszych: ");
        System.out.println(mniejsze);


        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }

    }

    void zad2() {
        Random rd = new Random();
        int[][] matrix = new int[5][5];

        int[] miny = {6, 6, 6, 6, 6};
        int[] maxy = {-6, -6, -6, -6, -6};

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix.length; x++) {
                matrix[y][x] = rd.nextInt() % 6;
                miny[x] = Math.min(miny[x], matrix[y][x]);
                maxy[x] = Math.max(maxy[x], matrix[y][x]);
            }
        }

        for (int y = 0; y < matrix.length; y++) {
            System.out.println(Arrays.toString(matrix[y]));
        }

        System.out.println("max values: ");
        System.out.println(Arrays.toString(maxy));


        System.out.println("min values: ");
        System.out.println(Arrays.toString(miny));


    }

    static void zad3() {
        Scanner myObj = new Scanner(System.in);
        int value = myObj.nextInt();
        int value_copy = value;

        int[] bits = new int[32];

        if (value < 0) {
            bits[0] = 1;
        }

        for (int i = 31; i > 0; i--) {
            bits[i] = Math.abs(value % 2);
            value = value / 2;
        }

        System.out.println("liczba " + Integer.toString(value_copy) + " binarne to:");
        System.out.println(Arrays.toString(bits));
    }

    static void zad4() {
        Scanner myObj = new Scanner(System.in);
        int n = myObj.nextInt();
        char[][] c = new char[n][n];

        for (int i = 0; i < c.length; i++) {
            var str = "";
            for (int j = 0; j < c.length; j++) {
                c[i][j] = areNWD(i + 1, j + 1) ? '+' : '.';
                str += c[i][j] + " ";
            }

            System.out.println(str);
        }


    }

    static int nwd(int a, int b) {
        return (a == 0) ? b : nwd(b % a, a);
    }

    static boolean areNWD(int a, int b) {
        return (nwd(a, b) == 1);
    }

    static void zad5() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int lastCharCount = 0;
        int numbersSum = 0;

        for (char c : chars) {
            if (c == chars[chars.length - 1]) {
                lastCharCount++;
            }

            if (Character.isDigit(c)) {
                numbersSum += (int) c - 48;
            }
        }

        System.out.println("Last chars count: " + Integer.toString(lastCharCount));
        System.out.println("Numbers sum: " + Integer.toString(numbersSum));
    }

    static void zad6() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int offset = sc.nextInt();
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            chars[i] = (char) ((chars[i] + offset) % (int) 'a' + (int) 'a');
        }


        System.out.println(chars);
    }
}