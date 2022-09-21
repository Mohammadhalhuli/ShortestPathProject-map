//package Free_Palestine;
//
//import javafx.event.ActionEvent;
//
//import javax.swing.*;
//import javax.swing.filechooser.FileSystemView;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//public class GraphMap {
//
//    int numOfVertexs=0;
//    private HashMap<String,Node> nodes = new HashMap<>();
//
//    public void addNode(Node nodeA) {
//        nodes.put(nodeA.getName(),nodeA);
//    }
//    public HashMap<String,Node>getNodes() {
//        return nodes;
//    }
//
//    public void setNodes(HashMap<String,Node> nodes) {
//        this.nodes = nodes;
//    }
////    public void Restart() {
////		for (int i = 0; i < nodes.size(); i++) {
////			distanceList.set(i, Double.MAX_VALUE);
////			pathList.set(i, 0);
////			knownList.set(i, false);
////
////		}
////	}
//
//
//    public void printMap(){
//        for (Map.Entry< String, Node> adjacencyPair: nodes.entrySet()){
//            System.out.print(adjacencyPair.getKey()+" adjecnts : ");
//            adjacencyPair.getValue().printAdjecnts();;
//            System.out.println();
//        }
//    }
//    public void getVertexes() throws FileNotFoundException {
//    	  Scanner scan = null;
//          try {
//              scan = new Scanner(new File("src/City.txt"));
//          } catch (FileNotFoundException e) {
//              e.printStackTrace();
//          }
//        int i=0;
//        while (scan.hasNextLine()){
//            String []str=scan.nextLine().split(" ");
//            Node v=new Node(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
//            numOfVertexs++;
//            nodes.put(v.getName(),v);
//            i++;
//        }
//    }
//    public void getEdges() throws FileNotFoundException {
//    	  Scanner scan = null;
//          try {
//              scan = new Scanner(new File("src/Adge.txt"));
//          } catch (FileNotFoundException e) {
//              e.printStackTrace();
//          }
//        int i=0;
//        while (scan.hasNextLine()) {
//            String[] str = scan.nextLine().split(" ");
//            //System.out.println(i++);
//            //nodes.put(str[0],nodes.get(str[1]));
//            nodes.get(str[0]).getAdjacentNodes().put(nodes.get(str[1]), Double.parseDouble(str[2]));
//        }
//         /* sortEdge=new LinkedList[size];
//        sortEdge2=new LinkedList[size];
//        for(int i=0;i<sortEdge2.length;i++){
//            sortEdge[i]=new LinkedList<>();
//            sortEdge2[i]=new LinkedList<>();
//
//        }*/
//         /*   int v1index=searchVertex(Edges,str[0]);
//            int v2index=searchVertex(Edges,str[1]);
//            Edge edge=new Edge(Edges.get(v1index),Edges.get(v2index),Double.parseDouble(str[2]));
//            Vertex path=Edges.get(searchVertex(Edges,str[0]));
//            if(sortEdge2[path.id].isEmpty())
//                sortEdge2[path.id].add(path);
//            Vertex vertex=new Vertex(Double.parseDouble(str[2]),str[1],false,path);
//            sortEdge2[path.id].add(vertex);
//            sortEdge[path.id].add(edge);*/
//            //adjesnts.put(Edges.get(v1index),Edges.get(v2index));
//            //adjesnts.put(Edges.get(v1index),Double.parseDouble(str[2]));
//            //adjesnts.putAll();
//
//
//     /*   sortEdge2.toString();
//        sortEdge.toString();
//        for (int i=0;i<sortEdge.length;i++){
//            System.out.println(sortEdge2[i].toString());
//            System.out.println(sortEdge[i].toString());
//
//        }
//        System.out.println(sortEdge2.toString());
//        System.out.println(sortEdge.toString());
//        initialTable(Edges.get(0));
//        printTable(table);
//
//*/
//    }
//  /*  int searchVertex(ArrayList<Vertex> list,String name){
//        for(int i=0;i<list.size();i++){
//            Vertex v=list.get(i);
//            if(v.getName().equals(name))
//                return i;
//        }
//        return -1;
//    }
//    public void printTable(Vertex [][] table){
//        for(int i=0;i<table.length;i++){
//            for(int j=0;j<table[i].length;j++)
//                System.out.print(" "+table[i][j].toString());
//            System.out.println();
//        }*/
//    }
