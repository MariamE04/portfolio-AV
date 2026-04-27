package algorithms.maze;

public class MazeExercise {
    static final int N = 6;

    static int[][] maze = {
            {1, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1}
    };

    static int[][] path = new int[N][N];

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            printPath();
        } else {
            System.out.println("Ingen løsning fundet.");
        }
    }

    // TODO: Implementer denne metode
    static boolean solveMaze(int row, int col) {

        // Tjek: udenfor grid ELLER rammer en mur (0)
        if (row < 0 || col < 0 || row >= N || col >= N || maze[row][col] != 1) {
            return false;
        }

        // Tjek: har vi allerede været her?
        // Hvis ja → undgå uendelig loop
        if (path[row][col] == 1) {
            return false;
        }

        // Tjek: er vi nået til målet? (nederste højre hjørne)
        if (row == N - 1 && col == N - 1) {
            path[row][col] = 1; // markér sidste skridt
            return true;        // løsning fundet
        }

        // Markér nuværende felt som en del af stien
        path[row][col] = 1;

        // Prøv at gå NED
        if (solveMaze(row + 1, col)) return true;

        // Prøv at gå HØJRE
        if (solveMaze(row, col + 1)) return true;

        // Prøv at gå OP
        if (solveMaze(row - 1, col)) return true;

        // Prøv at gå VENSTRE
        if (solveMaze(row, col - 1)) return true;

        // BACKTRACK:
        // Ingen retninger virkede → fjern fra path
        path[row][col] = 0;

        return false; // ingen løsning fra denne position
    }

    static void printPath() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
