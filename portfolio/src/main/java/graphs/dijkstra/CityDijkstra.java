package graphs.dijkstra;

import java.util.*;

class CityDijkstra {

    public static void main(String[] args) {

        // Opretter byer (noder i grafen)
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City e = new City("E");
        City f = new City("F");
        City g = new City("G");
        City h = new City("H");

        // Opretter veje mellem byer (rettede kanter med vægt)
        a.addRoad(b, 4);
        a.addRoad(c, 2);
        b.addRoad(d, 5);
        c.addRoad(d, 1);
        d.addRoad(e, 3);
        e.addRoad(f, 2);
        f.addRoad(g, 1);
        g.addRoad(h, 2);

        // Finder korteste vej fra A til H
        dijkstra(a, h);
    }

    public static void dijkstra(City start, City goal) {

        // Map der gemmer den korteste kendte afstand til hver by
        Map<City, Integer> distance = new HashMap<>();

        // Map der gemmer hvilken by vi kom fra (bruges til at finde vejen bagefter)
        Map<City, City> previous = new HashMap<>();

        // Set der holder styr på hvilke byer vi allerede har besøgt
        Set<City> visited = new HashSet<>();

        // PriorityQueue sørger for at vi altid vælger den billigste næste by
        PriorityQueue<CityDistance> pq = new PriorityQueue<>();

        // Startbyen har afstand 0
        distance.put(start, 0);

        // Læg startbyen i køen
        pq.add(new CityDistance(start, 0));

        // Kør så længe der er noder i køen
        while (!pq.isEmpty()) {

            // Tag den by med lavest afstand
            CityDistance current = pq.poll();
            City currentCity = current.city;

            // Hvis vi allerede har besøgt den, spring over
            if (visited.contains(currentCity)) continue;

            // Print hvilken by vi besøger (visualisering)
            System.out.println("visiting: " + currentCity.name);

            // Hvis vi har nået målet, stopper vi
            if (currentCity == goal) break;

            // Markér byen som besøgt
            visited.add(currentCity);

            // Gennemgå alle naboer til den nuværende by
            for (Map.Entry<City, Integer> entry : currentCity.roads.entrySet()) {

                City neighbor = entry.getKey();   // nabo-by
                int weight = entry.getValue();   // afstand til nabo

                // Beregn ny afstand via currentCity
                int newDist = distance.get(currentCity) + weight;

                // Hvis vi har fundet en kortere vej, opdater
                if (newDist < distance.getOrDefault(neighbor, Integer.MAX_VALUE)) {

                    // Opdater afstand
                    distance.put(neighbor, newDist);

                    // Gem hvor vi kom fra
                    previous.put(neighbor, currentCity);

                    // Print opdatering (visualisering)
                    System.out.println("Updated distance " + neighbor.name + " to " + newDist);

                    // Tilføj nabo til køen med ny afstand
                    pq.add(new CityDistance(neighbor, newDist));
                }
            }
        }

        // Rekonstruer den korteste vej baglæns fra mål til start
        List<String> path = new ArrayList<>();
        City step = goal;

        while (step != null) {
            path.add(0, step.name);   // indsæt forrest i listen
            step = previous.get(step); // gå baglæns
        }

        // Print resultat
        System.out.println("Shortest path: " + path);
        System.out.println("Distance: " + distance.get(goal));
    }
}