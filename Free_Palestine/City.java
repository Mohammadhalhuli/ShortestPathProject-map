package Free_Palestine;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class City implements Comparable<City> {

    int x;
    int y;
    private String name;
    private String notes;

    private double tempCost = Double.MAX_VALUE;
    private City tempPrev;


    private Button button;
    private LinkedList<Edge> list = new LinkedList<>();

    public City(String name ,int x, int  y) {
		
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public City(int x, int y, String name, String notes) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.notes = notes;
    }

    public City() {
		// TODO Auto-generated constructor stub
	}

	public void addAdjacentCity(City city, double distance) {
        list.add(new Edge(city, distance));
    }

    public double getDistanceToAdjacent(City city) {
        for (Edge edge : list) {
            if (edge.getAdjacentCity() == city)
                return edge.getDistance();
        }
        return -1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }


    public String getNotes() {
        return notes;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button2) {
        this.button = button2;
    }

    public LinkedList<Edge> getAdjacentsList() {
        return list;
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
               + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    public String getFullName() {
        return name;
    }

    public void resetTemps() {
        tempCost = Double.MAX_VALUE;
        tempPrev = null;
    }

    public double getTempCost() {
        return tempCost;
    }

    public void setTempCost(double tempCost) {
        this.tempCost = tempCost;
    }

    public City getTempPrev() {
        return tempPrev;
    }

    public void setTempPrev(City tempPrev) {
        this.tempPrev = tempPrev;
    }

    @Override
    public int compareTo(City o) {
        if (this.tempCost > o.tempCost) return 1;
        else if (this.tempCost < o.tempCost) return -1;
        return 0;
    }


}