package searchandsort;

public class BigOExamples {
    public static void main(String[] args) {
        int n = 10; // Juster n for at se effekten
        System.out.println("O(1) - Konstant tid:");
        constantTime(n);

        System.out.println("\nO(log n) - Logaritmisk tid:");
        logTime(n);

        System.out.println("\nO(n) - Lineær tid:");
        linearTime(n);

        System.out.println("\nO(n^2) - Kvadratisk tid:");
        quadraticTime(n);

        System.out.println("--------");

        myConstant();
        myLog(1000);
        myLinear(44);
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

    // O(n)
    public static void myLinear(int n){
        for(int i = 0; i < n; i++){
            System.out.println(i);
        }
    }
    // Loop kører n gange → O(n)
}

// Tommelfingerregel:
// 1 loop → O(n)
// 2 nested loops → O(n²)
// halvering → O(log n)

