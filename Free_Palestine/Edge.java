package Free_Palestine;


public class Edge {

    private City adjacentCity;
    private double distance;
    public Edge(City adjacentCity, double distance) {
        this.adjacentCity = adjacentCity;
        this.distance = distance;
    }

    public City getAdjacentCity() {
        return adjacentCity;
    }

    public double getDistance() {
        return distance;
    }
}
