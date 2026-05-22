package graphs.astar.DesignPattern;

public class EuclideanStrategy implements HeuristicStrategy {

    @Override
    public int calculate(MazeNode node, MazeNode destination) {

        int row = destination.getRow() - node.getRow();
        int col = destination.getCol() - node.getCol();

        return (int)Math.sqrt(row * row + col * col);
    }
}