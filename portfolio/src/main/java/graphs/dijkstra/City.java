package graphs.dijkstra;

import java.util.HashMap;
import java.util.Map;

// Klasse der repræsenterer en by (node)
class City {

    String name;

    // Map over naboer og afstande (kanter)
    Map<City, Integer> roads = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    // Tilføjer en vej til en anden by med en given afstand
    public void addRoad(City to, int distance) {
        roads.put(to, distance);
    }
}