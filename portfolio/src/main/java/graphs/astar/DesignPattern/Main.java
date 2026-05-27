package graphs.astar.DesignPattern;

public class Main {

    public static void main(String[] args) {

        System.out.println("MANHATTAN");
        MazeSolver manhattanSolver =
                new MazeSolver(new ManhattanStrategy());

        manhattanSolver.solve();


        System.out.println("\nEUCLIDEAN");
        MazeSolver euclideanSolver =
                new MazeSolver(new EuclideanStrategy());

        euclideanSolver.solve();


        System.out.println("\nZERO HEURISTIC");
        MazeSolver zeroSolver =
                new MazeSolver(new ZeroStrategy());

        zeroSolver.solve();
    }
}


/*
Strategy Pattern

Problem:
Heuristikken var tidligere hardkodet i MazeSolver,
så algoritmen skulle ændres hver gang man ville bruge
en ny heuristik.

Løsning:
Ved at bruge Strategy Pattern kan heuristikker
udskiftes dynamisk gennem et interface.

Hvorfor passer patternet her?
Fordi forskellige heuristikker er forskellige algoritmer,
som kan bruges på samme problem.
*/