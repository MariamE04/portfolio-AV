package graphs.dijkstra;

// Hjælpeklasse til priority queue
// Indeholder en by og dens afstand fra start
class CityDistance implements Comparable<CityDistance> {

    City city;
    int distance;

    public CityDistance(City city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    // Sørger for at køen sorterer efter laveste distance
    public int compareTo(CityDistance other) {
        return this.distance - other.distance;
    }
}