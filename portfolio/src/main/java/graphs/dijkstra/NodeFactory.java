package graphs.dijkstra;

import java.util.HashMap;
import java.util.Map;

/*
Factory Pattern:
Factoryen centraliserer oprettelsen af WeightedNode-objekter.
Det løser problemet med mange hardcodede node-oprettelser
og gør koden mere fleksibel og lettere at udvide.
Factory pattern passer godt her, fordi objektoprettelsen
er gentagende og samlet ét sted.
*/

public class NodeFactory {

    private Map<String, WeightedNode> nodes = new HashMap<>();

    public WeightedNode getNode(String name) {

        if (!nodes.containsKey(name)) {
            nodes.put(name, new WeightedNode(name));
        }

        return nodes.get(name);
    }
}