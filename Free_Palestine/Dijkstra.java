package Free_Palestine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Dijkstra {
	int numOfVertexs = 0;

	private static HashMap<String, City> nodes = new HashMap<>();

	public HashMap<String, City> getNodes() {
		return nodes;
	}

	public void setNodes(HashMap<String, City> nodes) {
		this.nodes = nodes;
	}

	private PriorityQueue<City> heap;
	private ArrayList<City> cities;
	private City source;
	private City destination;

	public Dijkstra(ArrayList<City> cities, City source, City destination) {
		heap = new PriorityQueue<>(cities.size());
		this.destination = destination;
		this.cities = cities;
		for (City city : cities) {
			city.resetTemps();
			if (city == source) {
				city.setTempCost(0);
			}
			heap.add(city);
		}
	}

	public void generateDijkstra() {
		while (!heap.isEmpty() && heap.contains(destination)) {
			City minUnknown = heap.poll();
			LinkedList<Edge> adjacentsList = minUnknown.getAdjacentsList();
			for (Edge edge : adjacentsList) {
				City adjacentCity = edge.getAdjacentCity();
				if (heap.contains(adjacentCity)) {
					if ((minUnknown.getTempCost() + edge.getDistance()) < adjacentCity.getTempCost()) {
						heap.remove(adjacentCity);
						adjacentCity.setTempCost(minUnknown.getTempCost() + edge.getDistance());
						adjacentCity.setTempPrev(minUnknown);
						heap.add(adjacentCity);
					}
				}
			}
		}
	}

	public Dijkstra() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<City> readVertices() throws FileNotFoundException {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		File selectedFile = jfc.getSelectedFile();
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
		// Edges=new ArrayList<>();
		Scanner scan = new Scanner(selectedFile);
		int i = 0;

		ArrayList<City> citiesList = new ArrayList<>();
		while (scan.hasNextLine()) {
			String[] str = scan.nextLine().split(" ");
			City v = new City(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
			citiesList.add(v);
			nodes.put(str[0], v);
		}
		scan.close();
		return citiesList;
	}

	public static void readEdges() throws FileNotFoundException {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		File selectedFile = jfc.getSelectedFile();
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
			Scanner scan = new Scanner(selectedFile);
			while (scan.hasNextLine()) {
				String[] arr = scan.nextLine().split(" ");
				String fromCityName = arr[0], toCityName = arr[1];
				double distance = Double.parseDouble(arr[2]);
				City fromCity = nodes.get(fromCityName), toCity = nodes.get(toCityName);
				if (fromCity == null || toCity == null)
					throw new IllegalArgumentException(
							Arrays.toString(arr) + " Edge found with no city instance corresponding");
				fromCity.addAdjacentCity(toCity, distance);
			}
			scan.close();
		}

	}

	private String pathString;
	private String distanceString;

	public City[] pathTo(City destination) {
		LinkedList<City> cities = new LinkedList<>();
		City iterator = destination;
		distanceString = String.format("%.2f", destination.getTempCost());
		while (iterator != source) {
			cities.addFirst(iterator);
			pathString = iterator.getFullName() + ": " + String.format("%.2f", iterator.getTempCost()) + "  пу" + "\n"
					+ "\t\t-->  " + pathString;
			iterator = iterator.getTempPrev();
		}

		return cities.toArray(new City[0]);
	}

	public String getPathString() {
		if (countOccurrences(pathString, '\n') <= 1) {
			pathString = "No Path";
			distanceString = "\t\t\t------------------";
			return pathString;
		}

		pathString = "\t" + pathString;

		int truncateIndex = pathString.lastIndexOf('\n');
		pathString = pathString.substring(0, truncateIndex);

		return pathString;
	}

	public String getDistanceString() {
		return distanceString;
	}

	public void printResult() {
		for (City city : cities) {
			System.out.println(city.getName() + ", " + city.getTempCost() + ", " + city.getTempPrev());
		}
	}

	private static int countOccurrences(String haystack, char needle) {
		int count = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle) {
				count++;
			}
		}
		return count;
	}
}
