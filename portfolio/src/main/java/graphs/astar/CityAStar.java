package graphs.astar;
import java.util.*;

public class CityAStar {

    public static void main(String[] args) {

        // Byer i et 8x8 grid
        CityNode nordby = new CityNode("Nordby", 0, 1);
        CityNode østby = new CityNode("Østby", 1, 6);
        CityNode midtby = new CityNode("Midtby", 3, 3);
        CityNode vestby = new CityNode("Vestby", 4, 0);
        CityNode sydby = new CityNode("Sydby", 6, 2);
        CityNode havneby = new CityNode("Havneby", 7, 7);
        CityNode skovby = new CityNode("Skovby", 5, 5);
        CityNode strandby = new CityNode("Strandby", 7, 4);

        // Veje mellem byerne
        nordby.addRoad(midtby, 4);
        nordby.addRoad(østby, 8);

        østby.addRoad(skovby, 3);
        østby.addRoad(havneby, 7);

        midtby.addRoad(vestby, 5);
        midtby.addRoad(sydby, 4);
        midtby.addRoad(skovby, 2);

        vestby.addRoad(sydby, 3);

        sydby.addRoad(strandby, 2);

        strandby.addRoad(havneby, 3);

        skovby.addRoad(havneby, 2);

        // Find korteste vej
        findShortestPath(nordby, havneby);
    }

    // Manhattan heuristik
    public static int heuristic(CityNode current, CityNode goal) {
        return Math.abs(current.getRow() - goal.getRow())
                + Math.abs(current.getCol() - goal.getCol());
    }

    public static void findShortestPath(CityNode start, CityNode goal) {

        Map<CityNode, Integer> distances = new HashMap<>();
        Map<CityNode, CityNode> previous = new HashMap<>();

        Set<CityNode> visited = new HashSet<>();

        PriorityQueue<PathNode> queue = new PriorityQueue<>();

        distances.put(start, 0);

        queue.add(new PathNode(start, 0, heuristic(start, goal)));

        System.out.println("Starter A* søgning...\n");

        while (!queue.isEmpty()) {

            PathNode current = queue.poll();

            if (visited.contains(current.city)) {
                continue;
            }

            visited.add(current.city);

            System.out.println("--------------------------------");
            System.out.println("Besøger: " + current.city.getName());
            System.out.println("gCost: " + current.gCost);
            System.out.println("fCost: " + current.fCost);

            // Hvis målet findes
            if (current.city.equals(goal)) {
                break;
            }

            // Gennemgå naboer
            for (Map.Entry<CityNode, Integer> road : current.city.getNeighbors().entrySet()) {

                CityNode neighbor = road.getKey();
                int roadCost = road.getValue();

                if (visited.contains(neighbor)) {
                    continue;
                }

                int newDistance = distances.get(current.city) + roadCost;

                System.out.println("Tjekker vej til: " + neighbor.getName());

                // Kortere vej fundet
                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {

                    distances.put(neighbor, newDistance);

                    previous.put(neighbor, current.city);

                    int hCost = heuristic(neighbor, goal);

                    queue.add(new PathNode(neighbor, newDistance, hCost));

                    System.out.println("Ny korteste afstand til "
                            + neighbor.getName()
                            + " er nu "
                            + newDistance);
                }
            }

            System.out.println();
        }

        // Rekonstruer sti
        List<String> shortestPath = new ArrayList<>();

        CityNode step = goal;

        while (step != null) {
            shortestPath.add(0, step.getName());
            step = previous.get(step);
        }

        System.out.println("================================");
        System.out.println("Korteste vej:");
        System.out.println(shortestPath);

        System.out.println("\nSamlet afstand: " + distances.get(goal));
    }

    // Klasse til priority queue
    static class PathNode implements Comparable<PathNode> {

        CityNode city;
        int gCost;
        int fCost;

        public PathNode(CityNode city, int gCost, int hCost) {
            this.city = city;
            this.gCost = gCost;
            this.fCost = gCost + hCost;
        }

        @Override
        public int compareTo(PathNode other) {
            return Integer.compare(this.fCost, other.fCost);
        }
    }
}
