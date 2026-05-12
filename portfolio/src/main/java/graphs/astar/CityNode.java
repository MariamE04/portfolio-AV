package graphs.astar;

import java.util.HashMap;
import java.util.Map;

public class CityNode {

    private String name;
    private int row;
    private int col;

    private Map<CityNode, Integer> neighbors;

    public CityNode(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;

        neighbors = new HashMap<>();
    }

    public void addRoad(CityNode neighbor, int distance) {
        neighbors.put(neighbor, distance);
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Map<CityNode, Integer> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return name;
    }
}