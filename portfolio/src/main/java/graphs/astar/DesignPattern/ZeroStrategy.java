package graphs.astar.DesignPattern;

public class ZeroStrategy implements HeuristicStrategy {

    @Override
    public int calculate(MazeNode node, MazeNode destination) {
        return 0;
    }
}