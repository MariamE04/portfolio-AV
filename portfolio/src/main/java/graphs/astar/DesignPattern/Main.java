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