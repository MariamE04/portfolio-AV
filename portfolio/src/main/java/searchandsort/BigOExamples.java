package searchandsort;

import java.lang.reflect.Array;

public class BigOExamples {
    public static void main(String[] args) {
      /*  int n = 10; // Juster n for at se effekten
        System.out.println("O(1) - Konstant tid:");
        constantTime(n);

        System.out.println("\nO(log n) - Logaritmisk tid:");
        logTime(n);

        System.out.println("\nO(n) - Lineær tid:");
        linearTime(n);

        System.out.println("\nO(n^2) - Kvadratisk tid:");
        quadraticTime(n);

        System.out.println("--------"); */

        int[] nums = new int[4];
        nums[0] = 12;
        nums[1] = 4;
        nums[2] = 8;
        nums[3] = 2;

        myConstant();
        myLog(1000);
        myLinear(44);
        // myQuadraticExample(nums);
        // myBinarySearch(nums, 10);
    }

    // O(1) - Konstant tid
    public static void constantTime(int n) {
        System.out.println("Jeg printer altid én gang, uanset n.");
    }

    // O(log n) - Logaritmisk tid (Binær nedtælling)
    public static void logTime(int n) {
        for (int i = n; i > 1; i /= 2) {
            System.out.println("Jeg kører log n gange, n er nu: " + i);
        }
    }

    // O(n) - Lineær tid
    public static void linearTime(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Itererer: " + i);
        }
    }

    // O(n^2) - Kvadratisk tid
    public static void quadraticTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Kvadratisk iteration: " + i + "," + j);
            }
        }

    }

    // OPGAVE 1
    // O(1)
    public static void myConstant(){
        int x = 4;
        System.out.println(x);
    }
    // Kører én gang → O(1)
    // Output: 4

    // O(log n)
    public static void myLog(int n){
        while(n > 1){
            n = n / 2;
            System.out.println(n);
        }
    }
    //Halverer hver gang → O(log n)
    //Output:
    //500
    //250
    //125
    //62 ...

    // O(n) - Loop kører n gange → O(n)
    public static void myLinear(int n){
        for(int i = 0; i < n; i++){
            System.out.println(i);
        }
    }

    // O(n^2) - Sammenligner alle elementer med hinanden
    public static void myQuadraticExample(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Match: " + arr[i]);
                }
            }
        }
    }

    // O(log n) - Binary Search
    public static int myBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // ikke fundet
    }
// Halverer søgeområdet hver gang → O(log n)
}

// Tommelfingerregel:
// 1 loop → O(n)
// 2 nested loops → O(n²)
// halvering → O(log n)

