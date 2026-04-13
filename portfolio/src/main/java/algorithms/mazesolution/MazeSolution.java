package algorithms.mazesolution;

public class MazeSolution {
    static final int N = 4;

    static int[][] maze = {
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 1, 0, 1}
    };

    static int[][] path = new int[N][N];

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            printPath();
        } else {
            System.out.println("Ingen løsning fundet.");
        }
    }

    static boolean solveMaze(int row, int col) {
        // udenfor grænser eller ulovligt felt
        if (row < 0 || col < 0 || row >= N || col >= N || maze[row][col] != 1) {
            return false;
        }

        // allerede besøgt
        if (path[row][col] == 1) {
            return false;
        }

        // nået mål
        if (row == N - 1 && col == N - 1) {
            path[row][col] = 1;
            return true;
        }

        // markér som en del af sti
        path[row][col] = 1;

        // prøv fire retninger
        if (solveMaze(row + 1, col)) return true;
        if (solveMaze(row, col + 1)) return true;
        if (solveMaze(row - 1, col)) return true;
        if (solveMaze(row, col - 1)) return true;

        // dead end – backtrack
        path[row][col] = 0;
        return false;
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
