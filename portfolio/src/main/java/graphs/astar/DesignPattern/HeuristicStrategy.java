package graphs.astar.DesignPattern;

public interface HeuristicStrategy {

    int calculate(MazeNode node, MazeNode destination);

}