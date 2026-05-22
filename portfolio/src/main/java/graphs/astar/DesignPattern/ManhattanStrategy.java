package graphs.astar.DesignPattern;

public class ManhattanStrategy implements HeuristicStrategy {

    @Override
    public int calculate(MazeNode node, MazeNode destination) {

        return Math.abs(destination.getRow() - node.getRow())
                + Math.abs(destination.getCol() - node.getCol());
    }
}